package ua.com.model;

/**
 * Created by User on 18.05.2017.
 */
public class ProductView {
    private int productId;
    private String productName;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductView that = (ProductView) o;

        if (productId != that.productId) return false;
        return productName != null ? productName.equals(that.productName) : that.productName == null;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "ProductView{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
