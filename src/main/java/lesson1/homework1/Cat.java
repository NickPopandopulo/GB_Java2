package lesson1.homework1;

import java.util.Random;

public class Cat implements Competible {

    private String name;
    private int maxHeight; // м
    private int maxLength; // м

    public Cat() {
        name = "Cat";
        maxHeight = new Random().nextInt(2) + 1;
        maxLength = new Random().nextInt(150) + 50;
    }

    public Cat(String name, int maxHeight, int maxLength) {
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
        if (name.equals("Cat"))
            return "Cat";
        return "cat " + name;
    }

}
