# Study Material 03: Conditions, Loops and Maven

## Conditions
`if` and `if-else` choose a path based on a boolean condition.

```java
int mark = 78;
if (mark >= 90) {
    System.out.println("A");
} else if (mark >= 75) {
    System.out.println("B");
} else {
    System.out.println("Needs improvement");
}
```

Use `switch` when one expression is compared against multiple alternatives.

```java
int day = 2;
switch (day) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    default -> System.out.println("Other day");
}
```

## Loops
- **`while`:** Checks the condition before each iteration.
- **`for`:** Groups initialization, condition, and update.
- **Enhanced `for`:** Reads each element of an array or iterable.

```java
for (int i = 0; i < 3; i++) {
    System.out.println(i);
}

int[] nums = {2, 4, 6};
for (int n : nums) {
    System.out.println(n);
}
```

- `break` exits the nearest loop or switch.
- `continue` skips the rest of the current loop iteration.

## Maven project structure
```text
project/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/
    │   └── resources/
    └── test/
        └── java/
```

- `pom.xml`: Project configuration, dependencies, plugins, and build settings.
- `src/main/java`: Application source code.
- `src/main/resources`: Configuration and other resources.
- `src/test/java`: Test source code.

## Dependencies and lifecycle
Dependencies are external libraries used by the project. Maven downloads and manages them.

```bash
mvn clean
mvn compile
mvn test
mvn package
mvn install
```

- `clean`: Removes generated build output.
- `compile`: Compiles main source.
- `test`: Runs tests.
- `package`: Creates a JAR or another configured artifact.
- `install`: Adds the artifact to the local Maven repository.

## Maven profiles
Profiles provide alternative configuration, for example for development and production.

```bash
mvn package -Pprod
```

Do not commit passwords or other secrets into source control.

## Quick revision
1. Which statement exits a loop? `break`.
2. Where are Maven dependencies declared? `pom.xml`.
3. What does `mvn test` do? Runs project tests.
