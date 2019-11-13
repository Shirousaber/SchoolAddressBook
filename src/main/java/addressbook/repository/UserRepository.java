/**
 * 
 */
package addressbook.repository;

import java.util.List;

import addressbook.domain.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户仓库.
 *
 * @since 
 * @author 
 */
public interface UserRepository  extends CrudRepository<User, Long> {

}
