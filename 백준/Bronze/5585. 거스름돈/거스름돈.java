import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int changes = 1000 -Integer.parseInt(br.readLine());

        int[] coins = {500, 100, 50, 10, 5, 1};

        int countCoins = 0;

        for (int i=0; changes>0; i++){
            if(changes >= coins[i]){
                countCoins += (changes / coins[i]);
                changes -= coins[i] * (changes / coins[i]);
            }
        }

        bw.write(countCoins + "");
        bw.close();

    }
}