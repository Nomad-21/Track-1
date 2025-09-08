package tech.zeta.practice.collections;

public class LibraryDemo {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();

        // Adding books
        catalog.addBook(new Book("101", "Java Programming", "James Gosling"));
        catalog.addBook(new Book("102", "Data Structures", "Robert Lafore"));
        catalog.addBook(new Book("103", "Operating Systems", "Silberschatz"));
        catalog.addBook(new Book("104", "Systems", "Silberschatz"));
        catalog.addBook(new Book("105", "Programming", "Silberschatz"));

        System.out.println(catalog.getBooksByTitle().replace(',','\n'));
    }
}

