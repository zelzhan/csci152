package Library;

public class DVD extends Library {
    boolean shiny;
    public DVD(){
        super();
        this.shiny = false;
    }

    public DVD(int amount, boolean borrowed, boolean shiny){
        super(amount, borrowed);
        this.shiny = shiny;
    }

    public String toString() {
        return "This is shiny DVD: " + this.shiny;
    }
}
