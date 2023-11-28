# MVSTask
This project task captures header information from incoming HTTP requests and provides a facility to email this information.

1. Main Application Class
Class: HeaderInfoApplication
•	Responsible for the initialization of the application.
•	The home page for the application is defined as HomePage.
2. Components
2.1 EmailForm
Location: com.MVSTask.headerinfo.component.EmailForm
•	A form component that captures an email address.
•	Upon submission, it checks if the email is valid and then sends the HTTP header information to the given email.
2.2 HeaderInfoDisplay
Location: com.MVSTask.headerinfo.component.HeaderInfoDisplay
•	A panel to display HTTP header information.
•	Accepts a map of headers and their values, which is then displayed in the format "HeaderName: Value".
2.3 HomePage
Location: com.MVSTask.headerinfo.page.HomePage
•	Represents the main page of the application.
•	This page integrates the EmailForm and HeaderInfoDisplay components.
•	It captures header information from the incoming request and displays it.
3. Services
3.1 EmailService
Location: com.MVSTask.headerinfo.service.EmailService
•	Provides a utility method sendEmail that sends emails with specified content.
•	Uses Gmail's SMTP service and OAuth2.0 for authentication.
3.2 HeaderInfoService
Location: com.MVSTask.headerinfo.service.HeaderInfoService
•	Provides a utility method getHeadersInfo to extract headers from the incoming HttpServletRequest.
4. Utilities
EmailValidator
Location: com.MVSTask.headerinfo.util.EmailValidator
•	Provides a utility method isValidEmail to validate email addresses using regex patterns.
5. Frontend Resources
5.1 HeaderInfoDisplay HTML
Location: src/main/resources/com/MVSTask/headerinfo/component/HeaderInfoDisplay.html
•	Provides the markup for displaying header information.
5.2 HomePage HTML
Location: com/MVSTask/headerinfo/page/HomePage.html
•	The primary markup for the main page.
•	Incorporates the EmailForm and HeaderInfoDisplay components.

