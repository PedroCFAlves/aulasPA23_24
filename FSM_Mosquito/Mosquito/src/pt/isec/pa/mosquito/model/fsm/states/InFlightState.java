package pt.isec.pa.mosquito.model.fsm.states;

import pt.isec.pa.mosquito.model.data.MosquitoData;
import pt.isec.pa.mosquito.model.fsm.MosquitoContext;
import pt.isec.pa.mosquito.model.fsm.MosquitoState;
import pt.isec.pa.mosquito.model.fsm.MosquitoStateAdapter;

import java.util.Random;

public class InFlightState extends MosquitoStateAdapter {


    public InFlightState(MosquitoContext context, MosquitoData data) {
        super(context, data);

    }

    @Override
    public MosquitoState getState() {
        return MosquitoState.IN_FLIGHT;
    }

    @Override
    public boolean crush() {
        boolean res = data.tryToCrush();
        if (res)
            changeState(MosquitoState.DEAD);
        return res;
    }


    @Override
    public void move() {
        data.move();

        if(data.isOnAnimal())
            changeState(MosquitoState.READY_TO_BITE);
        else if (data.isOnObject()) {
            changeState(MosquitoState.LANDED);
        }
        Random random = new Random();
        double randomNumber = random.nextDouble();

        if(randomNumber <= 0.2){
            //When it moves and reaches an animal (probability:
            //20%), it lands and becomes ready to bite
            bite();
        }
    }
}
