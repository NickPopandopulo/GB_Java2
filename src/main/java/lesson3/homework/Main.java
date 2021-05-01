package lesson3.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных
 * слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
 * <p>
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер
 * телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 * Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще
 * дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.). Консоль
 * желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().
 */

public class Main {

    public static void main(String[] args) {
        // --- Exercise 1 ---
        String[] words = {"apple", "house", "wall", "energy", "tree", "elbow", "chair",
                "apple", "chair", "wall", "apple", "sky", "apple", "tree", "teeth", "tree", "house"};

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println("Exercise 1\nUnique words(amount): ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "(" + entry.getValue() + "); ");
        }
        System.out.println("\n");

        // --- Exercise 2 ---
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "356-149");
        phoneBook.add("Petrov", "159-417");
        phoneBook.add("Smith", "364-679");
        phoneBook.add("Petrov", "123-789");
        phoneBook.add("Dixon", "147-369");
        phoneBook.add("Smith", "574-753");

        System.out.println("Exercise 2");
        System.out.println("Ivanov: " + phoneBook.get("Ivanov"));
        System.out.println("Smith: " + phoneBook.get("Smith"));
        System.out.println("Dixon: " + phoneBook.get("Dixon"));
        System.out.println("Petrov: " + phoneBook.get("Petrov"));
        System.out.println("Grimes: " + phoneBook.get("Grimes"));
    }
}
