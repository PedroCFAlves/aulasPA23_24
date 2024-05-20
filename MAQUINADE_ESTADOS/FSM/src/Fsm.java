import pt.isec.pa.FiniteStateMachine.fsm.SafeContext;
import pt.isec.pa.FiniteStateMachine.ui.SafeUI;

public class Fsm {
    public static void main(String[] args) {
        SafeContext fsm = new SafeContext();
        SafeUI ui = new SafeUI(fsm);
        ui.start();

    }
}