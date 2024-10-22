package workshop01Original;

import java.io.*;
import java.util.*;

public class Grocery {

    public static void main(String[] args) {

        Console cons = System.console();

        List<String> cart = new ArrayList<>();

        System.out.println("Welcome to your shopping cart");

        while (true) {
            String input = cons.readLine("> ");
            input = input + " ";
            String cmd = input.substring(0, input.indexOf(' '));

            switch (cmd) {
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
