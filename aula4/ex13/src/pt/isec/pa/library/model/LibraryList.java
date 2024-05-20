package pt.isec.pa.library.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryList implements ILibrary {

    private String name;

    private List<Book> books;

    public LibraryList(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    //@Override
    /*public int addBook(String title, List<String> authors) {
        Book newBook = new Book(title, authors);
        if (books.contains(newBook))
            return -1;
        books.add(newBook);
        return newBook.getId();
    }*/
    public int addBook(Book newBook) {
        if(books.contains(newBook))
            return -1;
        books.add(newBook);
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
        for (Book bookfind : books)
            if(bookfind.getTitle().equalsIgnoreCase(title))
                return bookfind.clone();
            return null;
    }

    @Override
    public Book findBook(int id) throws CloneNotSupportedException {
        for (Book book : books)
            if(book.getId() ==id)
                return book.clone();
        return null;
    }

    @Override
    public boolean removeBook(String title) {

        /*int index = books.indexOf(new Book(title, List.of()));
        if(index<0)return false;
        books.remove(index);
        return true;
        * */


        return books.remove(new Book(title,List.of()));
    }

    @Override
    public boolean removeBook(int id) {
        for (Book bookToRemove : books)
            if(bookToRemove.getId() ==id)
                return books.remove(bookToRemove);
        return false;
    }
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(String.format("library" + name + System.lineSeparator()));
        for (Book book: books){
            output.append("  - " + book + System.lineSeparator());
        }
        return output.toString();
    }
}
