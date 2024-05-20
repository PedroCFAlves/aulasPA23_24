package pt.isec.pa.mosquito.model.fsm;

import pt.isec.pa.mosquito.model.data.MosquitoData;
import pt.isec.pa.mosquito.model.fsm.states.*;
import pt.isec.pa.mosquito.ui.MosquitoUI;

public enum MosquitoState {
   IN_FLIGHT,  LANDED, DEAD,  READY_TO_BITE;





      public IMosquitoState getInstance(MosquitoContext context, MosquitoData data){
         return switch (this){
            case IN_FLIGHT -> new InFlightState(context,data);
            case DEAD -> new DeadState(context,data);
            case READY_TO_BITE -> new ReadyToBiteState(context,data);
            case LANDED -> new LandedState(context,data);
         };
      }

}
