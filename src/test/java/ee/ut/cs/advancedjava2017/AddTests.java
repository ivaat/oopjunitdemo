package ee.ut.cs.advancedjava2017;

import org.junit.Assert;
import org.junit.Test;

public class AddTests{

    @Test
    public void testAddSinglePerson() {
        SortedUniquePersonList list = new SortedUniquePersonListImpl();
        Person person = new Person(1, "TestFirst", "TestLast");
        boolean result = list.add(person);
        Assert.assertTrue(result);
        Assert.assertEquals(1, list.size());
        Assert.assertTrue(list.capacity() > 1 && list.capacity() <= 2);
    }
}
