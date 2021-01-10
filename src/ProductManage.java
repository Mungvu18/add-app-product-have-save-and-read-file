import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductManage {
    List<Product> productList;
    public static final String FILE_NAME = "product.dat";

    public ProductManage(List<Product> productList) {
        this.productList = productList;
    }

    public void addNew(Product product) {
        productList.add(product);
        ProcessWriteAndReadFile.writeFile(productList,FILE_NAME);
    }

    public void showAll(List<Product> list) {
        for (Product product : list) {
            System.out.println(product);
        }
    }

    // phương thức lấy danh sách sản phẩm đã bán
    public void showProductsSold() {
        boolean testSoldProduct = false;
        for (Product product : productList) {
            String saleDay = product.getSaleDay();
            testSoldProduct = (!saleDay.equals(""));
            if (testSoldProduct) {
                System.out.println(product);
            }
        }
        if (!testSoldProduct) {
            System.out.println("Không có sản phẩm nào");
        }
    }

    // phương thức lấy sản phẩm còn tồn kho
    public void showProductInventory() {
        boolean testProduct = false;
        for (Product product : productList) {
            String saleDay = product.getSaleDay();
            testProduct = (saleDay.equals(""));
            if (testProduct) {
                System.out.println(product);
            }
        }
        if (!testProduct) System.out.println("Không có sản phẩm nào");
    }
    // phương thức tìm kiếm sản phẩm qua tên
    public void showProductByName(String name){
        boolean testProductName = false;
        int count = 0;
        for (Product product: productList) {
            testProductName = product.getName().equalsIgnoreCase(name);
            if(testProductName){
                count ++;
                System.out.println(product);
            }
        }
        System.out.println("Số lượng sản phẩm: " + count);
    }

    // phương thức in ra sản phẩm hết hạn sử dụng
    public void showProductToExpiryDay() {
        List<Date> expiryTimeList = expiryTimeList();
        long currentTime = getCurrentTime();
        boolean testExpiryTime = false;
        for (int i = 0; i < expiryTimeList.size(); i++) {
            testExpiryTime = expiryTimeList.get(i).getTime() < currentTime;
            if (testExpiryTime) {
                System.out.println(productList.get(i));
            }
        }
        if(!testExpiryTime) System.out.println("Không có sản phẩm nào");
    }
    // phương thức in ra sản phầm sắp hết hạn sử dụng
    public void showProductProximateExpiryDay(){
        List<Date> expiryTimeList = expiryTimeList();
        long currentTime = getCurrentTime();
        boolean testExpiryTime = false;
        for (int i = 0; i < expiryTimeList.size(); i++) {
            long expiryTime = expiryTimeList.get(i).getTime();
            testExpiryTime = currentTime <= expiryTime || expiryTime - 7*24*60*60*1000 <= currentTime ;
            if(testExpiryTime){
                System.out.println(productList.get(i));
            }
        }
        if(!testExpiryTime) System.out.println("Không có sản phẩm nào");
    }

    // phương thức lấy time hệ thống
    public long getCurrentTime() {
        return new Date().getTime();
    }

    // phương thức lấy danh sách time hết hạn của sản phẩm
    public List<Date> expiryTimeList() {
        List<Date> expiryTimeList = new ArrayList<>();
        for (Product product : productList) {
            String expiryDay = product.getExpiryDay();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date expiryDate = null;
            try {
                expiryDate = format.parse(expiryDay);
                expiryTimeList.add(expiryDate);
            } catch (ParseException e) {
            }
        }
        return expiryTimeList;
    }
}
