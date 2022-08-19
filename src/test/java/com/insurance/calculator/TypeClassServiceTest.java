package com.insurance.calculator;

import com.insurance.calculator.dao.TypeClassRepository;
import com.insurance.calculator.domain.TypeClass;
import com.insurance.calculator.service.TypeClassService;
import com.insurance.calculator.service.TypeClassServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
//@Import(TypeClassServiceImpl.class)
public class TypeClassServiceTest {

    @Autowired
    TypeClassService typeClassService;

    @MockBean
    TypeClassRepository typeClassRepository;

    @DisplayName("Загрузка конфигурации в контекст")
    @Test
    void contextLoads() {
        assertTrue(true);
    }

    private void assertTrue(boolean b) {
    }

    @Test
    public void testUpdate() {
        when(typeClassRepository.findById(TestData.TYPECLASS1.getId())).thenReturn(Optional.of(TestData.UPDATED_TYPE_CLASS));
        when(typeClassRepository.save(TestData.UPDATED_TYPE_CLASS)).thenReturn(TestData.UPDATED_TYPE_CLASS);
        var actual = typeClassService.update(TestData.TYPECLASS1);

        verify(typeClassRepository).findById(TestData.TYPECLASS1.getId());
        verify(typeClassRepository).save(TestData.UPDATED_TYPE_CLASS);
        Assertions.assertEquals(TestData.UPDATED_TYPE_CLASS, actual);
    }

}
