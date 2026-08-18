package com.jkuat.cat.q1;

import java.net.URL;
import java.net.URLDecoder;

public class URLParser {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://api.techstore.com:8443/products/category/electronics?sort=price&limit=20#reviews");

        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("Path: " + url.getPath());
        System.out.println("Fragment: " + url.getRef());

        String query = url.getQuery();
        System.out.println("Query Parameters:");
        for (String param : query.split("&")) {
            String[] pair = param.split("=");
            String key = URLDecoder.decode(pair[0], "UTF-8");
            String value = URLDecoder.decode(pair[1], "UTF-8");
            System.out.println("  " + key + " = " + value);
        }
    }
}