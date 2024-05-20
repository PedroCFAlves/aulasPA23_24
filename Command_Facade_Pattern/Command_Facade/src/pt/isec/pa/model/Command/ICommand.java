package pt.isec.pa.model.Command;

public interface ICommand {
    boolean execute();
    boolean undo();
}