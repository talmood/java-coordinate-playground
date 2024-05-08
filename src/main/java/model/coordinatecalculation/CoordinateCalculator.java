package model.coordinatecalculation;

import model.CoordinateCalculationResult;
import model.DistinguishedCoordinates;
import model.coordinatecalculation.strategy.CoordinateCalculationStrategy;
import model.coordinatecalculation.strategy.CoordinateCalculationStrategyFactory;

public class CoordinateCalculator {

    private SwitchStatus switchStatus;

    private CoordinateCalculator(SwitchStatus switchStatus) {
        this.switchStatus = switchStatus;
    }

    public static CoordinateCalculator switchOnOf() {
        return new CoordinateCalculator(SwitchStatus.ON);
    }

    public void switchOff() {
        this.switchStatus = SwitchStatus.OFF;
    }

    public boolean isSwitchOn() {
        return this.switchStatus.isOn();
    }

    public CoordinateCalculationResult calculate(final DistinguishedCoordinates coordinates) {
        final CoordinateCalculationStrategy strategy =
                CoordinateCalculationStrategyFactory.getInstance().create(coordinates);

        return strategy.calculate();
    }

    private enum SwitchStatus {

        ON, OFF;

        public boolean isOn() {
            return this == ON;
        }

    }

}
