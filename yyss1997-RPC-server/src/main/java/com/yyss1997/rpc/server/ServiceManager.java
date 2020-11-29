package com.yyss1997.rpc.server;

import com.yyss1997.rpc.common.utils.ReflectionUtils;
import com.yyss1997.rpc.proto.Request;
import com.yyss1997.rpc.proto.ServiceDescriptor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理rpc暴露的服务
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/26 19:56
 * @Version 1.0
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }

    /*
    * @ Author:Zhiwei Ren
    * @ Date 2020/11/26 20:24
    * @ Description //入参interfaceClass是一个接口的class, bean是那个接口子类的实现单例对象, 我们会扫描那个
    * interfaceClass的所有方法和那个bean进行绑定, 形成一个ServiceInstance然后然后services这个map中
    * @ Param[interfaceClass, bean]
    * @ return void 
    **/
    public <T> void register(Class<T> interfaceClass, T bean){
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method: methods){
            ServiceInstance serviceInstance = new ServiceInstance(bean, method);
            ServiceDescriptor serviceDescriptor = ServiceDescriptor.from(interfaceClass, method);

            services.put(serviceDescriptor, serviceInstance);
            log.info("register service: {} {}", serviceDescriptor.getClazz(), serviceDescriptor.getMethod());
        }

    }

    public ServiceInstance lookup(Request request){
        ServiceDescriptor serviceDescriptor = request.getService();
        return services.get(serviceDescriptor);
    }
}
