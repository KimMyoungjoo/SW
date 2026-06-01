package student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StudentManagerTest {

    static StudentManager manager;

    @BeforeAll
    static void setUp() {
        manager = new StudentManager();
    }
    
    @Test
    void testInit() {
        assertNotNull(manager);
    }

}