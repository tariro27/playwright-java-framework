# Playwright Java Automation Framework

[![Playwright CI](https://github.com/tariro27/playwright-java-framework/actions/workflows/ci.yml/badge.svg)](https://github.com/tariro27/playwright-java-framework/actions/workflows/ci.yml)

A modern UI automation framework built with **Java + Playwright + TestNG**, designed to demonstrate fast, reliable browser testing with CI integration.

## Tech Stack
- Java 11
- Playwright
- TestNG
- Maven
- GitHub Actions

## Example Test Flow
This project includes a real-world navigation test against https://playwright.dev:
- Open Playwright home page
- Navigate to Docs
- Validate URL contains `/docs` and Docs page heading is present

## Debugging Artifacts (CI-friendly)
On test failure, the framework captures and uploads:
- Screenshot: `target/artifacts/<testName>/failure.png`
- Playwright trace: `target/artifacts/<testName>/trace.zip`
- Video (optional): `target/videos/`

Artifacts are uploaded automatically in GitHub Actions for easier debugging.

> Planned enhancements: self-healing locators with Healenium, reporting, and cross-browser execution.

## Run Locally
```bash
mvn clean test
