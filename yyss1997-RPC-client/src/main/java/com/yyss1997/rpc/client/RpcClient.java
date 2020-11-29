package com.yyss1997.rpc.client;

import com.yyss1997.rpc.codec.Decoder;
import com.yyss1997.rpc.codec.Encoder;
import com.yyss1997.rpc.common.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/28 22:59
 * @Version 1.0
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient(){
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config){
        this.config = config;

        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClass());

        this.selector.init(
                this.config.getServers(),
                this.config.getConnectCount(),
                this.config.getTransportClass()
        );
    }

    /**
    * @ Author:Zhiwei Ren
    * @ Date 2020/11/29 12:42
    * @ Description 接口的代理对象,直接基于jdk的动态代理
    * @ Param[clazz]
    * @ return T 
    **/
    public <T> T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoker(clazz, encoder, decoder, selector)
        );
    }

}
