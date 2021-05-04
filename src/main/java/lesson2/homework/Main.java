package lesson2.homework;

/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого
 * размера необходимо бросить исключение MyArraySizeException.
 * <p>
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то
 * элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть
 * брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
 * <p>
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
 * MyArrayDataException, и вывести результат расчета.
 */

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        int requiredSize = 4;

        try {
            System.out.println("Сумма элементов массива: " + sumOfElements(array, requiredSize));
        } catch (MyArraySizeException | MyArrayDataException myException) {
            myException.printStackTrace();
        }
    }

    public static int sumOfElements(String[][] array, int requiredSize) throws MyArraySizeException, MyArrayDataException {
        if (array.length != requiredSize) {
            throw new MyArraySizeException("Неверное количество строк массива", array.length, requiredSize);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != requiredSize) {
                throw new MyArraySizeException("Неверный размер строки в массиве", i, array[i].length, requiredSize);
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException nfe) {
                    throw new MyArrayDataException("Не удалось преобразовать в int значение в ячейке", i, j);
                }
            }
        }

        return sum;
    }
}
