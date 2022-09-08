# Critical Section and Synchronization

A critical section is a section of code that needs to be executed without outside interference - i.e. without another thread potentially affecting/being affected by "intermediate" states within the section.

For instance, a reservation system might have a critical section when reserving something in that it needs to both check to see if the item is available and then mark it as no longer available, without some other attempt at reserving the room changing that status in the middle.

Thus, the critical section of a piece of code is a **place where only one thread of execution is allowed to be at a time**, to prevent things like _race conditions_.

> A critical section wraps that portion of your code where shared data is being modified.


## Two Types of Race Conditions

Race conditions can occur when two or more threads read and write the same variable according to one of these two patterns:

- **Read-modify-write**
- **Check-then-act**


## Read-Modify-Write Critical Sections

The **read-modify-write** pattern means, that two or more threads first read a given variable, then modify its value and write it back to the variable.
For this to cause a problem, the new value must depend one way or another on the previous value.
The problem that can occur is, if two threads read the value (into CPU registers) then modify the value (in the CPU registers) and then write the values back.

```java
  public class Counter {
    protected long count = 0;

    public void add(long value) {
      this.count = this.count + value;
  }
}
```