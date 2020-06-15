package cl.azulprofundo.technologies.javamelody;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FactorialMSTest {

    @Autowired
    private FactorialMS factorialMS;

    @Test
    public void testFactorial01() {
        for (long number = 1L; number < 100; number++) {
            long factorial = factorialMS.factorial(number);
            assertEquals(number * factorialMS.factorial(number - 1), factorial);
        }
    }
}