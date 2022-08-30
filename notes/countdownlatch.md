## CountdownLatch - since 1.5

`CountDownLatch` is used to make sure that a task waits for other threads before it starts.

> A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.

### Working of CountDownLatch:

When we create an object of `CountDownLatch`, we specify the number of threads it should wait for, all such thread are required to do count down by calling the `CountDownLatch.countDown()` method once they are completed.
As soon as count reaches zero, the waiting task starts running.

If we were doing some parallel processing, we could instantiate the `CountDownLatch` with the same value for the counter as a number of threads we want to work across.
Then, we could just call `countDown()` method after each thread finishes, guaranteeing that a dependent thread calling `await()` will block until the worker threads are finished.


- Creating an object of `CountDownLatch` by passing an `int` to its constructor (the `count`), is actually number of invited parties (threads) for an event.

- The thread, which is dependent on other threads to start processing, waits on until every other thread has called count down.

- All threads, which are waiting on `await()` proceed together once count down reaches to zero.

- `countDown()` method decrements the `count` and `await()` method blocks until `count == 0`


### CountDownLatch Use cases:

- **Achieving Maximum Parallelism**: Sometimes we want to start a number of threads at the same time to achieve maximum parallelism
- Wait `N` threads to complete before starting execution
- Deadlock detection