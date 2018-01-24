package Library;

public class Library {
    int amount;
    boolean borrowed;

    /**
     * Basic constructor which sets the values when there is no arguments
     */
    public Library(){
        this.amount = 0;
        this.borrowed = false;
    }

    /**
     * Another constructor, which sets appropriate values when they are provided
     * @param amount
     * @param borrowed
     */
    public Library(int amount, boolean borrowed){
        this.amount = amount;
        this.borrowed = borrowed;
    }

    /**
     * Prints the line "Reading..."
     */
    public void read(){
        System.out.println("Reading...");
    }

    /**
     * If book is not borrowed, sets the value of "borrowed" field to the true and returns error if this is not true
     */
    public void borrow(){
        if (this.borrowed == false){
            this.borrowed = true;
        } else {
            System.out.println("You've already borrowed this boook!");
        }

    }

    /**
     * If book is  borrowed, sets the value of "borrowed" field to the false and returns error if this is not true
     */
    public void returnBack(){
        if(this.borrowed == true){
            this.borrowed = false;
        } else {
            System.out.println("You have not borrowed this book yet!");
        }

    }

    /**
     * getter
     * @return the value of "borrowed" field
     */
    public boolean isBorrowed() {
        return borrowed;
    }

    /**
     * getter
     * @return amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * overrided method toString()
     * @return some string
     */
    public String toString() {
        return "Amount of borrowed materials: " + this.amount;
    }
}
