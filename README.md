# 🚀 Selenium SDET Framework (Java + TestNG + Docker + Allure + CI)

## 📌 Overview

This is a **scalable, production-ready Selenium automation framework** built using:

* Java
* Selenium WebDriver
* TestNG
* Maven
* Docker (Selenium Grid)
* Allure Reporting
* GitHub Actions (CI/CD)

Designed with **SDET best practices**:

* Thread-safe execution using `ThreadLocal`
* Page Object Model (POM)
* Retry mechanism for flaky tests
* Screenshot capture on failure
* CI-ready execution

---

## 🏗️ Project Structure

```
sdet-framework/
│── src/
│   ├── main/
│   └── test/
│       ├── base/           # BaseTest (driver setup)
│       ├── pages/          # Page Object classes
│       ├── tests/          # Test classes
│       ├── utils/          # Listeners, Retry, Config, etc.
│
│── testng.xml              # TestNG suite
│── pom.xml                 # Maven dependencies
│── docker-compose.yml      # Selenium Grid (local)
│── .github/workflows/      # CI pipeline
```

---

## ⚙️ Key Features

### ✅ Thread-Safe Execution

* Uses `ThreadLocal<WebDriver>` to support parallel execution

### ✅ Page Object Model (POM)

* Clean separation of test logic and UI interactions

### ✅ Retry Mechanism

* Automatically retries failed tests

### ✅ Allure Reporting

* Generates rich HTML reports with screenshots

### ✅ CI/CD Integration

* Runs tests automatically using GitHub Actions

### ✅ Docker Support

* Run tests on Selenium Grid (local + CI)

---

## 🐳 Running Tests with Docker (Local)

### Step 1: Start Selenium Grid

```bash
docker-compose up -d
```

### Step 2: Verify Grid

Open:

```
http://localhost:4444
```

### Step 3: Run Tests

```bash
mvn clean test
```

---

## 🤖 Running Tests in CI (GitHub Actions)

* Triggered on:

    * Push to `main`
    * Pull Requests

### CI Features:

* Runs tests in headless mode
* Uses Selenium Docker container
* Generates Allure report
* Uploads test artifacts

---

## 📊 Allure Report

### Generate Locally:

```bash
mvn allure:report
```

### Open Report:

```bash
mvn allure:serve
```

---

## 🧪 Sample Test

```java
@Test
public void verifyTitle() {
    String title = getDriver().getTitle();
    Assert.assertTrue(title.contains("Google"));
}
```

---

## 🔧 Tech Stack

| Tool           | Purpose              |
| -------------- | -------------------- |
| Java           | Programming language |
| Selenium       | Browser automation   |
| TestNG         | Test framework       |
| Maven          | Build tool           |
| Docker         | Containerization     |
| Allure         | Reporting            |
| GitHub Actions | CI/CD                |

---

## 🚀 Best Practices Followed

* No hardcoded waits → Explicit waits used
* No shared driver → ThreadLocal used
* Clean code structure → POM design
* CI stability → Docker + retry + waits
* Proper `.gitignore` usage

---

## 📈 Future Enhancements

* Parallel execution on multiple browsers
* Test data management
* API + UI integration
* Reporting dashboard (Allure hosting)
* Video recording for test execution

---

## 👨‍💻 Author

**Ravindra Hyalij**

---

## ⭐ Why This Project Matters

This framework demonstrates:

* Real-world automation design
* CI/CD integration
* Scalable test architecture
* Industry-level SDET practices

---

🔥 *Perfect for showcasing in interviews and GitHub portfolio*
