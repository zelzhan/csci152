package Animal;

public class Test {
    public static void main(String[] args){
        Animal cow = new Cow();
        Animal tiger = new Tiger();
        Animal monkey = new Monkey();

        System.out.println(cow.canEat("Meat"));
        System.out.println(tiger.canEat("Meat"));
        cow.isAlone(true);
        tiger.isIll(true);
        cow.setMaxAge(15);
        cow.ageOneYear();
        cow.ageOneYear();
        cow.ageOneYear();
        cow.ageOneYear();
        cow.ageOneYear();
        cow.ageOneYear();
        cow.ageOneYear();
        cow.ageOneYear();
        cow.ageOneYear();
        cow.ageOneYear();
        cow.ageOneYear();
        cow.ageOneYear();
        cow.ageOneYear();cow.ageOneYear();cow.ageOneYear();cow.ageOneYear();cow.ageOneYear();

        System.out.println(cow);
        System.out.println(tiger);
        System.out.println(monkey);

    }
}
