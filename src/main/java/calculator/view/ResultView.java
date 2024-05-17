package calculator.view;

public class ResultView {

        private static final String RESULT_MESSAGE = "실행 결과";
        private static final String LINE_CALCULATE_RESULT_MESSAGE = "두 점 사이 거리는 %f";
        private static final String TRIANGLE_CALCULATE_RESULT_MESSAGE = "삼각형 넓이는 %.1f";
        private static final String RECTANGLE_CALCULATE_RESULT_MESSAGE = "사각형 넓이는 %.0f";

        private ResultView() {
        }

        public static void printLineCalculateResult(final double result) {
                printResultMessage();
                System.out.println(LINE_CALCULATE_RESULT_MESSAGE.formatted(result));
        }

        public static void printTriangleCalculateResult(final double result) {
                printResultMessage();
                System.out.println(TRIANGLE_CALCULATE_RESULT_MESSAGE.formatted(result));
        }

        public static void printRectangleCalculateResult(final double result) {
                printResultMessage();
                System.out.println(RECTANGLE_CALCULATE_RESULT_MESSAGE.formatted(result));
        }

        private static void printResultMessage() {
                System.out.println(RESULT_MESSAGE);
        }
}
