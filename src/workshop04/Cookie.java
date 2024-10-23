package workshop04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cookie {

    File file;
    List<String> fortuneCookie = new ArrayList<>();

    public Cookie(File f) {
        this.file = f;
    }

    //open cookie file
    public void open() throws FileNotFoundException, IOException {
        //read the text file
        Reader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            fortuneCookie.add(line);
        }
        br.close();
        reader.close();
    }

    //close cookie file
    public void close(){
        this.file = null;
        this.fortuneCookie = null;
    }


    //return cookie text
    public String getCookie() {
        //generate random number
        Random rnd = new Random();
        int cookiePos = rnd.nextInt(fortuneCookie.size());
        String currCookie = fortuneCookie.get(cookiePos);
        return currCookie;

    }

}
