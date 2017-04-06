package ee.ut.cs.advancedjava2017;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class CapacityTests {

    @Before
    public void init() {
        //not needed here, just for show
    }

    @After
    public void tearDown() {
        //not needed here, just for show
    }

    @Test
    public void testEmptyListCapacity() {
        SortedUniquePersonList list = new SortedUniquePersonListImpl();
        //empty list must have capacity 0
        Assert.assertEquals(0, list.capacity());
        //add 10 people
        for (int i = 0; i < 10; i++) {
            list.add(new Person(i, "TestFirst", "TestLast"));
        }
        //assert that capacity between 10 and 20 (incl)
        Assert.assertTrue(list.capacity() >= 10 && list.capacity() <= 20);
        //remove 5 persons
        for (int i = 0; i < 5; i++) {
            list.removeElement(i);
        }
        //assert that capacity between 5 and 10 (incl)
        Assert.assertTrue(list.capacity() >= 5 && list.capacity() <= 10);
        //remove 5 persons - list should be empty now
        for (int i = 5; i < 10; i++) {
            list.removeElement(i);
        }
        //empty list must have capacity 0
        Assert.assertEquals(0, list.capacity());
    }

    @Test(expected=Exception.class)
    public void testForcedZeroCapacity() throws Exception {
        SortedUniquePersonList list = new SortedUniquePersonListImpl();
        list.add(new Person(1, "TestFirst", "TestLast"));
        list.forceSetCapacity(0);
    }
}