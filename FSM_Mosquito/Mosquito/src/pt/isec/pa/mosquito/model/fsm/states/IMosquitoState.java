package pt.isec.pa.mosquito.model.fsm.states;

import pt.isec.pa.mosquito.model.fsm.MosquitoState;

public interface IMosquitoState {

    void move();

    boolean crush();
    boolean takeOff();
    void bite();

    MosquitoState getState();



}
