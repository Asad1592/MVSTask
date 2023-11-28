package com.MVSTask.headerinfo.component;

import com.MVSTask.headerinfo.service.EmailService;
import com.MVSTask.headerinfo.service.HeaderInfoService;
import com.MVSTask.headerinfo.util.EmailValidator;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.cycle.RequestCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

/**
 * A form component for inputting and submitting an email address.
 * This class is also responsible for sending email containing HTTP header information
 * if the email address is valid.
 */
public class EmailForm extends Form<Void> {
    private static final Logger logger = LoggerFactory.getLogger(EmailForm.class);

    private final TextField<String> emailField;

    public EmailForm(String id) {
        super(id);

        emailField = new TextField<>("email", Model.of(""));
        add(emailField);
    }

    /**
     * Handles the form submission. Validates the email and sends the HTTP headers information
     * via email if the email is valid.
     */
    @Override
    public void onSubmit() {
        String email = emailField.getModelObject();
        if (EmailValidator.isValidEmail(email)) {
            Object containerRequest = RequestCycle.get().getRequest().getContainerRequest();

            // Directly cast the containerRequest object to HttpServletRequest
            try {
                jakarta.servlet.http.HttpServletRequest request =
                        (jakarta.servlet.http.HttpServletRequest) containerRequest;

                Map<String, String> headersInfo = HeaderInfoService.getHeadersInfo(request);

                StringBuilder content = new StringBuilder("HTTP Headers Info:\n");
                headersInfo.forEach((key, value) -> content.append(key).append(": ").append(value).append("\n"));

                if (EmailService.sendEmail(email, "HTTP Headers Info", content.toString())) {
                    info("Email sent successfully!");
                } else {
                    error("Failed to send email!");
                }
            } catch (ClassCastException e) {
                error("Unexpected request type: " + containerRequest.getClass().getName());
            }
        } else {
            error("Invalid email address!");
        }
    }


}
