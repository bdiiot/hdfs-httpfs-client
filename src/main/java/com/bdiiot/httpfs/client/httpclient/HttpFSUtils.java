package com.bdiiot.httpfs.client.httpclient;

import com.bdiiot.httpfs.client.utils.HttpFSConf;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpFSUtils {
    private final static Log log = LogFactory.getLog(HttpFSUtils.class);
    private static final String SERVICE_PATH = "/webhdfs/v1";
    private static final String SCHEME = "http";

    public static String createURL(String path, String params) {
        StringBuilder sb = new StringBuilder();
        sb.append(SCHEME).append("://").append(HttpFSConf.getHOST())
                .append(":").append(HttpFSConf.getPORT()).append(SERVICE_PATH)
                .append(path).append("?").append(params);
        return sb.toString();
    }
}