# Playwright Java Automation Framework

A modern UI automation framework built with **Java + Playwright + TestNG**, designed to demonstrate fast, reliable browser testing with CI integration.

## Tech Stack
- Java 11
- Playwright
- TestNG
- Maven
- GitHub Actions

## Features
- Fast, reliable UI testing with Playwright
- Java + TestNG test structure
- CI execution via GitHub Actions
- Real-world test coverage using https://playwright.dev

## Debugging Artifacts (CI-friendly)
On test failure, the framework captures:
- Full-page screenshot (`target/artifacts/<testName>/failure.png`)
- Playwright trace (`target/artifacts/<testName>/trace.zip`)
- Video recording (`target/videos/`)

> Planned enhancements: self-healing locators with Healenium, reporting, and cross-browser execution.

## Run Locally
```bash
mvn clean test
