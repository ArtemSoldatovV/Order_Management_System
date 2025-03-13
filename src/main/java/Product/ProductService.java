package Product;

import MappingUtils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final MappingUtils mp;
    private Integer quantity = 10;

    @Autowired
    public ProductService(ProductRepository productRepository, MappingUtils mp) {
        this.productRepository = productRepository;
        this.mp = mp;
    }

    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id)
                .map(mp::mapToProductDTO);
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(mp::mapToProductDTO)
                .collect(Collectors.toList());
    }

    public Product save(Product product) {
        // Добавьте проверку валидности здесь
        return productRepository.save(product);
    }

    public Product update(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);

            Product product = optionalProduct.get();
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);

    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}