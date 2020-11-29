package com.yyss1997.rpc.server;

import com.yyss1997.rpc.codec.Decoder;
import com.yyss1997.rpc.codec.Encoder;
import com.yyss1997.rpc.codec.JSONDecoder;
import com.yyss1997.rpc.codec.JSONEncoder;
import com.yyss1997.rpc.transport.HTTPTransportServer;
import com.yyss1997.rpc.transport.TransportServer;
import lombok.Data;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/26 18:25
 * @Version 1.0
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}
