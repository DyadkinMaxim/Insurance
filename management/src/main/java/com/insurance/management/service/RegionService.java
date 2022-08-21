package com.insurance.management.service;

import com.insurance.management.domain.Region;
import com.insurance.management.dto.RegionDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface RegionService {
    RegionDTO save(RegionDTO region);

    List<RegionDTO> findAll();

    RegionDTO findByPostcode(Long postcode);

    void saveFromCSV(InputStream inputStream);

    RegionDTO update(RegionDTO region);

    boolean hasCSVFormat(MultipartFile file);

    List<Region> csvToList(InputStream is);

    void deleteById(long regionId);
}
