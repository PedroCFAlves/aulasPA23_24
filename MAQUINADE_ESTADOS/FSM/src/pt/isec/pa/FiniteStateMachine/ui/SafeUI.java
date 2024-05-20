package pt.isec.pa.FiniteStateMachine.ui;

import pt.isec.pa.FiniteStateMachine.fsm.SafeContext;
import pt.isec.pa.FiniteStateMachine.fsm.SafeState;

import java.util.Map;

public class SafeUI {
    private static final Map<SafeState,String> stateNames =
            Map.of(
                    SafeState.OPENED,"Safe opened",
                    SafeState.CLOSED, "Safe closed",
                    SafeState.BLOCKED, "Safe blocked"
            );
    private SafeContext fsm;

    public SafeUI(SafeContext fsm) {
        this.fsm = fsm;
    }

    public void start() {
        int res;
        do {
            System.out.println("\n\nSafe Controller\n");
            System.out.println("Current status: "+stateNames.get(fsm.getState()));
            System.out.println("Current failed opening attempts: "+fsm.getFailedAttempts());
            System.out.println();
            res = PAInput.chooseOption("Commands:", "Open safe",
                    "Close safe", "Unblock safe",
                    "Deposit money", "Withdraw money",
                    "Display money", "Exit");
            switch (res) {
                case 1 -> fsm.openSafe(PAInput.readString("Code: ",false));
                case 2 -> fsm.closeSafe();
                case 3 -> fsm.unblockSafe(PAInput.readString("PUK: ",false));
                case 4 -> fsm.depositMoney(PAInput.readNumber("Deposit - Amount: "));
                case 5 -> fsm.withdrawMoney(PAInput.readNumber(
                        String.format("Withdraw - Amount [Available: %.2f]: ",fsm.getMoney()))
                );
                case 6 -> System.out.printf("Money available: %.2f",fsm.getMoney());
            }
        } while (res!=7);
    }

    //TODO: version where only valid actions are made available in each state
}