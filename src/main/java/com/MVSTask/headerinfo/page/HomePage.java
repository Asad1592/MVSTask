package com.MVSTask.headerinfo.page;

import com.MVSTask.headerinfo.component.EmailForm;
import com.MVSTask.headerinfo.component.HeaderInfoDisplay;
import com.MVSTask.headerinfo.service.HeaderInfoService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.protocol.http.servlet.ServletWebRequest;
import org.apache.wicket.request.cycle.RequestCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

/**
 * The home page of the Header Info application. This page displays HTTP headers information
 * and contains a form for sending this information via email.
 */
public class HomePage extends BasePage {
    // Added a logger for error handling
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    public HomePage() {
        Map<String, String> headersInfo = Collections.emptyMap(); // initialize with an empty map

        // Get the HTTP request
        Object containerRequest = ((ServletWebRequest) RequestCycle.get().getRequest()).getContainerRequest();

        if (containerRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) containerRequest;

            // Get header information
            headersInfo = HeaderInfoService.getHeadersInfo(request);
        } else {
            logger.warn("Container request is not an HttpServletRequest: {}", containerRequest.getClass().getName());
        }

        // Add components to the page
        add(new HeaderInfoDisplay("headerInfo", headersInfo));
        add(new EmailForm("emailForm"));
        add(new FeedbackPanel("feedback"));

        // Example: Add title label if you need to display dynamic title
        add(new Label("title", "Home Page"));
    }
}
