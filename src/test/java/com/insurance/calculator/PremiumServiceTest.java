package com.insurance.calculator;

import com.insurance.calculator.dao.RegionRepository;
import com.insurance.calculator.dao.TypeClassRepository;
import com.insurance.calculator.service.PremiumService;
import com.insurance.calculator.service.PremiumServiceImpl;
import com.insurance.calculator.service.TypeClassService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = InsuranceApplication.class)
public class PremiumServiceTest {

    @Autowired
    PremiumService premiumService;

    @MockBean
    RegionRepository regionRepository;

    @MockBean
    TypeClassRepository typeClassRepository;

    @Test
    public void testSavePremium() {
        var actual = premiumService.savePremium(TestData.MILEAGE, TestData.TYPE_CLASS_NAME, TestData.POSTCODE);

        verify(regionRepository).findByPostCode(TestData.POSTCODE);
        verify(typeClassRepository).findByClassName(TestData.TYPE_CLASS_NAME);
        Assertions.assertEquals(0.22, actual);
    }
}
