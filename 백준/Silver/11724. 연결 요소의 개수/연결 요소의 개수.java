import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[] isVisited;
    static int M, N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        isVisited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            graph[p1][p2] = graph[p2][p1] = 1;
        }

        for(int i=1; i<=N; i++){
            if(!isVisited[i]){
                dfs(i);
                count++;
            }
        }

        bw.append(count + "\n");
        bw.close();
    }

    private static void dfs(int v) {
        isVisited[v] = true;

        for(int i=1; i<=N; i++){
            if(graph[v][i] == 1 && !isVisited[i])
                dfs(i);
        }
    }
}