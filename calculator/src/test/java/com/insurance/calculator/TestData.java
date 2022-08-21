package com.insurance.calculator;

import com.insurance.calculator.dto.PremiumDTO;
import com.insurance.calculator.dto.UserEntryDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class TestData {

    public static final PremiumDTO PREMIUM_DTO_1 = new PremiumDTO(1, 0.5, 1.0, 1, 1);
    public static final PremiumDTO PREMIUM_DTO_2 = new PremiumDTO(2, 2.5, 2.0, 2, 2);
    public static final PremiumDTO PREMIUM_DTO_3 = new PremiumDTO(3, 3.5, 3.0, 3, 3);
    public static final List<PremiumDTO> PREMIUMS_DTO = Collections.unmodifiableList(
            Arrays.asList(PREMIUM_DTO_1,
                    PREMIUM_DTO_2,
                    PREMIUM_DTO_3)
    );

    public static final UserEntryDTO USER_ENTRY_DTO = new UserEntryDTO(100L, "Business", 1234);
}
