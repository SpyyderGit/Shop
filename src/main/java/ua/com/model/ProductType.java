package ua.com.model;

/**
 * Created by User on 18.05.2017.
 */
public class ProductType {
    private int typeId;
    private String typeName;
    private int idView;



    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getIdView() {
        return idView;
    }

    public void setIdView(int idView) {
        this.idView = idView;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductType that = (ProductType) o;

        if (typeId != that.typeId) return false;
        if (idView != that.idView) return false;
        return typeName != null ? typeName.equals(that.typeName) : that.typeName == null;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + idView;
        return result;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", idView=" + idView +
                '}';
    }
}
