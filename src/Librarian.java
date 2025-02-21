import java.util.concurrent.locks.*;

public class Librarian implements LibraryOperations {
    private String name;
    private final Lock lock = new ReentrantLock();
    private Library library;

    public Librarian(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    @Override
    public void addBook(Book book) {
        lock.lock();
        try {
            library.addBook(book);  
            System.out.println(name + " added the book titled: " + book.getTitle());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean removeBook(String title) {
        lock.lock();
        try {
            if (library.removeBook(title)) {
                System.out.println(name + " removed the book titled: " + title);
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean borrowBook(String title, Member member) {
        lock.lock();
        try {
            Book book = library.getBookByTitle(title);
            if (book != null && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println(member.getName() + " borrowed the book titled: " + title);
                return true;
            }
            System.out.println("The book is not available.");
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void displayBookInfo(Book book) {
        book.displayInfo();
    }
}
