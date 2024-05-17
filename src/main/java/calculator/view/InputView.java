package calculator.view;

import calculator.utils.Scanner;
import calculator.request.CoordinateRequest;

public class InputView {

    private static final String CALCULATE_START_MESSAGE = "계산을 시작합니다.";
    private static final String CALCULATE_END_MESSAGE = "계산을 종료합니다.";
    private static final String INPUT_COORDINATE_MESSAGE = "좌표를 입력하세요.";
    private static final String CONTINUE_CALCULATE_MESSAGE = "계산을 계속하시겠습니까? (yes/no)";
    private static final String CONTINUE_CONDITION = "yes";

    private InputView() {
    }

    public static void printCalculateStartMessage() {
        System.out.println(CALCULATE_START_MESSAGE);
    }

    public static CoordinateRequest inputCoordinates() {
        System.out.println(INPUT_COORDINATE_MESSAGE);
        return CoordinateRequest.from(Scanner.readLine());
    }

    public static boolean isContinueCalculation() {
        System.out.println(CONTINUE_CALCULATE_MESSAGE);
        return Scanner.readLine().equalsIgnoreCase(CONTINUE_CONDITION);
    }

    public static void printCalculateEndMessage() {
        System.out.println(CALCULATE_END_MESSAGE);
    }
}