package com.example.personaddress.rest;

import com.example.personaddress.model.entity.AddressEntity;
import com.example.personaddress.model.requestDto.AddressRequest;
import com.example.personaddress.model.requestDto.PersonRequest;
import com.example.personaddress.model.responseDto.AddressResponse;
import com.example.personaddress.model.responseDto.PersonResponse;
import com.example.personaddress.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
            , @RequestBody AddressRequest addressRequest) throws Exception {

        if (service.get(id) == null) {
            throw new Exception("address not found.");
        }
        AddressEntity address = convertor.convertToEntity(addressRequest);
        return convertor.convertToResponse(service.updateAddress(id, address));
    }

    @GetMapping("/get/{id}")
    public AddressResponse findById(@PathVariable Long id) throws Exception {

        if (service.get(id) == null) {
            throw new Exception("address not found.");
        }
        return convertor.convertToResponse(service.get(id));
    }

    @GetMapping("/addresses")
    public List<AddressResponse> getAllAddress() {
        return convertor.entityCollectionConvertor(service.getAllAddress());
    }

    @GetMapping("/getAllAddressWithPagination")
    public List<AddressResponse> getAllAddressWithPagination(@RequestParam("pageIndex") int pageIndex) {
        return convertor.entityCollectionConvertor(service.getAllAddressWithPagination(pageIndex));
    }

    @DeleteMapping("delete/{id}")
    public String deleteAddress(@PathVariable Long id) {
        service.deleteById(id);
        return "deleted address with :" + id;
    }

    @PutMapping("setPersonId/{addressId}/{personId}")
    public String setPersonId(@PathVariable Long addressId
            , @PathVariable Long personId) throws Exception {

        if (service.get(addressId) == null) {
            throw new Exception("address not found.");
        }

        return service.setAddressToPerson(addressId, personId);
    }
}
