package pt.isec.pa.fleet.model;

import pt.isec.pa.fleet.ui.IPassengers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fleet {
    private String name;

    private Set<Vehicle> setVehicle;

    public Fleet(String name){
        this.name = name;
        setVehicle = new HashSet();
    }

    public boolean addVehicle(Vehicle vehicle){
        return setVehicle.add(vehicle);
    }

    public boolean removeVehicle(Vehicle vehicle){
        return setVehicle.remove(vehicle);
    }

    public boolean removeVehicle(String regPlate){
        Vehicle dummyVehicle = new Vehicle(regPlate, 0);
        return removeVehicle(dummyVehicle);
    }


   public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("vehicles:\n");
        if (setVehicle == null || setVehicle.isEmpty()) {
            sb.append("no vehicles");
            return sb.toString();
        }
        else{
            for (Vehicle v : setVehicle){
                sb.append(String.format("\t - %s\n", v.toString()));
            }
        }
        return sb.toString();
   }



    public String toStringSortedByNumberOfPassengers(){
        List<Vehicle> help= new ArrayList<>();
        for (Vehicle vehicle : setVehicle){
            if (vehicle instanceof IPassengers other){
                help.add(other);
            }
        }
    }
}
