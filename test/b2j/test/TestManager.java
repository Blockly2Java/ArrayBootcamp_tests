package b2j.test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import b2j.wrappers.MainWrapper;
import de.tum.in.test.api.StrictTimeout;
import io.github.valentinherrmann.levenshtein.LevenshteinTest;
import static io.github.valentinherrmann.levenshtein.StructuralLevenshtein.DetailLevel.ONE_FOR_EVERYTHING;
import static io.github.valentinherrmann.levenshtein.StructuralLevenshtein.structuralTestFactory;



@LevenshteinTest
public class TestManager {


    @BeforeAll
    static void beforeAll() {
        testCompilationAndSetup();
    }

    static void testCompilationAndSetup() {
        assertThat(Tests.main).isNotNull();
        assertThat(Tests.main).isInstanceOf(MainWrapper.class);
    }
    
    @TestFactory
    List<DynamicTest> strukturTests() {
        return structuralTestFactory(
            ONE_FOR_EVERYTHING,
            Tests.main
        );
    }

    @Test
    void testMain() {
        try {
            Tests.testMain();
        }
        catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test @StrictTimeout(1)
    void testA1() {
        try {
            Tests.testA1();
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test @StrictTimeout(1)
    void testA2() {
        try {
            Tests.testA2();
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test @StrictTimeout(1)
    void testA3() {
        try {
            Tests.testA3();
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test @StrictTimeout(1)
    void testA4() {
        try {
            Tests.testA4();
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test @StrictTimeout(1)
    void testA5() {
        try {
            Tests.testA5();
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test @StrictTimeout(1)
    void testA6() {
        try {
            Tests.testA6();
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test @StrictTimeout(1)
    void testA6_simple() {
        try {
            Tests.testA6_simple();
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test @StrictTimeout(1)
    void testA7() {
        try {
            Tests.testA7();
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }
    


}    

