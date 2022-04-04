package guru.springfamework.repositories;

import guru.springfamework.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author : cadqe13@gmail.com
 * date : 2022-04-05
 * description :
 */

public interface VendorRepository extends JpaRepository<Vendor, Long> {
	Vendor findByName(String name);
}
