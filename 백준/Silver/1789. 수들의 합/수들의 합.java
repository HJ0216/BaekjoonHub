import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long s = Long.parseLong(br.readLine());

        long increment = 1;

        while (s>0){
            s -= increment++;

            if(s < increment)
                break;
        }

        bw.write((increment-1) + "");
        bw.close();

    }
}