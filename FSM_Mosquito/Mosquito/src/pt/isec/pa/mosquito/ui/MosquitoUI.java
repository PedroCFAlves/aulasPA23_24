package pt.isec.pa.mosquito.ui;

import pt.isec.pa.mosquito.model.fsm.MosquitoContext;

import java.io.IOException;

public class MosquitoUI {
    MosquitoContext mosquito;

    public MosquitoUI(MosquitoContext mosquito) {
        this.mosquito = mosquito;
    }

    public void start() {
        boolean cont;

        do{
            cont = switch (mosquito.getState()) {
                case IN_FLIGHT -> inFlightUI();
                case DEAD -> deadUI();
                case READY_TO_BITE -> readyToBiteUI();
                case LANDED -> landedUI();
            };

            System.out.println();
            System.out.printf("Number of moves: %d\n", mosquito.getNumberMoves());
            System.out.printf("Number Crush Attempts: %d\n", mosquito.getNumberCrushAttempts());
            System.out.printf("Number of bites: %d\n", mosquito.getNumberBites());
            System.out.println();

        }while(cont);
    }

    private boolean inFlightUI() {
        System.out.println("***** In flight *****\n");
        switch(PAInput.chooseOption("Actions:", "Move","Try to crush","Exit")) {
            case 1 -> mosquito.move();
            case 2 -> mosquito.crush();
            default -> {
                return false;
            }
        }

        return true;
    }

    private boolean deadUI() {
        System.out.println("***** Dead *****\n");
        System.out.println("Press Enter to finish... ");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private boolean readyToBiteUI() {
        System.out.println("***** Ready To Bite *****\n");
        switch(PAInput.chooseOption("Actions:", "Take off","Try to crush","Bite","Exit")) {
            case 1 -> mosquito.takeOff();
            case 2 -> mosquito.crush();
            case 3 -> mosquito.bite();
            default -> {
                return false;
            }
        }

        return true;
    }

    private boolean landedUI() {
        System.out.println("***** Landed *****\n");
        switch(PAInput.chooseOption("Actions:", "Take off","Try to crush","Exit")) {
            case 1 -> mosquito.takeOff();
            case 2 -> mosquito.crush();
            default -> {
                return false;
            }
        }

        return true;
    }
}