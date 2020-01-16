package be.intecbrussel.model;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int idPerson;


    @Override
    public String toString() {
        return String.format("Person firstName = %-10s , lastName = %s , dateOfBirth = %2s, idPerson : %2d", firstName, lastName, dateOfBirth, idPerson);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = ( Person ) o;
        return idPerson == person.idPerson &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, idPerson);
    }

    public int getIdPerson() {
        return idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }


}
