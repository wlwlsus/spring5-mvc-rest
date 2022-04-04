package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.VendorDto;
import guru.springfamework.domain.Vendor;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author : cadqe13@gmail.com
 * date : 2022-04-04
 * description :
 */

public class VendorMapperTest {

	public static final String NAME = "VendingMachine";
	public static final long ID = 1L;

	VendorMapper vendorMapper = VendorMapper.INSTANCE;

	@Test
	public void vendorToVendorDto() {

		//given
		Vendor vendor = new Vendor();
		vendor.setId(ID);
		vendor.setName(NAME);

		//when
		VendorDto vendorDto = vendorMapper.vendorToVendorDto(vendor);

		//then
		assertEquals(Long.valueOf(ID), vendorDto.getId());
		assertEquals(NAME, vendorDto.getName());
	}

	@Test
	public void vendorDtoToVendor() {

		//given
		VendorDto vendorDto = new VendorDto();
		vendorDto.setId(ID);
		vendorDto.setName(NAME);

		//when
		Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDto);

		//then
		assertEquals(Long.valueOf(ID), vendor.getId());
		assertEquals(NAME, vendor.getName());
	}
}