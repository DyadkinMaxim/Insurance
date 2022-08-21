package com.insurance.management.controllers;

import com.insurance.management.dto.RegionDTO;
import com.insurance.management.repository.RegionRepository;
import com.insurance.management.service.RegionService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class RegionControllerImpl implements RegionController {

    private final RegionService regionService;

    public RegionControllerImpl(RegionService regionService) {
        this.regionService = regionService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/management/regions")
    public List<RegionDTO> getAllRegions() {
        return regionService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/management/regions/{postcode}")
    public RegionDTO findByPostCode(@PathVariable(value = "postcode") long postcode) {
        return regionService.findByPostcode(postcode);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/management/region/newRegion")
    public RegionDTO saveRegion(
            @RequestBody RegionDTO newRegionDTO
    ) {
        var actual =  regionService.save(newRegionDTO);
        return actual;
    }

    @PostMapping("/management/region/newCSV")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

//        if (regionService.hasCSVFormat(file)) {
            try {
                regionService.saveFromCSV(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        //}

//        message = "Please upload a csv file!";
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/management/region/{id}")
    public RegionDTO updateRegion(
            @RequestBody RegionDTO regionDTO
    ) {
        return regionService.update(regionDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("management/region/{id}")
    public void deleteRegion(@PathVariable(value = "id") long id) {
        regionService.deleteById(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Throwable ex) {
        // For any exceptions
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}