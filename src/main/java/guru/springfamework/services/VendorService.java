package guru.springfamework.services;

import guru.springfamework.api.v1.model.VendorDto;

import java.util.List;

/**
 * author : cadqe13@gmail.com
 * date : 2022-04-05
 * description : Vendor Service
 */

public interface VendorService {

	List<VendorDto> getAllVendors();

	VendorDto getVendorByName(String name);

	VendorDto getVendorById(Long id);

	VendorDto createNewVendor(VendorDto vendorDto);

	VendorDto saveVendorByDto(Long id, VendorDto vendorDto);

	VendorDto patchVendor(Long id, VendorDto vendorDto);

	void deleteVendorById(Long id);
}
