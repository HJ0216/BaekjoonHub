import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int p[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);

        int result = 0;

        for(int i = 0; i<n; i++){
            result += p[i] * (n-i);
        }

        bw.write(result + "");
        bw.close();
    }
}