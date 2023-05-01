package vintage;

import java.time.LocalDate;

public class datemanager {
    private static datemanager instance;

    private LocalDate currentDate;

    private datemanager() {
        currentDate = LocalDate.now();
    }

    public static datemanager getInstance() {
        if (instance == null) {
            instance = new datemanager();
        }
        return instance;
    }

    public void advanceDays(int days) {
        currentDate = currentDate.plusDays(days);
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }
}
