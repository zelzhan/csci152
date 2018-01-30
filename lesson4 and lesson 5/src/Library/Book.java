package Library;

public class Book extends Library {
    private boolean isInteresting, heavy;

    /**
     * Default constructor
     */
    public Book() {
        super();
        this.isInteresting = false;
        this.heavy = false;
    }

    /**
     * Constructor
     * @param amount amount of borrowed books
     * @param borrowed are these books borrowed?
     * @param isInteresting is this book interesting?
     * @param heavy is this book heavy?
     */
    public Book(int amount, boolean borrowed, boolean isInteresting, boolean heavy){
        super(amount, borrowed);
        this.isInteresting = isInteresting;
        this.heavy = heavy;
    }

    public String toString() {
        return "This book is interesting:" + this.isInteresting;
    }

}
