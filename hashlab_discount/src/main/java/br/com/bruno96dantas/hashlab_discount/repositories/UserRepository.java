package br.com.bruno96dantas.hashlab_discount.repositories;

import br.com.bruno96dantas.hashlab_discount.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.id = ?1")
    User findByOneId(Long id);
}
