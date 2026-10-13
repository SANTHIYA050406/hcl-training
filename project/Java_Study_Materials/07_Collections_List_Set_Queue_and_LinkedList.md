# Study Material 07: Collections, List, Set, Queue and LinkedList

## Java Collections Framework
The framework provides interfaces and implementations for groups of objects.
- **List:** Ordered; allows duplicates.
- **Set:** Does not allow duplicate elements under its equality rules.
- **Queue:** Holds elements for processing, often FIFO, though implementations differ.
- **Map:** Key-value mappings; `Map` is part of the framework but does not extend `Collection`.

Generics specify element types, for example `List<String>`.

## List
```java
import java.util.ArrayList;
import java.util.List;

List<String> names = new ArrayList<>();
names.add("Anu");
names.add("Bala");
names.add("Anu"); // duplicates allowed
System.out.println(names.get(0));
```

Common methods: `add`, `get`, `set`, `remove`, `contains`, `size`, `isEmpty`, `clear`.

## Set
```java
import java.util.HashSet;
import java.util.Set;

Set<String> parts = new HashSet<>();
parts.add("Filter");
parts.add("Oil");
parts.add("Filter");
System.out.println(parts.size()); // 2
```

- `HashSet`: Typically fast membership operations; no guaranteed iteration order.
- `LinkedHashSet`: Preserves insertion order.
- `TreeSet`: Keeps elements sorted by natural order or a comparator.

## Queue
```java
import java.util.ArrayDeque;
import java.util.Queue;

Queue<String> jobs = new ArrayDeque<>();
jobs.offer("Job-101");
jobs.offer("Job-102");
System.out.println(jobs.poll()); // Job-101
System.out.println(jobs.peek()); // Job-102
```

- `offer`: Attempts to add an element.
- `poll`: Removes and returns the head, or `null` if empty.
- `peek`: Reads the head without removing it, or `null` if empty.

`ArrayDeque` does not permit `null` elements.

## Iteration patterns
```java
for (String name : names) {
    System.out.println(name);
}
```

Or use an iterator:

```java
var iterator = names.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

When removing elements during iteration, use the iterator's supported `remove()` method where appropriate. Directly modifying a collection during fail-fast iteration may cause `ConcurrentModificationException`.

## ArrayList vs LinkedList
| Feature | `ArrayList` | `LinkedList` |
|---|---|---|
| Internal structure | Resizable array | Doubly linked nodes |
| Indexed access | Fast, typically O(1) | O(n) |
| Add at end | Amortized O(1) | O(1) with tail reference |
| Middle insertion/removal | Often shifts elements, O(n) | Finding position is O(n); relinking is O(1) once node is reached |
| Memory | Generally lower overhead | More overhead per element |
| Typical use | General-purpose lists and frequent reads | Deque operations at either end |

**Practical rule:** Start with `ArrayList` for most list use cases. Choose `LinkedList` when its deque behavior suits the workload; it is not automatically faster for every insertion or deletion.

## Practice exercise
Create a list of three job-card IDs, print each ID, then add a duplicate. Create a set from the IDs and compare sizes. Put the IDs into a queue and process them with `poll()` until empty.

## Quick revision
1. Does `List` allow duplicates? Yes.
2. Does `Set` allow duplicates? No.
3. What does `Queue.poll()` do? Removes and returns the head, or `null` if empty.
4. Which is usually better for indexed reads? `ArrayList`.
5. What is the internal structure difference? Resizable array vs doubly linked nodes.
