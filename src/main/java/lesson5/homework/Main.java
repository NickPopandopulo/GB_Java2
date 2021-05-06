package lesson5.homework;

import java.util.Arrays;

public class Main {

    private static final int size = 10000000;
    private static final int halfSize = size / 2;

    public static void main(String[] args) throws InterruptedException {
        System.out.printf("Время выполнения в обычном методе: %d, мс\n", timeOfSimpleFilling());
        System.out.printf("Время выполнения в методе c потоками: %d, мс\n", timeOfFillingWithThreads());
    }

    /**
     * Получение времени заполнения массива обычным способом
     *
     * @return время вычисления формулы для каждого элемента массива
     */
    public static long timeOfSimpleFilling() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        // --- Старт отсчета ---
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        // --- Конец отсчета ---
        long elapsedTime = System.currentTimeMillis() - startTime;

        return elapsedTime;
    }

    /**
     * Получение времени заполнения массива с использованием двух потоков
     *
     * @return время разбивки массив на 2, вычисления формулы и склейки
     */
    public static long timeOfFillingWithThreads() throws InterruptedException {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        float[] arr1 = new float[halfSize];
        float[] arr2 = new float[halfSize];

        // --- Старт отсчета ---
        long startTime = System.currentTimeMillis();

        // Разбивка массива на 2
        System.arraycopy(arr, 0, arr1, 0, halfSize);
        System.arraycopy(arr, halfSize, arr2, 0, halfSize);

        // Вычисление в 2-х потоках
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < halfSize; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < halfSize; i++) {
                int j = i + halfSize;
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
        });
        thread2.start();

        // Склейка массивов
        thread1.join();
        System.arraycopy(arr1, 0, arr, 0, halfSize);
        thread2.join();
        System.arraycopy(arr2, 0, arr, halfSize, halfSize);

        // --- Конец отсчета ---
        long elapsedTime = System.currentTimeMillis() - startTime;

        return elapsedTime;
    }

}

/**
 * 1. Необходимо написать два метода, которые делают следующее:
 * 1) Создают одномерный длинный массив, например:
 * <p>
 * static final int size = 10000000;
 * static final int h = size / 2;
 * float[] arr = new float[size];
 * <p>
 * 2) Заполняют этот массив единицами;
 * 3) Засекают время выполнения: long a = System.currentTimeMillis();
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * 5) Проверяется время окончания метода System.currentTimeMillis();
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 * <p>
 * Отличие первого метода от второго:
 * Первый просто бежит по массиву и вычисляет значения.
 * Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти
 * массивы обратно в один.
 * <p>
 * Пример деления одного массива на два:
 * <p>
 * System.arraycopy(arr, 0, a1, 0, h);
 * System.arraycopy(arr, h, a2, 0, h);
 * <p>
 * Пример обратной склейки:
 * <p>
 * System.arraycopy(a1, 0, arr, 0, h);
 * System.arraycopy(a2, 0, arr, h, h);
 * <p>
 * Примечание:
 * System.arraycopy() – копирует данные из одного массива в другой:
 * System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение,
 * откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
 * По замерам времени:
 * Для первого метода надо считать время только на цикл расчета:
 * <p>
 * for (int i = 0; i < size; i++) {
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * }
 * <p>
 * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */
