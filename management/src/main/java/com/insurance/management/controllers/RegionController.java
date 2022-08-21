package com.insurance.management.controllers;

import com.insurance.management.dto.RegionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

public interface RegionController {

    List<RegionDTO> getAllRegions();

    RegionDTO findByPostCode(long postcode);

    RegionDTO saveRegion(RegionDTO regionDTO);

    ResponseEntity<ResponseMessage> uploadFile(MultipartFile file) throws FileNotFoundException;

    RegionDTO updateRegion(RegionDTO typeClassDTO);

    void deleteRegion(long id);
}
