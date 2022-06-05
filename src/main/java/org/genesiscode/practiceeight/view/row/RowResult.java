package org.genesiscode.practiceeight.view.row;

public class RowResult {

    private int replica;
    private double randomNumber;
    private int demand;
    private double gain;

    public RowResult(int replica, double randomNumber, int demand, double gain) {
        this.replica = replica;
        this.randomNumber = randomNumber;
        this.demand = demand;
        this.gain = gain;
    }

    public int getReplica() {
        return replica;
    }

    public void setReplica(int replica) {
        this.replica = replica;
    }

    public double getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(double randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public double getGain() {
        return gain;
    }

    public void setGain(double gain) {
        this.gain = gain;
    }
}
