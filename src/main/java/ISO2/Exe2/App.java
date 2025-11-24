package ISO2.Exe2;

public class App {
    public static void main(String[] args) {
        try {
            java.util.Map<String,String> values = readInteractive();
            ISO2.Exe2.model.Customer.Builder b = new ISO2.Exe2.model.Customer.Builder();
            b.age(Integer.parseInt(values.get("age")));
            b.flightsPerYear(Integer.parseInt(values.get("flightsPerYear")));
            b.studentStudyingInAnotherCity(Boolean.parseBoolean(values.get("studentStudyingInAnotherCity")));
            b.travelsFromFamilyHomeMonthly(Boolean.parseBoolean(values.get("travelsFromFamilyHomeMonthly")));
            b.startedWorking(Boolean.parseBoolean(values.get("startedWorking")));
            b.livesWithParents(Boolean.parseBoolean(values.get("livesWithParents")));
            b.leisureTripsPerYear(Integer.parseInt(values.get("leisureTripsPerYear")));
            b.income(Double.parseDouble(values.get("income")));
            b.preferredClass(ISO2.Exe2.model.CabinClass.valueOf(values.get("preferredClass")));
            b.preferredRegion(ISO2.Exe2.model.DestinationRegion.valueOf(values.get("preferredRegion")));
            b.travelsWithChildrenUnder12(Boolean.parseBoolean(values.get("travelsWithChildrenUnder12")));

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

    private static java.util.Map<String,String> readInteractive() {
        java.util.Map<String,String> map = new java.util.HashMap<>();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.println("--- Airline Fare Calculator ---");
        System.out.println("Please enter the following details:");

        System.out.print("Age: ");
        map.put("age", scanner.nextLine());

        System.out.print("Flights per year: ");
        map.put("flightsPerYear", scanner.nextLine());

        System.out.print("Is student studying in another city? (true/false): ");
        map.put("studentStudyingInAnotherCity", scanner.nextLine());

        System.out.print("Travels from family home monthly? (true/false): ");
        map.put("travelsFromFamilyHomeMonthly", scanner.nextLine());

        System.out.print("Started working? (true/false): ");
        map.put("startedWorking", scanner.nextLine());

        System.out.print("Lives with parents? (true/false): ");
        map.put("livesWithParents", scanner.nextLine());

        System.out.print("Leisure trips per year: ");
        map.put("leisureTripsPerYear", scanner.nextLine());

        System.out.print("Income: ");
        map.put("income", scanner.nextLine());

        System.out.print("Preferred Class (ECONOMY/BUSINESS): ");
        map.put("preferredClass", scanner.nextLine());

        System.out.print("Preferred Region (EUROPE/ASIA/AMERICA/OTHER): ");
        map.put("preferredRegion", scanner.nextLine());

        System.out.print("Travels with children under 12? (true/false): ");
        map.put("travelsWithChildrenUnder12", scanner.nextLine());

        return map;
    }
}
