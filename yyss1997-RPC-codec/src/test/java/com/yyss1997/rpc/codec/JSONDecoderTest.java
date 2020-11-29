package com.yyss1997.rpc.codec;

import junit.framework.TestCase;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/24 19:56
 * @Version 1.0
 */
public class JSONDecoderTest extends TestCase {

    public void testDecode() {
        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setName("yyss1997");
        bean.setAge(18);

        byte[] bytes = encoder.encode(bean);

        Decoder decoder = new JSONDecoder();
        TestBean bean2 = decoder.decode(bytes, TestBean.class);

        assertEquals(bean.getName(), bean2.getName());
        assertEquals(bean.getAge(), bean2.getAge());

    }
}