package com.yyss1997.rpc.example;

import com.yyss1997.rpc.client.RpcClient;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/29 15:39
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {

        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);

        int a1 = service.add(11,22);
        int a2 = service.minus(32, 10);

        System.out.println(a1);
        System.out.println(a2);
    }
}
