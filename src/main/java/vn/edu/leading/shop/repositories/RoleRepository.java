package vn.edu.leading.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.leading.shop.models.RoleModel;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {

   List<RoleModel> findByNameContaining(String term);

   RoleModel findByName(String term);
}
