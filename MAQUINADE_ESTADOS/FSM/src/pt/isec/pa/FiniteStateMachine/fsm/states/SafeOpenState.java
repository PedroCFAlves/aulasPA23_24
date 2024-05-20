package pt.isec.pa.FiniteStateMachine.fsm.states;

import pt.isec.pa.FiniteStateMachine.data.SafeData;
import pt.isec.pa.FiniteStateMachine.fsm.SafeContext;
import pt.isec.pa.FiniteStateMachine.fsm.SafeState;
import pt.isec.pa.FiniteStateMachine.fsm.SafeStateAdapter;

public class SafeOpenState extends SafeStateAdapter {

    public SafeOpenState(SafeContext context, SafeData data){
        super(context,data);
    }

    @Override
    public boolean closeSafe(){
        boolean res = data.close();
        if (res)
            changeState(SafeState.CLOSED);
            //changeState(new SafeClosedState(context,data));
        return res;
    }

    @Override
    public double getMoney() {
        return data.getMoney();
    }
    @Override
    public boolean depositMoney(double amount) {
        return data.depositMoney(amount);
    }

    @Override
    public boolean withdrawMoney(double amount) {
        return data.withdrawMoney(amount);
    }
    @Override
    public SafeState getState() {
        return SafeState.OPENED;
    }
}
