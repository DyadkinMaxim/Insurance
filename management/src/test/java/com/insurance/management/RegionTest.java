package com.insurance.management;

import com.insurance.management.controllers.RegionController;
import com.insurance.management.domain.Region;
import com.insurance.management.repository.RegionRepository;
import com.insurance.management.service.RegionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.insurance.management.TestData.FILE_PATH;
import static com.insurance.management.TestData.REGIONS_DTO;
import static com.insurance.management.TestData.REGION_DTO_1;
import static com.insurance.management.TestData.REGION_FOR_SAVE;
import static com.insurance.management.TestData.REGION_FOR_UPDATE;

@SpringBootTest
@Sql({"/data-test.sql"})
public class RegionTest {
    @Autowired
    RegionService regionService;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    RegionController regionController;

    @Test
    public void testFindAll() {
        var actual = regionController.getAllRegions();
        Assertions.assertEquals(REGIONS_DTO, actual);
    }

    @Test
    public void testFindByPostcode() {
        var actual = regionController.findByPostCode(REGION_DTO_1.getPostCode());
        Assertions.assertEquals(REGION_DTO_1, actual);
    }

    @Test
    @Transactional
    public void testSave() {
        var actual = regionController.saveRegion(REGION_FOR_SAVE);
        Assertions.assertEquals(REGION_FOR_SAVE, actual);
    }

    @Test
    @Transactional
    public void testUploadCSV() throws Exception {
        Assertions.assertEquals(HttpStatus.OK, regionController.uploadFile(new MockMultipartFile(
                "postcodes", "postcodes.csv", "text/csv", new FileInputStream(new File(FILE_PATH)))).getStatusCode());
    }

    @Test
    @Transactional
    public void testUpdate() {
        var actual = regionController.updateRegion(REGION_FOR_UPDATE);
        Assertions.assertEquals(REGION_FOR_UPDATE, actual);
    }

    @Test
    public void testDelete() {
        regionController.deleteRegion(REGION_DTO_1.getId());
        Assertions.assertEquals(Optional.empty(), regionRepository.findById(REGION_DTO_1.getId()));
    }

    @Test
    @Transactional
    public void testCSVToList() {
        List<Region> regions = new ArrayList<>();
        try {
            MultipartFile file = new MockMultipartFile(
                    "postcodes.csv", new FileInputStream(new File(FILE_PATH)));
            regions = regionService.csvToList(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(22898, regions.size());
    }
}
