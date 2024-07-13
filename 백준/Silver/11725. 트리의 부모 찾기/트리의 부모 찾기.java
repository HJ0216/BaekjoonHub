import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static boolean[] isVisited;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        parent = new int[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            graph[p1].add(p2);
            graph[p2].add(p1);
        }

        bfs(1);

        for (int i=2; i<=N; i++){
            bw.append(parent[i] + "\n");
        }

        bw.close();
    }

    private static void bfs(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);

        isVisited[index] = true;

        while (!queue.isEmpty()){
            int current = queue.poll();

            for (int node : graph[current]){
                if(!isVisited[node]){
                    queue.offer(node);
                    parent[node] = current;
                    isVisited[node] =  true;
                }
            }
        }
    }
}