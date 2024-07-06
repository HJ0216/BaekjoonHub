import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visitedDfs;
    static boolean[] visitedBfs;
    static int[][] adjacencyMatrix;
    static int node, line;

    static StringBuilder sbDfs = new StringBuilder();
    static StringBuilder sbBfs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        adjacencyMatrix = new int[node+1][node+1];
        visitedDfs = new boolean[node+1];
        visitedBfs = new boolean[node+1];

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adjacencyMatrix[s][e] = adjacencyMatrix[e][s] = 1;
        }

        dfs(v);
        bfs(v);

        bw.write(sbDfs.toString() + "\n");
        bw.write(sbBfs.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int v) {
        visitedDfs[v] = true;

        sbDfs.append(v + " ");

        for(int i=1; i<=node; i++){
            if(adjacencyMatrix[v][i] == 1 && !visitedDfs[i]){
                visitedDfs[i] = true;
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);

        visitedBfs[v] = true;

        sbBfs.append(v +" ");

        while (!queue.isEmpty()){
            int temp = queue.poll();

            for (int i=1; i<=node; i++){
                if(adjacencyMatrix[temp][i] == 1 && !visitedBfs[i]){
                    queue.offer(i);
                    visitedBfs[i] = true;

                    sbBfs.append(i +" ");
                }
            }
        }
    }
}