package com.yyss1997.rpc.proto;

import lombok.Data;

/**
 * 表示RPC的返回
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/23 19:15
 * @Version 1.0
 */
@Data
public class Response {
    /**
     * 服务返回编码, 0成功, 非0失败
     * 默认值为0
     */
    private int code = 0;
    /**
     * 具体的错误信息
     * "默认为ok"
     */
    private String message;
    /**
     * 返回的数据
     */
    private Object data;
}
