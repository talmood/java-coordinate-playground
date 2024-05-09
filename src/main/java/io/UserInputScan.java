package io;

import common.constant.Placeholder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInputScan {

    private final static String RETRY_FLAG = "yes";
    private String points;
    private Scanner sc;
    private List<String> preprocessedPoints;

    public UserInputScan() {
        this.sc = new Scanner(System.in);
    }

    public void scan() {
        System.out.println(Placeholder.INPUT_POINT);
        if (sc.hasNextLine()) {
            this.points = sc.nextLine();
            this.preprocessedPoints = preprocessPoints(this.points);
        }
    }

    public boolean retryScan() {
        System.out.println(Placeholder.RETRY);
        if (sc.hasNextLine()) {
            return RETRY_FLAG.equals(sc.nextLine());
        }
        return false;
    }

    public List<String> getPreprocessedPoints() {
        return preprocessedPoints;
    }

    private List<String> preprocessPoints(final String inputValue){
        int numberOfDash = countOccurrences(inputValue, '-');
        final String[] seperatedPoints = inputValue.split("-");
        if(numberOfDash+1 != seperatedPoints.length){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
        return Arrays.stream(seperatedPoints)
                .map(seperatedPoint -> seperatedPoint
                        .replace("(", "")
                        .replace(")", "")
                ).toList();
    }

    private static int countOccurrences(String str, char targetChar) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == targetChar) {
                count++;
            }
        }
        return count;
    }
}
