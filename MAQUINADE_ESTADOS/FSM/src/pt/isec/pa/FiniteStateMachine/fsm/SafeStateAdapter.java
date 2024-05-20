package pt.isec.pa.FiniteStateMachine.fsm;

import pt.isec.pa.FiniteStateMachine.data.SafeData;
import pt.isec.pa.FiniteStateMachine.fsm.states.ISafeState;

public abstract class SafeStateAdapter implements ISafeState {
    protected SafeContext context;
    protected SafeData data;

    protected SafeStateAdapter(SafeContext context, SafeData data){
        this.context = context;
        this.data = data;
    }
    protected void changeState(ISafeState newState){
        context.changeState(newState);
    }

    protected void changeState(SafeState newState){
        context.changeState(newState.getInstance(context,data));
        //context.changeState(newState.getInstance(newState, context,data));
    }


    @Override
    public boolean depositMoney(double amount) {return false;}
    @Override
    public boolean openSafe(String code){return false;}

    @Override
    public boolean closeSafe(){return false;}

    @Override
    public boolean unblockSafe(String code){return false;}

    @Override
    public boolean withdrawMoney (double money){return false;}

    @Override
    public double getMoney(){return -1.0;}

}
