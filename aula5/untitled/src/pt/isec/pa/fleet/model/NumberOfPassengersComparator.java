package pt.isec.pa.fleet.model;

import pt.isec.pa.fleet.ui.IMaxLoad;
import pt.isec.pa.fleet.ui.IPassengers;

import java.util.Comparator;

public class NumberOfPassengersComparator implements Comparator<IPassengers> {

    @Override
    public int compare(IPassengers o1, IPassengers o2) {
        return o1.getNumberPassengers() - o2.getNumberPassengers();
    }
}
