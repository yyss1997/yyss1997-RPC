package com.yyss1997.rpc.server;

import com.yyss1997.rpc.common.utils.ReflectionUtils;
import com.yyss1997.rpc.proto.Request;
import com.yyss1997.rpc.proto.ServiceDescriptor;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/27 23:26
 * @Version 1.0
 */
public class ServiceManagerTest {
    ServiceManager sm;

    @Before
    public void init(){
        sm = new ServiceManager();
    }



    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void lookup() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);

        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, method);

        Request request = new Request();
        request.setService(sdp);

        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);

    }
}