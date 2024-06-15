import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int kindOfCoins[] = new int[n];

        for (int i = 0; i<n; i++){
            kindOfCoins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(kindOfCoins);

        int changes = k;
        int countOfCoins = 0;

        for (int i = n-1; i>=0; i--){
            if(kindOfCoins[i] <= changes){
                countOfCoins += changes / kindOfCoins[i];
                changes = changes % kindOfCoins[i];
            }
        }

        bw.write(countOfCoins + "");
        bw.close();
    }
}