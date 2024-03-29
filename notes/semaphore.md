## Semaphore (The permit machine) - since 1.5

If we want to give access to critical section to multiple threads one at a time then we use a `Lock`.

_But what if we want to give access to more than one threads?_

Here we use `Semaphore`.

Semaphore is nothing but a **"permit machine"**.

- We define a Semaphore with number of allowed permits.
- So if we define a Semaphore with 3 permits then at a time only 3 threads can work on the CS.
- Rest of the threads will wait for the working threads to release the permit.

> "A Semaphore manages a set of virtual permits; the initial number of permits is passed to the Semaphore constructor."

**Semaphore Use cases:**

- Limiting concurrent access to disk (as performance degrades due to competing disk seeks)
- Thread creation limiting
- JDBC connection pooling / limiting
- Network connection throttling
- Throttling CPU or memory intensive tasks