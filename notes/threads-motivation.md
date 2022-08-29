## Motivation - Why do we need Threads?

1. **[Responsiveness](#responsiveness---concurrency)**
2. **[Performance](#performance---parallelism)**

## Responsiveness - Concurrency

### Examples of Poor Responsiveness

- Waiting for Customer Support
- Late response from a person
- No feedback from an application

![Responsiveness](../images/responsiveness.png)

- Responsiveness can be achieved by using multiple threads, with a separate thread for each task.
- Generally very hard to achieve otherwise.

> By multi-tasking quickly between threads, the CPU can create an illusion that all the tasks are executing at the same time.

The term we use for this kind of multi-tasking is **concurrency**.

We don't need multiple cores to achieve concurrency. Even with one core, we can create responsive applications by using multiple threads.

## Performance - Parallelism

- We can create an *illusion* of multiple tasks executing in parallel using just a single core.
- With **multiple cores**, we can truly run tasks completely in parallel.

**Performance - Impact**
- Completing a complex task much faster
- Finish more work in the same period of time
- For high-scale services:
  - Fewer machines
  - Less money spent on hardware