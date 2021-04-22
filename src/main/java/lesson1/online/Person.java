package lesson1.online;

public class Person implements Workable, Eatable
{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println("lesson1.online.Person works");
    }

    @Override
    public void eat() {
        System.out.println("lesson1.online.Person eats");
    }

    @Override
    public void rest() {
        System.out.println("lesson1.online.Person rest");
    }
}
