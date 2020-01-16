package be.intecbrussel.dao;

import be.intecbrussel.model.Person;

public interface PersonDao {

    boolean createPerson(Person p);

    Person readPerson(int id);

    boolean updatePerson(Person p);

    boolean deletePerson(Person p);

    void readAll();



}
