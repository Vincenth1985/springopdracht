package be.intecbrussel.main;

import be.intecbrussel.config.ApplicationConfig;
import be.intecbrussel.dao.PersonDaoImpl;
import be.intecbrussel.factory.PersonFactory;
import be.intecbrussel.model.Person;
import be.intecbrussel.service.PersonService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import be.intecbrussel.service.PersonServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            PersonServiceImpl personService = ctx.getBean("mockservice", PersonServiceImpl.class);

            //Getting first Person
            PersonFactory personmaker = ctx.getBean("personmaker", PersonFactory.class);

            Person person1 = personmaker.getPerson();
            person1.setLastName("Honca");
            person1.setFirstName("Vincent");
            person1.setDateOfBirth(LocalDate.of(1985, 7, 18));

            Person person2 = personmaker.getPerson();
            person2.setLastName("Bicer");
            person2.setFirstName("Elisabeth");
            person2.setDateOfBirth(LocalDate.of(1965, 4, 15));

            Person person3 = personmaker.getPerson();
            person3.setLastName("Honca");
            person3.setFirstName("Agop");
            person3.setDateOfBirth(LocalDate.of(1960, 8, 15));

            //Add Persons to database.
            System.out.println("Put peoples to database");
            System.out.println("-----------------------");
            personService.addPersons(person1,person2,person3);
            System.out.println();

            //get person with id:2
            System.out.println("Get people by id");
            System.out.println("----------------");
            System.out.println(personService.getPerson(1));
            System.out.println();

            //Create Person via DAO
            PersonDaoImpl personDao = ctx.getBean("mockDao", PersonDaoImpl.class);
            Person person4 = personmaker.getPerson();
            person4.setFirstName("Marc");
            person4.setLastName("Cilek");
            person4.setDateOfBirth(LocalDate.of(1980,4,3));
            personDao.createPerson(person4);

            //get all the persons
            System.out.println();
            System.out.println("Get all persons");
            System.out.println("----------------");
            personDao.readAll();






        }


    }
}
