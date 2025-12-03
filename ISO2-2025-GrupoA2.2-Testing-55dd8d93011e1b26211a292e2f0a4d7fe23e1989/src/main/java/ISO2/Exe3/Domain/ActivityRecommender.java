package ISO2.Exe3.Domain;
import java.util.ArrayList;
import java.util.List;

public class ActivityRecommender {

    // Input attributes can be passed directly to the method to ensure stateless processing, 
    // or stored if the object represents a specific user session. 
    // Here we use a static-like utility method approach for pure logic testing.

    public List<String> getRecommendation(
            boolean isHealthy,
            boolean hasSymptoms,
            double temp,
            int humidity,
            boolean isPrecipitating,
            boolean isCloudy,
            boolean isCapacityFull
    ) {
        List<String> recommendations = new ArrayList<>();

        // 1. Health Status check (Gatekeeper)
        // "If the individual is in full physical health and has not exhibited symptoms... otherwise not permitted"
        if (!isHealthy || hasSymptoms) {
            recommendations.add("Not permitted to participate due to health status");
            return recommendations; // Immediate return
        }

        // 2. Extreme Cold (Temp < 0, Humidity < 15%)
        if (temp < 0 && humidity < 15) {
            if (isPrecipitating) {
                recommendations.add("Stay at home");
                return recommendations; // "Best to stay at home" implies exclusive advice
            } else {
                // Skiing allowed if capacity not exceeded
                if (!isCapacityFull) {
                    recommendations.add("Skiing");
                }
            }
        }

        // 3. Hiking/Climbing (0 <= Temp <= 15, No Rain)
        // Note: Logic assumes "between 0 and 15" is inclusive based on standard requirements interpretation
        if (temp >= 0 && temp <= 15 && !isPrecipitating) {
            if (!isCapacityFull) {
                recommendations.add("Hiking or Climbing");
            }
        }

        // 4. Spring/Summer Catalog (15 < Temp < 25, Clear weather)
        if (temp > 15 && temp < 25 && !isPrecipitating && !isCloudy && humidity <= 60) {
            if (!isCapacityFull) {
                recommendations.add("Spring/Summer/Autumn Catalog Activity");
            }
        }

        // 5. Cultural/Gastronomic (25 <= Temp <= 35, No Rain)
        if (temp >= 25 && temp <= 35 && !isPrecipitating) {
            if (!isCapacityFull) { // "respecting venue capacities"
                recommendations.add("Cultural or Gastronomic Activities");
            }
        }

        // 6. Beach/Pool (Temp > 30, No Rain)
        if (temp > 30 && !isPrecipitating) {
            recommendations.add("Go to the Beach");
            if (!isCapacityFull) {
                recommendations.add("Go to the Swimming Pool");
            }
        }

        // Do not add a generic recommendation when list is empty; callers/tests expect an empty list
        // when no specific activity matches the given conditions.

        return recommendations;
    }
}