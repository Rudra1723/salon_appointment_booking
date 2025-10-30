package com.sb.service_offering.controller;


import com.sb.service_offering.model.ServiceOffering;
import com.sb.service_offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/service-offering")
@RequiredArgsConstructor
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @GetMapping("/salon/{saloonId}")
    public ResponseEntity<Set<ServiceOffering>> getServiceBySaloonId(
            @PathVariable Long saloonId,
            @RequestParam(required = false) Long categoryId
    ) {
        Set<ServiceOffering> serviceOfferings = serviceOfferingService
                .getAllServiceBySalonId(saloonId, categoryId);
        return ResponseEntity.ok(serviceOfferings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOffering> getServiceById(
            @PathVariable Long id

    ) throws Exception {
        ServiceOffering serviceOffering = serviceOfferingService
                .getServiceById(id);
        return ResponseEntity.ok(serviceOffering);
    }

    @GetMapping("/list/{ids}")
    public ResponseEntity<Set<ServiceOffering>> getServicesByIds(
            @PathVariable Set<Long> ids) {
        Set<ServiceOffering> services = serviceOfferingService
                .getAllServiceByIds(ids);

        return ResponseEntity.ok(services);
    }
}
