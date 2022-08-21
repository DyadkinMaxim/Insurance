package com.insurance.management;

import com.insurance.management.domain.TypeClass;
import com.insurance.management.dto.RegionDTO;
import com.insurance.management.dto.TypeClassDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestData {

    public static final TypeClass TYPECLASS1 = new TypeClass(1, "Business", 1.0);
    public static final TypeClassDTO TYPECLASS_DTO_1 = new TypeClassDTO(1, "Business", 1.0);
    public static final TypeClassDTO TYPECLASS_DTO_2 = new TypeClassDTO(2, "Truck", 1.5);
    public static final TypeClassDTO TYPECLASS_DTO_3 = new TypeClassDTO(3, "Comfort", 2.5);
    public static final TypeClassDTO TYPECLASS_FOR_SAVE = new TypeClassDTO(4, "Economy", 0.5);
    public static final TypeClassDTO TYPECLASS_FOR_UPDATE = new TypeClassDTO(1, "Updated", 3.5);
    public static final List<TypeClassDTO> TYPECLASSES_DTO = Collections.unmodifiableList(
            Arrays.asList(TYPECLASS_DTO_1,
                    TYPECLASS_DTO_2,
                    TYPECLASS_DTO_3)
    );

    public static final RegionDTO REGION_DTO_1 = new RegionDTO(1, "Federal1", "County1", "City1", 1234L, "Location1", 1.0);
    public static final RegionDTO REGION_DTO_2 = new RegionDTO(2, "Federal2", "County2", "City2", 1235L, "Location2", 2.0);
    public static final RegionDTO REGION_DTO_3 = new RegionDTO(3, "Federal3", "County3", "City3", 1236L, "Location3", 3.0);
    public static final RegionDTO REGION_DTO_4 = new RegionDTO(4, "Federal4", "County4", "City4", 1234L, "Location4", 4.0);
    public static final RegionDTO REGION_FOR_SAVE = new RegionDTO(5, "Federa4", "County4", "City4", 1237L, "Location4", 4.0);
    public static final RegionDTO REGION_FOR_UPDATE = new RegionDTO(1, "Updated", "Updated", "Updated", 1L, "Updated", 1.0);
    public static final List<RegionDTO> REGIONS_DTO = Collections.unmodifiableList(
            Arrays.asList(REGION_DTO_1,
                    REGION_DTO_2,
                    REGION_DTO_3,
                    REGION_DTO_4)
    );

    public static final String FILE_PATH = "src/test/java/resources/postcodes.csv";

}
