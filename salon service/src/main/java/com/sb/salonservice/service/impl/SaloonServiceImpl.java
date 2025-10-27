package com.sb.salonservice.service.impl;

import com.sb.salonservice.model.Saloon;
import com.sb.salonservice.payload.dto.SaloonDTO;
import com.sb.salonservice.payload.dto.UserDTO;
import com.sb.salonservice.repository.SaloonRepository;
import com.sb.salonservice.service.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaloonServiceImpl implements SaloonService {


    private final SaloonRepository saloonRepository;
    @Override
    public Saloon createSaloon(SaloonDTO req, UserDTO user) {
        Saloon saloon = new Saloon();
        saloon.setName(req.getName());
        saloon.setAddress(req.getAddress());
        saloon.setEmail(req.getEmail());
        saloon.setCity(req.getCity());
        saloon.setImages(req.getImages());
        saloon.setOwnerId(user.getId());
        saloon.setOpenTime(req.getOpenTime());
        saloon.setCloseTime(req.getCloseTime());
        saloon.setPhoneNumber(req.getPhoneNumber());
        return saloonRepository.save(saloon);
    }

    @Override
    public Saloon updateSaloon(SaloonDTO saloon, UserDTO user, Long saloonId) throws Exception {

        Saloon existingSaloon = saloonRepository.findById(saloonId).orElse(null);
        if(existingSaloon != null && saloon.getOwnerId().equals(user.getId())) {
            existingSaloon.setCity(saloon.getCity());
            existingSaloon.setName(saloon.getName());
            existingSaloon.setImages(saloon.getImages());
            existingSaloon.setAddress(saloon.getAddress());
            existingSaloon.setEmail(saloon.getEmail());
            existingSaloon.setOpenTime(saloon.getOpenTime());
            existingSaloon.setCloseTime(saloon.getCloseTime());
            existingSaloon.setPhoneNumber(saloon.getPhoneNumber());
            existingSaloon.setOwnerId(user.getId());

            return  saloonRepository.save(existingSaloon);

        }
       throw new Exception("salon not exist");
    }

    @Override
    public List<Saloon> getAllSaloons() {
        return saloonRepository.findAll();
    }

    @Override
    public Saloon getSaloonById(Long saloonId) throws Exception {
        Saloon saloon = saloonRepository.findById(saloonId).orElse(null);
        if( saloon==null){
            throw new Exception("saloon is not exists.");
        }
        return saloon;
    }

    @Override
    public Saloon getSaloonByOwnerId(Long ownerId) {
        return saloonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Saloon> searchSaloonsByCityName(String city) {
        return saloonRepository.searchSaloon(city);
    }
}
