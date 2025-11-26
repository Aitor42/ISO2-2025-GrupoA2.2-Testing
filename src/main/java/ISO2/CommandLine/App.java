package ISO2.CommandLine;

import java.time.LocalDate;

import service.*;
import parser.*;
import exception.InputException;

public class App {
  public static void main(String[] args) throws InputException {
    InputService input = new InputService();

    String name = input.readString("Name: ");
    int age = input.readWithParser("Age: ", new IntegerParser());
    double height = input.readWithParser("Height (m): ", new DoubleParser());
    LocalDate birth = input.readWithParser("Birth (dd/MM/yyyy): ", new DateParser("dd/MM/yyyy"));

    System.out.printf("Name: %s, Age: %d, Height: %.2f, Birth: %s\n", name, age, height, birth);
  }
}