package Lesson1.Obstacles;

public class Main {
    public static void main(String[] args) {
        int trackLength = 50;
        int wallHeight = 2;
        int difficult = 2;

        MoveAble[] creatures = {
                new Human("Human", 100, 2),
                new Cat("Cat", 50, 4),
                new Robot("Robot", 1000, 5)
        };

        ManageAble[] obstacles = {
                new Wall(wallHeight),
                new Track(trackLength),
                new Wall(wallHeight * difficult),
                new Track(trackLength * difficult)
        };

        for (int i = 0; i < creatures.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                boolean result = obstacles[j].manageWithObstacle(creatures[i]);
                if (!result) {
                    break;
                }
            }
        }

    }
}




