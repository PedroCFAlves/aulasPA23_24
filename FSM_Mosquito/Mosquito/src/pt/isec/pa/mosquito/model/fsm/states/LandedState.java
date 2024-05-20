package pt.isec.pa.mosquito.model.fsm.states;

import pt.isec.pa.mosquito.model.data.MosquitoData;
import pt.isec.pa.mosquito.model.fsm.MosquitoContext;
import pt.isec.pa.mosquito.model.fsm.MosquitoState;
import pt.isec.pa.mosquito.model.fsm.MosquitoStateAdapter;

public class LandedState extends MosquitoStateAdapter {


    public LandedState(MosquitoContext context, MosquitoData data) {
        super(context, data);
    }

    @Override
    public MosquitoState getState() {

        return MosquitoState.LANDED;
    }

    @Override
    public boolean takeOff() {
        boolean res = data.takeOff();
        changeState(MosquitoState.IN_FLIGHT);
        return res;
    }

    @Override
    public boolean crush() {
        boolean res = data.tryToCrush();
        if (res)
            changeState(MosquitoState.DEAD);
        else
            changeState(MosquitoState.IN_FLIGHT);
        return res;
    }

}
