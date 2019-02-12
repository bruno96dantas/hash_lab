package br.com.bruno96dantas.hashlab_discount.repositories;

import br.com.bruno96dantas.hashlab_discount.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByOneId(Long id);
}
