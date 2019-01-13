package spring_di;

public class AnimalFactory {

    public static Animal createAnimal(String type){
        Animal animal = new Animal();
        animal.setGender("m");
        animal.setName(type);
        return animal;
    }
}
