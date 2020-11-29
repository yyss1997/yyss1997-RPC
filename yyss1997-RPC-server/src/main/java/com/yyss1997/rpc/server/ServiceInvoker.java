package com.yyss1997.rpc.server;

import com.yyss1997.rpc.common.utils.ReflectionUtils;
import com.yyss1997.rpc.proto.Request;

/**
 * 调用具体服务
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/28 11:42
 * @Version 1.0
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance serviceInstance,
                         Request request){
        return ReflectionUtils.invoke(
                serviceInstance.getTarget(),
                serviceInstance.getMethod(),
                request.getParameters()
        );

    }
}
