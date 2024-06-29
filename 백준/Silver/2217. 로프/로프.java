import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Integer[] ropes = new Integer[n];

        for (int i=0; i<n; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes, Collections.reverseOrder());

        int maxWeight = 0;

        for(int i=0; i<n; i++){
            int tempMaxWeight = ropes[i] * (i+1);
            if(tempMaxWeight > maxWeight){
                maxWeight = tempMaxWeight;
            }
        }

        bw.write(maxWeight + "");
        bw.close();

    }
}