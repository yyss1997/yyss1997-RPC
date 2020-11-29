package com.yyss1997.rpc.proto;

import lombok.Data;

/**
 * 表示RPC的一个请求
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/23 19:13
 * @Version 1.0
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;

}
