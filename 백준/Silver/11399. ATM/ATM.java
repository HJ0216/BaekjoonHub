import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int counting[] = new int[1001]; // idx: 걸리는 시간

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            counting[Integer.parseInt(st.nextToken())]++;
        }

        int sum = 0;
        int preSum = 0;

        for(int i = 0; i<1001; i++){
            while(counting[i]-- > 0){
                sum += (i + preSum);
                preSum += i;
            }
        }

        bw.write(sum + "");
        bw.close();
    }
}