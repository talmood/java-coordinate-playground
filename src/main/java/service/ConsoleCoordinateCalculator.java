package service;

import domain.Polygon;
import domain.PolygonCalculator;
import domain.PolygonCalculatorCreator;
import domain.PolygonCreator;
import input.CoordinateInputPrompt;
import input.dto.ConsoleInput;
import output.dto.CalculateOutput;
import output.dto.ConsoleOutputPrompt;

public class ConsoleCoordinateCalculator implements CoordinateCalculator {
    @Override
    public void calculate() {
        CoordinateInputPrompt inputPrompt = new CoordinateInputPrompt();
        ConsoleInput consoleInput = inputPrompt.prompt();

        Polygon polygon = PolygonCreator.create(consoleInput.toDomainCoordinates());
        PolygonCalculator polygonCalculator = PolygonCalculatorCreator.create(polygon);
        CalculateOutput output = polygonCalculator.calculate(polygon);

        ConsoleOutputPrompt consoleOutputPrompt = new ConsoleOutputPrompt();
        consoleOutputPrompt.prompt(output);
    }
}
