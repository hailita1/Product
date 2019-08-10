package service;

import model.Product;
import repository.ProductRepository;

public class ProductService implements GeneralService<Product> {
    ProductRepository productRepository = new ProductRepository();

    @Override
    public Product[] findAll() {
        return productRepository.findAll();
    }

    @Override
    public void find(int index) {
        productRepository.find(index);
    }

    @Override
    public void find(String name) {
        productRepository.find(name);
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void replace(Product product, int index) {
        productRepository.replace(product, index);
    }

    @Override
    public void remove(int index) {
        productRepository.remove(index);
    }

    @Override
    public Product[] sort() {
        return productRepository.sort();
    }

}
