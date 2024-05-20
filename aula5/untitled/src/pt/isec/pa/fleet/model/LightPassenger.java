package pt.isec.pa.fleet.model;

import pt.isec.pa.fleet.ui.IMaxLoad;
import pt.isec.pa.fleet.ui.IPassengers;

public class LightPassenger extends Vehicle implements IPassengers {
    private int passengerLimit;

    LightPassenger(int passengerLimit,  String licensePlate, int year){
        super(licensePlate,year);
        this.passengerLimit = passengerLimit;
    }

    public int getPassengerLimit() {
        return passengerLimit;
    }

    public void setPassengerLimit(int passengerLimit) {
        this.passengerLimit = passengerLimit;
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(String.format("License Plate and year:" + super.toString() + "passenger limite:" + passengerLimit
                +System.lineSeparator()));

        return output.toString();
    }

    @Override
    public int getNumberPassengers() {
        return passengerLimit;
    }
}
