package view;

import java.util.Scanner;

public class ConsoleReader implements InputReader {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String readLine() {
        return SCANNER.nextLine();
    }

}
