## ExecutorService - since 1.5

```java
interface  java.util.concurrent.ExecutorService  extends  Executor
```

If we look at `BasicMultiThreading.java`, and assume if we need to perform 100 copy tasks then do we need to create 100 threads ?

Short and simple answer is NO !

> Creating threads is a costly operation and creation of new threads must be done carefully and only when required.
>
>  "It is like purchasing 100 vehicles for doing 100 deliveries."

So what we can do is create a pool of threads and assign 100 tasks to the threads of that pool.

We can create a thread pool by using `ExecutorService (java.util.concurrent)`


> One Java thread = One OS thread

So creating new threads is itself an expensive operation.

This is why we don't want to create so many threads.

We can create a pool of threads instead.


### Different ways of creating Executor Services:

Creates an Executor that uses a single worker thread operating off an unbounded queue:

	ExecutorService executor = Executors.newSingleThreadExecutor();

Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue:

	ExecutorService executor = Executors.newFixedThreadPool(5);

Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically:

	ExecutorService executor = Executors.newScheduledThreadPool(10);



Submitting a Runnable task -

We can submit a task for execution using the execute method.

```java
    executor.execute( runnableTaskInstance );
```

e.g.

```java
    executor.execute(new CopyTask(sourceFile1, destFile1));
```

If a thread is available in the pool then it assigns this task to the thread otherwise the task is added to the blocking queue
and is kept till a thread is available.


#### How to check whether an `ExecutorService` task executed successfully ?

- We can use a `Future` to check the return value:

```java
	Future future = executorService.submit(new Runnable() {
		public void run() {
			System.out.println("hello");
		}
	});

	future.get(); // returns null if task has finished correctly.
```

#### But how to get the return value from the task ?

- By using `Callable` interface.

```java
	Future future = executorService.submit(new Callable() {
		public void call() throws Exception {
			Return "RESULT";
		}
	});

	System.out.println("value from the async task : " + future.get());
```