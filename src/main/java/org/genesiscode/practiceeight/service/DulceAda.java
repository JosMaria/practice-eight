package org.genesiscode.practiceeight.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practiceeight.service.utils.Decimal;
import org.genesiscode.practiceeight.view.row.RowDataInterval;
import org.genesiscode.practiceeight.view.row.RowRandomNumber;
import org.genesiscode.practiceeight.view.row.RowResult;

import java.util.Iterator;
import java.util.List;

public class DulceAda {

    private static DulceAda dulceAda;
    private List<Double> randomNumbers;
    private final ObservableList<RowDataInterval> list = FXCollections.observableArrayList();

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

    public void buildObservableListInterval() {
        list.clear();
        List<Integer> demandList = List.of(40, 50, 60, 70, 80, 90);
        double probability = 0.1666, accumulated = 0, startRange, endRange;

        for (int demand : demandList) {
            startRange = accumulated;
            accumulated = Decimal.getDecimal(4, accumulated + probability);
            endRange = demand != 90 ? accumulated : 1;
            String range = String.format("[%s - %s)", startRange, endRange);
            RowDataInterval row = new RowDataInterval(probability, accumulated, range, demand);
            row.setStartRange(startRange);
            row.setEndRange(endRange);
            list.add(row);
        }
    }

    public ObservableList<RowDataInterval> getList() {
        return list;
    }

    public ObservableList<RowResult> getObservableListResult(double salePrice, double cost,
                                                             double priceWithDiscount, double q) {
        buildObservableListInterval();
        ObservableList<RowResult> list = FXCollections.observableArrayList();
        Iterator<Double> iterator = randomNumbers.iterator();

        /*double salePrice = 12, cost = 7.5, priceWithDiscount = 6, q = 60;*/
        int d, replica = 0;
        double gain, randomNumber;
        while (iterator.hasNext()) {
            randomNumber = iterator.next();
            d = getDemand(randomNumber);
            gain = d <= q ?
                    (salePrice * d) - (cost * q) + priceWithDiscount * (q - d) :
                    (salePrice * q) - (cost * q);
            gain = Decimal.getDecimal(3, gain);
            list.add(new RowResult(replica++, randomNumber, d, gain));
        }
        return list;
    }

    private int getDemand(double randomNumber) {
        return list.stream()
                .filter(row -> row.getStartRange() <= randomNumber && randomNumber < row.getEndRange())
                .findFirst()
                .orElse(new RowDataInterval(0, 0, "", 0))
                .getDemand();
    }
}
