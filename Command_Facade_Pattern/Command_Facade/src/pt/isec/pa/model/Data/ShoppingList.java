package pt.isec.pa.model.Data;

import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<Product> list;

    public ShoppingList() {

        list = new ArrayList<>();
    }

    public boolean addProduct(String name, double qt) {
        if (name != null && !name.isBlank() && qt > 0) {
            list.add(new Product(name, qt));
            return true;
        }
        return false;
    }

    public boolean removeProduct(String name, double qt) {

        return list.remove(new Product(name, qt));
    }

    public double getQuantity(String name) {
        // é preciso de fazer o equals--> se os dois objetos tiverem exatamente o mesmo conteudo, então sao iguais
        double total = -1.0;

        for (Product p : list) {
            if (p.name().equals(name))
                total = total < 0 ? p.qt() : total + p.qt();
        }
        return total;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Shopping List:\n");
        for (Product p : list)
            sb.append("\t- ").append(p).append("\n");
        return sb.toString();
    }
}
