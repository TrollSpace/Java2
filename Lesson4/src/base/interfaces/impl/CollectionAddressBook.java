package base.interfaces.impl;

import base.interfaces.AddressBook;
import base.objects.Person;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CollectionAddressBook implements AddressBook {
    private List<Person> baseBook;
    private static String SERIALIZED_FILE = "TestDateBase.xml";

    public List<Person> getListPerson() {
        return baseBook;
    }
    public void add(Person person) {
        baseBook.add(person);
        save(person);
    }

    public void delete(Person person) {
        baseBook.remove(person);
        save(person);

    }

    public CollectionAddressBook() {
        baseBook = new ArrayList<Person>();
        loadList();
    }

    private void loadList() {
        XMLDecoder decoder = null;//select
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE)));
            baseBook.addAll((List) decoder.readObject());

        } catch (FileNotFoundException e) {
        }


    }

    public void save(Person person) {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE)));
        } catch (FileNotFoundException fileNotFound) {
            System.err.println("ERROR: Can't save file!");
        }
        encoder.writeObject(baseBook);
        encoder.close();
    }

//    public static void main(String[] args) {
//        CollectionAddressBook db = new CollectionAddressBook();
//        db.save();
//    }

}
