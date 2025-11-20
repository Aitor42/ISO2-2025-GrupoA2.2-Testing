package ISO2.Exe1.Presentation;

import ISO2.Exe1.Domain.CustomDate;
import java.util.Scanner;
import java.util.InputMismatchException;

public class IOManager {
    private Scanner scanner;

    public IOManager() {
        this.scanner = new Scanner(System.in);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void print(int number) {
        System.out.println(number);
    }

    public void print(double number) {
        System.out.println(number);
    }

    public int readInt(String message) throws Exception {
        print(message);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next(); // clear buffer
            throw new Exception("Invalid input: expected an integer, but got letters or symbols.");
        }
    }

    public double readDouble(String message) throws Exception {
        print(message);
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            scanner.next(); // clear buffer
            throw new Exception("Invalid input: expected a double, but got letters or symbols.");
        }
    }

    public String readString(String message) {
        print(message);
        return scanner.next();
    }

    public CustomDate readDate() throws Exception {
        print("Reading Date...");
        int day = readInt("Enter day:");
        int month = readInt("Enter month:");
        int year = readInt("Enter year:");
        
        // The constructor of CustomDate will handle negative numbers validation
        return new CustomDate(day, month, year);
    }
}
