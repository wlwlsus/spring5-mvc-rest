package guru.springfamework.controllers.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : cadqe13@gmail.com
 * date : 2022-04-05
 * description :
 */

@RestController
@RequestMapping(VendorController.BASE_URL)
public class VendorController {

	public static final String BASE_URL = "/api/v1/vendors";

}
