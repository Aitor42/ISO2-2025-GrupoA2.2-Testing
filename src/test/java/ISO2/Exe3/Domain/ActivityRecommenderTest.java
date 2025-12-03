package ISO2.Exe3.Domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ActivityRecommenderTest {

    ActivityRecommender recommender = new ActivityRecommender();

    @Test
    void testHealthRejection() {
        // Healthy=False, Symptoms=False -> Should be rejected
        List<String> result = recommender.getRecommendation(false, false, 20.0, 50, false, false, false);
        assertTrue(result.contains("Not permitted to participate due to health status"));
        assertEquals(1, result.size());
    }

    @Test
    void testSymptomsRejection() {
        // Healthy=True, Symptoms=True -> Should be rejected
        List<String> result = recommender.getRecommendation(true, true, 20.0, 50, false, false, false);
        assertTrue(result.contains("Not permitted to participate due to health status"));
    }

    @Test
    void testStayHomeConditions() {
        // Temp < 0 (-5), Hum < 15 (10), Precip=True
        List<String> result = recommender.getRecommendation(true, false, -5.0, 10, true, false, false);
        assertTrue(result.contains("Stay at home"));
    }

    @Test
    void testSkiingSuccess() {
        // Temp < 0 (-5), Hum < 15 (10), Precip=False, Cap=False
        List<String> result = recommender.getRecommendation(true, false, -5.0, 10, false, false, false);
        assertTrue(result.contains("Skiing"));
    }

    @Test
    void testHikingSuccess() {
        // Temp 0-15 (10), Rain=False, Cap=False
        List<String> result = recommender.getRecommendation(true, false, 10.0, 40, false, false, false);
        assertTrue(result.contains("Hiking or Climbing"));
    }

    @Test
    void testSpringSummerSuccess() {
        // Temp 15-25 (20), Rain=False, Cloudy=False, Hum<=60 (50)
        List<String> result = recommender.getRecommendation(true, false, 20.0, 50, false, false, false);
        assertTrue(result.contains("Spring/Summer/Autumn Catalog Activity"));
    }

    @Test
    void testCulturalSuccess() {
        // Temp 25-35 (28), Rain=False, Cap=False
        List<String> result = recommender.getRecommendation(true, false, 28.0, 50, false, false, false);
        assertTrue(result.contains("Cultural or Gastronomic Activities"));
    }
    
    @Test
    void testBeachAndPool() {
        // Temp > 30 (33), Rain=False, Cap=False
        List<String> result = recommender.getRecommendation(true, false, 33.0, 50, false, false, false);
        // Note: 33C falls into Cultural (25-35) AND Beach (>30)
        assertAll(
            () -> assertTrue(result.contains("Cultural or Gastronomic Activities"), "Should contain Cultural"),
            () -> assertTrue(result.contains("Go to the Beach"), "Should contain Beach"),
            () -> assertTrue(result.contains("Go to the Swimming Pool"), "Should contain Pool")
        );
    }

    // Boundary Value Analysis & MC/DC Checks using Parameterized Tests
    @ParameterizedTest
    @CsvSource({
        // T, H, P, C, Cap, Expected
        "10.0, 50, true, false, false, 0", // Rain stops Hiking
        "20.0, 50, false, true, false, 0", // Cloudy stops Spring Catalog
        "20.0, 80, false, false, false, 0", // High Humidity stops Spring Catalog
        "33.0, 50, false, false, true, 1"   // Cap Full: Cultural blocked, Pool blocked, Beach allowed = 1 result
    })
    void testSpecificConstraints(double temp, int hum, boolean precip, boolean cloud, boolean cap, int expectedCount) {
        // Assuming Healthy=True, Symp=False for these tests
        List<String> result = recommender.getRecommendation(true, false, temp, hum, precip, cloud, cap);
        
        // For the last case (33C, Cap Full):
        // Cultural: Blocked by Cap.
        // Beach: Allowed (No Cap check).
        // Pool: Blocked by Cap.
        // Result should be size 1 ("Go to the Beach").
        
        if (temp == 33.0 && cap) {
             assertTrue(result.contains("Go to the Beach"));
             assertFalse(result.contains("Go to the Swimming Pool"));
             assertFalse(result.contains("Cultural or Gastronomic Activities"));
        } else {
             assertEquals(expectedCount, result.size());
        }
    }
}