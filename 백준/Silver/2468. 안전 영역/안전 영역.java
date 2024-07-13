import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] isVisited;
    static int N;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        isVisited = new boolean[N][N];

        int heightMax = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                int height = Integer.parseInt(st.nextToken());
                graph[i][j] = height;
                heightMax = Math.max(height, heightMax);
            }
        }

        int countMax = 0;

        for (int h=0; h<=heightMax; h++){
            isVisited = new boolean[N][N];
            int count = 0;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(graph[i][j] > h && !isVisited[i][j]) {
                        dfs(i,j, h);
                        count++;
                    }
                }
            }

            countMax = Math.max(count, countMax);
        }

        bw.append(countMax+"");

        bw.close();
    }

    private static void dfs(int x, int y, int h) {
        isVisited[x][y] = true;

        for(int i=0; i<4; i++){
            int movedX = x + dx[i];
            int movedY = y + dy[i];

            if(checkVaildRange(movedX, movedY) && graph[movedX][movedY] > h && !isVisited[movedX][movedY]){
                dfs(movedX, movedY, h);
            }
        }
    }
    
    private static boolean checkVaildRange(int cx, int cy) {
        return (cx >= 0 && cx < N && cy >= 0 && cy < N);
    }
}