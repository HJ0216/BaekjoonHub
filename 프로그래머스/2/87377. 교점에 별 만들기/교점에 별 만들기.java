import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        // 1. 교점 구하기
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                Point intersection = getIntersectionPoint(line[i], line[j]);

                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

                // 2. 최소 교점, 최대 교점 구하기
        Point minimumPoint = getMinimumPoint(points);
        Point maxmimumPoint = getMaxmimumPoint(points);

        // 3. 배열 크기 구하기
        int width = (int) (maxmimumPoint.x - minimumPoint.x + 1);
        int height = (int) (maxmimumPoint.y - minimumPoint.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 4. 별찍기
        for (Point p : points) {
            int x = (int) (p.x - minimumPoint.x);
            int y = (int) (maxmimumPoint.y - p.y); // y가 클수록 배열 위치의 값이 작아짐

            arr[y][x] = '*';
        }

        // 5. String 배열 반환
        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(arr[i]);
        }

        return answer;

    }
    
    private static class Point{
        public final long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private Point getIntersectionPoint(int[] line1, int[] line2){
        long x1 = line1[0];
        long y1 = line1[1];
        long c1 = line1[2];

        long x2 = line2[0];
        long y2 = line2[1];
        long c2 = line2[2];

        double x = (double) (y1 * c2 - y2 * c1) / (x1 * y2 - x2 * y1);
        double y = (double) (x2 * c1 - x1 * c2) / (x1 * y2 - x2 * y1);

        if (x % 1 != 0 || y % 1 != 0)
            return null;

        return new Point((long) x, (long) y);
    }

    private Point getMinimumPoint(List<Point> points) {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for (Point p : points) {
            if(p.x < minX) minX = p.x;
            if(p.y < minY) minY = p.y;
        }

        return new Point(minX, minY);
    }
    
    private Point getMaxmimumPoint(List<Point> points) {
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point p : points) {
            if(p.x > maxX) maxX = p.x;
            if(p.y > maxY) maxY = p.y;
        }

        return new Point(maxX, maxY);
    }
}