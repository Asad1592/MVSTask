package com.MVSTask.headerinfo.page;

import com.MVSTask.headerinfo.application.HeaderInfoApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class BasePageTest {

    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new HeaderInfoApplication());
    }

    @Test
    public void testRenderBasePage() {
        tester.startPage(BasePage.class);
        tester.assertRenderedPage(BasePage.class);
    }
}
