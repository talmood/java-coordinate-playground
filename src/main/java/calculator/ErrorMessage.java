package calculator;

public class ErrorMessage {
    public static final String INVALID_INPUT = "[ERROR] 잘못된 입력입니다.";

    // 좌표 관련 에러 메시지
    public static final String COORDINATE_RANGE = INVALID_INPUT + " X, Y 좌표의 범위는 최소 0, 최대 24입니다.";
    public static final String COORDINATE_COUNT = INVALID_INPUT + " 좌표는 최소 2개 이상, 4개 이하까지 입력가능합니다.";
    public static final String DUPLICATE_COORDINATES = INVALID_INPUT + " 겹치는 좌표가 존재합니다.";
    public static final String NULL_COORDINATES = INVALID_INPUT + " 좌표 값이 존재하지 않습니다.";

    // 도형 관련 에러 메시지
    public static final String INVALID_SHAPE = INVALID_INPUT + " 지원하지 않는 도형입니다.";
}