# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java library (`calclib`) that provides financial calculation utilities for asset management. The library focuses on interest calculations using BigDecimal for precision.

## Build and Test Commands

This is a Maven project using Java 17. Use the following commands:

```bash
# Clean and compile
mvn clean compile

# Run all tests
mvn test

# Run a single test class
mvn test -Dtest=CalcInterestTest

# Run a single test method
mvn test -Dtest=CalcInterestTest#calculateInterest_success

# Package the library (creates JAR)
mvn package

# Install to local Maven repository
mvn install
```

## Architecture

The library has a simple, focused architecture:

- **CalcInterest** (src/main/java/am/calclib/CalcInterest.java): Core calculation class providing:
  - Rate of return calculations
  - Simple interest calculations
  - Compound interest calculations using the formula (1 + r)^t
  - Generic input validation with detailed error reporting

Key design decisions:
- All monetary calculations use `BigDecimal` to avoid floating-point precision issues
- Input validation is centralized in a generic `checkInput` method that supports varargs
- The validation method uses `@SafeVarargs` to suppress heap pollution warnings
- All public methods validate inputs before performing calculations

## Testing Approach

Tests use JUnit 5 (Jupiter) and are located in src/test/java/am/calclib/. When adding new tests:
- Test methods should follow the pattern: `methodName_scenario`
- Use BigDecimal for test values to match production code
- Assert using `compareTo` for BigDecimal equality checks

## DEV Rule
- After modifying the resource, run `mvn test` to verify that the verification passes.