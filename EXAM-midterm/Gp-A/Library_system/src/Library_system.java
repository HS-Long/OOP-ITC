import java.util.Scanner;

public class Library_system {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Library library = new Library(); // Declare Library outside the loop

        int choice;
        do {
            System.out.println("Welcome to My Project!");
            System.out.println("1. Add new books.");
            System.out.println("2. Update book information.");
            System.out.println("3. Delete books.");
            System.out.println("4. Display books.");
            System.out.println("5. Borrow books.");
            System.out.println("6. Return books.");
            System.out.println("7. Exit the system.");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    Book book1 = new Book("Java", "Na Standa", 2023, 20.2, true);
                    Book book2 = new Book("Math", "Dr.serey", 2023, 30.2, true);
                    library.addBook(book1);
                    library.addBook(book2);
                    System.out.println("Books added successfully.");
                    break;
                case 2:
                    System.out.print("Enter the title of the book to update: ");
                    String titleToUpdate = scan.next();
                    Book updatedBook = new Book(titleToUpdate, "New Author", 2023, 25.0, true);
                    library.updateBook(titleToUpdate, updatedBook);
                    System.out.println("Book information updated successfully.");
                    break;

                case 3:
                    System.out.print("Enter book title to delete: ");
                    String titleToDelete = scan.next();

                    for (Book book : library.getBooks()) {
                        if (book.getTitle().equals(titleToDelete)) {
                            library.removeBook(book);
                            System.out.println("Book deleted successfully");
                            break;
                        }
                    }
                    break;

                case 4:
                    library.DisplayallBooks();
                    break;

                case 5:
                    // Assuming you want to borrow a book, provide a valid Book object
                    Book borrowedBook = new Book("Java", "Na Standa", 2023, 20.2, true);
                    library.Borrow(borrowedBook);
                    break;

                case 6:
                    System.out.print("Enter book title to return: ");
                    String titleToReturn = scan.next();

                    for (Book book : library.getBooks()) {
                        if (book.getTitle().equals(titleToReturn)) {
                            library.Return(book);
                            break;
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while (choice != 7); // Change the exit condition to match the menu options
    }
}
