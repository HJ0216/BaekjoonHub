import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int numberOfHouse, numberOfDanji, n;
    static boolean[][] isVisited;
    static int[] dx = {0,0,-1,1}; // 상하좌우
    static int[] dy = {-1,1,0,0}; // 상하좌우
    static int currentX, currentY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        isVisited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String data = br.readLine();
            for(int j=0; j<data.length(); j++){
                 map[i][j] = Character.getNumericValue(data.charAt(j));
            }
        }

        ArrayList<Integer> numbersOfHouse = new ArrayList<Integer>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !isVisited[i][j]){
                    numberOfDanji++;

                    numberOfHouse = 0;
                    bfs(i, j);
                    numbersOfHouse.add(numberOfHouse);
                }
            }
        }

        Collections.sort(numbersOfHouse);

        bw.append(numberOfDanji + "\n");

        for(int numberOfHouse : numbersOfHouse){
            bw.append(numberOfHouse + "\n");
        }

        bw.close();
    }
    
    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        isVisited[x][y] = true;

        while (!queue.isEmpty()){
            numberOfHouse++;

            int current[] = queue.poll();

            for (int i=0; i<4; i++){
                currentX = current[0] + dx[i];
                currentY = current[1] + dy[i];

                if(checkVaildRange() && map[currentX][currentY] == 1 && !isVisited[currentX][currentY]){
                    queue.offer(new int[]{currentX, currentY});
                    isVisited[currentX][currentY] = true;
                }
            }
        }
    }

    private static boolean checkVaildRange() {
        return (currentX >= 0 && currentX < n && currentY >= 0 && currentY < n);
    }
}