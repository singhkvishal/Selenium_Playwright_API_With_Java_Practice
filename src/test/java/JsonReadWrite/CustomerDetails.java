package JsonReadWrite;

public class CustomerDetails {
    private String courseName;
    private String purchasedDate;
    private int amount;
    private String location;
    private Discount discount;

    public static class Discount {
        private int discountedAmount;
        private int discountPercentage;

        public int getDiscountedAmount() {
            return discountedAmount;
        }

        public void setDiscountedAmount(int discountedAmount) {
            this.discountedAmount = discountedAmount;
        }

        public int getDiscountPercentage() {
            return discountPercentage;
        }

        public void setDiscountPercentage(int discountPercentage) {
            this.discountPercentage = discountPercentage;
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(String purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
