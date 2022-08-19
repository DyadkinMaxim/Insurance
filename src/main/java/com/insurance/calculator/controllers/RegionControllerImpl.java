package com.insurance.calculator.controllers;

import com.insurance.calculator.dao.RegionRepository;
import com.insurance.calculator.domain.Region;
import com.insurance.calculator.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RegionControllerImpl implements RegionController {

    private final RegionRepository regionRepository;
    private final RegionService regionService;

    public RegionControllerImpl(RegionRepository regionRepository,
                                RegionService regionService) {
        this.regionRepository = regionRepository;
        this.regionService = regionService;
    }

    @GetMapping("/management/regions")
    public List<Region> getAllRegions() {
        return new ArrayList<>(regionRepository.findAll());
    }

    @DeleteMapping("management/region/{id}")
    public void deleteRegion(@PathVariable(value = "id") long id) {
        regionRepository.deleteById(id);
    }

    @PutMapping("/management/region/{id}")
    @ExceptionHandler(NotFoundException.class)
    public void updateRegion(
            @RequestBody Region region
    ) {
        regionService.update(region);
    }


    @PostMapping("/management/region/newRegion")
    public void saveRegion(
            @RequestBody Region newRegion
    ) {
        regionService.save(newRegion);
    }

    @PostMapping("/management/region/newCSV")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (regionService.hasCSVFormat(file)) {
            try {
                regionService.saveFromCSV(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}