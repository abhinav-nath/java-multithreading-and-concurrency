package com.codecafe.concurrency._synchronized;

import java.util.HashMap;
import java.util.Map;

// class responsible for reserving/booking tickets
class TicketReservationSystem {

  Map<String, Integer> reservationInfo = new HashMap<>();

  public TicketReservationSystem() {
    init();
  }

  private void init() {
    reservationInfo.put("train1", 100);
    reservationInfo.put("train2", 100);
  }

  // reserves the tickets for the given train
  // if there are sufficient tickets available
  public synchronized void reserveTickets(String trainName, int ticketCount) {
    Integer available = reservationInfo.get(trainName);

    if (available == null) {
      System.out.println("Invalid train name - " + trainName);
      return;
    }

    if (available < ticketCount) {
      System.out.println("Could not reserve, requested number of seats are not available");
      return;
    }

    // For demo purpose.
    // Intentionally passed on control to other thread before updating available tickets.
    // This is to demonstrate that what if control is switched here..
    Thread.yield();

    // Reduce the available ticket count
    available -= ticketCount;

    // Update the Map
    reservationInfo.put(trainName, available);
  }

  public Integer getAvailableTickets(String trainName) {
    return reservationInfo.get(trainName);
  }

}

// A Runnable task that enables parallel ticket booking
class TicketBookingTask implements Runnable {

  private final TicketReservationSystem reservationSystem;
  private final String trainName;
  private final int ticketCount;

  public TicketBookingTask(TicketReservationSystem reservationSystem, String trainName, int ticketCount) {
    this.reservationSystem = reservationSystem;
    this.trainName = trainName;
    this.ticketCount = ticketCount;
  }

  @Override
  public void run() {
    reservationSystem.reserveTickets(trainName, ticketCount);
  }

}

public class TicketBookingExample {

  public static void main(String[] args) {
    TicketReservationSystem reservationSystem = new TicketReservationSystem();

    String trainName = "train1";
    int ticketCount = 50;

    // These two threads are trying to book 50 tickets for train1
    // After the operation, expected available tickets should be 0
    Thread t1 = new Thread(new TicketBookingTask(reservationSystem, trainName, ticketCount));

    Thread t2 = new Thread(new TicketBookingTask(reservationSystem, trainName, ticketCount));

    t1.start();
    t2.start();

    // Wait for both threads to finish
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Expected result is 0, without synchronized the result could be 50 which is wrong
    System.out.println("Available tickets for train <" + trainName + "> are <" + reservationSystem.getAvailableTickets(trainName) + ">");
  }

}