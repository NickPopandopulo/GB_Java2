package lesson1.hw;

public class Human implements Passable{

    private static final int DEFAULR_RUN_LIMIT = 42195;

    private final String name;
    private final int runLimit;

    public Human(String name, int runLimit) {
        this.name = name;
        this.runLimit = runLimit;
    }

    public Human(String name) {
        this(name, DEFAULR_RUN_LIMIT);
    }

    @Override
    public boolean jump(Wall wall) {
        return false;
    }

    @Override
    public boolean run(Threadmill threadmill) {
        return false;
    }
}
