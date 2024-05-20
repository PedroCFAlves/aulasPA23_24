package pt.isec.pa.library.model;

import java.util.ArrayList;
import java.util.List;

public class Book implements Cloneable, Comparable<Book> {

    private List<String> author;
    private String title;
    private static int counter = 0;
    private int id;

    private static int getNewId() {
        return ++counter;
    }

    public Book(String titl, List<String> auth) {
        this.title = titl;

        this.author = new ArrayList<>();
        //for (String a : auth){this.author.add(a);}
        /*for (int i = 0; i < auth.size(); i++) {
            this.author.add(auth.get(i));
        }*/
        this.author = List.copyOf(auth); // DEVOLVE UMA LISTA NÃO MODIFICÁVEL
        id = getNewId();
    }

    public Book(String title, String... authors) {
        this.title = title;
        this.author = new ArrayList<>();
        //for (String a : authors){this.author.add(a);}
        /*for (int i = 0; i < authors.length; i++) {
            author.add(authors[i]);
        }*/
        this.author = List.of(authors);
        id = getNewId();
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // if (o == null || getClass() != o.getClass()) return false;
        //O GETCLASS() SIMPLES REFERE-SE AO THIS
        //Book book = (Book) o; //É PRECISO DE FAZER O CAST PQ O 'o' ESTÁ DECLARADO COMO OBJECTO! POR ESTAR DECLARADO COMO OBJECTO, IMPLICA QUE NÃO TEM LÁ O TITULO!!
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;

        /*com cast automatico:
         * if (!(o instanceof Book book)) return false;
         * return title.equalsIgnoreCase(book.title);
         * */

        return title.equalsIgnoreCase(book.title);
    }

    /*#####
     * ####
     * OBJECTOS IGUAIS TÊM QUE TER O MESMO HASCODE!!!
     * ####
     * #####
     * */


    @Override
    public int hashCode() {
        int result = title != null ? title.toLowerCase().hashCode() : 0;
        return result;
    }


    @Override
    public String toString() {
        String strAuthors = author.toString();

        return String.format("[%d] %s - %s",
                id, title,
                strAuthors.substring(1, strAuthors.length() - 1));
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*
    public List<String> getAuthor() {
        return author;
    }!!!! NÃO USAR ESTE!!! ISTO PORQUE DEVOLVE UMA REFERENCIA PARA ALGO INTERNO DO OBJECTO!!!*/

    public List<String> getAuthor() {
        return List.copyOf(author);
    }


    @Override
    protected Book clone() throws CloneNotSupportedException {
        Book newBook = (Book) super.clone(); //pode criar

        newBook.author = List.copyOf(author); // permite ter listas separadas. isto consegue desagregar da outra lista
        return newBook;
    }

    @Override
    public int compareTo(Book o){
        return title.toLowerCase().compareTo(o.title.toLowerCase()); // pode ser organizado por codigo
    }
}
