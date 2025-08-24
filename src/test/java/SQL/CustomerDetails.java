package SQL;

public class CustomerDetails {
    public String getCourseName() {
        return courseName;
    }

    public String getPurchasedDate() {
        return purchasedDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setPurchasedDate(String purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String courseName;
    private String purchasedDate;
    private int amount;
    private String location;

    //get set
}
