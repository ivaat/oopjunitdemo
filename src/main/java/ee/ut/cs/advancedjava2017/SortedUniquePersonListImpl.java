package ee.ut.cs.advancedjava2017;

public class SortedUniquePersonListImpl implements SortedUniquePersonList {
    private Person[] persons = new Person[0];
    private int size = 0;

    public Person getElementAt(int index) {
        if (index >= size) {
            return null;
        }
        return persons[index];
    }

    public int indexOf(int idCode) {
        for (int i = 0; i < size; i++) {
            if (persons[i].getIdCode() == idCode) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(Person person) {
        for (int i = 0; i < size; i++) {
            if (persons[i].getFirstName().equals(person.getFirstName()) &&
                persons[i].getLastName().equals(person.getLastName())) {
                  return i;
            }
        }
        return -1;
    }

    public boolean add(Person person) {
        boolean wasResized = (size == persons.length);
        Person[] target = (wasResized) ? new Person[(size+1) * 2] : persons;

        Integer personInsertIndex = null;
        for (int i = 0; i < size; i++) {
            if (person.getIdCode() < persons[i].getIdCode()) {
                personInsertIndex = i;
                break;
            }
        }
        if (personInsertIndex == null) {
            if (wasResized) {
                System.arraycopy(persons, 0, target, 0, size);
            }
            target[size] = person;
        }
        else {
            if (personInsertIndex != 0 && wasResized) {
                System.arraycopy(persons, 0, target, 0, personInsertIndex);
            }
            System.arraycopy(persons, personInsertIndex, target, personInsertIndex+1, (size-personInsertIndex));
            target[personInsertIndex] = person;
        }

        if (wasResized) {
            persons = target;
        }

        size++;
        return true;
    }

    public boolean removeElement(int idCode) {
        int index = indexOf(idCode);
        if (index == -1) {
            return false;
        }

        boolean wasResized = (size-1) * 2 < persons.length;
        Person[] target = wasResized ? new Person[(size-1) * 2] : persons;
        if (wasResized && index > 0) {
            System.arraycopy(persons, 0, target, 0, index);
        }
        int remainder = (size-1) - index;
        if (remainder != 0) {
            System.arraycopy(persons, index+1, target, index, remainder);
        }

        if (wasResized) {
            persons = target;
        }

        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return persons.length;
    }

    public void forceSetCapacity(int capacity) throws Exception {
        if (capacity >= 0 && capacity < size) {
            throw new Exception("Incorrect forced capacity. Capacity: " + capacity + ", size:" + size);
        }
        Person[] tmp = new Person[capacity];
        System.arraycopy(persons, 0, tmp, 0, size);
        persons = tmp;
    }
}