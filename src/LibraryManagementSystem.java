import java.util.Scanner;

public class LibraryManagementSystem {
    private static Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Librarian librarian = new Librarian("Bob Smith", library);
        Member member = new Member("Alice Johnson", "M001");

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline after integer input

            switch (choice) {
                case 1: // Add books
                    addBook(librarian);
                    break;
                case 2: // Remove books
                    removeBook(librarian);
                    break;
                case 3: // Borrow books
                    borrowBook(member);
                    break;
                case 4: // Display book information
                    displayBookInfo();
                    break;
                case 5: // Show all books
                    showAllBooks();
                    break;
                case 6: // Exit
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Books");
        System.out.println("2. Remove Books");
        System.out.println("3. Borrow Books");
        System.out.println("4. Display Book Information");
        System.out.println("5. Show All Books");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBook(Librarian librarian) {
        System.out.print("Enter the type of book to add (1 for Fiction, 2 for Non-Fiction): ");
        int bookType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the author's name: ");
        String author = scanner.nextLine();

        System.out.print("Enter the book's ISBN: ");
        String isbn = scanner.nextLine();

        if (bookType == 1) { // Fiction
            System.out.print("Enter the genre of the Fiction book: ");
            String genre = scanner.nextLine();
            FictionBook fictionBook = new FictionBook(title, author, isbn, genre);
            librarian.addBook(fictionBook);
        } else if (bookType == 2) { // Non-Fiction
            System.out.print("Enter the subject of the Non-Fiction book: ");
            String subject = scanner.nextLine();
            NonFictionBook nonFictionBook = new NonFictionBook(title, author, isbn, subject);
            librarian.addBook(nonFictionBook);
        } else {
            System.out.println("Invalid book type selected.");
        }
    }

    private static void removeBook(Librarian librarian) {
        System.out.print("Enter the title of the book you want to remove: ");
        String titleToRemove = scanner.nextLine();
        if (!library.removeBook(titleToRemove)) {
            System.out.println("Book not found.");
        } else {
            System.out.println("Book removed successfully.");
        }
    }

    private static void borrowBook(Member member) {
        System.out.print("Enter the title of the book you want to borrow: ");
        String bookTitleToBorrow = scanner.nextLine();
        Book bookToBorrow = library.getBookByTitle(bookTitleToBorrow);

        if (bookToBorrow != null) {
            member.borrowBook(bookToBorrow);
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void displayBookInfo() {
        System.out.print("Enter the title of the book you want to display information for: ");
        String title = scanner.nextLine();
        Book book = library.getBookByTitle(title);
        if (book != null) {
            book.displayInfo();
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void showAllBooks() {
        System.out.println("All books in the library:");
        library.displayAllBooks();
    }
}
