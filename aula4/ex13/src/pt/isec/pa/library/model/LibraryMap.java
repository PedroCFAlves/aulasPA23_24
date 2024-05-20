package pt.isec.pa.library.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryMap implements ILibrary{
    private String name;

    private Map<Integer,Book> books;

    public LibraryMap(String name) {
        this.name = name;
        books = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int addBook(String title, List<String> authors) {
        Book newBook = new Book(title, authors);
        /*if (books.contains(newBook))
            return -1;
        books.add(newBook);*/

        //if (books.containsKey(newBook.getId())) !!! esta também pode ser usada, mas vai contra o que é pedido no enunciado
        /*if (books.containsValue(newBook.getId()))
            return -1;
        books.put(newBook.getId(), newBook);*/
        /*ou
        * if (books.get(newBook.getId() !=null)) return -1;
        * book.put(newBook.getId(),newBook);
        *
        * */
        if(books.putIfAbsent(newBook.getId(), newBook)!=null)
            return -1;

        return newBook.getId();
    }

    //@Override
    public int addBook(Book newBook) {
        if (books.containsValue(newBook))
            return -1;
        books.put(newBook.getId(), newBook);
        return newBook.getId();
    }


    @Override
    int oldBook(String title, List<String> authors, int nrCopies) {
        return addBook(new OldBook(title,authors,nrCopies));
    }
    @Override
    int recentBook(String title, List<String> authors, String isbn, double cost) {
        return addBook(new RecentBook(title,authors, isbn,  cost));
    }


    @Override
    public Book findBook(String title) throws CloneNotSupportedException {
        /*
        ####   FORMA DO PROF!!!
        #####
        Book tempBook = new Book(title,List.of());
        int index = books.indexOf(tempBook);
        if(index>=0)
            return books.get(index).clone();
        return null;

        */
        for (Book bookfind : books.values())
            if(bookfind.getTitle().equalsIgnoreCase(title))
                return bookfind.clone();
        return null;
    }

    @Override
    public Book findBook(int id) throws CloneNotSupportedException {
        /*for (Book book : books.values())
            if(book.getId() ==id)
                return book.clone();
        return null;*/

        return books.get(id) == null ? null : books.get(id).clone();

    }

    @Override
    public boolean removeBook(String title) {

        /*int index = books.indexOf(new Book(title, List.of()));
        if(index<0)return false;
        books.remove(index);
        return true;
        * */
        for (Book book : books.values())
            if(book.getTitle().equalsIgnoreCase(title))
                return books.remove(book.getId()) != null;
        return false;
    }

    @Override
    public boolean removeBook(int id) {
        return books.remove(id)!=null;
    }
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(String.format("library" + name + System.lineSeparator()));
        for (Book book: books.values()){
            output.append("  - " + book + System.lineSeparator());
        }
        return output.toString();
    }
}
