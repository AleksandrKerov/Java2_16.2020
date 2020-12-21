package Lesson1.Obstacles;

public class Track implements ManageAble {
    private int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public boolean manageWithObstacle(MoveAble creature) {
        boolean result = creature.run() >= this.length;
        System.out.println("Is attempt to run successful? " + result);
        return result;
    }
}
