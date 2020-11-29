package com.yyss1997.rpc.codec;

import junit.framework.TestCase;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/24 19:51
 * @Version 1.0
 */
public class JSONEncoderTest extends TestCase {

    public void testEncode() {
        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setName("yyss1997");
        bean.setAge(18);

        byte[] bytes = encoder.encode(bean);

        assertNotNull(bytes);

    }
}