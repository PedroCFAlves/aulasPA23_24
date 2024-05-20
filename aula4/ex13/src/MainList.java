import pt.isec.pa.library.model.ILibrary;
import pt.isec.pa.library.model.LibraryList;
import pt.isec.pa.library.model.LibraryMap;
import pt.isec.pa.library.model.LibrarySet;
import pt.isec.pa.library.ui.LibraryUI;

public class MainList {
    public static void main(String[] args) throws CloneNotSupportedException {


        //ILibrary library = new LibraryList("DEIS_ISEC- list");
        //ILibrary library = new LibrarySet("DEIS_ISEC- list");
        ILibrary library = new LibraryMap("DEIS_ISEC- list");
        LibraryUI ui = new LibraryUI(library);
        ui.start();
    }
}