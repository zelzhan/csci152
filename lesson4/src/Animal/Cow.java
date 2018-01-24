package Animal;

public class Cow extends AnimalImpl {
    public Cow(){
        super();
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
    public boolean canEat(String food) {
        if(food.equals("Grass")){
            return true;
        }
        return false;
    }

    public String toString(){
        return "A cow which is " + this.age + " years old\n" +
                "This cow is Ill: " + this.isIll + "\n" +
                "Is this cow is married? " + this.isMarried + "\n" +
                "Is this cow alive? " + this.isAlive + '\n';
    }
}
