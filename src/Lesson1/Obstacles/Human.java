package Lesson1.Obstacles;

public class Human implements MoveAble {
    private String name;
    private int runMaxDistance;
    private int jumpMaxHeight;

    public Human(String name, int runMaxDistance, int jumpMaxHeight) {
        this.name = name;
        this.runMaxDistance = runMaxDistance;
        this.jumpMaxHeight = jumpMaxHeight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRunMaxDistance() {
        return runMaxDistance;
    }

    @Override
    public int getJumpMaxHeight() {
        return jumpMaxHeight;
    }
}
