package Library;

public class Book extends Library {
    private boolean isInteresting, heavy;

    public Book() {
        super();
        this.isInteresting = false;
        this.heavy = false;
    }
    public Book(int amount, boolean borrowed, boolean isInteresting, boolean heavy){
        super(amount, borrowed);
        this.isInteresting = isInteresting;
        this.heavy = heavy;
    }

    public String toString() {
        return "This book is interesting:" + this.isInteresting;
    }

}
