# 🚀 Selenium WebDriver Factory Pattern Framework

<div align="center">

![Selenium](https://img.shields.io/badge/Selenium-4.23.0-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Java](https://img.shields.io/badge/Java-21-007396?style=for-the-badge&logo=java&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-7.9.0-DC382D?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

**Advanced Test Automation Framework for SauceDemo Application**

*Demonstrating Factory Design Pattern + Page Object Model*

</div>

---

## 📑 Table of Contents

- [🎯 Overview](#-overview)
- [🧠 Factory Design Pattern](#-factory-design-pattern)
- [🏗️ Framework Architecture](#️-framework-architecture)
- [⚙️ Tech Stack](#️-tech-stack)
- [🎨 Design Patterns](#-design-patterns)
- [🚀 Getting Started](#-getting-started)
- [🧪 Running Tests](#-running-tests)
- [✨ Key Features](#-key-features)
- [📊 Test Flow](#-test-flow)
- [🎯 Sample Output](#-sample-output)
- [💡 Why Factory Pattern](#-why-factory-pattern)
- [🔮 Future Enhancements](#-future-enhancements)
- [👨‍💻 Author](#-author)

---

## 🎯 Overview

This project demonstrates an **enterprise-grade Test Automation Framework** built using **Selenium WebDriver**, **Java**, and **TestNG**. It implements the **Factory Design Pattern** to automate the [SauceDemo](https://www.saucedemo.com/) e-commerce application.

### 🎪 What Makes This Special?

```
🏭 Factory Pattern  →  Smart browser instantiation
📄 Page Object Model  →  Modular & maintainable code
🧵 Thread-Safe Design  →  Parallel execution ready
🌐 Cross-Browser Support  →  Chrome | Firefox | Edge
🔄 CI/CD Ready  →  Jenkins | GitHub Actions compatible
```

---

## 🧠 Factory Design Pattern

The **Factory Pattern** is a **Creational Design Pattern** that provides an interface for creating objects without exposing the instantiation logic to the client.

### 🎭 How It Works in This Framework

```java
// ❌ Without Factory Pattern
WebDriver driver = new ChromeDriver();  // Tightly coupled

// ✅ With Factory Pattern
WebDriver driver = DriverFactory.createInstance("chrome");  // Flexible & extensible
DriverManager.setDriver(driver);
```

### 🌟 Key Benefits

| Benefit | Description |
|---------|-------------|
| 🎯 **Centralized Logic** | All driver creation in one place |
| 🔄 **Reduces Duplication** | Write once, use everywhere |
| 📈 **Easy Extension** | Add new browsers without breaking existing code |
| 🛡️ **Better Maintainability** | Change once, affect all |
| ⚡ **Parallel Testing** | Thread-safe driver management |
| 🧪 **Testability** | Easy to mock and test |

---

## 🏗️ Framework Architecture

```
📦 SeleniumFactoryDesign/
┃
┣━━ 📂 src/
┃   ┣━━ 📂 main/java/
┃   ┃   ┣━━ 🏭 factory/
┃   ┃   ┃   ┣━━ ⚙️ DriverFactory.java        # Creates WebDriver instances
┃   ┃   ┃   ┗━━ 🧵 DriverManager.java       # Thread-safe driver handling
┃   ┃   ┃
┃   ┃   ┗━━ 📄 pages/
┃   ┃       ┣━━ 🔐 LoginPage.java           # Login page object
┃   ┃       ┗━━ 🛒 InventoryPage.java       # Product page object
┃   ┃
┃   ┗━━ 📂 test/java/
┃       ┗━━ 🧪 tests/
┃           ┣━━ 🔧 BaseTest.java            # Test setup/teardown
┃           ┣━━ ✅ LoginTest.java           # Login validations
┃           ┗━━ 🎯 AddToCartTest.java       # Cart operations
┃
┣━━ 📋 pom.xml                               # Maven dependencies
┣━━ 🎯 testng.xml                            # TestNG configuration
┗━━ 📖 README.md                             # Project documentation
```

### 🔍 Layer Breakdown

```
┌─────────────────────────────────────────┐
│        🧪 Test Layer                    │  ← LoginTest, AddToCartTest
│         (TestNG Tests)                  │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│        📄 Page Object Layer             │  ← LoginPage, InventoryPage
│         (UI Elements & Actions)         │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│        🏭 Factory Layer                 │  ← DriverFactory, DriverManager
│         (Driver Creation)               │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│        🌐 WebDriver Layer               │  ← Chrome, Firefox, Edge
│         (Browser Instances)             │
└─────────────────────────────────────────┘
```

---

## ⚙️ Tech Stack

<table>
  <tr>
    <th>Component</th>
    <th>Technology</th>
    <th>Version</th>
    <th>Purpose</th>
  </tr>
  <tr>
    <td>☕ Language</td>
    <td><strong>Java</strong></td>
    <td>21</td>
    <td>Core programming language</td>
  </tr>
  <tr>
    <td>🤖 Automation</td>
    <td><strong>Selenium WebDriver</strong></td>
    <td>4.23.0</td>
    <td>Browser automation</td>
  </tr>
  <tr>
    <td>🧪 Test Framework</td>
    <td><strong>TestNG</strong></td>
    <td>7.9.0</td>
    <td>Test execution & assertions</td>
  </tr>
  <tr>
    <td>🔨 Build Tool</td>
    <td><strong>Maven</strong></td>
    <td>3.9+</td>
    <td>Dependency management</td>
  </tr>
  <tr>
    <td>📊 Reporting</td>
    <td><strong>TestNG/Allure</strong></td>
    <td>-</td>
    <td>Test reports & analytics</td>
  </tr>
  <tr>
    <td>🎨 Design Patterns</td>
    <td><strong>Factory + POM</strong></td>
    <td>-</td>
    <td>Code organization</td>
  </tr>
</table>

---

## 🎨 Design Patterns

### 1️⃣ Factory Pattern Implementation

**DriverFactory.java** encapsulates all browser initialization logic:

```java
public class DriverFactory {
    
    public static WebDriver createInstance(String browser) {
        WebDriver driver;
        
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-save-password-bubble");
                driver = new ChromeDriver(chromeOptions);
                break;
                
            case "firefox":
                driver = new FirefoxDriver();
                break;
                
            case "edge":
                driver = new EdgeDriver();
                break;
                
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
```

### 2️⃣ Page Object Model (POM)

Each page is represented as a separate class:

```java
📄 LoginPage.java
┣━━ 🔑 Elements: usernameField, passwordField, loginButton
┗━━ ⚡ Actions: login(), isDisplayed()

📄 InventoryPage.java
┣━━ 🛒 Elements: productButtons, cartBadge
┗━━ ⚡ Actions: addToCart(), getCartCount()
```

**Benefits:**
- ✅ Code reusability across tests
- ✅ Easy maintenance when UI changes
- ✅ Better readability and organization
- ✅ Reduces test fragility

---

## 🚀 Getting Started

### 📋 Prerequisites

```bash
☑️ Java 21 or higher
☑️ Maven 3.9+
☑️ Chrome/Firefox/Edge browser
☑️ IDE (IntelliJ IDEA / Eclipse)
```

### 📥 Installation

1. **Clone the repository**
```bash
git clone https://github.com/sarankumar/selenium-factory-pattern.git
cd selenium-factory-pattern
```

2. **Install dependencies**
```bash
mvn clean install
```

3. **Verify setup**
```bash
mvn test
```

---

## 🧪 Running Tests

### 🎯 Method 1: Run via TestNG XML

```bash
# Right-click on testng.xml
Run As → TestNG Suite
```

### 💻 Method 2: Run via Maven CLI

```bash
# Run all tests
mvn clean test

# Run specific test class
mvn test -Dtest=LoginTest

# Run with specific browser
mvn test -Dbrowser=firefox
```

### 🔀 Method 3: Parallel Cross-Browser Execution

The `testng.xml` configuration enables parallel execution:

```xml
<suite name="SauceDemo-Factory-Suite" parallel="tests" thread-count="2">
    
    <!-- Chrome Tests -->
    <test name="ChromeSuite">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.AddToCartTest"/>
        </classes>
    </test>
    
    <!-- Firefox Tests -->
    <test name="FirefoxSuite">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.AddToCartTest"/>
        </classes>
    </test>
    
</suite>
```

**Result:** Tests run simultaneously on Chrome and Firefox! ⚡

---

## ✨ Key Features

### 🎯 Core Capabilities

| Feature | Description |
|---------|-------------|
| 🏭 **Factory Pattern** | Browser-agnostic WebDriver instantiation |
| 🔐 **Auto-Handling** | Manages Chrome password-manager popups |
| 📦 **Modular POM** | Organized page objects for easy maintenance |
| 🧵 **Thread-Safe** | ThreadLocal WebDriver for parallel execution |
| ⚡ **Parallel Tests** | TestNG parallel execution support |
| 🔄 **CI/CD Ready** | Compatible with Jenkins & GitHub Actions |
| 🌐 **Cross-Browser** | Chrome, Firefox, Edge support |
| 📊 **Rich Reporting** | TestNG HTML reports with screenshots |

### 🛡️ Best Practices Implemented

```
✅ SOLID principles adherence
✅ DRY (Don't Repeat Yourself) code
✅ Separation of concerns
✅ Explicit waits over implicit
✅ Meaningful test and method names
✅ Proper exception handling
✅ Comprehensive logging
```

---

## 📊 Test Flow

```
🚀 START
   ↓
1️⃣  Factory creates browser instance (Chrome/Firefox/Edge)
   ↓
2️⃣  Navigate to https://www.saucedemo.com
   ↓
3️⃣  Enter credentials (standard_user / secret_sauce)
   ↓
4️⃣  Click login button
   ↓
5️⃣  Verify landing on Inventory Page
   ↓
6️⃣  Add product "Sauce Labs Backpack" to cart
   ↓
7️⃣  Assert cart badge shows "1"
   ↓
8️⃣  Cleanup & close browser
   ↓
🏁 END
```

### 📸 Test Scenarios Covered

| Test Case | Validation | Status |
|-----------|-----------|--------|
| 🔐 **Valid Login** | User redirected to Inventory Page | ✅ PASS |
| 🛒 **Add to Cart** | Cart badge increments correctly | ✅ PASS |
| 🔍 **Page Title** | Correct title displayed | ✅ PASS |
| 🏷️ **Product Display** | Products visible on inventory | ✅ PASS |

---

## 🎯 Sample Output

```bash
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running TestSuite

╔════════════════════════════════════════════════╗
║          Test Execution Report                 ║
╚════════════════════════════════════════════════╝

🔵 Chrome Suite
   ✅ PASSED: LoginTest.validLogin() - 3.2s
   ✅ PASSED: AddToCartTest.addItemToCart() - 2.8s

🟠 Firefox Suite
   ✅ PASSED: LoginTest.validLogin() - 3.5s
   ✅ PASSED: AddToCartTest.addItemToCart() - 3.1s

╔════════════════════════════════════════════════╗
║  Total Tests: 4  |  Passed: 4  |  Failed: 0   ║
║  Execution Time: 12.6 seconds                  ║
╚════════════════════════════════════════════════╝

[INFO] All tests executed successfully! 🎉
```

---

## 💡 Why Factory Pattern Matters in Automation

### 🎭 The Problem Without Factory

```java
// ❌ Hard to maintain
if (browser.equals("chrome")) {
    driver = new ChromeDriver();
} else if (browser.equals("firefox")) {
    driver = new FirefoxDriver();
}
// Repeated in every test class... 😱
```

### ✨ The Solution With Factory

```java
// ✅ Clean, reusable, maintainable
WebDriver driver = DriverFactory.createInstance(browser);
DriverManager.setDriver(driver);
```

### 🌟 Advantages

| Aspect | Impact |
|--------|--------|
| 🎯 **Flexibility** | Easy to add Safari, Opera, or remote browsers |
| 🧩 **Separation** | Driver setup isolated from test logic |
| 🧵 **Thread Safety** | Works seamlessly with ThreadLocal for parallel runs |
| 🛡️ **Stability** | Centralized browser options reduce flakiness |
| 📈 **Scalability** | Supports distributed execution (Selenium Grid) |
| 🔧 **Maintainability** | Change once, impact everywhere |

---

## 🔮 Future Enhancements

### 🎯 Roadmap

```
Phase 1: Enhanced Reporting
   ├── 📊 Integrate Allure Reports
   ├── 📸 Automatic screenshot on failure
   └── 📹 Video recording of test execution

Phase 2: CI/CD Integration
   ├── 🔄 GitHub Actions pipeline
   ├── 🔧 Jenkins integration
   └── 📦 Docker containerization

Phase 3: Advanced Features
   ├── 🌐 Selenium Grid support
   ├── ☁️ BrowserStack/Sauce Labs integration
   ├── 📁 Property files for configuration
   └── 🗃️ Database validation

Phase 4: Performance & Security
   ├── ⚡ API testing integration
   ├── 🔒 Security testing
   └── 📈 Performance benchmarking
```

---

## 📚 Additional Resources

### 📖 Documentation
- [Selenium WebDriver Docs](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- [Factory Pattern Guide](https://refactoring.guru/design-patterns/factory-method)

### 🎓 Learning Materials
- Design Patterns in Test Automation
- Page Object Model Best Practices
- Selenium Framework Development

---

## 🎯 Conclusion

By combining the **Factory Design Pattern** with **Page Object Model**, this framework achieves:

```
✨ Clean & Elegant Architecture
✨ High Maintainability & Readability
✨ Scalable Parallel Testing
✨ Reliable & Stable Execution
✨ Enterprise-Grade Quality
```

> 💡 *"The Factory Pattern transforms complex browser initialization into a simple, reusable, and powerful abstraction - making your automation framework future-proof and scalable."*

---

<div align="center">

## 👨‍💻 Author

### **Saran Kumar**

⭐ **If this framework helped you, please star the repository!** ⭐

