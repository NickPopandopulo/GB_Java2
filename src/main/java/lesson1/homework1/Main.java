package lesson1.homework1;

/**
 * 1.Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и
 * прыгать (методы просто выводят информацию о действии в консоль).
 * 2.Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
 * соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог
 * пробежать и т.д.).
 * 3.Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
 * 4.* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если
 * участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */

public class Main {

    public static void main(String[] args) {
        Competible[] participants = {
                new Human("Jack", 4, 250),
                new Cat("Murka",2,200),
                new Robot("Beep",3,150)
        };

        Obstacle[] obstacles = {
                new Racetrack(),
                new Wall(),
                new Wall(),
                new Racetrack(),
                new Wall()
        };

        for (Competible participant : participants) {
            System.out.println("Participant " + participant + ", let's go!");
            for (Obstacle obstacle : obstacles) {
                System.out.println("Obstacle: " + obstacle);
                if (participant.pass(obstacle)) {
                    System.out.println("Success!");
                } else {
                    System.out.println("Fail!");
                    break;
                }
            }
            System.out.println("Participant " + participant + " has finished race!\n");
        }
    }
}
