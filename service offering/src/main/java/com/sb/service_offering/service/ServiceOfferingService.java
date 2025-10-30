package com.sb.service_offering.service;

import com.sb.service_offering.dto.CategoryDTO;
import com.sb.service_offering.dto.SaloonDTO;
import com.sb.service_offering.dto.ServiceDTO;
import com.sb.service_offering.model.ServiceOffering;


import java.util.Set;


public interface ServiceOfferingService {

    ServiceOffering createService(SaloonDTO saloonDTto,
                                  ServiceDTO  serviceDTO,
                                  CategoryDTO categoryDTO);

    ServiceOffering updateService(Long serviceId, ServiceOffering serviceOffering) throws Exception;

    Set<ServiceOffering> getAllServiceBySaloonId(Long saloonId, Long categoryId);

    Set<ServiceOffering> getAllServiceBySalonId(Long saloonId, Long categoryId);

    Set<ServiceOffering> getAllServiceByIds(Set<Long> ids);

    ServiceOffering getServiceById(Long id) throws Exception;

}
