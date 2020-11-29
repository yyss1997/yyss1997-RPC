package com.yyss1997.rpc.client;

import com.yyss1997.rpc.proto.Peer;
import com.yyss1997.rpc.transport.TransportClient;

import java.util.List;


/**
 * 表示选择哪个server去连接
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/28 15:43
 * @Version 1.0
 */
public interface TransportSelector {
    /*
    * 初始化selector
    *
    * @ Author:Zhiwei Ren
    * @ Date 2020/11/28 18:13
    * @ Description
    * @ Param[peers, count, clazz]
    * peers:可以连接的server端点信息; client与server建立多少个连接;  client实现class
    * @ return void
    **/
    void init(List<Peer> peers,
              int count,
              Class<? extends TransportClient> clazz);
    /*
    * @ Author:Zhiwei Ren
    * @ Date 2020/11/28 15:57
    * @ Description 选择一个transport与server做交互
    * @ Param[]
    * @ return com.yyss1997.rpc.transport.TransportClient
    **/
    TransportClient select();

    /*
    * @ Author:Zhiwei Ren
    * @ Date 2020/11/28 18:08
    * @ Description 释放用完的client
    * @ Param[client]
    * @ return void
    **/
    void release(TransportClient client);

    void close();

}
