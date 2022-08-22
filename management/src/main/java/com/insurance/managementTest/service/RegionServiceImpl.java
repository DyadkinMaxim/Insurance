package com.insurance.managementTest.service;


import com.insurance.managementTest.controllers.NotFoundException;
import com.insurance.managementTest.domain.Region;
import com.insurance.managementTest.dto.RegionDTO;
import com.insurance.managementTest.repository.RegionRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.modelmapper.ModelMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService {

    public static String TYPE = "text/csv";

    private final RegionRepository regionRepository;

    private ModelMapper modelMapper;

    public RegionServiceImpl(RegionRepository regionRepository,
                             ModelMapper modelMapper
    ) {
        this.regionRepository = regionRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public RegionDTO save(@NonNull RegionDTO newRegionDTO) {
        var newRegion = regionRepository.save(modelMapper.map(newRegionDTO, Region.class));
        return modelMapper.map(newRegion, RegionDTO.class);
    }

    @Transactional
    public void saveFromCSV(InputStream inputStream) {
        List<Region> regionsFromCSV = csvToList(inputStream);
        regionRepository.saveAll(regionsFromCSV);
    }

    public List<RegionDTO> findAll() {
        return regionRepository.findAll().stream().map(
                region -> modelMapper.map(region, RegionDTO.class))
                .collect(Collectors.toList());
    }

    public RegionDTO findByPostcode(Long postcode) throws NotFoundException {
        var foundList = regionRepository.findByPostCode(postcode);
        if(foundList.isEmpty()) {
            throw new NotFoundException("No regions foudn with postcode " + postcode);
        }
        var minComparator = new Comparator<Region>() {
            @Override
            public int compare(Region r1, Region r2) {
                return r1.getFactorValue().compareTo(r2.getFactorValue());
            }
        };
        return modelMapper.map(foundList.stream().min(minComparator), RegionDTO.class);
    }

    @Transactional
    public RegionDTO update(@NonNull RegionDTO region) {
        Region savedRegion = regionRepository.findById(region.getId()).orElseThrow(
                () -> new NotFoundException("No premiums found with id " + region.getId()));
        savedRegion.setFederalState(region.getFederalState());
        savedRegion.setCounty(region.getCounty());
        savedRegion.setCity(region.getCity());
        savedRegion.setLocation(region.getLocation());
        savedRegion.setFactorValue(region.getFactorValue());
        return modelMapper.map(region, RegionDTO.class);
    }

    public boolean hasCSVFormat(MultipartFile file) {

        return TYPE.equals(file.getContentType());
    }

    public List<Region> csvToList(InputStream is) {
        try (
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())
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
                region.setFactorValue(random.nextInt(200) / 100.0);

                regions.add(region);
            }

            return regions;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public void deleteById(long regionId) {
        regionRepository.deleteById(regionId);
    }
}
