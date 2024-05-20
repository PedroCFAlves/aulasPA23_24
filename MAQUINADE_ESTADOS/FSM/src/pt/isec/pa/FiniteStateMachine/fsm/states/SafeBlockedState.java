package pt.isec.pa.FiniteStateMachine.fsm.states;

import pt.isec.pa.FiniteStateMachine.data.SafeData;
import pt.isec.pa.FiniteStateMachine.fsm.SafeContext;
import pt.isec.pa.FiniteStateMachine.fsm.SafeState;
import pt.isec.pa.FiniteStateMachine.fsm.SafeStateAdapter;

public class SafeBlockedState extends SafeStateAdapter {
    public SafeBlockedState(SafeContext context, SafeData data){
        super(context,data);
    }

    @Override
    public boolean unblockSafe(String code){
        boolean res = data.unblock(code);
        if(res)
            changeState(SafeState.CLOSED);
            //changeState(new SafeClosedState(context,data));
        return res;
    }
    @Override
    public SafeState getState() {
        return SafeState.BLOCKED;
    }
}
