package com.yyss1997.rpc.transport;

/**
 * 1. 启动, 监听
 * 2. 接受请求
 * 3. 关闭监听
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/24 21:30
 * @Version 1.0
 */
public interface TransportServer {
    void init(int port, RequestHandler requestHandler);

    void start();

    void stop();
}
