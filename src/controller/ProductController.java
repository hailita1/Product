package controller;

        import model.Product;
        import service.ProductService;

public class ProductController {
    ProductService productService = new ProductService();

    public Product[] findAll() {
        return productService.findAll();
    }

    public void find(int index) {
        productService.find(index);
    }

    public void find(String name) {
        productService.find(name);
    }

    public void add(Product product) {
        productService.add(product);
    }

    public void replace(Product product, int index) {
        productService.replace(product, index);
    }

    public void remove(int index) {
        productService.remove(index);
    }

    public Product[] sort() {
        return productService.sort();
    }
}