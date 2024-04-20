package com.seleniumexpress.assressapp.controllers;

import com.seleniumexpress.assressapp.dto.AddressDTO;
import com.seleniumexpress.assressapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping()
    public ResponseEntity createAddress(@RequestBody AddressDTO addressDTO) {
        addressService.createAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAllAddress() {
        List<AddressDTO> addressResponse = addressService.getAllAddress();

        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<AddressDTO> getAddressByEmployeeId(@PathVariable("employeeId") int id) {

        AddressDTO addressDTO = addressService.findAddressByEmployeeId(id);

        return ResponseEntity.status(HttpStatus.OK).body(addressDTO);
    }
}
