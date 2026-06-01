package student;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class StudentManagerTest {

    private static StudentManager manager;

    @BeforeAll
    static void setUp() {
        manager = new StudentManager();
    }

    @Test
    @Order(1)
    void shouldAddStudent() {
        manager.addStudent("Kim");

        assertTrue(manager.hasStudent("Kim"));
    }

    @Test
    @Order(2)
    void shouldRemoveStudent() {
        manager.addStudent("Lee");

        manager.removeStudent("Lee");

        assertFalse(manager.hasStudent("Lee"));
    }

    @Test
    @Order(3)
    void shouldThrowExceptionWhenAddingDuplicateStudent() {
        manager.addStudent("Park");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> manager.addStudent("Park")
        );

        assertEquals("이미 존재하는 학생입니다: Park", exception.getMessage());
    }

    @Test
    @Order(4)
    void shouldThrowExceptionWhenRemovingNonExistingStudent() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> manager.removeStudent("Choi")
        );

        assertEquals("존재하지 않는 학생입니다: Choi", exception.getMessage());
    }
}