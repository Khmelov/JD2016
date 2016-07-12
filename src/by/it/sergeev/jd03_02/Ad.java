package by.it.sergeev.jd03_02;

public class Ad {
    private int id;
    private String electronics;
    private String manufacturer;
    private String name;
    private String model;
    private int price;
    private String description;
    private int fk_user;

    public Ad() {

    }

    public Ad(int id, String electronics, String manufacturer, String name, String model, int price, String description, int fk_user) {
        this.id = id;
        this.electronics = electronics;
        this.manufacturer = manufacturer;
        this.name = name;
        this.model = model;
        this.price = price;
        this.description = description;
        this.fk_user = fk_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElectronics() {
        return electronics;
    }

    public void setElectronics(String electronics) {
        this.electronics = electronics;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (id != ad.id) return false;
        if (price != ad.price) return false;
        if (fk_user != ad.fk_user) return false;
        if (electronics != null ? !electronics.equals(ad.electronics) : ad.electronics != null) return false;
        if (manufacturer != null ? !manufacturer.equals(ad.manufacturer) : ad.manufacturer != null) return false;
        if (name != null ? !name.equals(ad.name) : ad.name != null) return false;
        if (model != null ? !model.equals(ad.model) : ad.model != null) return false;
        return description != null ? description.equals(ad.description) : ad.description == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (electronics != null ? electronics.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + fk_user;
        return result;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", electronics='" + electronics + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", fk_user=" + fk_user +
                '}';
    }
}



