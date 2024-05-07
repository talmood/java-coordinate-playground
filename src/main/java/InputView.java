import java.util.Scanner;

public class InputView {

    static final String START_MESSAGE = "> 계산을 시작합니다.\n";
    static final String GUIDE_INPUT_MESSAGE = "> 좌표를 입력하세요";

    Scanner scanner = new Scanner(System.in);

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printGuideInputMessage() {
        System.out.println(GUIDE_INPUT_MESSAGE);
    }

    public String acceptInput() {
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }

}
