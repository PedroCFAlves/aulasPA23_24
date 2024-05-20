package pt.isec.pa.model;

import pt.isec.pa.model.Command.AddProductCommand;
import pt.isec.pa.model.Command.CommandManager;
import pt.isec.pa.model.Command.RemoveProductCommand;
import pt.isec.pa.model.Data.ShoppingList;
import pt.isec.pa.utils.PAInput;

public class ShoppingListManager {
ShoppingList sp;
CommandManager cm;
    public ShoppingListManager(){
        sp = new ShoppingList();
        cm = new CommandManager();
    }

    public boolean addProduct(String name, double qt){
        return cm.invokeCommand(new AddProductCommand(sp,name,qt));
    }

    public boolean removeProduct(String name, double qt){
        return cm.invokeCommand(new RemoveProductCommand(sp,name,qt));
    }

    public boolean undo(){return cm.undo();}
    public boolean hasUndo(){return cm.hasUndo();}

    public boolean redo(){return cm.redo();}
    public boolean hasRedo(){return cm.hasRedo();}


}
