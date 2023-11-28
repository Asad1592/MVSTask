package com.MVSTask.headerinfo.page;

import com.MVSTask.headerinfo.application.HeaderInfoApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class HomePageTest {

    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new HeaderInfoApplication());
    }

    @Test
    public void testRenderHomePage() {
        tester.startPage(HomePage.class);
        tester.assertRenderedPage(HomePage.class);
        tester.assertVisible("headerInfo");
        tester.assertVisible("emailForm");
    }
}
