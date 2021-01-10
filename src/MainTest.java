import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        testFile(ProductManage.FILE_NAME);
        List<Product> productList = (List<Product>) ProcessWriteAndReadFile.readFile(ProductManage.FILE_NAME);
        ProductManage productManage;
        if (productList != null) productManage = new ProductManage(productList);
        else {
            productList = new ArrayList<>();
            productManage = new ProductManage(productList);
        }
        int choice;
        do {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị toàn bộ sản phẩm");
            System.out.println("3. Hiển thị các sản phẩm đã bán");
            System.out.println("4. Hiển thị các sản phẩm còn tồn kho");
            System.out.println("5. Hiển thị các sản phẩm hết hạn sử dụng");
            System.out.println("6. Hiển thị các sản phẩm sắp hết hạn");
            System.out.println("7. Tìm kiếm sản phẩm");
            System.out.println("8. Đọc file dữ liệu");
            System.out.println("0. Thoát chương trình");
            System.out.println(" Nhập lựa trọn choice");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng sản phẩm muốn thêm");
                    int amount = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < amount; i++) {
                        Product product = SetInForProduct.setInForProduct();
                        productManage.addNew(product);
                    }
                    break;
                case 2:
                    productManage.showAll(productList);
                    break;
                case 3:
                        productManage.showProductsSold();
                    break;
                case 4:
                        productManage.showProductInventory();
                    break;
                case 5:
                        productManage.showProductToExpiryDay();
                    break;
                case 6:
                        productManage.showProductProximateExpiryDay();
                    break;
                case 7:
                    System.out.println("Nhập tên sản phẩm cần tìm");
                    String name = sc.nextLine();
                    productManage.showProductByName(name);
                    break;
                case 8:
                    for (Product p: productList) {
                        System.out.println(p.getSaleDay());
                    }
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    private static void testFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
