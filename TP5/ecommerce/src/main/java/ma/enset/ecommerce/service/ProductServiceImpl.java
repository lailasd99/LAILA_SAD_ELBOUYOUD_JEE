package ma.enset.ecommerce.service;

import ma.enset.ecommerce.dtos.ProductDTO;
import ma.enset.ecommerce.entities.Product;
import ma.enset.ecommerce.mappers.CatalogMappers;
import ma.enset.ecommerce.respositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRespository productRespository;
    @Autowired
    private CatalogMappers catalogMappers;

    @Override
    public ProductDTO save(ProductDTO productDTO){
        Product product = catalogMappers.fromProductDTO(productDTO);
        product.setId(UUID.randomUUID().toString());
        Product savedProduct = productRespository.save(product);
        return catalogMappers.fromProduct(savedProduct);
    }

    @Override
    public List<ProductDTO> listProducts(){
        List<Product> products = productRespository.findAll();
        List<ProductDTO> productsDTO = products.stream().map(p->catalogMappers.fromProduct(p))
                .collect(Collectors.toList());
        return productsDTO;
    }

    @Override
    public ProductDTO getProduct(String id) {
        Product product = productRespository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        return catalogMappers.fromProduct(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = catalogMappers.fromProductDTO(productDTO);
        Product saved = productRespository.save(product);
        return catalogMappers.fromProduct(saved);
    }

    @Override
    public void deleteProduct(String id) {
        productRespository.deleteById(id);
    }

}
