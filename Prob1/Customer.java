package L3.Prob1;

public class Customer {
    private String firstName;
    private String lastName;
    private String socSecurityNum;
    private Address billingAddress;
    private Address shippingAddress;

    public Customer(String firstName, String lastName, String socSecurityNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socSecurityNum = socSecurityNum;
    }
    public void setShippingAddress(String street, String city, String state, String zip)
    {
        shippingAddress=new Address(street,city,state,zip);
    }
    public void setBillingAddress(String street, String city, String state, String zip)
    {
        billingAddress=new Address(street,city,state,zip);
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public String toString() {
        return "[" + firstName + ", " + lastName + ", " + "ssn: " + socSecurityNum + "]";
    }
}
