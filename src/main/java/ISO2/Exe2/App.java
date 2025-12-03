package ISO2.Exe2;

import service.InputService;
import exception.InputException;
import parser.IntegerParser;
import parser.DoubleParser;
import parser.BooleanParser;

public class App {
    public static void main(String[] args) {
        try {
            java.util.Map<String,String> values = readInteractive();
            ISO2.Exe2.model.Customer.Builder b = new ISO2.Exe2.model.Customer.Builder();
            b.age(Integer.parseInt(values.get("age")));
            b.flightsPerYear(Integer.parseInt(values.get("flightsPerYear")));
            b.isStudent(Boolean.parseBoolean(values.get("isStudent")));
            b.livesWithParents(Boolean.parseBoolean(values.get("livesWithParents")));
            b.income(Double.parseDouble(values.get("income")));
            b.preferredClass(ISO2.Exe2.model.CabinClass.valueOf(values.get("preferredClass")));
            b.preferredRegion(ISO2.Exe2.model.DestinationRegion.valueOf(values.get("preferredRegion")));
            b.travelsWithChildren(Boolean.parseBoolean(values.get("travelsWithChildren")));

            ISO2.Exe2.model.Customer customer = b.build();
            ISO2.Exe2.service.FareService svc = new ISO2.Exe2.service.FareService();
            java.util.Optional<ISO2.Exe2.model.FareOffer> offer = svc.findOffer(customer);
            if (offer.isPresent()) {
                System.out.println("Offer: " + offer.get().getName() + " (" + offer.get().getDiscountPercentage() + "% discount)");
            } else {
                System.out.println("No special offer for this customer.");
            }
        } catch (Exception e) {
            System.err.println("Error reading input or computing offer: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static java.util.Map<String,String> readInteractive() throws InputException {
        java.util.Map<String,String> map = new java.util.HashMap<>();
        InputService input = new InputService();
        boolean tryAgain = false;
        try {
            while (tryAgain) {
                System.out.println("--- Airline Fare Calculator ---");
                System.out.println("Please enter the following details:");

                int age = input.readWithParser("Age: ", new IntegerParser());
                map.put("age", String.valueOf(age));

                int flightsPerYear = input.readWithParser("Flights per year: ", new IntegerParser());
                map.put("flightsPerYear", String.valueOf(flightsPerYear));

                boolean isStudent = input.readWithParser("Is student? (true/false): ", new BooleanParser());
                map.put("isStudent", String.valueOf(isStudent));

                boolean livesWithParents = input.readWithParser("Lives with parents? (true/false): ", new BooleanParser());
                map.put("livesWithParents", String.valueOf(livesWithParents));

                double income = input.readWithParser("Income: ", new DoubleParser());
                map.put("income", String.valueOf(income));

                String preferredClass = input.readString("Preferred Class (ECONOMY/BUSINESS): ");
                map.put("preferredClass", preferredClass);

                String preferredRegion = input.readString("Preferred Region (EUROPE/ASIA/AMERICA/OTHER): ");
                map.put("preferredRegion", preferredRegion);

                boolean travelsWithChildren = input.readWithParser("Travels with children? (true/false): ", new BooleanParser());
                map.put("travelsWithChildren", String.valueOf(travelsWithChildren));

                tryAgain = false;
            }
        } catch (Exception e) {
            tryAgain = true;
            System.out.println("Error in input data " + e);
        }
        return map;
    }
}
