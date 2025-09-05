package L3.Prob1;

public class Main {
    public static void main(String[] args) {
        Customer custA=new Customer("John","Doe","339-337-814");
        custA.setBillingAddress("4th N Street", "Fairfield","IA","52556");
        custA.setShippingAddress("111 N Canal St", "Chicago","IL","60606");


        Customer custB=new Customer("Mike","Biden","641-337-112");
        custB.setBillingAddress("113 N Canal St", "Chicago","IL","60601");
        custB.setShippingAddress("4th N Street", "Fairfield","IA","52556");

        Customer custC=new Customer("Nur","Ablikim","761-337-119");
        custC.setBillingAddress("231 N Canal St", "Chicago","IL","60608");
        custC.setShippingAddress("4th N Street", "Fairfield","IA","52556");

        Customer[] cust={custA, custB, custC};

        for (Customer c: cust)
        {
            if (c.getBillingAddress().getCity().equalsIgnoreCase("Chicago"))
            {
                System.out.println("Customer: "+ c.toString());
                System.out.println("Billing Address: " + c.getBillingAddress().toString());

            }
        }

    }
}
