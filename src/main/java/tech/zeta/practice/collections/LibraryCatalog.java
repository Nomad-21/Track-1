package tech.zeta.practice.collections;

import java.util.*;

// Class representing a Book
class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is currently not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    @Override
    public String toString() {
        return "[" + isbn + "] " + title + " by " + author +
                (isAvailable ? " (Available)" : " (Not Available)");
    }
}

// Library Catalog class
class LibraryCatalog {
    private Map<String, Book> catalog;
    private TreeSet<Book> sortedBooks;

    public LibraryCatalog() {
        catalog = new HashMap<>();
        sortedBooks = new TreeSet<>((a,b)->a.getTitle().compareTo(b.getTitle()));
    }

    public void addBook(Book book) {
        catalog.put(book.getIsbn(), book);
        sortedBooks.add(book);
    }

    public void removeBook(String isbn) {
        if (catalog.containsKey(isbn)) {
            sortedBooks.remove(catalog.get(isbn));
            catalog.remove(isbn);
            System.out.println("Book removed from catalog.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : catalog.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) System.out.println("No book found with title: " + title);
    }

    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("Catalog is empty.");
        } else {
            System.out.println("\n--- Library Catalog ---");
            for (Book book : catalog.values()) {
                System.out.println(book);
            }
        }
    }

    public Book getBook(String isbn) {
        return catalog.get(isbn);
    }

    public String getBooksByTitle(){
        return sortedBooks.toString();
    }

}


