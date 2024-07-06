import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check;
    static int[][] arr;
    static int count = 0;
    static int node, line;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for (int i=0; i<line; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            arr[nodeA][nodeB] = arr[nodeB][nodeA] = 1;
        }
        
        dfs(1);

        bw.write(count-1+"");
        bw.flush();
        bw.close();
    }

    private static void dfs(int start) {
        check[start] = true;
        count++;

        for (int i=0; i<= node; i++){
            if(arr[start][i] == 1 && !check[i]){
                dfs(i);
            }
        }
    }
}