package com.yyss1997.rpc.codec;

/**
 * 序列化
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/23 20:33
 * @Version 1.0
 */
public interface Encoder {
    byte[] encode(Object obj);
}
