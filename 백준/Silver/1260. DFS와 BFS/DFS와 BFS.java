import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] adjacencyList;
    static int node, line;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[node+1];
        visited = new boolean[node+1];

        for (int i=1; i<=node; i++){
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjacencyList[from].add(to);
            adjacencyList[to].add(from);
        }

        for (int i=1; i<=node; i++){
            Collections.sort(adjacencyList[i]);
        }

        dfsList(v);
        sb.append("\n");

        Arrays.fill(visited, false);

        bfsList(v);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfsList(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(v);
        visited[v] = true;

        sb.append(v +" ");

        while (!queue.isEmpty()){
            int current = queue.poll();

            for(int node : adjacencyList[current]){
                if(!visited[node]){
                    queue.offer(node); // 다음 레벨 방문을 위해 저장
                    visited[node] = true;

                    sb.append(node +" ");
                }
            }
        }
    }

    private static void dfsList(int v) {
        visited[v] = true;

        sb.append(v +" ");

        for(int node : adjacencyList[v]){
            if(!visited[node]){
                dfsList(node);
            }
        }
    }
}