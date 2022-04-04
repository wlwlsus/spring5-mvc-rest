package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.VendorMapper;
import guru.springfamework.api.v1.model.VendorDto;
import guru.springfamework.controllers.v1.CustomerController;
import guru.springfamework.controllers.v1.VendorController;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author : cadqe13@gmail.com
 * date : 2022-04-05
 * description :
 */
@Service
public class VendorServiceImpl implements VendorService {

	private final VendorMapper vendorMapper;
	private final VendorRepository vendorRepository;

	public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
		this.vendorMapper = vendorMapper;
		this.vendorRepository = vendorRepository;
	}

	@Override
	public List<VendorDto> getAllVendors() {
		return vendorRepository.findAll()
						.stream()
						.map(vendor -> {
							VendorDto vendorDto = vendorMapper.vendorToVendorDto(vendor);
							vendorDto.setVendorUrl(getVendorUrl(vendor.getId()));
							return vendorDto;
						})
						.collect(Collectors.toList());
	}

	@Override
	public VendorDto getVendorByName(String name) {
		return vendorMapper.vendorToVendorDto(vendorRepository.findByName(name));
	}

	@Override
	public VendorDto getVendorById(Long id) {
		return vendorRepository.findById(id)
						.map(vendorMapper::vendorToVendorDto)
						.map(vendorDto -> {
							vendorDto.setVendorUrl(getVendorUrl(id));
							return vendorDto;
						})
						.orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public VendorDto createNewVendor(VendorDto vendorDto) {
		return saveAndReturnDto(vendorMapper.vendorDtoToVendor(vendorDto));
	}

	private VendorDto saveAndReturnDto(Vendor vendor) {
		Vendor savedVendor = vendorRepository.save(vendor);

		VendorDto returnDto = vendorMapper.vendorToVendorDto(savedVendor);

		returnDto.setVendorUrl(getVendorUrl(savedVendor.getId()));

		return returnDto;
	}

	@Override
	public VendorDto saveVendorByDto(Long id, VendorDto vendorDto) {
		Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDto);
		return saveAndReturnDto(vendor);
	}

	@Override
	public VendorDto patchVendor(Long id, VendorDto vendorDto) {
		return vendorRepository.findById(id)
						.map(vendor -> {
							if (vendorDto.getName() != null) {
								vendor.setName(vendorDto.getName());
							}

							VendorDto returnDto = vendorMapper.vendorToVendorDto(vendorRepository.save(vendor));
							returnDto.setVendorUrl(getVendorUrl(id));
							return returnDto;
						}).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteVendorById(Long id) {
		vendorRepository.deleteById(id);
	}

	private String getVendorUrl(Long id) {
		return VendorController.BASE_URL + "/" + id;
	}
}
