package Day2;

public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("Dune", "Frank Herbert", 450, false);
        Book book2 = new Book("The Very Hungry Caterpillar", "Eric Carle", 32, true);

        book1.displayInfo();
        book1.borrowBook();
        book1.returnBook();
        System.out.println("Is this book long?: " + book1.isLongBook());

        book2.displayInfo();
        book2.borrowBook();
        book2.returnBook();
        System.out.println("Is this book long?: " + book2.isLongBook());
    }
}
