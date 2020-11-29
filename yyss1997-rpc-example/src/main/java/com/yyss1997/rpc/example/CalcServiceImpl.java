package com.yyss1997.rpc.example;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/29 15:41
 * @Version 1.0
 */
public class CalcServiceImpl implements CalcService{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }
}
