package Animal;

public class Tiger extends AnimalImpl{

    public Tiger(){
        super();
    }
    @Override
    public String animalKind() {
        return "Tiger";
    }

    @Override
    public boolean canEat(String food) {
        if(food.equals("Meat")){
            return true;
        }
        return false;
    }

    @Override
    public void feed(String food) throws Exception {
        if(!this.canEat(food)){
            throw new Exception("Tigers cannot eat the " + food);
        }
        System.out.println("MUNCH, MUNCH!!!");
    }



    public String toString(){
        return "A Tiger which is " + this.age + " years old\n" +
                "This Tiger is Ill: " + this.isIll + "\n" +
                "Is this Tiger  married? " + this.isMarried + "\n" +
                "Is this Tiger is alive? " + this.isAlive + "\n";
    }
}
