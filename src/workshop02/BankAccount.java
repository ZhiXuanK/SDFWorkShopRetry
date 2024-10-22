package workshop02;

import java.time.LocalDateTime;
import java.util.*;

public class BankAccount {

    private final String name;
    private final String accNum;
    protected Float accBal;
    private List<String> transaction;
    private boolean status;
    private LocalDateTime creationTime;
    private LocalDateTime closingTime;

    public BankAccount(String n) {
        Random rnd = new Random();
        this.name = n;
        this.accNum = Float.toString(100000 + rnd.nextInt(900000));
        this.accBal = 0f;
        this.transaction = new ArrayList<>();
        this.status = true;
        this.creationTime = LocalDateTime.now();
    }

    public BankAccount(String n, Float b){
        Random rnd = new Random();
        this.name = n;
        this.accNum = Float.toString(100000 + rnd.nextInt(900000));
        this.accBal = b;
        this.transaction = new ArrayList<>();
        this.status = true;
        this.creationTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getAccNum() {
        return accNum;
    }

    public Float getAccBal() {
        return accBal;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public boolean isStatus() {
        return status;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public LocalDateTime getClosingTime() {
        return closingTime;
    }

    public void deposit(Float f){
        if (f < 0f || status != true){
            throw new IllegalArgumentException("Deposit amount must be positive");
        } else {
            accBal += f;
            LocalDateTime curr = LocalDateTime.now();
            String currStr = curr.toString();
            String trans = String.format("deposit %f at %s", f, currStr);
            transaction.add(trans);
            System.out.println(trans);
        }
    }

    public void withdraw (Float f){
        if (f < 0f || status != true){
            throw new IllegalArgumentException("Withdrawal amount should be positive");
        } else {
            accBal -= f;
            LocalDateTime curr = LocalDateTime.now();
            String currStr = curr.toString();
            String trans = String.format("withdraw %f at %s", f, currStr);
            transaction.add(trans);
            System.out.println(trans);
        }

    }



}
