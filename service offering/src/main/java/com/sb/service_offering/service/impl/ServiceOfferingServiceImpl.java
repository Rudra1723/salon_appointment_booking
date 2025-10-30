package com.sb.service_offering.service.impl;

import com.sb.service_offering.dto.CategoryDTO;
import com.sb.service_offering.dto.SaloonDTO;
import com.sb.service_offering.dto.ServiceDTO;
import com.sb.service_offering.model.ServiceOffering;
import com.sb.service_offering.repository.ServiceOfferingRepository;
import com.sb.service_offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements ServiceOfferingService {

    private final ServiceOfferingRepository serviceOfferingRepository;

    @Override
    public ServiceOffering createService(SaloonDTO saloonDTto, ServiceDTO serviceDTO, CategoryDTO categoryDTO) {

       ServiceOffering serviceOffering = new ServiceOffering();
       serviceOffering.setSaloonId(saloonDTto.getId());
       serviceOffering.setCategoryId(categoryDTO.getId());
       serviceOffering.setName(serviceDTO.getName());
       serviceOffering.setDescription(serviceDTO.getDescription());
       serviceOffering.setPrice(serviceDTO.getPrice());
       serviceOffering.setImage(serviceDTO.getImage());
       serviceOffering.setId(serviceDTO.getId());
       serviceOffering.setDuration(serviceDTO.getDuration());

        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception {

        ServiceOffering serviceOffering1 = serviceOfferingRepository.findById(serviceId).orElse(null);

        if(serviceOffering1 == null){
            throw new Exception("service not exist with id "+serviceId);
        }


        serviceOffering1.setName(service.getName());
        serviceOffering1.setDescription(service.getDescription());
        serviceOffering1.setPrice(service.getPrice());
        serviceOffering1.setImage(service.getImage());
        serviceOffering1.setDuration(service.getDuration());

        return serviceOfferingRepository.save(serviceOffering1);
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySaloonId(Long salonId,
                                                        Long categoryId) {
        Set<ServiceOffering> services = serviceOfferingRepository.findBySaloonId(salonId);
        if(categoryId != null) {
            services=services.stream()
                    .filter(service -> service.getCategoryId() != null && service.getCategoryId().equals(categoryId))
                    .collect(Collectors.toSet());
        }

        return services;
    }


    @Override
    public Set<ServiceOffering> getAllServiceBySalonId(Long saloonId, Long categoryId) {
        Set<ServiceOffering> services = serviceOfferingRepository.findBySaloonId(saloonId);
        if(categoryId != null) {
            services=services.stream()
                    .filter(service -> service.getCategoryId() != null && service.getCategoryId().equals(categoryId))
                    .collect(Collectors.toSet());
        }
        return services;
    }

    @Override
    public Set<ServiceOffering> getAllServiceByIds(Set<Long> ids) {
        List<ServiceOffering> services = serviceOfferingRepository
                .findAllById(ids);
        return new HashSet<>(services);
    }

    @Override
    public ServiceOffering getServiceById(Long id) throws Exception {
        ServiceOffering serviceOffering = serviceOfferingRepository.findById(id).orElse(null);

        if(serviceOffering == null){
            throw new Exception("service not exist with id " +id);
        }
        return serviceOffering;
    }
}
