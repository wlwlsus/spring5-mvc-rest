package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.VendorDto;
import guru.springfamework.api.v1.model.VendorListDto;
import guru.springfamework.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * author : cadqe13@gmail.com
 * date : 2022-04-05
 * description :
 */

@RestController
@RequestMapping(VendorController.BASE_URL)
public class VendorController {

	public static final String BASE_URL = "/api/v1/vendors";

	private final VendorService vendorService;

	public VendorController(VendorService vendorService) {
		this.vendorService = vendorService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public VendorListDto getListOfVendors() {
		return new VendorListDto(vendorService.getAllVendors());
	}

	@GetMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public VendorDto getVendorById(@PathVariable Long id) {
		return vendorService.getVendorById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VendorDto createNewCustomer(@RequestBody VendorDto vendorDto) {
		return vendorService.createNewVendor(vendorDto);
	}

	@PutMapping("{/id}")
	@ResponseStatus(HttpStatus.OK)
	public VendorDto updateVendor(@PathVariable Long id, @RequestBody VendorDto vendorDto) {
		return vendorService.saveVendorByDto(id, vendorDto);
	}

	@PatchMapping("{/id}")
	@ResponseStatus(HttpStatus.OK)
	public VendorDto patchVendor(@PathVariable Long id, @RequestBody VendorDto vendorDto) {
		return vendorService.patchVendor(id, vendorDto);
	}

	@DeleteMapping("{/id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteVendor(@PathVariable Long id) {
		vendorService.deleteVendorById(id);
	}
}
