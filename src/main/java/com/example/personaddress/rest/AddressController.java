package com.example.personaddress.rest;

import com.example.personaddress.model.entity.AddressEntity;
import com.example.personaddress.model.requestDto.AddressRequest;
import com.example.personaddress.model.requestDto.PersonRequest;
import com.example.personaddress.model.responseDto.AddressResponse;
import com.example.personaddress.model.responseDto.PersonResponse;
import com.example.personaddress.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController<AddressEntity
        , AddressRequest
        , AddressResponse
        , AddressService> {

    @PostMapping("/create")
    public AddressResponse create(@RequestBody AddressRequest addressRequest) throws Exception {

        Optional.ofNullable(convertor.convertToEntity(addressRequest))
                .filter(entity -> entity.getCity() != null && entity.getStreet() != null)
                .orElseThrow(() -> new Exception("Entering data is necessary."));
        return convertor.convertToResponse(service.create(convertor.convertToEntity(addressRequest)));
    }

    @PutMapping("updateAddress/{id}")
    public AddressResponse updateAddress(@PathVariable Long id
            , @RequestBody AddressRequest rackDto) throws Exception {

        if (this.findById(id) == null) {
            throw new Exception("server not fount.");
        }
        return convertor.convertToResponse(service.updateAddress(id,convertor.convertToEntity(rackDto)));
    }

    @GetMapping("/get/{id}")
    public AddressResponse findById(@PathVariable Long id) throws Exception {

        if (service.get(id) == null) {
            throw new Exception("address not found.");
        }
        return convertor.convertToResponse(service.get(id));
    }

    @DeleteMapping("delete/{id}")
    public String deleteAddress(@PathVariable Long id)  {
        service.deleteById(id);
        return "deleted address with :" +id;
    }
}
