package pt.isec.pa.aula2.ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final int NUMERO_PENSADO_IGUAL = 1;
    public static final int NUMERO_PENSADO_MAIOR = 2;
    public static final int NUMERO_PENSADO_MENOR = 3;

    public static int obtemResposta(int palpite) {
        int resposta = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.printf("O número em que pensou é: %d?\n",palpite);
            System.out.println();
            System.out.println(NUMERO_PENSADO_IGUAL + " - SIM");
            System.out.println(NUMERO_PENSADO_MAIOR + " - PENSEI NUM NÚMERO MAIOR");
            System.out.println(NUMERO_PENSADO_MENOR + " - PENSEI NUM NÚMERO MENOR");
            System.out.println();
            System.out.print("Resposta: ");

            /* Obtem a resposta do utilizador */
            //...
            /*if (sc.hasNextInt()){
                resposta = sc.nextInt();
            }else{
                resposta = -1;
                sc.next();
            }*/

            try {
                resposta = sc.nextInt();
                //sc.hasNextInt();
            }catch (InputMismatchException ex){
                System.out.println("deu bronca");
                resposta = -1;
                sc.next();
            }
            //resposta = sc.nextInt();
        } while(resposta<1 || resposta>3);

        return resposta;
    }

    public static void main(String[] args) {
        int min=1, max=100;
        int palpiteComputador, respostautilizador;
        int numTentativas=0;

        System.out.println("Pense num número...");

        do {
            numTentativas++;
            palpiteComputador = (min+max)/2;


            /* Ajuste, se necessário, min ou max em função da resposta do utilizador */
            respostautilizador = obtemResposta(palpiteComputador);
            if(respostautilizador == NUMERO_PENSADO_MAIOR)
                min = palpiteComputador + 1;
            else if (respostautilizador == NUMERO_PENSADO_MENOR) {
                max = palpiteComputador -1;
            }

        } while (respostautilizador != NUMERO_PENSADO_IGUAL && min <= max);

        if (respostautilizador != NUMERO_PENSADO_IGUAL)
            System.out.println("\nMentiu-me!");
        else
            System.out.printf("\nAcertei no número %d em %d tentativas.\n", palpiteComputador, numTentativas);
    }

}