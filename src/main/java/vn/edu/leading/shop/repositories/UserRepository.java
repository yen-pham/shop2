package vn.edu.leading.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.CategoryModel;
import vn.edu.leading.shop.models.UserModel;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUsernameContaining(String term);

    List<UserModel> findAllByUsernameContaining(String term);
}
