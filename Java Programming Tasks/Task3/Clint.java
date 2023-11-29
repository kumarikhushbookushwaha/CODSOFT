

public class Clint {
    private String name;
    private String address;
    private long phoneNumber;
    private float accountBalance;
    private int atmPin;
    private String accountType;
    private boolean creditCard;
    private int craditCardNumber;

    public Clint(String name, long phoneNumber, float accountBalance, int atmPin) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.accountBalance = accountBalance;
        this.atmPin = atmPin;
    }

    public int getAtmPin() {
        return atmPin;
    }

    public void setAtmPin(int atmPin) {
        this.atmPin = atmPin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public boolean isCreditCard() {
        return creditCard;
    }

    public void setCreditCard(boolean creditCard) {
        this.creditCard = creditCard;
    }

    public int getCraditCardNumber() {
        return craditCardNumber;
    }

    public void setCraditCardNumber(int craditCardNumber) {
        this.craditCardNumber = craditCardNumber;
    }

    @Override
    public String toString() {
        return "Clint [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
    }

    public float chechBalance() {
        return accountBalance;
    }

    public float withdraw(float ammount) {
        if (accountBalance < 500 || ammount > accountBalance) {
            return -1;
        }

        else {
            accountBalance = accountBalance - ammount;
            return accountBalance;
        }
    }

    public float credit(float ammount) {
        accountBalance = accountBalance + ammount;
        return accountBalance;
    }

}
