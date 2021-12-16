package np.qa;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Это наш первый простой тест")
public class FirstSimpleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll method!");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    @BeforeEach method!");
    }

    @AfterEach
    void afterEach() {
        System.out.println("    @AfterEach method!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll method!");
    }

    @DisplayName("Простенький тест на assertEquals")
    @Test
    void firstTest() {
        System.out.println("        Простенький тест на assertEquals");
        Assertions.assertEquals(1, 1);
    }

    @DisplayName("Простенький тест на assertTrue")
    @Test
    void secondTest() {
        System.out.println("        Простенький тест на assertTrue");
        Assertions.assertTrue(7 > 6);
    }
}
