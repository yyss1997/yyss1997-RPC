package com.yyss1997.rpc.client;

import com.yyss1997.rpc.codec.Decoder;
import com.yyss1997.rpc.codec.Encoder;
import com.yyss1997.rpc.codec.JSONDecoder;
import com.yyss1997.rpc.codec.JSONEncoder;
import com.yyss1997.rpc.proto.Peer;
import com.yyss1997.rpc.transport.HTTPTransportClient;
import com.yyss1997.rpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/28 22:37
 * @Version 1.0
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1",3000)
    );
}
