package lesson2.online.exceptions;

public class ExceptionApp {

    public static void main(String[] args) {
        int c = div(10, 0);
        System.out.println(c);
        String num = "100a";
        try {
           int i =  Integer.parseInt(num);
        } catch (NumberFormatException nfe) {
            System.out.println("Тут вовсе не число");
        }

    }


    static int div(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException | IllegalArgumentException ex) {
            //handle
            System.out.println("Handle " + ex.getMessage());
            ex.printStackTrace(System.out);
            return 0;
        } catch (RuntimeException rte) {

        } catch (Exception ex) {

        } catch (Throwable tw) {

        }
        return 0;
    }

    static void exc(int a, int b) throws MyUncheckedException {
        throw new MyUncheckedException("Unimplemented");
    }

    public static void readFile() {
        try {

        } catch (Exception ex) {

        } finally {

        }
    }
}
