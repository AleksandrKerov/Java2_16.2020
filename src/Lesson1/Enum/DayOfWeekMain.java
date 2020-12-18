package Lesson1.Enum;

public class DayOfWeekMain {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.Thursday));
    }

    private static String getWorkingHours(DayOfWeek day) {
        int sum = 0;
        for (DayOfWeek y : DayOfWeek.values()) {
            if (y.ordinal() >= day.ordinal()) {
                sum += y.getWorkingHours();
            }
        }
        if (sum != 0) {
            return "Value of working hours is " + sum;
        } else {
            return "Сегодня выходной";
        }
    }
}
