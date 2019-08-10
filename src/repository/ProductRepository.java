package repository;

import model.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ProductRepository implements GeneralRepository<Product>, Comparator<Product> {
    Product[] product = new Product[20];
    private static int size = 3;

    {
        product[0] = new Product(1, "IPHONE", 20, "Quả táo");
        product[1] = new Product(2, "SAMSUNG", 15, "");
        product[2] = new Product(3, "OPPO", 10, "");
    }

    @Override
    public Product[] findAll() {
        return product;
    }

    @Override
    public void find(int index) {
        if (index < 0 || index >= size) {
            System.out.println("index: " + index + ", size: " + size);
        } else {
            System.out.println(product[index]);
        }
    }

    @Override
    public void find(String name) {
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (product[i].getName().equals(name)) {
                System.out.println(product[i]);
                check = true;
                break;
            }
        }
        if (check != true) {
            System.out.println("Khong co ten");
        }
    }

    @Override
    public void add(Product product) {
        if (size == this.product.length) {
            int newSize = this.product.length * 2;
            this.product = Arrays.copyOf(this.product, newSize);
        }
        this.product[size++] = new Product(product.getId(), product.getName(), product.getPrice(), product.getDescription());

    }

    @Override
    public void replace(Product product, int index) {

        if (index < 0 || index >= size) {
            System.out.println("Chi so khong ton tai");
        } else {
            this.product[index].setId(product.getId());
            this.product[index].setName(product.getName());
            this.product[index].setPrice(product.getPrice());
            this.product[index].setDescription(product.getDescription());
            System.out.println("Complete");
        }

    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Chi so khong ton tai");
        } else {
            for (int i = index; i < size - 1; i++) {
                product[i].setId(product[i + 1].getId());
                product[i].setName(product[i + 1].getName());
                product[i].setPrice(product[i + 1].getPrice());
                product[i].setDescription(product[i + 1].getDescription());
            }
            size--;
            product = Arrays.copyOf(product, size);
            System.out.println("Complete");
        }
    }

    @Override
    public Product[] sort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (compare(product[i], product[j]) == 1) {
                    min = j;
                }
            }
            if (min != i) {
                Product product1 = product[i];
                product[i] = product[min];
                product[min] = product1;
            }
        }
        return product;
    }

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getPrice()) return 1;
        else if (o1.getPrice() < o2.getPrice()) return -1;
        else return 0;
    }
}

