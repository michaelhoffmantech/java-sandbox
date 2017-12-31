package com.michaelhoffmantech.javasandbox.customspliterator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CreatingSpliteratorTest {

    private CreatingSpliterator spliterator = new CreatingSpliterator();

    @Test
    public void test_run_success() throws Exception {
        List<PersonModel> people = spliterator.run();
        assertNotNull(people);
        assertEquals(5, people.size());
        for (PersonModel person : people) {
        	System.err.println(person.getName() + " | " + person.getAge() + " | " + person.getCity());
        }
    }
}
