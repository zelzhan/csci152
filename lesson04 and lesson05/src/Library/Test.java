package Library;

public class Test {
    public static void main(String[] args){
        Library material = new Book(5, true, true, false);
        material.read();
        System.out.println(material);
        System.out.println(material.isBorrowed());

    }
}

