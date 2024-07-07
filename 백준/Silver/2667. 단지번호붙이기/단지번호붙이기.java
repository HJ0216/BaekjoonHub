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
                map[i][j] = data.charAt(j) - '0';
                // map[i][j] = Character.getNumericValue(data.charAt(j));
            }
        }

        ArrayList<Integer> numbersOfHouse = new ArrayList<Integer>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !isVisited[i][j]){
                    numberOfDanji++;

                    numberOfHouse = 0;
                    dfs(i,j);
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

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;
        map[x][y] = numberOfDanji;
        numberOfHouse++;

        for (int i=0; i<4; i++){
            currentX = dx[i] + x;
            currentY = dy[i] + y;

            if(checkVaildRange() && map[currentX][currentY] == 1 && !isVisited[currentX][currentY]){
                isVisited[currentX][currentY] = true;
                map[currentX][currentY] = numberOfDanji;

                dfs(currentX, currentY);
            }
        }

    }

    private static boolean checkVaildRange() {
        return (currentX >= 0 && currentX < n && currentY >= 0 && currentY < n);
    }
}