package com.yyss1997.rpc.server;

import com.yyss1997.rpc.codec.Decoder;
import com.yyss1997.rpc.codec.Encoder;
import com.yyss1997.rpc.common.utils.ReflectionUtils;
import com.yyss1997.rpc.proto.Request;
import com.yyss1997.rpc.proto.Response;
import com.yyss1997.rpc.transport.RequestHandler;
import com.yyss1997.rpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/28 14:46
 * @Version 1.0
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer(){
        this(new RpcServerConfig());
    }

    public RpcServer(RpcServerConfig config){
        this.config = config;

        //net
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(), this.handler);

        //codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());

        //service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register(Class<T> interfaceClass, T bean){
        serviceManager.register(interfaceClass, bean);
    }

    public void start(){
        this.net.start();
    }

    public void stop(){
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream rec, OutputStream toResp) {
            Response response = new Response();

            try {
                byte[] inBytes = IOUtils.readFully(rec, rec.available());
                Request request = decoder.decode(inBytes, Request.class);

                log.info("get request: {}", request);

                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(sis, request);
                response.setData(ret);


            } catch (IOException e) {
                e.printStackTrace();
                log.warn(e.getMessage(), e);
                response.setCode(1);
                response.setMessage("RpcServer got error: " + e.getClass().getName()
                + " : " +e.getMessage());
            } finally {
                try {
                    byte[] outBytes = encoder.encode(response);
                    toResp.write(outBytes);
                    log.info("response cline");
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    };
}
