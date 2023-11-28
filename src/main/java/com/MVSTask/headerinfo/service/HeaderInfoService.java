package com.MVSTask.headerinfo.service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * A service class for retrieving HTTP headers information from HttpServletRequest.
 */
public class HeaderInfoService {

    /**
     * Retrieves the headers information from the given HttpServletRequest.
     *
     * @param request the HttpServletRequest object
     * @return a map containing the headers information
     */
    public static Map<String, String> getHeadersInfo(jakarta.servlet.http.HttpServletRequest request) {
        Map<String, String> headersInfo = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headersInfo.put(headerName, headerValue);
        }

        return headersInfo;
    }
}
