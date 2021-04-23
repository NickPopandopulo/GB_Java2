package lesson1.homework1;

import java.util.Random;

public class Cat implements Competible {

    private String name;
    private int maxHeight; // м
    private int maxLength; // м
    private boolean stopRace;

    public Cat() {
        name = "Cat";
        maxHeight = new Random().nextInt(2) + 1;
        maxLength = new Random().nextInt(150) + 50;
        stopRace = false;
    }

    public Cat(String name, int maxHeight, int maxLength) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        stopRace = false;
    }

    @Override
    public void jump() {
        System.out.println(name + " jumps...");
    }

    @Override
    public void run() {
        System.out.println(name + " runs...");
    }

    @Override
    public String toString() {
        if (name.equals("Cat"))
            return "Cat";
        return "cat " + name;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean isStopRace() {
        return stopRace;
    }

    public void setStopRace(boolean stopRace) {
        this.stopRace = stopRace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
