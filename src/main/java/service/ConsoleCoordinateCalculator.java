package service;

import domain.Polygon;
import domain.PolygonCalculator;
import domain.PolygonCalculatorCreator;
import domain.PolygonCreator;
import input.CoordinateInputPrompt;
import input.dto.CoordinateInput;
import output.ConsoleOutputPrompt;
import output.dto.CalculateOutput;

public class ConsoleCoordinateCalculator implements CoordinateCalculator {

    @Override
    public void calculate() {
        CoordinateInputPrompt inputPrompt = new CoordinateInputPrompt();
        CoordinateInput coordinateInput = inputPrompt.prompt();

        Polygon polygon = PolygonCreator.create(coordinateInput.toDomainCoordinates());
        PolygonCalculator polygonCalculator = PolygonCalculatorCreator.create(polygon);
        CalculateOutput output = polygonCalculator.calculate(polygon);

        ConsoleOutputPrompt consoleOutputPrompt = new ConsoleOutputPrompt();
        consoleOutputPrompt.prompt(output);
    }
}
