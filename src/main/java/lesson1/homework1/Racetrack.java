package lesson1.homework1;

import java.util.Random;

public class Racetrack implements Obstacble {

    private int length; // м

    public Racetrack() {
        length = new Random().nextInt(250) + 50;
    }

    public Racetrack(int length) {
        this.length = length;
    }

    @Override
    public boolean isRunnable(int maxParticipantLength) {
        return maxParticipantLength >= length;
    }

    @Override
    public boolean isJumpble(int maxParticipantHeight) {
        return false;
    }

    @Override
    public String toString() {
        return "Racetrack, length " + length + " m";
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
