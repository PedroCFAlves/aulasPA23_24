package pt.isec.pa.library.model;
import java.util.List;
public interface ILibrary {

    String getName();

    void setName(String name);

    int addBook(String title, List<String> authors);
    int oldBook(String title, List<String> authors, int nrCopies);
    int recentBook(String title, List<String> authors, String isbn, double cost);
    Book findBook(String title) throws CloneNotSupportedException;

    Book findBook(int id) throws CloneNotSupportedException;

    boolean removeBook(String title);

    boolean removeBook(int id);


}
