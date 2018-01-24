package Animal;

public class AnimalImpl implements Animal{
    public int age, maxAge;
    public boolean isIll, isMarried, isAlive;

    public AnimalImpl(){
        this.age = 0;
        this.isIll = false;
        this.isMarried = false;
        this.maxAge = 10;
        this.isAlive = true;
    }
    @Override
    public String animalKind() {
        return "Some Animal";
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public boolean canEat(String food) {
        return true;
    }

    @Override
    public void ageOneYear() {
        this.age++;
        if(this.age > this.maxAge){
            this.isAlive = false;
        }
    }

    @Override
    public void feed(String food) throws Exception {
        throw new Exception("Some Exception");
    }

    @Override
    public void isAlone(boolean isMarried) {
        this.isMarried = isMarried;
    }

    @Override
    public void isIll(boolean isIll) {
        this.isIll = isIll;
    }
    @Override
    public void setMaxAge(int maxAge){
        this.maxAge = maxAge;
    }
}
