package com.sb.salonservice.mapper;

import com.sb.salonservice.model.Saloon;
import com.sb.salonservice.payload.dto.SaloonDTO;

public class SaloonMapper {

    public static SaloonDTO mapTODTO(Saloon saloon) {
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(saloon.getId());

        saloonDTO.setName(saloon.getName());
        saloonDTO.setAddress(saloon.getAddress());
        saloonDTO.setCity(saloon.getCity());
        saloonDTO.setEmail(saloon.getEmail());
        saloonDTO.setPhoneNumber(saloon.getPhoneNumber());
        saloonDTO.setImages(saloon.getImages());
        saloonDTO.setOpenTime(saloon.getOpenTime());
        saloonDTO.setCloseTime(saloon.getCloseTime());
        saloonDTO.setOwnerId(saloon.getOwnerId());
        return saloonDTO;
    }
}
