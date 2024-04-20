package com.seleniumexpress.assressapp.service;

import com.seleniumexpress.assressapp.dto.AddressDTO;
import com.seleniumexpress.assressapp.entity.Address;
import com.seleniumexpress.assressapp.repo.AddressRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepo addressRepo;

    private final ModelMapper modelMapper;

    @Autowired
    public AddressService(AddressRepo addressRepo, ModelMapper modelMapper) {
        this.addressRepo = addressRepo;
        this.modelMapper = modelMapper;
    }

    public AddressDTO findAddressByEmployeeId(int employeeId) {

        Address address = addressRepo.findAddressByEmployeeId(employeeId);

        return modelMapper.map(address, AddressDTO.class);
    }

    public List<AddressDTO> getAllAddress() {

        List<AddressDTO> addressList = Arrays.asList(modelMapper.map(addressRepo.findAll(), AddressDTO[].class));
        return addressList;
    }

    public void createAddress(AddressDTO addressDTO) {
        addressRepo.save(modelMapper.map(addressDTO, Address.class));
    }
}
