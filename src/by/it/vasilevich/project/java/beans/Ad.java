package by.it.vasilevich.project.java.beans;


public class Ad {

    private int ID;
    private int Price;
    private String Brand;
    private String Model;
    private String Type;
    private int Year;
    private String Engine;
    private String Transmission;
    private String Drive_unit;
    private int Mileage;
    private String Color;
    private int FK_Users;

    public Ad() {

    }

    public Ad(int ID, int price, String brand, String model, String type, int year, String engine, String transmission, String drive_unit, int mileage, String color, int FK_Users) {
        this.ID = ID;
        this.Price = price;
        this.Brand = brand;
        this.Model = model;
        this.Type = type;
        this.Year = year;
        this.Engine = engine;
        this.Transmission = transmission;
        this.Drive_unit = drive_unit;
        this.Mileage = mileage;
        this.Color = color;
        this.FK_Users = FK_Users;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getEngine() {
        return Engine;
    }

    public void setEngine(String engine) {
        Engine = engine;
    }

    public String getTransmission() {
        return Transmission;
    }

    public void setTransmission(String transmission) {
        Transmission = transmission;
    }

    public String getDrive_unit() {
        return Drive_unit;
    }

    public void setDrive_unit(String drive_unit) {
        Drive_unit = drive_unit;
    }

    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        Mileage = mileage;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getFK_Users() {
        return FK_Users;
    }

    public void setFK_Users(int FK_Users) {
        this.FK_Users = FK_Users;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ad)) return false;

        Ad ad = (Ad) o;

        if (ID != ad.ID) return false;
        if (Price != ad.Price) return false;
        if (Year != ad.Year) return false;
        if (Mileage != ad.Mileage) return false;
        if (FK_Users != ad.FK_Users) return false;
        if (Brand != null ? !Brand.equals(ad.Brand) : ad.Brand != null) return false;
        if (Model != null ? !Model.equals(ad.Model) : ad.Model != null) return false;
        if (Type != null ? !Type.equals(ad.Type) : ad.Type != null) return false;
        if (Engine != null ? !Engine.equals(ad.Engine) : ad.Engine != null) return false;
        if (Transmission != null ? !Transmission.equals(ad.Transmission) : ad.Transmission != null) return false;
        if (Drive_unit != null ? !Drive_unit.equals(ad.Drive_unit) : ad.Drive_unit != null) return false;
        return Color != null ? Color.equals(ad.Color) : ad.Color == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Price;
        result = 31 * result + (Brand != null ? Brand.hashCode() : 0);
        result = 31 * result + (Model != null ? Model.hashCode() : 0);
        result = 31 * result + (Type != null ? Type.hashCode() : 0);
        result = 31 * result + Year;
        result = 31 * result + (Engine != null ? Engine.hashCode() : 0);
        result = 31 * result + (Transmission != null ? Transmission.hashCode() : 0);
        result = 31 * result + (Drive_unit != null ? Drive_unit.hashCode() : 0);
        result = 31 * result + Mileage;
        result = 31 * result + (Color != null ? Color.hashCode() : 0);
        result = 31 * result + FK_Users;
        return result;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "ID=" + ID +
                ", Price=" + Price +
                ", Brand='" + Brand + '\'' +
                ", Model='" + Model + '\'' +
                ", Type='" + Type + '\'' +
                ", Year=" + Year +
                ", Engine='" + Engine + '\'' +
                ", Transmission='" + Transmission + '\'' +
                ", Drive_unit='" + Drive_unit + '\'' +
                ", Mileage=" + Mileage +
                ", Color='" + Color + '\'' +
                ", FK_Users=" + FK_Users +
                "}\n";
    }
}
