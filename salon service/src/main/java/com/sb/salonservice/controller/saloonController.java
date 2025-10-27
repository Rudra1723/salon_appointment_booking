package com.sb.salonservice.controller;

import com.sb.salonservice.mapper.SaloonMapper;
import com.sb.salonservice.model.Saloon;
import com.sb.salonservice.payload.dto.SaloonDTO;
import com.sb.salonservice.payload.dto.UserDTO;
import com.sb.salonservice.service.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saloons")
@RequiredArgsConstructor
public class saloonController {

    private final SaloonService saloonService;

    @PostMapping
    public ResponseEntity<SaloonDTO> createSaloon(@RequestBody  SaloonDTO saloonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Saloon salon = saloonService.createSaloon(saloonDTO,userDTO);
        SaloonDTO saloonDTO1 = SaloonMapper.mapTODTO(salon);
        return ResponseEntity.ok(saloonDTO1);
    }

    @PatchMapping("/{saloonId}")
    public ResponseEntity<SaloonDTO> updateSaloon(
            @PathVariable("saloonId") Long saloonId,
            @RequestBody SaloonDTO saloonDTO) throws Exception {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L); // Dummy logged-in user for testing

        Saloon salon = saloonService.updateSaloon(saloonDTO, userDTO, saloonId);
        SaloonDTO responseDTO = SaloonMapper.mapTODTO(salon);

        return ResponseEntity.ok(responseDTO);
    }


    @GetMapping
    public ResponseEntity<List<SaloonDTO>> getSaloon() throws Exception {

        List<Saloon> saloon = saloonService.getAllSaloons();

        List<SaloonDTO> saloonDTOS = saloon.stream().map((Saloon) ->
                {
                    SaloonDTO saloonDTO = SaloonMapper.mapTODTO(Saloon);
                    return saloonDTO;
                }
        ).toList();
        return ResponseEntity.ok(saloonDTOS);
    }

    @GetMapping("/{salonId}")
    public ResponseEntity<SaloonDTO> getSaloonById(@PathVariable Long salonId) throws Exception {


        Saloon salon = saloonService.getSaloonById(salonId);


        SaloonDTO salonDTO=SaloonMapper.mapTODTO(salon);

        return ResponseEntity.ok(salonDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SaloonDTO>> searchSaloons(
            @RequestParam("city") String city) throws Exception {

        List<Saloon> salons = saloonService.searchSaloonsByCityName(city);

       List<SaloonDTO> saloonDTOS = salons.stream().map((salon) ->
       {
           SaloonDTO saloonDTO = SaloonMapper.mapTODTO(salon);
           return saloonDTO;
       }
       ).toList();
        return ResponseEntity.ok(saloonDTOS);
    }

    @GetMapping("/owner")
    public ResponseEntity<SaloonDTO> getSaloonByOwnerId(
            @PathVariable Long saloonId )throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Saloon salon = saloonService.getSaloonByOwnerId(userDTO.getId());
        SaloonDTO salonDTO = SaloonMapper.mapTODTO(salon);
        return ResponseEntity.ok(salonDTO);

    }
}
