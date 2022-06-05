package org.genesiscode.practiceeight.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
}
