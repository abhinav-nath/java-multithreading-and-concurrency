## Creating Threads

We know that the execution of a Java application starts from the `main()` method.

Similarly, the execution of a thread starts from the `run()` method.

There are two ways to create a thread in Java :

1. By extending the `Thread` class
2. By implementing the `Runnable` interface  -->  _recommended approach_

To perform any task in a separate thread, you need to override the `run()` method and invoke the `start()` method on the thread.

If we need to add any feature to the `Thread` class implementation then only use approach #1.

For regular thread creation scenarios, always use `#2`.

Using `#1` we create a thread directly.

But using `#2` we create a **Task** which implements the `Runnable` interface.

So for `#2` once we create a task and override the `run()` method, we need to create a `Thread` class object and submit this task to run inside that thread.

And then submit the thread for execution by doing `thread.start()`

> `thread.start()` does not necessarily start the thread execution immediately.
> It just submits the thread for execution and whenever the thread gets the CPU cycle, it starts getting executed.


### Runnable or Thread?

Simply put, it is encouraged to use `Runnable` instead of `Thread` class. Reasons:

- When extending the `Thread` class, we're not overriding any of its methods. Instead, we override the method of `Runnable` (which `Thread` happens to implement).
  This is a clear violation of `is-a Thread` principle.

- Creating an implementation of `Runnable` and passing it to the `Thread` class utilizes **composition** and not **inheritance** which is more flexible.

- After extending the `Thread` class, we can't extend any other class.

- From Java 8 onwards, `Runnable`s can be represented as lambda expressions.