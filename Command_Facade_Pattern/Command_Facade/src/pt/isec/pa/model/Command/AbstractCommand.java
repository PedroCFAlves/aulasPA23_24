package pt.isec.pa.model.Command;

import pt.isec.pa.model.Data.ShoppingList;

abstract class AbstractCommand implements ICommand {
    protected ShoppingList receiver;

    protected AbstractCommand(ShoppingList receiver) {
        this.receiver = receiver;
    }
}