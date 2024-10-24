package workshop01;

import java.io.*;
import java.util.*;

public class Grocery {

    public static void main(String[] args) throws IOException{
        
        String directoryName = "db"; 

        if (args.length > 0){
            directoryName = args[0];
        }

        File directory = new File(directoryName);

        if (! directory.exists()){
            directory.mkdir();
        }

        Console cons = System.console();

        List<String> cart = new ArrayList<>();

        ShoppingCartDB db = new ShoppingCartDB(directoryName);

        System.out.println("Welcome to your shopping cart");
        Boolean status = false;

        while (true) {
            String input = cons.readLine("> ");
            input = input + " ";
            String cmd = input.substring(0, input.indexOf(' '));

            switch (cmd) {
                case "login":
                    String[] name = input.split(" ");
                    cart = db.login(name[1]);
                    status = true;
                    break;
                case "save":
                    if (status == false){
                        System.out.println("Login to account");
                        break;
                    }
                    db.save(cart);
                    cart = null;
                    status = false;
                    break;
                case "users":
                    db.users();
                    break;
                case "list":
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty");
                    } else {
                        int count = 0;
                        for (String s : cart) {
                            count += 1;
                            System.out.printf("%d. %s \n", count, s);
                        }
                    }
                    break;
                case "add":
                    String[] cmdAdd = input.substring(input.indexOf(' ') + 1, input.length()).toLowerCase().split(",");
                    for (int i = 0; i < cmdAdd.length; i++) {
                        String curr = cmdAdd[i].trim();
                        if (cart.contains(curr)) {
                            System.out.printf("Cart already contains %s\n", curr);
                            continue;
                        } else {
                            cart.add(curr);
                            System.out.printf("%s added to cart\n", curr);
                        }

                    }
                    break;
                case "delete":
                    String cmdDel = input.substring(input.indexOf(' ') + 1, input.length()).trim();
                    int del = Integer.parseInt(cmdDel);
                    if (del > cart.size()) {
                        System.out.println("Incorrect item index");
                    } else {
                        cart.remove(del);
                    }
                    break;

            }

        }

    }

}
