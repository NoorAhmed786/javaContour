public class Book {
    private String author;
    private String title;
    private int quantity;

    public Book(String author, String title, int quantity) {
        this.author = author;
        this.title = title;
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
