package org.springframework.social.support;

import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

// http://code.google.com/appengine/docs/java/urlfetch/overview.html
// By default, the deadline for a fetch is 5 seconds. The maximum deadline is 10 seconds for HTTP requests and 10 minutes for task queue and cron job requests.
// When using the URLConnection interface, the service uses the connection timeout (setConnectTimeout()) plus the read timeout (setReadTimeout()) as the deadline.

// The code below would set a maximum of 90 seconds to be safe as I am not sure by setting 45 each one might be a limiting factor.

public class GAESimpleClientHttpRequestFactory extends SimpleClientHttpRequestFactory {
    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
        connection.setConnectTimeout(45000);
		connection.setReadTimeout(45000);
        super.prepareConnection(connection, httpMethod);
    }
}
