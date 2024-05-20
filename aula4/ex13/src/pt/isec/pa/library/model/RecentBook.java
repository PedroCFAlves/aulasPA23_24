package pt.isec.pa.library.model;

import java.util.List;

public class RecentBook extends Book{
    private String ISBN;
    private double price;
    RecentBook(String titl, List<String> auth,String isbn, double cost){
        super(titl, auth); // tem que ser a primeira instrução!!! o super tem que ser chamado porque não encontrou nenhum construtor por omissão
        this.ISBN = isbn;
        this.price = cost;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("*Recent --> %s, isbn: %s, cost: %.2f" + super.toString(), ISBN, price);
    }




}
