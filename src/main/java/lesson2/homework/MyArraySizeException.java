package lesson2.homework;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {

    MyArraySizeException(String msg, int size, int requiredSize) {
        super(msg + ": количество " + size + " вместо " + requiredSize);
    }

    MyArraySizeException(String msg, int lineNumber, int size, int requiredSize) {
        super(msg + ": строка " + lineNumber + ", размер " + size  + " вместо " + requiredSize);
    }

}
