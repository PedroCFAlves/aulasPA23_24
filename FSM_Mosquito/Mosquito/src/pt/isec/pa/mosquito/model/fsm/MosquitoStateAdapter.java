package pt.isec.pa.mosquito.model.fsm;

import pt.isec.pa.mosquito.model.data.MosquitoData;
import pt.isec.pa.mosquito.model.fsm.states.IMosquitoState;

public abstract class MosquitoStateAdapter implements IMosquitoState {

    protected MosquitoContext context;
    protected MosquitoData data;

    public MosquitoStateAdapter(MosquitoContext context, MosquitoData data) {
        this.context = context;
        this.data = data;
    }

    /*protected void changeState(IMosquitoState newState){
        context.changeState(newState);
    }*/

    protected void changeState(MosquitoState newState){
        context.changeState(newState.getInstance(context,data));
        //context.changeState(newState.getInstance(newState, context,data));
    }
    @Override
    public void move() {

    }

    @Override
    public boolean crush() {
        return false;
    }

    @Override
    public boolean takeOff() {
        return false;
    }

    @Override
    public void bite() {

    }

}
