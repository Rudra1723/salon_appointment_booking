package com.sb.salonservice.service;

import com.sb.salonservice.model.Saloon;
import com.sb.salonservice.payload.dto.SaloonDTO;
import com.sb.salonservice.payload.dto.UserDTO;

import java.util.List;

public interface SaloonService {

    Saloon createSaloon(SaloonDTO saloon, UserDTO user);

    Saloon updateSaloon(SaloonDTO saloon, UserDTO user, Long saloonId) throws Exception;

    List<Saloon> getAllSaloons();

    Saloon getSaloonById(Long saloonId) throws Exception;

    Saloon getSaloonByOwnerId(Long ownerId);

    List<Saloon> searchSaloonsByCityName(String city);
}
