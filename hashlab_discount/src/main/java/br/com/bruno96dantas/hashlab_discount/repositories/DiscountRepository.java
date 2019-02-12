package br.com.bruno96dantas.hashlab_discount.repositories;

import br.com.bruno96dantas.hashlab_discount.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
