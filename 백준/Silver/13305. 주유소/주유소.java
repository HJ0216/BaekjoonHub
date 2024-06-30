import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] distance = new int[n-1];
        int[] costs = new int[n];

        int index = 0;
        while (st.hasMoreTokens()){
            distance[index++] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        index = 0;
        while (st.hasMoreTokens()){
            costs[index++] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long minCost = costs[0];
        for(int i=0; i< n-1; i++){
            if(costs[i]<minCost){
                minCost = costs[i];
            }

            sum += minCost*distance[i];
        }

        bw.write(sum + "");
        bw.close();

    }
}