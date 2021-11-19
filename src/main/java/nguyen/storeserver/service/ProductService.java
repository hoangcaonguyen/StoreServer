package nguyen.storeserver.service;

import nguyen.storeserver.comon.MessageUtils;
import nguyen.storeserver.dto.ProductDTO;
import nguyen.storeserver.dto.ResponseDTO;
import nguyen.storeserver.entity.Product;
import nguyen.storeserver.repository.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }
    public Optional<Product> findById(Integer productId){
        return productRepo.findById(productId);
    }
    public Product findByProductName(String productName){
        return productRepo.getByProductName(productName);
    }
    public List<Product> findByImportPrice(double importPrice){
        return productRepo.getByImportPrice(importPrice);
    }
    public List<Product> findByPrice(double price){
        return productRepo.getByPrice(price);
    }
    public List<Product> findByUpdater(String updater){
        return productRepo.getByUpdater(updater);
    }
    public Product findByUpdateTime(LocalDateTime dateTime){
        return productRepo.getByUpdateTime(dateTime);
    }
    @Transactional
    public ResponseDTO AddProduct (ProductDTO productDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        Product product = new Product();
        Assert.isNull(productRepo.getByProductName(productDTO.getProductName()),
                MessageUtils.getMessage("error.notfound",productDTO.getProductName()));
    //TODO : them updater.
        return responseDTO;
    }
}
