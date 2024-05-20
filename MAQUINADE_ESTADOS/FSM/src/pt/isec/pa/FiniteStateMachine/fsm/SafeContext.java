package pt.isec.pa.FiniteStateMachine.fsm;

import pt.isec.pa.FiniteStateMachine.data.SafeData;
import pt.isec.pa.FiniteStateMachine.fsm.states.ISafeState;
import pt.isec.pa.FiniteStateMachine.fsm.states.SafeClosedState;

public class SafeContext {
    private SafeData data;
    private ISafeState current;

    public SafeContext() {
        data = new SafeData();

        ///##### !!!! IMPORTANTE: DEVERIA CRIAR O ESTADO ATUAL INICIAL EM FUNÇÃO DOS DADOS!!!! ////

        current = new SafeClosedState(this, data);
    }

    void changeState(ISafeState newState) {
        current = newState;
    }

    public SafeState getState() {
        return current.getState();
    }

    public boolean openSafe(String code) {
        return current.openSafe(code);
    }

    public boolean closeSafe() {
        return current.closeSafe();
    }

    public boolean unblockSafe(String code) {
        return current.unblockSafe(code);
    }

    public boolean depositMoney(double amount) {
        return current.depositMoney(amount);
    }

    public boolean withdrawMoney(double amount) {
        return current.withdrawMoney(amount);
    }

    public double getMoney() {
        return current.getMoney();
    }

    public boolean isSafeOpened() {
        return data.isDoorOpened();
    }

    public boolean isSafeBlocked() {
        return data.isBlocked();
    }

    public int getFailedAttempts() {
        return data.getFailedAttempts();
    }


}
