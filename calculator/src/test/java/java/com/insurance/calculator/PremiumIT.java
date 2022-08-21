package java.com.insurance.calculator;

import com.insurance.calculator.controllers.PremiumController;
import com.insurance.calculator.repository.PremiumRepository;
import com.insurance.calculator.service.PremiumService;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static java.com.insurance.calculator.TestData.POSTCODE;
import static java.com.insurance.calculator.TestData.TYPE_CLASS_NAME;

@SpringBootTest
public class PremiumIT {

    @Autowired
    PremiumService premiumService;

    @Autowired
    PremiumRepository premiumRepository;

    @Autowired
    PremiumController premiumController;

    @Test
    @Transactional
    public void testSavePremium() {
        var actual = premiumController.savePremium(TestData.MILEAGE, TYPE_CLASS_NAME, POSTCODE);
        Assertions.assertEquals(HttpResponseStatus.OK, actual);
    }
}
