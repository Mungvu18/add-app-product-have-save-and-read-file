import java.io.Serializable;

public class Product extends ProductPortfolio implements Serializable {
    private String code;
    private String name;
    private double price;
    private String enterDay;
    private String saleDay;
    private String expiryDay;
    private String description;

    public Product(String portfolioCode, String portfolioName, String code, String name, double price, String enterDay, String saleDay, String expiryDay, String description) {
        super(portfolioCode, portfolioName);
        this.code = code;
        this.name = name;
        this.price = price;
        this.enterDay = enterDay;
        this.saleDay = saleDay;
        this.expiryDay = expiryDay;
        this.description = description;
    }
    public String getSaleDay(){
        return saleDay;
    }

    public String getExpiryDay(){
        return enterDay;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", enterDay='" + enterDay + '\'' +
                ", saleDay='" + saleDay + '\'' +
                ", expiryDay='" + expiryDay + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
