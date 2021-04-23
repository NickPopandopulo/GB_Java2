package lesson1.homework1;

import java.util.Random;

public class Wall implements Obstacble {

    private int height; // м

    public Wall() {
        height = new Random().nextInt(3) + 2;
    }

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean isRunnable(int maxParticipantLength) {
        return false;
    }

    @Override
    public boolean isJumpble(int maxParticipantHeight) {
        return maxParticipantHeight >= height;
    }

    @Override
    public String toString() {
        return "Wall, height " + height + " m";
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
