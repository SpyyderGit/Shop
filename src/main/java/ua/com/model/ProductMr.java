package ua.com.model;

/**
 * Created by User on 18.05.2017.
 */
public class ProductMr {
    private int mrId;
    private String mrName;

    public ProductMr(String mrName) {
        this.mrName = mrName;
    }

    public ProductMr(int mrId, String mrName) {
        this.mrId = mrId;
        this.mrName = mrName;
    }

    public int getMrId() {
        return mrId;
    }

    public void setMrId(int mrId) {
        this.mrId = mrId;
    }

    public String getMrName() {
        return mrName;
    }

    public void setMrName(String mrName) {
        this.mrName = mrName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductMr productMr = (ProductMr) o;

        if (mrId != productMr.mrId) return false;
        return mrName != null ? mrName.equals(productMr.mrName) : productMr.mrName == null;
    }

    @Override
    public int hashCode() {
        int result = mrId;
        result = 31 * result + (mrName != null ? mrName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductMr{" +
                "mrId=" + mrId +
                ", mrName='" + mrName + '\'' +
                '}';
    }
}
