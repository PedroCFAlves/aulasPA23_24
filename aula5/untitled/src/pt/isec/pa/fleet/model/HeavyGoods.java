package pt.isec.pa.fleet.model;

import pt.isec.pa.fleet.ui.IMaxLoad;

public class HeavyGoods extends Vehicle implements IMaxLoad {
private int cargoLimit;
    HeavyGoods(int cargoLimit, String licensePlate, int year){
        super(licensePlate,year);
        this.cargoLimit = cargoLimit;
    }

    public int getCargoLimit() {
        return cargoLimit;
    }

    public void setCargoLimit(int cargoLimit) {
        this.cargoLimit = cargoLimit;
    }
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(String.format("License Plate and year:" + super.toString() + "passenger limite:" + cargoLimit
                +System.lineSeparator()));

        return output.toString();
    }

    @Override
    public int getMaxWeight() {
        return cargoLimit;
    }
}
/*
* o toString
*
* */