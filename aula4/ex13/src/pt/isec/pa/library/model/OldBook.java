package pt.isec.pa.library.model;

import java.util.List;

public class OldBook extends Book {
    private int nrCopies;

    public OldBook(String titl, List<String> auth, int nrCopies) {
        super(titl, auth); // tem que ser a primeira instrução!!! o super tem que ser chamado porque não encontrou nenhum construtor por omissão
        this.nrCopies = nrCopies;
    }


    public int getNrCopies() {
        return nrCopies;
    }

    public void setNrCopies(int nrCopies) {
        this.nrCopies = nrCopies;
    }

    @Override
    public String toString() {
        return String.format("*oldbook -->" + super.toString() + ", #copies" + nrCopies);
    }

}
