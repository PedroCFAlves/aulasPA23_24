package pt.isec.pa.fleet.model;

import java.util.Comparator;
import java.util.Objects;

public class Vehicle {

    private String licensePlate;
    private int year;

    public Vehicle(String licensePlate, int year) {
    }

    @Override
    public String toString() {
        return "Vehicle{" + "matricula='" + licensePlate + '\'' + ", year=" + year + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle veiculo = (Vehicle) o;

        return this.licensePlate.equalsIgnoreCase(veiculo.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, year);
    }



}
