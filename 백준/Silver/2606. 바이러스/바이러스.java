import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] adjacencyList;
    static int count = 0;
    static int node, line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[node+1];
        visited = new boolean[node+1];

        for (int i=1; i<=node; i++){
            adjacencyList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<line; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adjacencyList[s].add(e);
            adjacencyList[e].add(s);
        }

        dfs(1);

        bw.write(count+"");
        bw.flush();
        bw.close();
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int i : adjacencyList[start]){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
    }
}