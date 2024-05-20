import pt.isec.pa.model.ShoppingListManager;
import pt.isec.pa.ui.ShoppingListUI;

public class Main {
    public static void main(String[] args) {
        ShoppingListManager sm = new ShoppingListManager();
        ShoppingListUI ui = new ShoppingListUI(sm);
        ui.start();

    }
}