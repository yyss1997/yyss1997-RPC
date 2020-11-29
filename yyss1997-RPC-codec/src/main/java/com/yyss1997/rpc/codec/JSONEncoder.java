package com.yyss1997.rpc.codec;
import com.alibaba.fastjson.JSON;
/**
 * 基于json的序列化实现
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/23 20:44
 * @Version 1.0
 */
public class JSONEncoder implements Encoder{
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);

    }
}
