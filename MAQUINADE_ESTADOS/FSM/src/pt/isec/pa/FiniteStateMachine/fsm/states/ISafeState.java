package pt.isec.pa.FiniteStateMachine.fsm.states;

import pt.isec.pa.FiniteStateMachine.data.SafeData;
import pt.isec.pa.FiniteStateMachine.fsm.SafeState;

public interface ISafeState {
    boolean openSafe(String code);

    boolean closeSafe();

    boolean unblockSafe(String code);
    boolean depositMoney(double amount);
    boolean withdrawMoney(double amount);
    double getMoney();

    SafeState getState();
}
