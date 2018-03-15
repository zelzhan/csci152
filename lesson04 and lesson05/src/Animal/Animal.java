package Animal;

public interface Animal {

    /**
     * Returns the kind of animal
     * @return the kind of animal
     */
    public String animalKind();

    /**
     * Returns current age of animal
     * @return age of animal
     */

    public int getAge();

    /**
     * If the animal can eat returns true
     * @param food - name of food
     * @return whether or nor the animal can eat the following food
     */

    public boolean canEat(String food);

    /**
     * Increment the age by 1 year
     */
    public void ageOneYear();

    /**
     * Trying to feed the animal with provided food
     * @param food The food to be fed to the animal
     * @throws Exception If the animal cannot eat the following food
     */
    public void feed(String food) throws Exception;

    /**
     * Returns true if animal is sick, false otherwise
     * @return animal's condition
     */
    public void isIll(boolean isIll);

    /**
     * Returns true if animal is alone, false otherwise
     * @return animal's marital status
     */
    public void isAlone(boolean isMarried);

//    /**
//     * Sets manually maxAge
//     * @param maxAge to which the maxAge will be set
//     */
//    public void setMaxAge(int maxAge);

}
