package com.yyss1997.rpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * 表示一个具体服务
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/26 19:54
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;
}
