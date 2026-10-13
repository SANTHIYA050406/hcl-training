# Study Material 01: JVM, JRE, JDK and Agile Basics

## JVM, JRE and JDK
- **JVM (Java Virtual Machine):** Loads and executes Java bytecode.
- **JRE (Java Runtime Environment):** Conceptually includes the JVM and libraries needed to run Java programs.
- **JDK (Java Development Kit):** Development tools, including `javac`, plus runtime components.

**Memory tip:** JDK is for developing; JVM executes bytecode.

## Compilation and execution
1. Write `Hello.java`.
2. Compile it using `javac Hello.java`.
3. The compiler creates `Hello.class` bytecode.
4. The JVM loads, verifies, and executes the bytecode. The JIT compiler may compile frequently used code to native machine code.

```java
class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

## JVM architecture
- **Class Loader:** Loads classes.
- **Bytecode Verifier:** Checks bytecode.
- **Runtime memory:** Includes heap, Java stacks, program counter registers, and method-area-related storage.
- **Execution Engine:** Interpreter and JIT compiler execute code.
- **Garbage Collector:** Reclaims heap memory for unreachable objects.
- **JNI/native libraries:** Support interaction with native code.

## Agile and Scrum
- **Sprint:** Fixed time period for working toward a goal.
- **Daily stand-up:** Short meeting to coordinate work and surface blockers.
- **Sprint review:** Demonstrate completed work and collect feedback.
- **Retrospective:** Discuss improvements to the team's process.
- **User story:** Requirement from a user's perspective. Example: “As a customer, I want to book a service slot so that I can schedule vehicle maintenance.”
- **Estimation:** Predict relative effort, often with story points.
- **Definition of Done (DoD):** Checklist that work must satisfy before being considered complete, such as code reviewed and tests passed.

## Quick revision
1. What compiles Java source? `javac`.
2. What executes bytecode? JVM.
3. What is a retrospective for? Improving the team's process.
