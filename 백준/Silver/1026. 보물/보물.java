import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[][] b = new int[n][2];

        StringTokenizer stA = new StringTokenizer(br.readLine());

        int count = 0;
        while (stA.hasMoreTokens()){
            a[count++] = Integer.parseInt(stA.nextToken());
        }

        StringTokenizer stB = new StringTokenizer(br.readLine());

        count = 0;
        while (stB.hasMoreTokens()){
            b[count++][0] = Integer.parseInt(stB.nextToken());
        }

        Arrays.sort(a);

        int sum = 0;
        for (int i=n-1; i>=0; i--){
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;

            for(int j=0; j<n; j++){
                if((b[j][1] == 0) && (minSum > (a[i] * b[j][0]))){
                    minSum = (a[i] * b[j][0]);
                    minIndex = j;
                }
            }

            b[minIndex][1] = 1;
            sum += minSum;
        }

        bw.write(sum + "");
        bw.close();

    }
}