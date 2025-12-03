package ISO2.Exe3;

import ISO2.Exe3.Domain.ActivityRecommender;
import service.InputService;
import parser.IntegerParser;
import parser.DoubleParser;
import parser.BooleanParser;
import exception.InputException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        InputService input = new InputService();
        ActivityRecommender recommender = new ActivityRecommender();
        
        System.out.println("Welcome to Adventure Recommender System");

        boolean running = true;
        while (running) {
            try {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Get Recommendation");
                System.out.println("2. Exit");
                
                // Reusing the IntegerParser from your existing infrastructure
                int choice = input.readWithParser("Select an option: ", new IntegerParser(), 3);

                switch (choice) {
                    case 1:
                        runRecommendation(input, recommender);
                        break;
                    case 2:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
        input.close();
    }

    private static void runRecommendation(InputService input, ActivityRecommender recommender) throws InputException {
        System.out.println("\n--- Please answer the following conditions ---");
        
        // 1. Health Status
        // Uses the new BooleanParser to handle "y/n", "true/false", etc.
        boolean isHealthy = input.readWithParser("Is the client in full physical health? (y/n): ", new BooleanParser(), 3);
        boolean hasSymptoms = input.readWithParser("Has the client had infectious symptoms in last 2 weeks? (y/n): ", new BooleanParser(), 3);
        
        // 2. Weather Conditions
        double temp = input.readWithParser("Enter temperature (C): ", new DoubleParser(), 3);
        int humidity = input.readWithParser("Enter humidity (%): ", new IntegerParser(), 3);
        boolean isPrecipitating = input.readWithParser("Is it raining/snowing? (y/n): ", new BooleanParser(), 3);
        boolean isCloudy = input.readWithParser("Is it cloudy? (y/n): ", new BooleanParser(), 3);
        
        // 3. Venue Characteristics
        boolean isCapacityFull = input.readWithParser("Are the local venue capacities full? (y/n): ", new BooleanParser(), 3);

        // 4. Get Logic Result
        List<String> results = recommender.getRecommendation(
            isHealthy, hasSymptoms, temp, humidity, isPrecipitating, isCloudy, isCapacityFull
        );

        // 5. Display Output
        System.out.println("\n--- Recommendations ---");
        if (results.isEmpty()) {
            System.out.println("No specific recommendations for these conditions.");
        } else {
            for (String rec : results) {
                System.out.println("- " + rec);
            }
        }
    }
}