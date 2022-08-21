package com.insurance.calculator;

import com.insurance.calculator.controllers.PremiumController;
import com.insurance.calculator.repository.PremiumRepository;
import com.insurance.calculator.service.PremiumService;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static com.insurance.calculator.TestData.PREMIUMS_DTO;
import static com.insurance.calculator.TestData.PREMIUM_DTO_1;

@SpringBootTest
@Sql({"/data-test.sql"})
public class PremiumIT {

    @Autowired
    PremiumService premiumService;

    @Autowired
    PremiumRepository premiumRepository;

    @Autowired
    PremiumController premiumController;

    @Test
    public void getAllPremiums() {
        var actual = premiumController.getAllPremiums();
        Assertions.assertEquals(PREMIUMS_DTO, actual);
    }

    @Test
    public void getPremiumById() {
        var actual = premiumController.getPremiumByID(PREMIUM_DTO_1.getId());
        Assertions.assertEquals(PREMIUM_DTO_1, actual);
    }

    @Test
    @Transactional
    public void testSavePremium() {
        var actual = premiumController.savePremium(TestData.MILEAGE, TestData.TYPE_CLASS_NAME, TestData.POSTCODE);
        Assertions.assertEquals(HttpResponseStatus.OK, actual);
    }

}
