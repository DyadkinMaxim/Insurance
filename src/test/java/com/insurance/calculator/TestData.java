package com.insurance.calculator;

import com.insurance.calculator.domain.TypeClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {

    public static final TypeClass TYPECLASS1 = new TypeClass(-1, "Economy", 0.5);
    public static final TypeClass TYPECLASS2 = new TypeClass(-1, "Business", 1.0);
    public static final TypeClass TYPECLASS3 = new TypeClass(-1, "Truck", 1.5);
    public static final TypeClass UPDATED_TYPE_CLASS = new TypeClass(-1, "Economy", 1.0);

    public static final List<TypeClass> TYPECLASSES = new ArrayList<>(
            Arrays.asList(TYPECLASS1,
                    TYPECLASS2,
                    TYPECLASS3)
    );

    public static final long TYPE_CLASS_ID = 1L;
    public static final long MILEAGE = 100L;
    public static final String TYPE_CLASS_NAME = "Economy";
    public static final long POSTCODE = 1234;

}
