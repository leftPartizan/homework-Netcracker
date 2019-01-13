package spring_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
@ComponentScan(basePackages = {"spring_di"})
public class MyConfiguration {


    @Value("10")
    int level;

    @Bean
    public List<String> enemyDovakinList() {
        return Arrays.asList("Алдуин", "фалмеры", "драконы", "великаны");
    }

    @Bean
    public Staff staff1(){
        Staff staff = new Staff();
        staff.setName("Ваббаджек ");
        staff.setDamage_radius(5);
        staff.setDescription("Луч Ваббаджека оказывает непредсказуемый эффект");
        staff.setLevel(level);
        return staff;
    }

    @Bean
    public Staff staff2(){
        Staff staff = new Staff();
        staff.setName("посох Магнуса");
        staff.setDamage_radius(15);
        staff.setDescription("Поглощает 20 ед. магии в секунду. Если у жертвы не осталось магии, " +
                "поглощает вместо неё здоровье");
        staff.setLevel(50);
        return staff;
    }


    @Bean
    public Archmage Dovakin() {
        Archmage archmage = new Archmage(staff2(), level);
        archmage.setName("довакин");
        archmage.setStaff(staff2());
        archmage.setEnemy(enemyDovakinList());

        return archmage;
    }

    @Bean
    public Archmage Sheogarat() {
        Archmage archmage = new Archmage();
        archmage.setName("Шеогорат");
        archmage.setStaff(staff1());
        return archmage;
    }

}
