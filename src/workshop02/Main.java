package workshop02;

public class Main {
    
    public static void main(String[] args) {
        
        BankAccount fred = new BankAccount("fred");
        BankAccount barney = new BankAccount("barney", 3000f);

        fred.deposit(500f);

        fred.withdraw(200f);

        barney.withdraw(300f);

        barney.deposit(200f);

        System.out.println(fred.getTransaction());

        System.out.println(barney.getTransaction());

        System.out.println(fred.getCreationTime());

        System.out.println(barney.getCreationTime());

        FixedDepositAccount mary = new FixedDepositAccount("Mary", 300f);

        FixedDepositAccount jane = new FixedDepositAccount("Jane", 900f, 20f);

        mary.deposit(200f);

        jane.withdraw(300f);

        System.out.println(mary.getTransaction());

        System.out.println(jane.getTransaction());

        System.out.println(mary.getBalanece());
        
        System.out.println(jane.getBalanece());
    }

}
