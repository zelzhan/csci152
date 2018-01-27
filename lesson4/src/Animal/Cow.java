package Animal;

public class Cow extends AnimalImpl {
    private int maxAge;
    public Cow(){
        super();
        this.maxAge = 20;
    }

    public Cow(int maxAge){
        super();
        this.maxAge = maxAge;
    }

    @Override
    public String animalKind() {
        return "Cow";
    }

    @Override
    public void feed(String food) throws Exception {
        if(!this.canEat(food)){
            throw new Exception("Cows cannot eat the " + food);
        }
        System.out.println("Chew, chew, chew");
    }

    @Override
    public void ageOneYear() {
        this.age++;
        if(this.age > this.maxAge){
            this.isAlive = false;
        }
    }

    @Override
    public boolean canEat(String food) {
        if(food.equals("Grass")){
            return true;
        }
        return false;
    }

    public String toString(){
        return "A cow which is " + this.age + " years old\n" +
                "This cow is Ill: " + this.isIll + "\n" +
                "Is this cow married? " + this.isMarried + "\n" +
                "Is this cow alive? " + this.isAlive + '\n';
    }
}
