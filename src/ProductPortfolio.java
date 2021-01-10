import java.io.Serializable;

public class ProductPortfolio implements Serializable {
    private String portfolioCode;
    private String portfolioName;

    public ProductPortfolio(String portfolioCode, String portfolioName) {
       this.portfolioCode = portfolioCode;
       this.portfolioName = portfolioName;
    }

    @Override
    public String toString() {
        return "ProductPortfolio{" +
                "PortfolioCode='" + portfolioCode + '\'' +
                ", PortfolioName='" + portfolioCode + '\'' +
                '}';
    }
}
