package org.genesiscode.practiceeight.view.row;

public class RowRandomNumber {

    private int rowNumber;
    private double randomNumber;

    public RowRandomNumber(int rowNumber, double randomNumber) {
        this.rowNumber = rowNumber;
        this.randomNumber = randomNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public double getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(double randomNumber) {
        this.randomNumber = randomNumber;
    }
}
