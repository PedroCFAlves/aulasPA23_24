import pt.isec.pa.hangman.model.JogoEnforcadoModelo;
import pt.isec.pa.hangman.ui.JogoEnforcadoIU;
public class JogoEnforcado {
    public static void main(String args[]) {
        JogoEnforcadoModelo jogo = new JogoEnforcadoModelo();
        JogoEnforcadoIU jogoIU = new JogoEnforcadoIU(jogo);
        jogoIU.play();
    }
}