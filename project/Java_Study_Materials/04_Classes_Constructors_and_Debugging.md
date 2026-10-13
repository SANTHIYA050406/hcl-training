# Study Material 04: Classes, Constructors and Debugging

## Classes, fields and methods
A **class** is a blueprint. **Fields** store state, and **methods** define behavior.

```java
class BankAccount {
    private double balance;

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }

    double getBalance() {
        return balance;
    }
}
```

## Constructors
A constructor initializes an object. Its name matches the class name and it has no return type.

```java
class Student {
    String name;
    int age;

    Student() {
        this("Unknown", 0);
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

- `this.field` refers to the current object's field.
- `this(...)` calls another constructor in the same class and must be the first constructor statement.
- `super(...)` calls a superclass constructor and must be first when explicitly used.
- If you declare no constructor, Java may provide a default no-argument constructor. If you declare any constructor, Java does not automatically add that default constructor.

## Access modifiers
- `public`: Accessible wherever the class/member is visible.
- `protected`: Accessible in the same package and by subclasses under Java access rules.
- Package-private (no modifier): Accessible within the same package.
- `private`: Accessible within the declaring class.

Use private fields and methods to control access to object state.

## Packages
Packages organize related classes and reduce naming conflicts. Example declaration:

```java
package com.example.model;
```

## `clone()` basics
`Object.clone()` makes a field-by-field **shallow copy** and is protected in `Object`. A class traditionally supports it by implementing `Cloneable` and overriding `clone()`. Referenced objects are still shared in a shallow copy. Copy constructors or factory methods are often simpler alternatives.

## IntelliJ debugging tools
- **Breakpoint:** Pauses execution at a line.
- **Conditional breakpoint:** Pauses only when a condition is true.
- **Step over:** Executes the current line without entering a called method.
- **Step into:** Enters a method call.
- **Step out:** Runs until the current method returns.
- **Watch:** Evaluates a variable or expression while paused.
- **Call stack:** Shows the method-call path to the current line.
- **Logpoint:** Logs information without necessarily pausing.
- **Hot code replace:** Applies some changes during debugging; not every change is supported.

## Practice: find the bug
```java
int total = 0;
for (int i = 1; i <= 3; i++) {
    total = i; // Bug: should be total += i
}
System.out.println(total);
```

The intended sum is `6`, but this prints `3`. Use a breakpoint and watch `total` to understand why.

## Quick revision
- Constructors have no return type.
- `this` refers to the current object.
- A shallow clone does not recursively copy referenced objects.
