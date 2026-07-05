package Day2;

public class Book {
    private String m_title;
    private String m_author;
    private int m_pages;
    private boolean m_isAvailable;

    public Book(String p_title, String p_author, int p_pages, boolean p_isAvailable) {
        m_title = p_title;
        m_author = p_author;
        m_pages = p_pages;
        m_isAvailable = p_isAvailable;
    }

    public void displayInfo() {
        if (m_isAvailable) {
            System.out.println("Title: " + m_title + " Author: " + m_author +
                    " Pages: " + m_pages + " Status: Available");
        } else {
            System.out.println("Title: " + m_title + " Author: " + m_author +
                    " Pages: " + m_pages + " Status: Checked Out");
        }
    }

    public void borrowBook() {
        if (!m_isAvailable) {
            System.out.println("This book is already checked out.");
        } else {
            m_isAvailable = false;
            System.out.println("Book has been borrowed.");
        }
    }

    public void returnBook() {
        System.out.println("Book has been returned");
        m_isAvailable = true;
    }

    public boolean isLongBook() {
        return m_pages > 400;
    }
}
