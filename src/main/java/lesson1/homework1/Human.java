package lesson1.homework1;

import java.util.Random;

public class Human implements Competible {

    String name;
    private int maxHeight; // м
    private int maxLength; // м

    public Human() {
        name = "Human";
        maxHeight = new Random().nextInt(3) + 2;
        maxLength = new Random().nextInt(250) + 50;
    }

    public Human(String name, int maxHeight, int maxLength) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    @Override
    public boolean jump(Obstacle o) {
        return maxHeight >= ((Wall) o).getHeight();
    }

    @Override
    public boolean run(Obstacle o) {
        return maxLength >= ((Racetrack) o).getLength();
    }

    @Override
    public String toString() {
        if (name.equals("Human"))
            return "Human";
        return "human " + name;
    }
}
