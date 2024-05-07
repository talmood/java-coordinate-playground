package model.coordinatecalculation.polygon;

import model.DistinguishedCoordinates;
import model.Point;

import java.util.Arrays;

import static utils.GeometryUtils.calculateDistance;

public record Rectangle(
        DistinguishedCoordinates coordinates
) {

    public Rectangle {
        validateRectangle(coordinates);
    }

    private static double[] parseAllDistancesOfFourPointsOrderByDistanceAsc(final DistinguishedCoordinates coordinates) {
        final Point first = coordinates.fetchPointByIndex(0);
        final Point second = coordinates.fetchPointByIndex(1);
        final Point third = coordinates.fetchPointByIndex(2);
        final Point fourth = coordinates.fetchPointByIndex(3);

        final double[] distances = new double[6];
        distances[0] = calculateDistance(first, second);
        distances[1] = calculateDistance(first, third);
        distances[2] = calculateDistance(first, fourth);
        distances[3] = calculateDistance(second, third);
        distances[4] = calculateDistance(second, fourth);
        distances[5] = calculateDistance(third, fourth);

        Arrays.sort(distances);

        return distances;
    }

    public double calculateArea() {
        return getShortestSideLength() * getLongestSideLength();
    }

    private void validateRectangle(DistinguishedCoordinates coordinates) {
        validateSize(coordinates);
        if (!isRectangle(coordinates)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private double getLongestSideLength() {
        return parseAllDistancesOfFourPointsOrderByDistanceAsc(this.coordinates)[2];
    }

    private double getShortestSideLength() {
        return parseAllDistancesOfFourPointsOrderByDistanceAsc(this.coordinates)[0];
    }

    // todo 벡터 내적을 이용해서 내각이 수직을 이루는지 확인
    private boolean isRectangle(DistinguishedCoordinates coordinates) {
        final double[] distances = parseAllDistancesOfFourPointsOrderByDistanceAsc(coordinates);

        Arrays.sort(distances); // 거리 오름차순 정렬

        return (distances[0] == distances[1]) // 가장 짧은 변 2개의 길이가 같고,
                && (distances[2] == distances[3]) // 나머지 변의 길이가 서로 같고
                && (distances[4] == distances[5]); // 대각선 길이가 서로 같으면 직사각형
    }

    private void validateSize(DistinguishedCoordinates coordinates) {
        if (!coordinates.matchesSize(4)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

}
