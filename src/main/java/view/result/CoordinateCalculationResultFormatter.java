package view.result;

import model.CoordinateCalculationResult;
import model.CoordinateCalculationResult.ResultType;

import java.util.Arrays;
import java.util.function.Function;

public enum CoordinateCalculationResultFormatter {

    DISTANCE(ResultType.DISTANCE, (CoordinateCalculationResult result) -> "두 점 사이 거리는 %.6f".formatted(result.getValue())),
    TRIANGLE_AREA(ResultType.TRIANGLE_AREA, (CoordinateCalculationResult result) -> "삼각형 넓이는 %.1f".formatted(result.getValue())),
    QUADRANGLE_AREA(ResultType.QUADRANGLE_AREA, (CoordinateCalculationResult result) -> "사각형 넓이는 %d".formatted((int) result.getValue())); // todo 반올림 적용

    private final ResultType type;
    private final Function<CoordinateCalculationResult, String> formattedResultLiteralGenerator;

    CoordinateCalculationResultFormatter(
            final ResultType type,
            final Function<CoordinateCalculationResult, String> formattedResultLiteralGenerator
    ) {
        this.type = type;
        this.formattedResultLiteralGenerator = formattedResultLiteralGenerator;
    }

    public static String format(final CoordinateCalculationResult result) {
        return getTypeBy(result).formattedResultLiteralGenerator.apply(result);
    }

    private static CoordinateCalculationResultFormatter getTypeBy(final CoordinateCalculationResult result) {
        return Arrays.stream(CoordinateCalculationResultFormatter.values())
                .filter(formatter -> formatter.matchesType(result.getType()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "type %s와 일치하는 Formatter가 존재하지 않습니다.".formatted(result.getType()))
                );
    }

    private boolean matchesType(final ResultType type) {
        return this.type == type;
    }

}
