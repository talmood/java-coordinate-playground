import java.util.List;
import java.util.Scanner;

public class InputView {

    static final String START_MESSAGE = "> 계산을 시작합니다.\n";
    static final String GUIDE_INPUT_MESSAGE = "> 좌표를 입력하세요";
    static final String ASK_ANOTHER_ROUND_MESSAGE = "> 계산을 계속하시겠습니까?";
    static final String ENDING_MESSAGE = " > 계산을 종료합니다.";


    Scanner scanner = new Scanner(System.in);

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printGuideInputMessage() {
        System.out.println(GUIDE_INPUT_MESSAGE);
    }

    public void askAnotherRoundMessage() {
        System.out.println(ASK_ANOTHER_ROUND_MESSAGE);
    }

    public void printEndingMessage() {
        System.out.println(ENDING_MESSAGE);
    }

    public String acceptInput() {
        return scanner.nextLine();
    }

    public List<Point> validateCoordinates() {
        while (true) {
            try {
                String userInput = acceptInput();
                Coordinate coordinate = new Coordinate(userInput);
                return coordinate.getPoints();
            } catch (Exception e) {
                System.out.println("\n> [ERROR] 잘못된 입력입니다. " + e.getMessage() + "\n");
                printGuideInputMessage();
            }
        }
    }

    public boolean decideRetry() {
        while (true) {
            try {
                askAnotherRoundMessage();
                String acceptInput = acceptInput();
                boolean retry = retry(acceptInput);
                printEndingMessageIfNoRetry(retry);
                return retry;
            } catch (Exception e) {
                System.out.println("[ERROR] 잘못된 입력입니다. " + e.getMessage() + "\n");
            }
        }
    }

    private void printEndingMessageIfNoRetry(boolean retry) {
        if (!retry) {
            printEndingMessage();
        }
    }

    private boolean retry(String acceptInput) {
        if (acceptInput.equals("yes")) {
            return true;
        }
        if (acceptInput.equals("no")) {
            return false;
        }
        throw new IllegalArgumentException("yes 또는 no로 입력하세요");
    }

    public void closeScanner() {
        scanner.close();
    }

}
