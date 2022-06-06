package ma.enset.ecommerce.web;

import lombok.AllArgsConstructor;
import ma.enset.ecommerce.dtos.ProductDTO;
import ma.enset.ecommerce.entities.Product;
import ma.enset.ecommerce.respositories.ProductRespository;
import ma.enset.ecommerce.service.ProductService;
import ma.enset.ecommerce.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController @AllArgsConstructor
public class ProductRestController {
    private ProductRespository productRespository;
    @Autowired
    private ProductService productService;

    @GetMapping(path ="/products")
    public List<ProductDTO> productList(){
        //return productRespository.findAll();
        return productService.listProducts();
    }

    @GetMapping(path="/products/{id}")
    public ProductDTO getProducts(@PathVariable(name="id") String id){
        return productService.getProduct(id);
    }

    @PostMapping(path="/products")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @PutMapping(path="/products/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable String id){
        productDTO.setId(id);
        return productService.save(productDTO);
    }

    @PutMapping(path="/products/{id}")
    public void deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }
}
