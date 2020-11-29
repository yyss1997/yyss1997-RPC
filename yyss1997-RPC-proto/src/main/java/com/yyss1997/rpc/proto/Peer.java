package com.yyss1997.rpc.proto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表示网络传输的一个端点
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/23 14:39
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;

}
