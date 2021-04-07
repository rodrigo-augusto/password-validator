package br.com.password.validator.application;

import br.com.password.validator.application.business.Rule0001;
import br.com.password.validator.application.exception.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Rule0001Test {

    @Autowired
    @InjectMocks
    private Rule0001 rn0001;

    @Test
    void testSuccess() {
        rn0001.execute("AbTp9!fok");
    }

    @Test
    void testFailSituation0001() {
        Assertions.assertThrows(BusinessException.class, () -> rn0001.execute(""));
    }

    @Test
    void testFailSituation0002() {
        Assertions.assertThrows(BusinessException.class, () -> rn0001.execute("aa"));
    }

    @Test
    void testFailSituation0003() {
        Assertions.assertThrows(BusinessException.class, () -> rn0001.execute("ab"));
    }

    @Test
    void testFailSituation0004() {
        Assertions.assertThrows(BusinessException.class, () -> rn0001.execute("AAAbbbCc"));
    }

    @Test
    void testFailSituation0005() {
        Assertions.assertThrows(BusinessException.class, () -> rn0001.execute("AbTp9!foo"));
    }

    @Test
    void testFailSituation0006() {
        Assertions.assertThrows(BusinessException.class, () -> rn0001.execute("AbTp9!foA"));
    }

    @Test
    void testFailSituation0007() {
        Assertions.assertThrows(BusinessException.class, () -> rn0001.execute("AbTp9 fok"));
    }

}
