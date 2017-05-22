package ua.com.model;

/**
 * Created by User on 18.05.2017.
 */
public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private String productRemark;
    private String sklad;
    private int mrIdFk;
    private int typeIdFk;

//    private ProductMr mrIdFk;
//    private ProductType typeIdFk;


    public Product(int productId, String productName, double productPrice, String productRemark, String sklad, int mrIdFk, int typeIdFk) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productRemark = productRemark;
        this.sklad = sklad;
        this.mrIdFk = mrIdFk;
        this.typeIdFk = typeIdFk;
    }

    public Product(String productName, double productPrice, String productRemark, String sklad, int mrIdFk, int typeIdFk) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productRemark = productRemark;
        this.sklad = sklad;
        this.mrIdFk = mrIdFk;
        this.typeIdFk = typeIdFk;
    }

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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark;
    }

    public String getSklad() {
        return sklad;
    }

    public void setSklad(String sklad) {
        this.sklad = sklad;
    }

    public int getMrIdFk() {
        return mrIdFk;
    }

    public void setMrIdFk(int mrIdFk) {
        this.mrIdFk = mrIdFk;
    }

    public int getTypeIdFk() {
        return typeIdFk;
    }

    public void setTypeIdFk(int typeIdFk) {
        this.typeIdFk = typeIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (Double.compare(product.productPrice, productPrice) != 0) return false;
        if (mrIdFk != product.mrIdFk) return false;
        if (typeIdFk != product.typeIdFk) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productRemark != null ? !productRemark.equals(product.productRemark) : product.productRemark != null)
            return false;
        return sklad != null ? sklad.equals(product.sklad) : product.sklad == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (productRemark != null ? productRemark.hashCode() : 0);
        result = 31 * result + (sklad != null ? sklad.hashCode() : 0);
        result = 31 * result + mrIdFk;
        result = 31 * result + typeIdFk;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productRemark='" + productRemark + '\'' +
                ", sklad='" + sklad + '\'' +
                ", mrIdFk=" + mrIdFk +
                ", typeIdFk=" + typeIdFk + '}' + "\n";
    }
}
