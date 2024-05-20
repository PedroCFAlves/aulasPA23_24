package pt.isec.pa.fleet.model;

import pt.isec.pa.fleet.ui.IMaxLoad;

import java.util.Comparator;

public class MaxLoadReverseComparator implements Comparator<IMaxLoad> {
    @Override
    public int compare(IMaxLoad o1, IMaxLoad o2) {

        return o2.getMaxWeight() - o1.getMaxWeight();
    }
}
