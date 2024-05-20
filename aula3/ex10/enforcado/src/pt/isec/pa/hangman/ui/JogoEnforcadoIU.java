package pt.isec.pa.hangman.ui;

import pt.isec.pa.hangman.model.JogoEnforcadoModelo;

import java.util.Scanner;

public class JogoEnforcadoIU {

    JogoEnforcadoModelo jogo;

    Scanner sc;

    public JogoEnforcadoIU(JogoEnforcadoModelo jogo) {
        this.jogo = jogo;
    }

    public void play() {
        sc = new Scanner(System.in);
        while (!jogo.concluded()) {
            System.out.println("palavra:" + jogo.getWordToFind());
            System.out.println("Situacao atual"+ jogo.getCurrentSituation());

            System.out.println("N tentativas:"+ jogo.getnAttempts());

            System.out.printf("Caracteres que foram tentados", jogo.getAttemptedCharacters(), jogo.getnFound());

            System.out.print("\nSugestao:");
            String option = sc.nextLine().trim();

            if (option.length()>0){
                jogo.tryOption(option);
            }

            if(jogo.isWordFound()){
                System.out.printf("30 caraças!!!");
            }
            else
                System.out.println("acabou e falhaste! miseravel!" + jogo.getWordToFind());

        }
    }


}
