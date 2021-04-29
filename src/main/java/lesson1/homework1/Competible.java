package lesson1.homework1;

public interface Competible {
    boolean run(Obstacle o);

    boolean jump(Obstacle o);

    default boolean pass(Obstacle o) {
        if (o instanceof Racetrack) {
            return run(o);
        } else if (o instanceof Wall) {
            return jump(o);
        } else {
            System.out.println("Something wrong in goThrough() in Competible");
            return false;
        }
    }
}
