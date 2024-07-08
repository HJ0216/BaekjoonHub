import java.io.*;
import java.util.*;

public class Main {
    static int[][] cabbagesMap;
    static boolean[][] isVisited;
    static int M, N, K;
    static int[] dx = {0,0,-1,1}; // 상하좌우
    static int[] dy = {-1,1,0,0}; // 상하좌우
    static int cabbageWhiteWorms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for(int i=0; i<tc; i++){
            cabbageWhiteWorms = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            cabbagesMap = new int[M][N];
            isVisited = new boolean[M][N];

            K = Integer.parseInt(st.nextToken());
            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());

                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());

                cabbagesMap[p1][p2] = 1;
            }

            for(int x=0; x<M; x++){
                for(int y=0; y<N; y++){
                    if(cabbagesMap[x][y] == 1 && !isVisited[x][y]){
                        dfs(x,y);
                        cabbageWhiteWorms++;
                    }
                }
            }
            
            bw.append(cabbageWhiteWorms + "\n");
        }
        bw.close();
    }

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;

        for (int i=0; i<4; i++){
            int cx = dx[i] + x;
            int cy = dy[i] + y;

            if(checkVaildRange(cx, cy) && cabbagesMap[cx][cy] == 1 && !isVisited[cx][cy]){
                dfs(cx, cy);
            }
        }
    }

    private static boolean checkVaildRange(int cx, int cy) {
        return (cx >= 0 && cx < M && cy >= 0 && cy < N);
    }
}