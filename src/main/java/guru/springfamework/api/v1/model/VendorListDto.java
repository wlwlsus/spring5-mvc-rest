package guru.springfamework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author : cadqe13@gmail.com
 * date : 2022-04-04
 * description : Vendor 목록을 출력해 줄  List DTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorListDto {
	List<VendorDto> vendors;
}
