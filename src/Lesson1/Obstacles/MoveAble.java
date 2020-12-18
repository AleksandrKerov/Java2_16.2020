package Lesson1.Obstacles;

public interface MoveAble {
    default int run() {
        System.out.print(getName() + " is running. ");
        return getRunMaxDistance();
    }

    default int jump() {
        System.out.print(getName() + " is jumping. ");
        return getJumpMaxHeight();
    }

    String getName();
    int getRunMaxDistance();
    int getJumpMaxHeight();

}
