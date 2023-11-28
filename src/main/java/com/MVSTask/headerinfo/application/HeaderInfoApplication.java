package com.MVSTask.headerinfo.application;

import com.MVSTask.headerinfo.page.HomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * The main application class for the Header Info application.
 * This class is responsible for initializing and configuring the Wicket application.
 */

public class HeaderInfoApplication extends WebApplication {

    /**
     * Gets the home page class for the application.
     *
     * @return the HomePage class.
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }
    @Override
    protected void init() {
        super.init();
        // You can add other initializations here if needed
    }
}
