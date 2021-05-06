package lesson1.hw;

public interface Passable extends Runable, Jumppable{

    default boolean pass(Obstacle obstacle){
        switch (obstacle.getType()) {
            case THREADMILL: {
                return run((Threadmill)obstacle);
            }
            default: {
                throw new IllegalArgumentException("Unknown obstacle");
            }
        }





    }

}
