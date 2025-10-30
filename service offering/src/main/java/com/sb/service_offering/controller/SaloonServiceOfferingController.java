package com.sb.service_offering.controller;

import com.sb.service_offering.dto.CategoryDTO;
import com.sb.service_offering.dto.SaloonDTO;
import com.sb.service_offering.dto.ServiceDTO;
import com.sb.service_offering.model.ServiceOffering;
import com.sb.service_offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/service-offering/saloon-owner")
@RequiredArgsConstructor
public class SaloonServiceOfferingController {
    private final ServiceOfferingService serviceOfferingService;
    @PostMapping()
    public ResponseEntity<ServiceOffering> createService(
            @RequestBody ServiceDTO serviceDTO
    ) {
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategory());

        ServiceOffering serviceOfferings = serviceOfferingService
                .createService(saloonDTO,serviceDTO,categoryDTO);
        return ResponseEntity.ok(serviceOfferings);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long id,
            @RequestBody ServiceOffering serviceOffering
    ) throws Exception {
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1L);

        ServiceOffering serviceOfferings = serviceOfferingService
                .updateService(id,serviceOffering);
        return ResponseEntity.ok(serviceOfferings);
    }



}
