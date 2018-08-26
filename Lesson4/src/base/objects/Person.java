package base.objects;

public class Person {
    private int idPerson;
    private String fio;
    private String birthday;
    private String address;
    private String phone;


    public Person(String fio, String birthday, String address, String phone) {
        this.fio = fio;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return fio;
    }

    public void setBirthday(String birthday) {

        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public Person() {
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
}

