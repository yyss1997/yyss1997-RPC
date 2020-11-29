package com.yyss1997.rpc.example;

import com.yyss1997.rpc.server.RpcServer;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/29 15:39
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}
