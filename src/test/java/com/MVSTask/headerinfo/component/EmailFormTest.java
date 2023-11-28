package com.MVSTask.headerinfo.component;

import com.MVSTask.headerinfo.application.HeaderInfoApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class EmailFormTest {

    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new HeaderInfoApplication());
    }

    @Test
    public void testRenderEmailForm() {
        // Creating a dummy WebPage to hold the form
        tester.startPage(new DummyPage(new EmailForm("emailForm")));

        tester.assertVisible("emailForm");
        tester.assertVisible("emailForm:email");
    }

    // This is a dummy WebPage class that you use to hold and test individual components like forms
    private static class DummyPage extends WebPage {
        public DummyPage(Form<Void> form) {
            add(form);
        }
    }
}
