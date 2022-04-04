package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author : cadqe13@gmail.com
 * date : 2022-04-04
 * description : Vendor DTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDto {

	private Long id;
	private String name;

	@JsonProperty("vendor_url")
	private String vendorUrl;

}
