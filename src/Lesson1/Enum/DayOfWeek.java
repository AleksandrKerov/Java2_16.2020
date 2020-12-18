package Lesson1.Enum;

public enum DayOfWeek {
    Monday (40), Tuesday (40), Wednesday(40),
    Thursday(40), Friday(30), Saturday(0), Sunday(0);

    private int workingHours;

    DayOfWeek(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
        return workingHours;
    }
}
