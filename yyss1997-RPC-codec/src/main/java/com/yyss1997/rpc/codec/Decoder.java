package com.yyss1997.rpc.codec;

/**
 * 反序列化
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/23 20:39
 * @Version 1.0
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
