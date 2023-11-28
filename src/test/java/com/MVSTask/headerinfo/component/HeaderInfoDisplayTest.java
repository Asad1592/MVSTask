package com.MVSTask.headerinfo.component;

import com.MVSTask.headerinfo.application.HeaderInfoApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HeaderInfoDisplayTest {

    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new HeaderInfoApplication());
    }

    @Test
    public void testRenderHeaderInfoDisplay() {
        // Create a map of headers info as expected
        Map<String, String> expectedHeadersInfo = new HashMap<>();
        expectedHeadersInfo.put("Header1", "Value1");
        expectedHeadersInfo.put("Header2", "Value2");

        // Convert expectedHeadersInfo map to a single formatted string to compare in assertion
        StringBuilder expectedHeadersInfoStr = new StringBuilder("HTTP Headers Info:\n");
        expectedHeadersInfo.forEach((key, value) ->
                expectedHeadersInfoStr.append(key).append(": ").append(value).append("\n")
        );

        tester.startComponentInPage(new HeaderInfoDisplay("headerInfo", expectedHeadersInfo));

        tester.assertVisible("headerInfo");

        // Get the actual content and trim it to remove leading and trailing whitespaces
        String actualContent = tester.getComponentFromLastRenderedPage("headerInfo:headersInfo")
                .getDefaultModelObjectAsString().trim();

        // Assert that the actual content is equal to the expected content after both being trimmed
        assertEquals(expectedHeadersInfoStr.toString().trim(), actualContent);
    }
}
