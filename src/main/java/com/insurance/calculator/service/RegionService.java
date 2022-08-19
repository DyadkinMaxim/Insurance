package com.insurance.calculator.service;

import com.insurance.calculator.domain.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface RegionService {
    Region save(Region region);

    void saveFromCSV(MultipartFile file);

    Region update(Region region);

    boolean hasCSVFormat(MultipartFile file);

    List<Region> csvToList(InputStream is);
}
