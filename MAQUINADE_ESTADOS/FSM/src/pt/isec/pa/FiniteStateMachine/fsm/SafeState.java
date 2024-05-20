package pt.isec.pa.FiniteStateMachine.fsm;

import pt.isec.pa.FiniteStateMachine.data.SafeData;
import pt.isec.pa.FiniteStateMachine.fsm.states.ISafeState;
import pt.isec.pa.FiniteStateMachine.fsm.states.SafeBlockedState;
import pt.isec.pa.FiniteStateMachine.fsm.states.SafeClosedState;
import pt.isec.pa.FiniteStateMachine.fsm.states.SafeOpenState;

public enum SafeState {

    CLOSED,OPENED,BLOCKED;


//alternativa c)
    public ISafeState getInstance(SafeContext context, SafeData data){ //este não é estático, é de uma instância, ou seja de um indicado contexto closed, open, blocked
        return switch (this){
        case CLOSED -> new SafeClosedState(context,data);
        case OPENED -> new SafeOpenState(context,data);
        case BLOCKED -> new SafeBlockedState(context,data);
    };}

    //alternativa b)
    static public ISafeState getInstance(SafeState type, SafeContext context, SafeData data){
        return switch (type){
            case CLOSED -> new SafeClosedState(context,data);
            case OPENED -> new SafeOpenState(context,data);
            case BLOCKED -> new SafeBlockedState(context,data);
        };
    }
}


/*########
* ####
*               FÁBRICA DE OBJECTOS!!!
* ####
* #######
* */

/*public */class SafeStateFactory{
    private SafeStateFactory(){    }

    static public ISafeState getInstance(SafeState type, SafeContext context, SafeData data){
        return switch (type){
            case CLOSED -> new SafeClosedState(context,data);
            case OPENED -> new SafeOpenState(context,data);
            case BLOCKED -> new SafeBlockedState(context,data);
        };
    }
}