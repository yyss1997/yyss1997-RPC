package com.yyss1997.rpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求的handler
 *
 * @Author Zhiwei Ren
 * @Date 2020/11/24 21:38
 * @Version 1.0
 */
public interface RequestHandler {
    void onRequest(InputStream rec, OutputStream toResp);
}
