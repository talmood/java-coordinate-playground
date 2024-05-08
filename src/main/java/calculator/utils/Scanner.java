package calculator.utils;

public class Scanner {
    private static java.util.Scanner scanner;

    private Scanner() {
    }

    public static String readLine() {
        return getInstance().nextLine();
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    private static java.util.Scanner getInstance() {
        if (scanner == null) {
            scanner = new java.util.Scanner(System.in);
        }
        return scanner;
    }
}
