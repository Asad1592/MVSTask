package com.MVSTask.headerinfo.component;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import java.util.Map;

/**
 * A panel component for displaying HTTP headers information.
 */
public class HeaderInfoDisplay extends Panel {

    /**
     * Constructor to initialize the panel with HTTP headers information.
     *
     * @param id          the id of the panel
     * @param headersInfo the HTTP headers information to display
     */
    public HeaderInfoDisplay(String id, Map<String, String> headersInfo) {
        super(id);

        StringBuilder headersInfoDisplay = new StringBuilder("HTTP Headers Info:\n");
        headersInfo.forEach((key, value) ->
                headersInfoDisplay.append(key).append(": ").append(value).append("\n")
        );

        add(new Label("headersInfo", headersInfoDisplay.toString()));
    }
}
