package vintage;

import java.time.LocalDate;

public class datemanager {
    // Private static instance of the datemanager class
    private static datemanager instance;

    // Private field to hold the current date
    private LocalDate currentDate;

    // Private constructor to prevent instantiation from outside the class
    private datemanager() {
        // Initialize the current date to the current system date
        currentDate = LocalDate.now();
    }

    // Public static method to get the singleton instance of datemanager
    public static datemanager getInstance() {
        if (instance == null) {
            instance = new datemanager();
        }
        return instance;
    }

    // Public method to advance the current date by a specified number of days
    public void advanceDays(int days) {
        currentDate = currentDate.plusDays(days);
    }

    // Public method to get the current date
    public LocalDate getCurrentDate() {
        return currentDate;
    }
}

/* 
Using datamanager in other classes

 * public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of DateManager
        DateManager dateManager = DateManager.getInstance();

        // Get the current date
        LocalDate currentDate = dateManager.getCurrentDate();
        System.out.println("Current date: " + currentDate);

        // Advance the current date by 7 days
        dateManager.advanceDays(7);

        // Get the updated current date
        LocalDate updatedDate = dateManager.getCurrentDate();
        System.out.println("Updated date: " + updatedDate);
    }
}
 */