package example.controller;
import example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import example.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public List<Product> productList(){
        List<Product> productsList=productRepository.findAll();
        return productsList;
    }
    @RequestMapping(value = "/product",method =RequestMethod.POST)
    public String AddProduct(@RequestBody Product product){
        productRepository.save(product);
        return "Maxsulot bazaga qo'shildi";
    }
    @RequestMapping(value ="/product/{id}",method = RequestMethod.GET)
    public Optional<Product> getProduct(@PathVariable Integer id){
        Optional<Product> product = productRepository.findById(id);
        return product;
    }
    @RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Integer id){
        productRepository.deleteById(id);
        return "malumot O'chdi";
    }
    @RequestMapping(value = "/product/{id}",method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Product product){
        productRepository.save(product);
        return "Malumotlar Yangilandi";
    }
}