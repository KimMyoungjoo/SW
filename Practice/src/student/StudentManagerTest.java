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
    
    // 학생 추가 테스트
    @Test
    @Order(1)
    void testAddStudent() {

        manager.addStudent("Kim");

        assertTrue(manager.hasStudent("Kim"));
    }
    
 // 중복 학생 추가 예외 테스트
    @Test
    @Order(3)
    void testDuplicateStudent() {

        manager.addStudent("Park");

        assertThrows(IllegalArgumentException.class, () -> {
            manager.addStudent("Park");
        });
    }
    
    // 존재하지 않는 학생 제거 예외 테스트
    @Test
    @Order(4)
    void testRemoveNonExistingStudent() {

        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeStudent("Choi");
        });
    }
}