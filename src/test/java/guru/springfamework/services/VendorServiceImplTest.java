package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.VendorMapper;
import guru.springfamework.api.v1.model.VendorDto;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * author : cadqe13@gmail.com
 * date : 2022-04-05
 * description :
 */
public class VendorServiceImplTest {

	public static final Long ID = 2L;
	public static final String NAME = "swj";

	@Mock
	VendorRepository vendorRepository;

	VendorMapper vendorMapper = VendorMapper.INSTANCE;

	VendorService vendorService;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		vendorService = new VendorServiceImpl(vendorMapper, vendorRepository);
	}

	@Test
	public void getAllVendors() {
		//given
		Vendor vendor1 = new Vendor();
		vendor1.setId(1L);
		vendor1.setName("Vendor1");

		Vendor vendor2 = new Vendor();
		vendor2.setId(2L);
		vendor2.setName("Vendor2");

		when(vendorRepository.findAll()).thenReturn(Arrays.asList(vendor1, vendor2));

		//when
		List<VendorDto> vendors = vendorService.getAllVendors();

		//then
		assertEquals(2, vendors.size());
	}

	@Test
	public void getVendorByName() {
		//given
		Vendor vendor = new Vendor();
		vendor.setId(ID);
		vendor.setName(NAME);

		when(vendorRepository.findByName(anyString())).thenReturn(vendor);

		//when
		VendorDto vendorDto = vendorService.getVendorByName(vendor.getName());

		//then
		assertEquals("swj", vendorDto.getName());
	}

	@Test
	public void getVendorById() {
		//given
		Vendor vendor = new Vendor();
		vendor.setId(ID);
		vendor.setName(NAME);

		when(vendorRepository.findById(anyLong())).thenReturn(Optional.of(vendor));

		//when
		VendorDto vendorDto = vendorService.getVendorById(vendor.getId());

		//then
		assertEquals(ID, vendorDto.getId());

	}

	@Test
	public void createNewVendor() {
		//given
		VendorDto vendorDto = new VendorDto();
		vendorDto.setName(NAME);

		Vendor savedVendor = new Vendor();
		savedVendor.setName(vendorDto.getName());
		savedVendor.setId(1L);

		when(vendorRepository.save(any(Vendor.class))).thenReturn(savedVendor);

		//when
		VendorDto savedDto = vendorService.createNewVendor(vendorDto);

		//then
		assertEquals(vendorDto.getName(), savedDto.getName());
		assertEquals("/api/v1/vendors/1", savedDto.getVendorUrl());

	}

	@Test
	public void saveVendorByDto() {
		//given
		VendorDto vendorDto = new VendorDto();
		vendorDto.setName(NAME);

		Vendor savedVendor = new Vendor();
		savedVendor.setId(ID);
		savedVendor.setName(vendorDto.getName());

		when(vendorRepository.save(any(Vendor.class))).thenReturn(savedVendor);

		//when
		VendorDto savedDto = vendorService.saveVendorByDto(ID, vendorDto);

		//then
		assertEquals(vendorDto.getName(), savedDto.getName());
		assertEquals("/api/v1/vendors/" + ID, savedDto.getVendorUrl());

	}

	@Test
	public void patchVendor() {
		//given

		//when

		//then

	}

	@Test
	public void deleteVendorById() {
		vendorRepository.deleteById(ID);

		verify(vendorRepository, times(1)).deleteById(anyLong());
	}
}