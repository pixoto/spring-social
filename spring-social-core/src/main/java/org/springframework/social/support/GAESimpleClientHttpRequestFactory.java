package org.springframework.social.support;

import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public class GAESimpleClientHttpRequestFactory extends SimpleClientHttpRequestFactory {
    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
        connection.setConnectTimeout(10000);
		connection.setReadTimeout(10000);
        super.prepareConnection(connection, httpMethod);
    }
}
