import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int result = n;

        for(int i=n/5; i>=0; i--){
            for(int j=0; j<=n/3; j++){
                if(n == (5*i + 3*j)){
                    result = (result > (i+j)) ? (i+j) : result;
                }
            }
        }

        if(result == n){
            bw.write("-1");
        } else {
            bw.write(result + "");
        }

        bw.close();
    }
}