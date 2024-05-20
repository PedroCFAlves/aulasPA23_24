package pt.isec.pa.mosquito.model.fsm.states;

import pt.isec.pa.mosquito.model.data.MosquitoData;
import pt.isec.pa.mosquito.model.fsm.MosquitoContext;
import pt.isec.pa.mosquito.model.fsm.MosquitoState;
import pt.isec.pa.mosquito.model.fsm.MosquitoStateAdapter;

public class ReadyToBiteState extends LandedState {


    public ReadyToBiteState(MosquitoContext context, MosquitoData data) {
        super(context, data);
    }

    @Override
    public MosquitoState getState() {
        return MosquitoState.READY_TO_BITE;
    }

    @Override
    public void bite() {
        data.bite();
    }

}
