package com.insurance.calculator;

import com.insurance.calculator.controllers.TypeClassController;
import com.insurance.calculator.controllers.TypeClassControllerImpl;
import com.insurance.calculator.dao.TypeClassRepository;
import com.insurance.calculator.domain.TypeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(TypeClassRepository.class)
public class TypeClassRepositoryTest {

    @Autowired
    TypeClassRepository typeClassRepository;

    @Test
    public void saveTest() {
        TypeClass newTypeClass = typeClassRepository.save(TestData.TYPECLASS1);
        assertThat(newTypeClass).hasFieldOrPropertyWithValue("className", "Economy");
        assertThat(newTypeClass).hasFieldOrPropertyWithValue("factor_value", 0.5);
    }

}
