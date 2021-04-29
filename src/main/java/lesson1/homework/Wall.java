package lesson1.homework;

import java.util.Random;

public class Wall extends Obstacle {

    private int height; // м

    public Wall() {
        height = new Random().nextInt(3) + 2;
    }

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Wall, height " + height + " m";
    }

    public int getHeight() {
        return height;
    }
}
