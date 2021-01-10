import java.util.Scanner;

public class SetInForProduct {
    public static Product setInForProduct(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập mã danh mục");
        String portfolioCode = sc.nextLine();
        System.out.println("Nhập tên danh mục");
        String portfolioName = sc1.nextLine();
        System.out.println("Mã sản phẩm");
        String code = sc.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String name = sc1.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập ngày nhập kho của sản phẩm");
        String enterDay = sc1.nextLine();
        System.out.println("Nhập ngày bán của sản phẩm");
        String saleDay = sc.nextLine();
        System.out.println("Nhập hạn sử dụng của sản phẩm");
        String expiryDay = sc1.nextLine();
        System.out.println("Nhập miêu tả sản phẩm");
        String description = sc.nextLine();
        Product product = new Product(portfolioCode,portfolioName,code,name,price,enterDay,saleDay,expiryDay,description);
        return product;
    }
}
