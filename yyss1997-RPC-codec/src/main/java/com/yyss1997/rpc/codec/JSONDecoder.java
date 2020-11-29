package com.yyss1997.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于json的反序列化实现
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/24 19:49
 * @Version 1.0
 */
public class JSONDecoder implements Decoder{
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
