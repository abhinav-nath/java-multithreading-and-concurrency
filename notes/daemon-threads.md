## Daemon Threads

> **Daemon threads** are low priority threads that run in background to perform housekeeping tasks such as garbage collection.
> They are background threads that do not prevent the application from exiting if the `main` thread terminates.

#### Properties:

- They can not prevent the JVM from exiting when all the user threads finish their execution.

- JVM terminates itself when all user threads finish their execution.

- If JVM finds running daemon thread, it terminates the thread and after that shutdown itself.
  JVM does not care whether Daemon thread is running or not.

- It is an _utmost low priority_ thread.

Methods:

```java
void setDaemon(boolean status):
	used to mark the current thread as daemon thread or user thread
```

```java
boolean isDaemon():
	used to check that if current is daemon or not
```

**Note** - If you call the `setDaemon()` method after starting the thread, it would throw `IllegalThreadStateException`.