package com.insurance.calculator;

import com.insurance.calculator.dao.RegionRepository;
import com.insurance.calculator.domain.Region;
import com.insurance.calculator.domain.TypeClass;
import com.insurance.calculator.service.RegionService;
import com.insurance.calculator.service.RegionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@JdbcTest
@Import(RegionServiceImpl.class)
public class RegionServiceTest {
    @Autowired
    RegionService regionService;

    @MockBean
    RegionRepository regionRepository;

    @Test
    public void testCSVToList() {
        List<Region> regions = new ArrayList<>();
        try {
            MultipartFile file = new MockMultipartFile(
                    "postcodes.csv", new FileInputStream(new File("src/test/resources/postcodes.csv")));
            regions = regionService.csvToList(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(22898, regions.size());
    }
}
