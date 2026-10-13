# Study Material 06: Exception Handling and AI-Assisted Debugging

## What is an exception?
An exception is an event that interrupts the normal flow of a program. Java exceptions are objects.

## Checked vs unchecked exceptions
- **Checked:** The compiler requires catching or declaring them, subject to Java's rules. Examples: `IOException`, `SQLException`, `ClassNotFoundException`.
- **Unchecked:** Subclasses of `RuntimeException`; the compiler does not require catching or declaring them. Examples: `NullPointerException`, `IllegalArgumentException`, `IllegalStateException`, `NumberFormatException`.
- `Error` is a separate category, usually representing serious JVM or environment problems.

## `try`, `catch`, and `finally`
```java
try {
    int result = 10 / 0;
    System.out.println(result);
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
} finally {
    System.out.println("Finished");
}
```

`finally` normally runs whether or not an exception occurs, but not in every possible circumstance (for example, abrupt JVM termination). Avoid returning from `finally`, because it can hide exceptions or return values.

## `throw` vs `throws`
- `throw`: Actually throws an exception object.
- `throws`: Declares exceptions a method may pass to its caller.

```java
void validateQuantity(int quantity) {
    if (quantity <= 0) {
        throw new IllegalArgumentException("Quantity must be positive");
    }
}

void readFile() throws IOException {
    // file-reading code
}
```

## Custom exceptions
Use a custom exception to make a business error clearer.

```java
class InsufficientStockException extends RuntimeException {
    InsufficientStockException(String message) {
        super(message);
    }
}
```

Vehicle service system examples: `JobCardNotFoundException`, `InsufficientStockException`, and `EstimateApprovalRequiredException`.

## Understanding stack traces
A stack trace shows the exception type, message, and method-call path. Start with the exception message and find the first stack-trace line pointing to your own code. A `Caused by` section may show the underlying issue.

## Using Copilot or another AI assistant
1. Share the smallest relevant code snippet and the full error message.
2. Ask what the exception means and which line may be responsible.
3. Ask for likely causes and a minimal fix.
4. Verify the explanation against your code and reliable documentation.
5. Run tests, including edge cases, before accepting the change.
6. Never paste passwords, API keys, private customer data, or confidential code into an unapproved tool.

AI suggestions can be wrong. Treat them as hypotheses and verify them.

## Quick revision
- `throw` throws; `throws` declares.
- Checked exceptions must be caught or declared.
- Custom unchecked exceptions can represent business-rule violations.
