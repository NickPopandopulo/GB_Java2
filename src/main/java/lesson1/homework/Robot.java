package lesson1.homework;

import java.util.Random;

public class Robot implements Competible {

    private String name;
    private int maxHeight; // м
    private int maxLength; // м

    public Robot() {
        name = "Robot";
        maxHeight = new Random().nextInt(1) + 2;
        maxLength = new Random().nextInt(200) + 50;
    }

    public Robot(String name, int maxHeight, int maxLength) {
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
        if (name.equals("Robot"))
            return "Robot";
        return "robot " + name;
    }

}
