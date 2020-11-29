package com.yyss1997.rpc.transport;

import com.yyss1997.rpc.proto.Peer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author Zhiwei Ren
 * @Date 2020/11/26 14:44
 * @Version 1.0
 */
public class HTTPTransportClient implements TransportClient{
    private String url;

    @Override
    public void connect(Peer peer) {
        this.url = "http://" + peer.getHost() + ":" + peer.getPort();
    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");

            httpURLConnection.connect();
            IOUtils.copy(data, httpURLConnection.getOutputStream());

            int resultCode = httpURLConnection.getResponseCode();
            if (resultCode == HttpURLConnection.HTTP_OK){
                return httpURLConnection.getInputStream();
            } else {
                return httpURLConnection.getErrorStream();
            }

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {

    }
}
