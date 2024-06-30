import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] routes = new int[n-1];

        int index = 0;
        while (st.hasMoreTokens()){
            routes[index++] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int[] cities = new int[n];

        index = 0;
        while (st.hasMoreTokens()){
            cities[index++] = Integer.parseInt(st.nextToken());
        }

        int price = 0;
        for(int i=0; i< cities.length; i++){
            int tempMin = Arrays.stream(cities, (i+1), (cities.length-1)).min().getAsInt();
            if(cities[i]>tempMin){
                price += cities[i] * routes[i];
            } else {
                for (int j=i; j< routes.length; j++){
                    price += cities[i] * routes[j];
                }

                break;
            }
        }

        bw.write(price + "");
        bw.close();

    }
}