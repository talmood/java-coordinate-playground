package view;

import java.util.Objects;

public final class UserIntentionToContinueCalculation {

    private final String userIntention;

    public UserIntentionToContinueCalculation(final String userIntention) {
        if (Objects.isNull(userIntention) || userIntention.isEmpty()) {
            throw new IllegalArgumentException("yes 또는 no 만 입력 가능합니다.");
        }

        if (!(userIntention.equalsIgnoreCase("yes") || userIntention.equalsIgnoreCase("no"))) {
            throw new IllegalArgumentException("yes 또는 no 만 입력 가능합니다.");
        }

        this.userIntention = userIntention;
    }

    public boolean wantToFinish() {
        return this.userIntention.equalsIgnoreCase("no");
    }

}
