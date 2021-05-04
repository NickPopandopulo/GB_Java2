package lesson2.homework;

public class MyArrayDataException extends NumberFormatException {

    MyArrayDataException(String msg, int i, int j) {
        super(msg + " [" + i + "][" + j + "]");
    }

}
