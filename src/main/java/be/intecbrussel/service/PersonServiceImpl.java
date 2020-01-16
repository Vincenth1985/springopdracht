package be.intecbrussel.service;

import be.intecbrussel.dao.PersonDao;
import be.intecbrussel.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("mockservice")
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;


    @Override
    public Person getPerson(int personId) {
        return personDao.readPerson(personId);
    }

    @Override
    public void addPerson(Person p) {
        personDao.createPerson(p);

    }

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public void addPersons(Person...persons) {
        for (Person person : persons) {
            personDao.createPerson(person);
        }
    }
}
