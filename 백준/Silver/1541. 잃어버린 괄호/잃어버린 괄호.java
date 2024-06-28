import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stSubstraction = new StringTokenizer(br.readLine(), "-");

        int sum = Integer.MAX_VALUE;

        while (stSubstraction.hasMoreTokens()){
            int tempSum = 0;

            StringTokenizer stAddition = new StringTokenizer(stSubstraction.nextToken(), "+");
            while (stAddition.hasMoreTokens()){
                tempSum += Integer.parseInt(stAddition.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = tempSum;
            }else {
                sum -= tempSum;
            }
        }

        bw.write(sum + "");
        bw.close();

    }
}