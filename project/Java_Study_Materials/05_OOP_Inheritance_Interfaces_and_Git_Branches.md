# Study Material 05: OOP, Inheritance, Interfaces and Git Branches

## Inheritance
Inheritance lets a subclass reuse and specialize superclass behavior.

```java
class Vehicle {
    void start() {
        System.out.println("Vehicle starts");
    }
}
class Car extends Vehicle {
    void openBoot() {
        System.out.println("Boot opened");
    }
}
```

Java classes have single class inheritance: a class can extend one direct superclass. A class can implement multiple interfaces.

## Overloading vs overriding
- **Overloading:** Same method name, different parameter lists; resolved mainly at compile time.
- **Overriding:** A subclass provides a compatible implementation of an inherited instance method; selected dynamically at runtime.

```java
class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```

```java
class Animal {
    void sound() { System.out.println("Sound"); }
}
class Dog extends Animal {
    @Override
    void sound() { System.out.println("Bark"); }
}
```

Return type alone is not enough to overload a method. Static methods are hidden, not overridden like instance methods.

## Abstract classes and interfaces
- **Abstract class:** Can have fields, constructors, concrete methods, and abstract methods. A class can extend only one class.
- **Interface:** Defines a contract. It can contain abstract, `default`, `static`, and private helper methods. A class can implement multiple interfaces.

Use interfaces for shared capabilities, such as `Payable` or `Serviceable`.

## Polymorphism
```java
Animal animal = new Dog();
animal.sound(); // Bark
```

The reference type controls which members are accessible at compile time. The runtime object determines the overridden instance method implementation.

## Git branches
A branch supports isolated work on a feature.

```bash
git switch -c feature/service-booking
git add .
git commit -m "Add service booking"
git switch main
git merge feature/service-booking
```

## Merge, rebase and conflicts
- **Merge:** Integrates histories and may create a merge commit.
- **Rebase:** Replays commits on a new base, producing new commit IDs.
- **Conflict:** Git cannot automatically reconcile changes.

Resolve conflict markers, test the result, stage the resolved files, and complete the merge or rebase. Avoid rebasing shared commits unless the team agrees.

## Quick revision
- Overloading changes parameter lists.
- Overriding changes inherited instance-method behavior.
- Interfaces allow a class to implement multiple contracts.
- Merge integrates histories; rebase replays commits on a new base.
