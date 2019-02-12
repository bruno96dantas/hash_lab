package br.com.bruno96dantas.hashlab_listing.repositories;

import br.com.bruno96dantas.hashlab_listing.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
