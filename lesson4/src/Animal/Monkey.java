package Animal;

public class Monkey extends AnimalImpl{
    public Monkey(){
        super();
    }

    @Override
    public String animalKind() {
        return "Monkey";
    }

    @Override
    public void feed(String food) throws Exception {
        if(!this.canEat(food)){
            throw new Exception("Monkeys cannot eat the " + food);
        }
        System.out.println("Nyam, nyam, nyam");
    }

    @Override
    public boolean canEat(String food) {
        if(food.equals("Banana")){
            return true;
        }
        return false;
    }

    public String toString(){
        return "A Monkey which is " + this.age + " years old\n" +
                "This Monkey is Ill: " + this.isIll + "\n" +
                "Is this Monkey is married? " + this.isMarried + "\n" +
                "Is this Monkey alive? " + this.isAlive + '\n';
    }
}
