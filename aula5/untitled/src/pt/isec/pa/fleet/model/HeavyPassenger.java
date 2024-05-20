package pt.isec.pa.fleet.model;

import pt.isec.pa.fleet.ui.IMaxLoad;
import pt.isec.pa.fleet.ui.IPassengers;

public class HeavyPassenger extends Vehicle implements IMaxLoad, IPassengers {
    private int passengerLimit;
    private int cargoLimit;

    HeavyPassenger(int passengerLimit, int cargoLimit, String licensePlate, int year){
        super(licensePlate,year);
        this.cargoLimit = cargoLimit;
        this.passengerLimit = passengerLimit;
    }

    public int getPassengerLimit() {
        return passengerLimit;
    }

    public void setPassengerLimit(int passengerLimit) {
        this.passengerLimit = passengerLimit;
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
        output.append(String.format("License Plate and year:" + super.toString() + "passenger limite:" + passengerLimit
                + "cargo limit" + cargoLimit
                +System.lineSeparator()));

        return output.toString();
    }

    @Override
    public int getMaxWeight() {
        return cargoLimit;
    }

    @Override
    public int getNumberPassengers() {
        return passengerLimit;
    }
}
