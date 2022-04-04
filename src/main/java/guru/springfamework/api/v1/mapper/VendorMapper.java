package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.VendorDto;
import guru.springfamework.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * author : cadqe13@gmail.com
 * date : 2022-04-04
 * description : Vendor Entity <-> DTO Mapping Library
 */

@Mapper
public interface VendorMapper {

	VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

	VendorDto vendorToVendorDto(Vendor vendor);

	Vendor vendorDtoToVendor(VendorDto vendorDto);
}
