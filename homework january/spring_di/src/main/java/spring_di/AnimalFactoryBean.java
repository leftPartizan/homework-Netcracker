package spring_di;

import org.springframework.beans.factory.FactoryBean;

public class AnimalFactoryBean implements FactoryBean<Animal> {

    private String name;
    private String gender;

    @Override
    public Animal getObject() throws Exception {
        Animal animal = new Animal();
        animal.setName(name);
        animal.setGender(gender);
        return animal;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
