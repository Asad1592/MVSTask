package com.MVSTask.headerinfo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HeaderInfoServiceTest {

    @Test
    public void testGetHeadersInfo() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        Enumeration<String> headerNames = Collections.enumeration(Collections.singletonList("User-Agent"));
        Mockito.when(request.getHeaderNames()).thenReturn(headerNames);
        Mockito.when(request.getHeader("User-Agent")).thenReturn("Mozilla/5.0");

        assertEquals("Mozilla/5.0", HeaderInfoService.getHeadersInfo(request).get("User-Agent"));
    }
}
