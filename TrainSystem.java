import java.util.ArrayList;
import java.util.Scanner;

public class TrainSystem {
  
  private String name, src, dest;
  private int seats;
  private ArrayList<String> p;

  public TrainSystem(String n, String s, String d, int seats) {
    name = n;
    src = s;
    dest = d;
    this.seats = seats;
    p = new ArrayList<String>();
  }

  public String getName() { return name; }
  public String getSrc() { return src; }
  public String getDest() { return dest; }
  public int getSeats() { return seats; }

  public boolean book(int np) {
    Scanner input = new Scanner(System.in);
    if (np > seats) {
      System.out.println("Sorry, there are not enough seats available on this train.");
      return false;
    } else {
      for (int i = 1; i <= np; i++) {
        System.out.println("Enter passenger " + i + " name:");
        String name = input.nextLine();
        p.add(name);
      }
      seats -= np;
      System.out.println("Seats booked successfully for " + np + " passengers.");
      return true;
    }
  }

  public void display() {
    if (p.size() > 0) {
      System.out.println("Passenger list:");
      for (String passenger : p) {
        System.out.println(passenger);
      }
    } else {
      System.out.println("No passengers have been added yet.");
    }
  }

  public void cancel() {
    Scanner input = new Scanner(System.in);
    if (p.size() == 0) {
      System.out.println("No bookings to cancel.");
    } else {
      System.out.println("Enter passenger name to cancel booking:");
      String name = input.nextLine();
      if (p.contains(name)) {
        p.remove(name);
        seats++;
        System.out.println("Booking cancelled successfully for passenger " + name + ".");
      } else {
        System.out.println("Booking not found for passenger " + name + ".");
      }
    }
  }

  public static void main(String[] args) {
    TrainSystem t = new TrainSystem("Express", "Delhi", "Mumbai", 50);
    Scanner input = new Scanner(System.in);
    boolean flag = true;
    while (flag) {
      System.out.println("Enter 1 to book seats, 2 to display passenger list, 3 to cancel booking, or 4 to exit:");
      int choice = input.nextInt();
      switch (choice) {
        case 1:
          System.out.println("Enter number of passengers:");
          int np = input.nextInt();
          t.book(np);
          break;
        case 2:
          t.display();
          break;
        case 3:
          t.cancel();
          break;
        case 4:
          flag = false;
          System.out.println("Thank you for using our reservation system.");
          break;
        default:
          System.out.println("Invalid choice. Please enter a valid option.");
          break;
      }
    }
    input.close();
  }
}
