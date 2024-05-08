package view.input;

import model.DistinguishedCoordinates;
import view.UserIntentionToContinueCalculation;

public interface InputView {

    DistinguishedCoordinates inputCoordinates();

    UserIntentionToContinueCalculation inputUserIntentionToContinueCalculation();

    void welcome();

}
