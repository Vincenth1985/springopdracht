package be.intecbrussel.factory;

import be.intecbrussel.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("personmaker")
public class PersonFactory {
    static int x = 0;


    @Bean
    @Scope(scopeName = "prototype")
    public Person getPerson() {
        Person person = new Person();
        person.setIdPerson(x++);
        return person;
    }


}
