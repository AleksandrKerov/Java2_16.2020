package Lesson1.Obstacles;

public class Wall implements ManageAble{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean manageWithObstacle(MoveAble creature) {
        boolean result = creature.jump() >= this.height;
        System.out.println("Is attempt to jump successful? " + result);
        return result;
    }
}
