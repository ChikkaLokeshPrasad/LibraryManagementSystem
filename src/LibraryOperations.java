public interface LibraryOperations {
    void addBook(Book book);
    boolean removeBook(String title);
    boolean borrowBook(String title, Member member);
    void displayBookInfo(Book book);
}
