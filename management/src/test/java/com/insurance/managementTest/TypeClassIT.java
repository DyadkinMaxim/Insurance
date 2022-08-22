package com.insurance.managementTest;

import com.insurance.managementTest.controllers.NotFoundException;
import com.insurance.managementTest.controllers.TypeClassController;
import com.insurance.managementTest.repository.TypeClassRepository;
import com.insurance.managementTest.service.TypeClassService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static com.insurance.managementTest.TestData.TYPECLASS1;
import static com.insurance.managementTest.TestData.TYPECLASSES_DTO;
import static com.insurance.managementTest.TestData.TYPECLASS_DTO_1;
import static com.insurance.managementTest.TestData.TYPECLASS_FOR_SAVE;
import static com.insurance.managementTest.TestData.TYPECLASS_FOR_UPDATE;

@SpringBootTest
@Sql({"/data-test.sql"})
public class TypeClassIT {

    @Autowired
    TypeClassService typeClassService;

    @Autowired
    TypeClassRepository typeClassRepository;

    @Autowired
    TypeClassController typeClassController;

    @Test
    public void testFindAll() {
        var actual = typeClassController.findAllTypeClasses();
        Assertions.assertEquals(TYPECLASSES_DTO, actual);
    }

    @Test
    public void testFindByClassname() {
        var actual = typeClassController.findByClassName(TYPECLASS_DTO_1.getClassName());
        Assertions.assertEquals(TYPECLASS_DTO_1, actual);
    }

    @Test
    @Transactional
    public void testSave() {
        var actual = typeClassController.saveTypeClass(TYPECLASS_FOR_SAVE);
        Assertions.assertEquals(TYPECLASS_FOR_SAVE, actual);
    }

    @Test
    @Transactional
    public void testUpdate() {
        var actual = typeClassController.updateTypeClass(TYPECLASS_FOR_UPDATE);
        Assertions.assertEquals(TYPECLASS_FOR_UPDATE, actual);
    }

    @Test
    public void testDelete() {
        typeClassController.deleteTypeClass(TYPECLASS1.getId());
        Assertions.assertThrows(NotFoundException.class, () -> typeClassController.findByClassName(TYPECLASS1.getClassName()));
    }
}