import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int changes = 1000 -Integer.parseInt(br.readLine());

        int countCoins = 0;

        while (changes >0){
            if(changes >= 500){
                countCoins += changes / 500;
                changes -= 500*(changes / 500);
            }
            if(changes >= 100){
                countCoins += changes / 100;
                changes -= 100*(changes / 100);
            }
            if(changes >= 50){
                countCoins += changes / 50;
                changes -= 50*(changes / 50);
            }
            if(changes >= 10){
                countCoins += changes / 10;
                changes -= 10*(changes / 10);
            }
            if(changes >= 5){
                countCoins += changes / 5;
                changes -= 5*(changes / 5);
            }
            if(changes >= 1){
                countCoins += changes / 1;
                changes -= 1*(changes / 1);
            }
        }

        bw.write(countCoins + "");
        bw.close();

    }
}