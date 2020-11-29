package com.yyss1997.rpc.common.utils;

import junit.framework.TestCase;

import java.lang.reflect.Method;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/23 19:57
 * @Version 1.0
 */
public class ReflectionUtilsTest extends TestCase {

    public void testNewInstance() {
        TestClass testClass = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(testClass);

    }

    public void testGetPublicMethods() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(1,methods.length);

        String mname = methods[0].getName();
        assertEquals("b",mname);
    }

    public void testInvoke() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method b = methods[0];

        TestClass t = new TestClass();
        Object r = ReflectionUtils.invoke(t, b);

        assertEquals("b",r);
    }
}