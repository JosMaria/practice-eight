package org.genesiscode.practiceeight.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practiceeight.service.utils.Decimal;
import org.genesiscode.practiceeight.view.row.RowDataInterval;
import org.genesiscode.practiceeight.view.row.RowRandomNumber;

import java.util.List;

public class DulceAda {

    private static DulceAda dulceAda;
    private List<Double> randomNumbers;

    public synchronized static DulceAda getInstance() {
        return dulceAda != null ? dulceAda : new DulceAda();
    }

    public void setRandomNumbers(List<Double> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public ObservableList<RowRandomNumber> getObservableListRandomNumbers() {
        ObservableList<RowRandomNumber> list = FXCollections.observableArrayList();
        int counter = 1;
        for (double randomNumber : randomNumbers) {
            list.add(new RowRandomNumber(counter, randomNumber));
            counter++;
        }
        return list;
    }

    public ObservableList<RowDataInterval> getObservableListInterval() {
        ObservableList<RowDataInterval> list = FXCollections.observableArrayList();
        List<Integer> demandList = List.of(40, 50, 60, 70, 80, 90);
        double probability = 0.1666, accumulated = 0, startRange, endRange;

        for (int demand : demandList) {
            startRange = accumulated;
            accumulated = Decimal.getDecimal(4, accumulated + probability);
            endRange = accumulated;
            String range = String.format("[%s - %s)", startRange, endRange);
            list.add(new RowDataInterval(probability, accumulated, range, demand));
        }
        return list;
    }
}
