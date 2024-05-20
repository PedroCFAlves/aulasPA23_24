package pt.isec.pa.mosquito.model.fsm;

import pt.isec.pa.mosquito.model.data.MosquitoData;
import pt.isec.pa.mosquito.model.fsm.states.IMosquitoState;

import static pt.isec.pa.mosquito.model.fsm.MosquitoState.IN_FLIGHT; //o import static é mesmo para o valor

public class MosquitoContext {

    private MosquitoData data;
    private IMosquitoState atual;

    public MosquitoContext() {
        this.data = new MosquitoData();
        this.atual = IN_FLIGHT.getInstance(this,data);
    }

    void changeState(IMosquitoState newState) {
        atual = newState;
    }

    public void move(){ atual.move();}

    public boolean crush(){return atual.crush();}

    public boolean takeOff(){return atual.takeOff();}
    public void bite(){atual.bite();}

public MosquitoState getState(){return atual.getState();}
    public int getNumberBites(){return data.getNumberBites();}
    public int getNumberCrushAttempts(){return data.getNumberCrushAttempts();}
    public int getNumberMoves(){return data.getNumberMoves();}
}
