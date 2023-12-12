import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    public void updateBook(String title, Book updatedBook) {

        for(Book book : books) {
            if(book.getTitle().equals(title)) {
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                System.out.println("Book updated successfully!");
                return;
            }
        }

        System.out.println("Book not found");
    }
    public ArrayList<String> getAuthors() {
        ArrayList<String> authors = new ArrayList<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        return authors;
    }

    public void Borrow(Book book) {
        if (book.isAvailable()) {
            System.out.println("You borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }


        public void Return(Book book) {
            if (books.contains(book)) {
                book.setAvailable(true);
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Book not found in the library.");
            }
        }

        public void DisplayallBooks() {
            if (books.isEmpty()) {
                System.out.println("No books in the library.");
            } else {
                System.out.println("List of all books in the library:");
                for (Book book : books) {
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Published Year: " + book.getPublishedYear());
                    System.out.println("Price: " + book.getPrice());
                    System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
                    System.out.println("------------------------");
                }
            }
        }
    }

