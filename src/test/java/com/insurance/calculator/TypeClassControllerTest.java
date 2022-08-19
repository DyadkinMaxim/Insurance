package com.insurance.calculator;

import com.insurance.calculator.controllers.TypeClassController;
import com.insurance.calculator.controllers.TypeClassControllerImpl;
import com.insurance.calculator.dao.TypeClassRepository;
import com.insurance.calculator.domain.TypeClass;
import com.insurance.calculator.service.TypeClassService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@JdbcTest
@Import(TypeClassControllerImpl.class)
public class TypeClassControllerTest {

    @MockBean
    TypeClassService typeClassService;

    @MockBean
    TypeClassRepository typeClassRepository;

    @Autowired
    TypeClassController typeClassController;

    @Test
    public void testFindAll() {
       when(typeClassRepository.findAll()).thenReturn(TestData.TYPECLASSES);
       List<TypeClass> actual = typeClassController.getAllTypeClasses();

       verify(typeClassRepository).findAll();
       Assertions.assertEquals(TestData.TYPECLASSES, actual);
    }

    @Test
    public void testDelete() {
        doNothing().when(typeClassRepository).deleteById(TestData.TYPE_CLASS_ID);
        typeClassController.deleteTypeClass(TestData.TYPE_CLASS_ID);

        verify(typeClassRepository).deleteById(TestData.TYPE_CLASS_ID);
    }

    @Test
    public void testUpdate() {
        when(typeClassService.update(TestData.TYPECLASS1)).thenReturn(TestData.UPDATED_TYPE_CLASS);
        TypeClass actual = typeClassController.updateTypeClass(TestData.TYPECLASS1);

        verify(typeClassService).update(TestData.TYPECLASS1);
        Assertions.assertEquals(TestData.UPDATED_TYPE_CLASS, actual);
    }

    @Test
    public void testSave() {
        when(typeClassRepository.save(TestData.TYPECLASS2)).thenReturn(TestData.TYPECLASS2);
        TypeClass actual = typeClassController.saveTypeClass(TestData.TYPECLASS2);

        verify(typeClassRepository).save(TestData.TYPECLASS2);
        Assertions.assertEquals(TestData.TYPECLASS2, actual);
    }
}