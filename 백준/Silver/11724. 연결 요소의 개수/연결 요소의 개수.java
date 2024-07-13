import java.io.*;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int[][] graph;
//    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;
    static int M, N;
    static int count;

    public static void main(String[] args) throws IOException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        // Press Shift+F9 to start debugging your code. We have set one breakpoint
        // for you, but you can always add more by pressing Ctrl+F8.

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
                bfs(i);
                count++;
            }
        }

        bw.append(count + "\n");

        bw.close();
    }

    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);

        isVisited[start] = true;

        while (!queue.isEmpty()){
            int temp = queue.poll();

            for (int i=1; i<=N; i++){
                if(graph[temp][i] == 1 && !isVisited[i]){
                    queue.offer(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}