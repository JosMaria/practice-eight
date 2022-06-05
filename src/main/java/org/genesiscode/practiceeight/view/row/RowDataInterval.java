package org.genesiscode.practiceeight.view.row;

public class RowDataInterval {

    private double probability;
    private double accumulated;
    private String range;
    private int demand;
    private double startRange;
    private double endRange;

    public RowDataInterval(double probability, double accumulated, String range, int demand) {
        this.probability = probability;
        this.accumulated = accumulated;
        this.range = range;
        this.demand = demand;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getAccumulated() {
        return accumulated;
    }

    public void setAccumulated(double accumulated) {
        this.accumulated = accumulated;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public double getStartRange() {
        return startRange;
    }

    public void setStartRange(double startRange) {
        this.startRange = startRange;
    }

    public double getEndRange() {
        return endRange;
    }

    public void setEndRange(double endRange) {
        this.endRange = endRange;
    }
}
