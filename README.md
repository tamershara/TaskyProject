
# Tasky Integration Automation


## 📌 Overview

This project is an automated test suite for the Tasky web app that uses Selenium for browser automation, Rest Assured for API testing, and WireMock to simulate backend data. It focuses on verifying key integration scenarios, such as subscription renewal alerts and to-do limits, by combining UI and API testing with controlled mock responses.


## 🛠️ Tech Stack

- **Selenium**: For browser automation to verify UI behavior.
- **Rest Assured**: For testing APIs such as registration, login, and subscription.
- **WireMock**: For mocking backend services and simulating different scenarios.
- **Maven**: For project and dependency management.
- **TestNG**: For structuring and running the tests.


## 🧰 Tools

- Intellij Idea
- GitHub


## 🌐 Dependencies and Plugins Sources

- https://mvnrepository.com/
- https://allurereport.org/docs/testng/

## 👥 Who It's For

This project is intended for **QA engineers**, **test automation developers**, and **developers** who want to ensure critical features of the Tasky app work correctly under various conditions.


## 📝 Test Scenarios

1. **Subscription Renewal Test**: Verify that a renewal message/button appears **2 days before subscription expiration**.
2. **To-Do Alert Test**: Ensure that a **regular user** receives an alert banner when they have **3 to-dos**.


## 📝 Test Scenarios & Strategy

### 1. **Subscription Renewal Test**

**Objective**: Verify that the renewal message or button appears **2 days before subscription expiration**.

#### **Test Steps**:
- **Setup**:
    - Configure the mock server
    - Configure the proxy of browser

- **Action**:
    - Register a user with random unique email using API
    - Login using same user using API
    - Store the cookies in browser
    - Redirect user to subscription page
    - User to be subscribe using API
    - Mock the current subscription API response
    - Navigate to the user dashboard page where the subscription status is display

- **Verification**:
    - Check if the renewal message/button is visible on the UI.

- **Cleanup**:
    - Close the mock server session.
    - Close the browser

#### **Test Strategy**:
- **Mocking**: Use **WireMock** to simulate the expiration date so that it matches the scenario where the renewal message/button should appear.
- **UI Verification**: Use **Selenium** to verify that the renewal message/button appears exactly **2 days before expiration**.

---

### 2. **To-Do Alert Test**

**Objective**: Ensure that a **regular user** sees an alert banner when they have **3 to-dos**.

#### **Test Steps**:
- **Setup**:
    - Configure the mock server
    - Configure the proxy of browser

- **Action**:
    - Register a user with random unique email using API
    - Login using same user using API
    - Store the cookies in browser
    - Mock the TODOs API response
    - Redirect user to Todos page

- **Verification**:
    - Verify that an alert banner appears, stating that the user has reached the maximum number of to-dos.

- **Cleanup**:
    - Close the mock server session.
    - Close the browser

#### **Test Strategy**:
- **Mocking**: Use **WireMock** to mock the to-do list data, ensuring that the user has exactly **3 to-dos**.
- **UI Verification**: Use **Selenium** to confirm the presence of the alert banner and verify its content (e.g., "You have reached the maximum number of to-dos").

---

### Test Strategy Overview

- **Mocking Data**: For both tests, **WireMock** is used to simulate backend responses, ensuring that specific conditions (like subscription expiration or to-do count) are met.
- **Selenium**: This is used for all UI-related verifications, checking that the renewal button/message appears and ensuring the alert banner is displayed when required.
- **Consistency**: Each test case includes setup, action, verification, and cleanup steps to ensure tests are repeatable and isolated from each other.
 


## 🚀 Getting Started

### Prerequisites

- **Java 17**: Ensure you have Java 8 or higher installed on your machine.
- **Maven**: Maven must be installed for managing dependencies and running tests.

### Important Note 
Please change the start and 
end date in current_subscription.json 
to display the renew button

### Installation

Clone this repository to your local machine:
   ```bash
   git clone https://github.com/tamershara/TaskyProject.git
```

### Run

   ```bash
   mvn test
```

### Environment Variable


   ```bash
   mvn test -Dbrowser for example firefox

