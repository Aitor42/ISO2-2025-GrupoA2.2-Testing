package ISO2.Exe2.model;

/**
 * Value object that encapsulates demographic information about a customer.
 * This reduces the number of independent parameters in Customer.
 */
public class Demographics {
    private final int age;
    private final boolean isStudent;
    private final boolean livesWithParents;

    public Demographics(int age, boolean isStudent, boolean livesWithParents) {
        this.age = age;
        this.isStudent = isStudent;
        this.livesWithParents = livesWithParents;
    }

    public int getAge() {
        return age;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public boolean livesWithParents() {
        return livesWithParents;
    }

    public boolean isMinor() {
        return age < 18;
    }

    public boolean isYoungAdult() {
        return age >= 18 && age <= 25;
    }

    public boolean isMatureAdult() {
        return age > 25;
    }
}
