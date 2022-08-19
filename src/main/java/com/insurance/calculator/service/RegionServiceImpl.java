package com.insurance.calculator.service;

import com.insurance.calculator.controllers.NotFoundException;
import com.insurance.calculator.dao.RegionRepository;
import com.insurance.calculator.domain.Region;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RegionServiceImpl implements RegionService {

    public static String TYPE = "text/csv";

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Transactional
    public Region save(@NonNull Region newRegion) {
        regionRepository.save(newRegion);
        return newRegion;
    }

    @Transactional
    public void saveFromCSV(MultipartFile file) {
        try {
            List<Region> regionsFromCSV = csvToList(file.getInputStream());
            regionRepository.saveAll(regionsFromCSV);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    @Transactional
    public Region update(@NonNull Region region) {
        Region savedRegion = regionRepository.findById(region.getId()).orElseThrow(NotFoundException::new);
        savedRegion.setFederalState(region.getFederalState());
        savedRegion.setCounty(region.getCounty());
        savedRegion.setCity(region.getCity());
        savedRegion.setLocation(region.getLocation());
        savedRegion.setFactorValue(region.getFactorValue());
        return savedRegion;
    }

    public boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public List<Region> csvToList(InputStream is) {
        try (
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        ) {

            List<Region> regions = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            Random random = new Random();
            for (CSVRecord csvRecord : csvRecords) {
                Region region = new Region();
                region.setFederalState(csvRecord.get("REGION1"));
                region.setCounty(csvRecord.get("REGION3"));
                region.setCity(csvRecord.get("REGION4"));
                region.setPostCode(Long.parseLong(csvRecord.get("POSTLEITZAHL").replaceAll("\"", "")));
                region.setLocation(csvRecord.get("AREA1"));
                region.setFactorValue(random.nextDouble() * 2);

                regions.add(region);
            }

            return regions;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
