package br.com.bruno96dantas.hashlab_listing.repositories;

import br.com.bruno96dantas.hashlab_listing.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.id = ?1")
    Product findByOneId(Long id);
}
