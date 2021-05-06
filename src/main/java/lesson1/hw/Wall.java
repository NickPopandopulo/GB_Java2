package lesson1.hw;

public class Wall extends Obstacle{
    @Override
    ObstacleType getType() {
        return ObstacleType.WALL;
    }
}
