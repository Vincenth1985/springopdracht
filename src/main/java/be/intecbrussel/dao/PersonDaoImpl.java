package be.intecbrussel.dao;

import be.intecbrussel.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("mockDao")
public class PersonDaoImpl implements PersonDao {

    private List<Person> personDb;

    @Override
    public boolean createPerson(Person p) {

        boolean inList = (personDb.stream().anyMatch(person -> person.getIdPerson() == p.getIdPerson()));
        if (inList) {
            System.out.print("Person object with id : " + p.getIdPerson() + " is already in Database");
            return false;
        } else {
            System.out.print("Person object with id : " + p.getIdPerson() + " is constructed :");
            return personDb.add(p);
        }
    }

    @Override
    public Person readPerson(int id) {
        return personDb.get(id);
    }

    @Autowired
    public void setPersonDb(List<Person> personDb) {
        this.personDb = personDb;
    }

    @Override
    public boolean updatePerson(Person p) {
        return false;
    }

    @Override
    public boolean deletePerson(Person p) {
        boolean inList = (personDb.stream().anyMatch(person -> person.getIdPerson() == p.getIdPerson()));
        if (inList) {
            personDb.remove(p);
            System.out.println("Person is deleted from database.");
            return true;
        } else {
            System.out.println("Person is not in list");
            return false;
        }

    }

    @Override
    public void readAll() {
        for (Person person : personDb) {
            if (person.getIdPerson() == 0) {
                continue;
            }
            System.out.println(person);
        }

    }
}
