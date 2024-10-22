package workshop02;

public class FixedDepositAccount extends BankAccount{
    
    private final Float interest;
    private final int duration;

    public FixedDepositAccount(String n, Float b){
        super(n,b);
        this.interest = 3f;
        this.duration = 6;
    }

    public FixedDepositAccount(String n, Float b, Float i){
        super(n,b);
        this.interest = i;
        this.duration = 6;
    }

    public FixedDepositAccount(String n, Float b, Float i, Integer d){
        super(n, b);
        this.interest = i;
        this.duration = d;
    }

    @Override
    public void deposit(Float f){

    }

    @Override
    public void withdraw(Float f){

    }

    public Float getBalanece(){
        accBal += this.interest;
        return accBal;
    }

}
