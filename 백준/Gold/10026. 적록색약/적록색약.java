import java.io.*;
import java.util.*;

public class Main {
    static char[][] graph;
    static boolean[][] isVisited;
    static int N;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];
        isVisited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                graph[i][j] = line.charAt(j);
            }
        }

        int rgb = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!isVisited[i][j]) {
                    dfs(i,j);
                    rgb++;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(graph[i][j] == 'R'){
                    graph[i][j] = 'G';
                }
            }
        }

        isVisited = new boolean[N][N];
        int yb = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!isVisited[i][j]) {
                    dfs(i,j);
                    yb++;
                }
            }
        }

        bw.append(rgb + " " + yb);

        bw.close();
    }

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;

        char currentChar = graph[x][y];

        for(int i=0; i<4; i++){
            int movedX = x + dx[i];
            int movedY = y + dy[i];

            if(checkVaildRange(movedX, movedY) && graph[movedX][movedY] == currentChar && !isVisited[movedX][movedY]){
                dfs(movedX, movedY);
            }
        }
    }

    private static boolean checkVaildRange(int cx, int cy) {
        return (cx >= 0 && cx < N && cy >= 0 && cy < N);
    }
}