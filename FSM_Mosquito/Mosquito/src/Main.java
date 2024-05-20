import pt.isec.pa.mosquito.model.fsm.MosquitoContext;
import pt.isec.pa.mosquito.ui.MosquitoUI;

public class Main {
    public static void main(String[] args) {
        MosquitoContext mosquito = new MosquitoContext();
        MosquitoUI ui = new MosquitoUI(mosquito);
        ui.start();

    }
}