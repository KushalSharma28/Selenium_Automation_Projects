# 📘 Selenium Automation Projects

> 🧪 Automated Testing Suite for Website & REST API Testing using Selenium WebDriver, TestNG/JUnit, RestAssured, and more.

---

## 📂 Table of Contents

1. [About the Project](#about-the-project)
2. [Project Structure](#project-structure)
3. [Technologies Used](#technologies-used)
4. [Setup Instructions](#setup-instructions)
5. [Running the Tests](#running-the-tests)
6. [Test Reports](#test-reports)
7. [CI/CD Integration](#cicd-integration)
8. [Contributing](#contributing)
9. [Contact](#conatct)
---

## 📖 About the Project

This repository contains automated test scripts for:

* 🌐 **Website UI Testing** using Selenium WebDriver.
* 🔗 **REST API Testing** using RestAssured (or alternative frameworks).

The purpose is to maintain a scalable, maintainable automation test suite for end-to-end and backend testing.

---

## 🗂 Project Structure

```bash
selenium-automation-projects/
│
├── website-testing/
│   ├── src/
│   │   ├── test/
│   │   └── main/
│   ├── testng.xml / junit-config.xml
│   └── README.md
│
├── restapi-testing/
│   ├── src/
│   │   ├── test/
│   │   └── main/
│   ├── testng.xml / junit-config.xml
│   └── README.md
│
├── reports/
│   ├── extent-reports/
│   └── logs/
│
├── .github/
│   └── workflows/
│       └── ci.yml
│
├── pom.xml / build.gradle
├── .gitignore
└── README.md
```

---

## 🛠 Technologies Used

* **Languages**: Core Java 
* **Frameworks**:

  * 🧪 Selenium WebDriver
  * 🧪 RestAssured (for REST API)
  * 🧪 TestNG / JUnit 
* **Build Tools**: Maven
* **Reporting**: ExtentReports / Allure / HTML reports
* **CI/CD**: GitHub Actions / Jenkins 
* **Others**: Log4j / SLF4J / dotenv for env config

---

## ⚙️ Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/selenium-automation-projects.git
   cd selenium-automation-projects
   ```

2. **Install Dependencies**

   * For Maven:

     ```bash
     mvn clean install
     ```
   * For Python:

     ```bash
     pip install -r requirements.txt
     ```

3. **Environment Variables**

   * Set the environment variables in `.env` file or via command line:

     ```
     BASE_URL=https://yourwebsite.com
     API_BASE_URL=https://api.yourservice.com
     ```

---

## ▶️ Running the Tests

### Website Testing

* **Using Maven**:

  ```bash
  mvn test -Pwebsite-tests
  ```

### REST API Testing

* **Using Maven**:

  ```bash
  mvn test -Prestapi-tests
  ```

*Use appropriate profiles/configs depending on your test runner.*

---

## 📊 Test Reports

* Test reports will be generated in the `reports/` directory.
* ExtentReports or Allure Reports can be viewed in browser:

  ```bash
  open reports/extent-reports/index.html
  ```

---

## 🚀 CI/CD Integration

This project is integrated with **GitHub Actions** for:

* Running tests on every push or PR
* Generating reports
* Notifying build/test results

> Config: `.github/workflows/ci.yml`

---

## 🤝 Contributing

Feel free to fork the repo, raise issues, or submit pull requests for improvements and new test cases.

---

## 📬 Contact

* Maintainer: [Kushal Sharma](mailto:kushalsharma28499@gmail.com)
* GitHub: [KushalSharma28](https://github.com/KushalSharma28)

---
