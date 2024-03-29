## CyclicBarrier - since 1.5

A `CyclicBarrier` is a **synchronizer** that allows a set of threads to wait for each other to reach a common execution point, also called a `barrier`.

> CyclicBarriers are used in programs in which we have a fixed number of threads that must wait for each other to reach a common point before continuing execution.

**Latches** can facilitate starting a group of related activities or waiting for a group of related activities to complete.
**Latches** are single-use objects; once a latch enters the terminal state, it cannot be reset.

Barriers are similar to latches in that they block a group of threads until some event has occurred.

> The key difference is that with a barrier, all the threads must come together at a **barrier point** at the same time in order to proceed.

_Latches are for waiting for events; barriers are for waiting for other threads._

> A barrier implements the protocol some families use to rendezvous during a day at the mall:
 	"Everyone meet at McDonald's at 6:00; once you get there, stay there
	 until everyone shows up, and then we'll figure out what we're doing next.

CyclicBarrier allows a fixed number of parties to rendezvous repeatedly at a barrier point,
and is useful in parallel iterative algorithms that break down a problem into a fixed number of independent sub-problems.

Threads call `await()` when they reach the barrier point,
and `await()` blocks until all the threads have reached the barrier point.

If all threads meet at the barrier point, the barrier has been successfully passed,
in which case all threads are released and the barrier is reset, so it can be used again.

If a call to `await()` times out or a thread blocked in await is interrupted,
then the barrier is considered broken and all outstanding calls to await terminate with `BrokenBarrierException`.