package ma.enset.ecommerce;

import ma.enset.ecommerce.entities.Category;
import ma.enset.ecommerce.entities.Product;
import ma.enset.ecommerce.respositories.CategoryRespository;
import ma.enset.ecommerce.respositories.ProductRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductRespository productRespository, CategoryRespository categoryRespository){
        return args -> {
            /*Stream.of("Computer", "Printer", "Smartphone").forEach(name->{
                productRespository.save(new Product(UUID.randomUUID().toString(),
                        name, Math.random()*8000, Math.random()*100));
            });*/
            Stream.of("Computers", "Printers", "Smartphones").forEach(name->{
                Category category = new Category();
                category.setName(name);
                categoryRespository.save(category);
            });
            categoryRespository.findAll().forEach(cat->{
                for(int i=1; i<=5 ; i++){
                    Product product = new Product();
                    product.setId(UUID.randomUUID().toString());
                    product.setPrice(Math.random()*9000);
                    product.setQuantity(Math.random()*50);
                    product.setName(cat.getName()+"-"+i);
                    product.setCategory(cat);
                    productRespository.save(product);
                }
            });
        };
    }

}
