package workshop01;

import java.io.*;
import java.util.*;

public class ShoppingCartDB {

    public String directoryName;
    public String filename;
    public File f;

    public ShoppingCartDB(String f){
        this.directoryName = f;
    }
    
    public List<String> login(String name) throws IOException{

        filename = directoryName + "/" + name + ".db";
        f = new File(filename);
        f.createNewFile();

        Reader reader = new FileReader(f);
        BufferedReader br = new BufferedReader(reader);

        List<String> cart = new ArrayList<>();

        while (true){
            String curr = br.readLine();
            if (curr == null){
                break;
            }
            cart.add(curr);
        }

        return cart;

    }

    public void save(List<String> c) throws IOException{
        Writer writer = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(writer);

        for (int i = 0; i < c.size(); i++){
            bw.write(c.get(i));
            bw.newLine();
            bw.flush();
        }

        bw.close();

    }

    public void users(){
        File d = new File(directoryName);
        for (File f: d.listFiles()){
            String ans = f.getName().substring(0, f.getName().length()-3);
            System.out.println(ans);
        }
    }



}
