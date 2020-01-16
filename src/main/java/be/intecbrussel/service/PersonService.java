package be.intecbrussel.service;

import be.intecbrussel.model.Person;

import java.util.ArrayList;
import java.util.List;

public interface PersonService {

    Person getPerson(int personId);

    void addPerson(Person p);

    void addPersons(Person...peoples);

    List<Person> allPersons = new ArrayList<>();


}
