package com.yyss1997.rpc.proto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/23 14:45
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDescriptor {
    private String clazz;
    private String method;
    private String returnType;
    private String[] parameterTypes;

    public static ServiceDescriptor from(Class clazz, Method method){
        ServiceDescriptor sdp = new ServiceDescriptor();
        sdp.setClazz(clazz.getName());
        sdp.setMethod(method.getName());
        sdp.setReturnType(method.getReturnType().getName());

        Class[] parameterClasses = method.getParameterTypes();
        String[] parameterTypes = new String[parameterClasses.length];
        for (int i=0; i<parameterClasses.length; i++){
            parameterTypes[i] = parameterClasses[i].getName();
        }
        sdp.setParameterTypes(parameterTypes);

        return sdp;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || getClass() != o.getClass()) return false;

        ServiceDescriptor that = (ServiceDescriptor) o;
        return this.toString().equals(that.toString());
    }

    @Override
    public String toString() {
        return "clazz="+clazz
                + ",method=" + method
                + ",returnType=" + returnType
                + ",parameterTypes" + Arrays.toString(parameterTypes);
    }
}
