# Study Material 02: Java Basics and Git

## Variables and constants
A variable stores a value. Use `final` when a variable should not be reassigned.

```java
int age = 20;
double cgpa = 8.1;
String name = "Ravi";
final double PI = 3.14159;
```

## Primitive data types
| Type | Example | Use |
|---|---|---|
| `byte` | `byte b = 10;` | Small integer |
| `short` | `short s = 1000;` | Short integer |
| `int` | `int count = 25;` | Whole numbers |
| `long` | `long n = 8000000L;` | Large whole numbers |
| `float` | `float rate = 2.5f;` | Decimal, lower precision |
| `double` | `double price = 19.99;` | Decimal, commonly preferred |
| `char` | `char grade = 'A';` | One UTF-16 code unit |
| `boolean` | `boolean active = true;` | True/false |

`String` is a reference type, not a primitive type.

## Arrays
Arrays hold a fixed number of elements of one type. Indexing starts at `0`.

```java
int[] marks = {80, 90, 75};
System.out.println(marks[0]); // 80

for (int mark : marks) {
    System.out.println(mark);
}
```

An invalid index can cause `ArrayIndexOutOfBoundsException`.

## Operators
- Arithmetic: `+ - * / %`
- Comparison: `== != > < >= <=`
- Logical: `&& || !`
- Assignment: `= += -= *=`
- Increment/decrement: `++ --`
- Conditional: `condition ? value1 : value2`

Integer division `7 / 2` gives `3`; `7.0 / 2` gives `3.5`.

## Type casting
- **Widening:** Usually automatic, such as `int` to `double`.
- **Narrowing:** Explicit, such as `double` to `int`; fractional parts may be lost.

```java
int x = 10;
double y = x;
int whole = (int) 9.8; // 9
```

## Git commands
- `git init`: Initialize a repository.
- `git status`: View staged, changed, and untracked files.
- `git add file`: Stage a file.
- `git commit -m "message"`: Save a local snapshot.
- `git push`: Send local commits to a remote repository.
- `git pull`: Fetch and integrate remote changes.
- `git clone URL`: Copy a remote repository locally.
- `.gitignore`: Lists files Git should normally ignore, such as `target/` and `.class` files.

Typical workflow:

```bash
git status
git add .
git commit -m "Add Java basics"
git push
```

## SSH setup
SSH keys can authenticate Git without repeatedly entering a password. Add the **public key** to your hosting account. Keep the **private key secret** and never share it.

## Quick revision
- Arrays have fixed length.
- `final` prevents reassignment.
- `add` stages; `commit` saves locally; `push` uploads commits.
