package base.interfaces;

import base.objects.Person;

import java.util.List;

public interface AddressBook {
    void add(Person person);

    void delete(Person person);

    void save(Person person);

    List<Person> getListPerson();

}
