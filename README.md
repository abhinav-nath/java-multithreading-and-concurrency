# Multithreading and Concurrency in Java

All about Multi-threading and Concurrent programming in Java.
Simple and easy to understand code examples for most of the Concurrent APIs provided by Java.

### Topics

#### All about Threads
- [Motivation - Why do we need Threads?](./notes/threads-motivation.md)
- [Threads in Java](./src/com/codecafe/concurrency/thread)
  - [Creating Threads](./notes/creating-threads.md) using:
    - [Runnable](./src/com/codecafe/concurrency/thread/basics/designathread/ThreadDemo.java)
    - [Thread class](./src/com/codecafe/concurrency/thread/basics/designathread/ThreadDemo.java)
    - [Callable](./src/com/codecafe/concurrency/thread/basics/designathread/CallableDemo.java)
    - [ExecutorService](notes/executorservice.md) - [[code](./src/com/codecafe/concurrency/executorservice/ExecutorServiceDemo.java)]
  - [Thread States](./notes/thread-states.md) - [[code](./src/com/codecafe/concurrency/thread/basics/designathread/ThreadStates.java)]
  - [Thread Termination](./src/com/codecafe/concurrency/thread/threadtermination/Main.java)
  - [Joining Threads](./src/com/codecafe/concurrency/thread/joiningthreads/Main.java)
- [Thread Signalling](./src/com/codecafe/concurrency/threadsignalling)
- [Daemon Threads](./notes/daemon-threads.md) - [[code](./src/com/codecafe/concurrency/thread/daemonthreads/Main.java)]

#### Performance in Multithreading
- [Latency](./notes/performance-in-multithreading.md#latency)
  - [How many subtasks/threads to break the original task into?](./notes/performance-in-multithreading.md#n--)
    - [Hyper-threading](./notes/performance-in-multithreading.md#hyper-threading)
  - [Inherent cost of Parallelization and Aggregation](./notes/performance-in-multithreading.md#inherent-cost-of-parallelization-and-aggregation)
  - [Can we always break any task into multiple subtasks?](./notes/performance-in-multithreading.md#can-we-always-break-any-task-into-multiple-subtasks)
- [Throughput](./notes/performance-in-multithreading.md#throughput)

#### Thread synchronization and locks
- [The `synchronized` keyword](./src/com/codecafe/concurrency/_synchronized)
- [Locks](./src/com/codecafe/concurrency/locks)
- [Deadlock](./src/com/codecafe/concurrency/deadlock)

#### Concurrent APIs provided by Java
- [BlockingQueue](./src/com/codecafe/concurrency/blockingqueue)
- [Semaphore](./notes/semaphore.md) - [[code](./src/com/codecafe/concurrency/semaphore)]
- [CountdownLatch](./notes/countdownlatch.md) - [[code](./src/com/codecafe/concurrency/countdownlatch/CountDownLatchDemo.java)]
  - [with time-out](./src/com/codecafe/concurrency/countdownlatch/timeout/TerminatingCountDownLatch.java)
- [CyclicBarrier](./notes/cyclicbarrier.md) - [[code](./src/com/codecafe/concurrency/cyclicbarrier/CyclicBarrierDemo.java)]
  - [Need of CyclicBarrier](./src/com/codecafe/concurrency/cyclicbarrier/NeedOfCyclicBarrier.java)
- [`atomic` variables](./src/com/codecafe/concurrency/_atomic)
- [The `volatile` keyword](./notes/volatile-keyword.md) - [[code](./src/com/codecafe/concurrency/_volatile/VolatileDemo.java)]

---
<p align="center">
  ⭐ Star this repository if it helped you!
</p>
