package view;

public class ConsoleWriter {

    private static final ConsoleWriter INSTANCE = new ConsoleWriter();

    private ConsoleWriter() {
    }

    public static ConsoleWriter getInstance() {
        return INSTANCE;
    }

    public void writeLine(String message) {
        System.out.println(message);
    }

    public void writeLineWithPromptPrefix(String message) {
        System.out.println("> " + message);
        System.out.println();
    }

}
