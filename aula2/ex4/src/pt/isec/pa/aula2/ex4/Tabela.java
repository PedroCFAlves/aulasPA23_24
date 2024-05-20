package pt.isec.pa.aula2.ex4;
import java.util.Random;
public class Tabela {
    private static final int MAX = 100;
    private static final int TAM = 20;
    private int [] tab;
    private int nInseridos = 0;
    private int nGerados = 0;
    Random rand = new Random();
    public Tabela() {
        tab = new int[TAM];
    }

    public int getnInseridos() {
        return nInseridos;
    }

    public int getnGerados() {
        return nGerados;
    }

    public boolean existe(int nr) {
        for (int i = 0; i < nInseridos; i++){
            if (tab[i] == nr){
                return true;
            }
        }
        return false;
    }

    public boolean adiciona(int nr) {
        if (nInseridos >=TAM ||existe(nr) || nr<0 || nr>MAX)
            return false;
        tab[nInseridos++] = nr;
        return true;
    }

    public void geraNums() {
        for (int i = 0; i<=TAM; i++){
            // tambem pode ser ---> int nr = (int) (Math.random()*(MAX+1))
            //int nr = (int) (Math.random()*(MAX+1));
            int nr = rand.nextInt(MAX);
            nGerados++;
            adiciona(nr);
        }
    }

    public void listar() {
        System.out.print("[");
        String x;

        for (int i =0; i< nInseridos; i++){
            System.out.print(tab[i]+",");
        }

        System.out.println("]");
    }

    public void mostraQtDuplicados() {
        if (nInseridos ==0)
            System.out.println("Ainda não foram gerados valores.");
        else
            System.out.printf("Para além dos %d valores inseridos, foram gerados %d valores duplicados.\n", nInseridos, nGerados - nInseridos);
    }
}
