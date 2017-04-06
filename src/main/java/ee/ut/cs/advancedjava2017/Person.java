package ee.ut.cs.advancedjava2017;

public class Person {
    private final int idCode;
    private final String firstName;
    private final String lastName;

    public Person(int idCode, String firstName, String lastName) {
        this.idCode = idCode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIdCode() {
        return idCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (idCode != person.idCode) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        return !(lastName != null ? !lastName.equals(person.lastName) : person.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = idCode;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
