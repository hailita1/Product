import controller.ProductController;
import model.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        int choice;
        do {
            menu();
            System.out.println("Nhap vao lua chon:");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1: {

                    Product[] product = productController.findAll();
                    for (int i = 0; i < product.length; i++) {
                        if (product[i] != null) {
                            System.out.println("ID: " + product[i].getId() + " NAME: " + product[i].getName() + " PRICE: " + product[i].getPrice() + " DESCRIPTION: " + product[i].getDescription());
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhap ID: ");
                    int id = new Scanner(System.in).nextInt();
                    System.out.println("Nhap ten: ");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("Nhap gia: ");
                    double price = new Scanner(System.in).nextDouble();
                    System.out.println("Nhap dac trung: ");
                    String description = new Scanner(System.in).nextLine();
                    Product product = new Product(id, name, price, description);
                    productController.add(product);
                    break;
                }
                case 3: {
                    System.out.println("Nhap vi tri can tim: ");
                    int index = new Scanner(System.in).nextInt();
                    productController.find(index);
                    break;
                }
                case 4: {
                    System.out.println("Nhap vi tri can thay doi: ");
                    int index = new Scanner(System.in).nextInt();
                    System.out.println("Nhap ID: ");
                    int id = new Scanner(System.in).nextInt();
                    System.out.println("Nhap ten: ");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("Nhap gia: ");
                    double price = new Scanner(System.in).nextDouble();
                    System.out.println("Nhap dac trung: ");
                    String description = new Scanner(System.in).nextLine();
                    Product product = new Product(id, name, price, description);
                    productController.replace(product, index);
                    break;
                }
                case 5: {
                    System.out.println("Nhap vi tri can xoa: ");
                    int index = new Scanner(System.in).nextInt();
                    productController.remove(index);
                    break;
                }
                case 6: {
                    System.out.println("Danh sach san pham sau khi sap xep la:");
                    Product[] product = productController.sort();
//                    Product[] product = productController.findAll();
                    for (int i = 0; i < product.length; i++) {
                        if (product[i] != null) {
                            System.out.println(product[i]);
                        }
                    }
                    break;
                }
                case 7: {
                    System.out.println("Nhap ten san pham: ");
                    String name = new Scanner(System.in).nextLine();
                    productController.find(name);
                    break;
                }
            }
        } while (choice != 0);
    }

    public static void menu() {
        System.out.println("\n");
        System.out.println("-----Quan ly san pham-----");
        System.out.println("1. Hien thi tat ca san pham");
        System.out.println("2. Them san pham");
        System.out.println("3. Tim kiem san pham");
        System.out.println("4. Thay doi thong tin san pham");
        System.out.println("5. Xoa san pham");
        System.out.println("6. Sap xep sam pham");
        System.out.println("7. Tim kiem theo ten");
        System.out.println("0. Thoat");
    }
}