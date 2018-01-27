package Library;

public class DVD extends Library {
    boolean shiny;

    /**
     * Default constructor
     */
    public DVD(){
        super();
        this.shiny = false;
    }

    public void returnBack(){
        if(this.borrowed == true){
            this.borrowed = false;
        } else {
            System.out.println("You have not borrowed this DVD yet!");
        }

    }

    public void read(){
        System.out.println("Listening...");
    }


    /**
     * Constructor
     * @param amount amount of borrowed items
     * @param borrowed are these items borrowed?
     * @param shiny Is this DvD shiny?
     */
    public DVD(int amount, boolean borrowed, boolean shiny){
        super(amount, borrowed);
        this.shiny = shiny;
    }

    public String toString() {
        return "This is shiny DVD: " + this.shiny;
    }
}
