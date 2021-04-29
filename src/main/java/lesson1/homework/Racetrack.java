package lesson1.homework;

import java.util.Random;

public class Racetrack extends Obstacle {

    private int length; // м

    public Racetrack() {
        length = new Random().nextInt(250) + 50;
    }

    public Racetrack(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Racetrack, length " + length + " m";
    }

    public int getLength() {
        return length;
    }

}
