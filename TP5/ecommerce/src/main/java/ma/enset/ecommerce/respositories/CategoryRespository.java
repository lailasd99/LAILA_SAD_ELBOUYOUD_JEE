package ma.enset.ecommerce.respositories;

import ma.enset.ecommerce.entities.Category;
import ma.enset.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<Category, Long> {
}
