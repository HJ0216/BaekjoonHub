import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] coins = {25, 10, 5, 1};

        StringBuilder sb = new StringBuilder();

        while (t-->0){
            int c = Integer.parseInt(br.readLine());

            for (int i=0; i<coins.length; i++){
                if(c >= 0){
                    sb.append((c/coins[i]) + " ");
                    c = (c % coins[i]);
                }
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();

    }
}