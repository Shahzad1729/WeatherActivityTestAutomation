# Activity Ranking Mobile Test Automation

## Overview

This project implements automated testing for the **Activity Ranking API - City Based Weather Forecast Integration with Autocomplete (Mobile)** feature.

The goal of the framework is to validate the mobile application behavior where a user types a city name, receives autocomplete suggestions, selects a city, and receives a **7-day ranked list of activities based on weather conditions**.

---

# Technology Stack

| Tool               | Purpose                 |
| ------------------ | ----------------------- |
| Java               | Programming language    |
| Appium 2.x         | Mobile automation       |
| Cucumber           | BDD test scenarios      |
| TestNG             | Test execution          |
| Maven              | Dependency management   |

---

# Framework Design

The framework follows **Page Object Model (POM)** architecture for better maintainability and separation of concerns.

```
src/main
│
├── driver
│     DriverFactory.java
│     DriverManager.java
├── pages
│     BasePage.java
│     DashboardPage.java
│     SearchPage.java
│     ActivityPage.java
├── utils
│     ConfigReader.java
│     WaitUtils.java
│
src/test
│
├── stepdefinitions
│     ActivitySteps.java 
├── hooks
│     Hooks.java 
├── runners
│     TestRunner.java 
└── resources
    ├── features
    │      activityRanking.feature
    │ config.properties
     
```

---

# Cross Platform Support (Android & iOS)

The framework supports both **Android and iOS**.

Platform-specific locators are implemented using **Appium PageFactory annotations**:

```
@AndroidFindBy
@iOSXCUITFindBy
```

Example:

```java
@AndroidFindBy(accessibility = "citySearchInput")
@iOSXCUITFindBy(accessibility = "citySearchInput")
WebElement cityInput;
```

Appium automatically selects the appropriate locator depending on the driver type.

This allows the **same test scripts to run on both Android and iOS without modification**.

---

# Wait Strategy

Mobile UI elements load asynchronously (e.g., autocomplete suggestions or API responses).
To ensure stable test execution, the framework uses **explicit waits via WebDriverWait**.

Examples implemented:

* Wait for element visibility
* Wait for element clickable
* Wait for dynamic list loading (autocomplete suggestions)
* Wait for UI content to appear

Wait utilities are implemented in:

```
utils/WaitUtils.java
```

---

# Driver Management

Driver initialization and cleanup are handled using **Cucumber Hooks**.

```
@Before
DriverManager.init()

@After
DriverManager.quit()
```

This ensures:

* One driver per scenario
* Clean test lifecycle
* Proper session management

---

# Configuration

Execution configuration is controlled via:

```
src/test/resources/config.properties
```

Example:

```
platform=android
deviceName=Pixel_6
automationName=UiAutomator2
appPath=apps/activity.apk
```

To run on iOS:

```
platform=ios
deviceName=iPhone 14
automationName=XCUITest
appPath=apps/activity.app
```

---

# How to Run the Tests

## 1. Start Appium Server

```
appium
```

---

## 2. Configure Platform

Edit:

```
config.properties
```

Example:

```
platform=android
```

or

```
platform=ios
```

---

## 3. Run Tests

Execute using Maven:

```
mvn clean test
```
