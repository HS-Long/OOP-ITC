public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private int yearOfCreation;
    private double price;
    private String dateOfAvailability;

    public Vehicle(String vehicleNumber, VehicleType vehicleType, int yearOfCreation, double price, String dateOfAvailability) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.yearOfCreation = yearOfCreation;
        this.price = price;
        this.dateOfAvailability = dateOfAvailability;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public double getPrice() {
        return price;
    }

    public String getDateOfAvailability() {
        return dateOfAvailability;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDateOfAvailability(String dateOfAvailability) {
        this.dateOfAvailability = dateOfAvailability;
    }
}

