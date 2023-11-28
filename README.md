# MVSTask
This project task captures header information from incoming HTTP requests and provides a facility to email this information.

# HeaderInfoApplication

## Introduction
This project, HeaderInfoApplication, is designed to capture header information from incoming HTTP requests and provide a facility to email this information to a specified email address.

## Main Application Class

### `HeaderInfoApplication`
- **Responsibility**: Initializes the application.
- **HomePage**: Defined as `HomePage`, serving as the landing page of the application.

## Components

### 2.1 `EmailForm`
- **Location**: `com.MVSTask.headerinfo.component.EmailForm`
- **Description**: Captures an email address through a form.
- **Functionality**: Validates the email and sends HTTP header information to the provided email upon submission.

### 2.2 `HeaderInfoDisplay`
- **Location**: `com.MVSTask.headerinfo.component.HeaderInfoDisplay`
- **Description**: Displays HTTP header information.
- **Details**: Accepts a map of headers and their values and displays them in the format "HeaderName: Value".

### 2.3 `HomePage`
- **Location**: `com.MVSTask.headerinfo.page.HomePage`
- **Description**: Represents the main page of the application.
- **Features**: Integrates `EmailForm` and `HeaderInfoDisplay` components to capture and display header information from incoming requests.

## Services

### 3.1 `EmailService`
- **Location**: `com.MVSTask.headerinfo.service.EmailService`
- **Capabilities**: Provides a `sendEmail` method to send emails with specified content using Gmail's SMTP and OAuth2.0.

### 3.2 `HeaderInfoService`
- **Location**: `com.MVSTask.headerinfo.service.HeaderInfoService`
- **Function**: Offers a `getHeadersInfo` method to extract headers from the incoming `HttpServletRequest`.

## Utilities

### `EmailValidator`
- **Location**: `com.MVSTask.headerinfo.util.EmailValidator`
- **Purpose**: Validates email addresses using regex patterns with a `isValidEmail` utility method.

## Frontend Resources

### 5.1 `HeaderInfoDisplay`
- **Location**: `com.MVSTask.headerinfo.component.HeaderInfoDisplay.html`
- **Purpose**: •	Provides the markup for displaying header information.

### 5.2 `HomePage HTML`
- **Location**: `com.MVSTask.headerinfo.page.HomePage.html`
- **Purpose**: •	•	The primary markup for the main page. •	Incorporates the EmailForm and HeaderInfoDisplay components.

