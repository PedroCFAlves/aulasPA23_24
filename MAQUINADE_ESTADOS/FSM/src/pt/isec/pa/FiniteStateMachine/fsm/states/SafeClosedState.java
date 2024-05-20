package pt.isec.pa.FiniteStateMachine.fsm.states;

import pt.isec.pa.FiniteStateMachine.data.SafeData;
import pt.isec.pa.FiniteStateMachine.fsm.SafeContext;
import pt.isec.pa.FiniteStateMachine.fsm.SafeState;
import pt.isec.pa.FiniteStateMachine.fsm.SafeStateAdapter;

public class SafeClosedState extends SafeStateAdapter {
    public SafeClosedState(SafeContext context, SafeData data) {
        super(context, data);
    }

    @Override
    public boolean openSafe(String code) {
        boolean res = data.open(code);
        if (res) {
            changeState(SafeState.OPENED); // para a fabrica de objectos
            //changeState(new SafeOpenState(context,data));
            return true;
        }
        if (data.isBlocked())
            changeState(SafeState.BLOCKED);// para a fabrica de objectos
            //changeState(new SafeBlockedState(context,data));
        return false;
    }


    @Override
    public SafeState getState() {
        return SafeState.CLOSED;
    }
}
