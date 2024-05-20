package pt.isec.pa.mosquito.model.fsm.states;

import pt.isec.pa.mosquito.model.data.MosquitoData;
import pt.isec.pa.mosquito.model.fsm.MosquitoContext;
import pt.isec.pa.mosquito.model.fsm.MosquitoState;
import pt.isec.pa.mosquito.model.fsm.MosquitoStateAdapter;

public class DeadState extends MosquitoStateAdapter {
    MosquitoContext context;
    MosquitoData data;

    public DeadState(MosquitoContext context, MosquitoData data) {
        super(context, data);

    }

    @Override
    public MosquitoState getState() {
        return MosquitoState.DEAD;
    }

}
