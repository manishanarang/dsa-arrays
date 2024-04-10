import java.util.*;

class Solution {

   private static class Point {
      public final int x;
      public final int y;

      public final int integer;

      public final int distance;

      public Point(int x, int y, int integer, int distance) {
         this.x = x;
         this.y = y;
         this.integer = integer;
         this.distance = distance;
      }

      @Override
      public String toString() {
         return "(" + x + ", " + y + ")";
      }
   }

   private static class PointComparator implements Comparator<Point> {

      @Override
      public int compare(Point o1, Point o2) {
         if (o1.distance != o2.distance) {
            return Integer.compare(o1.distance, o2.distance);
         }
         if (o1.integer != o2.integer) {
            return Integer.compare(o1.integer, o2.integer);
         }
         if (o1.x != o2.x) {
            return Integer.compare(o1.x, o2.x);
         }
         return Integer.compare(o1.y, o2.y);

      }
   }


   private static void update(int x, int y, int distance, int m, int n, int[][] grid, boolean[][] visited, PriorityQueue<Point> pq) {
      if (x < 0 || x >= m || y < 0 || y >= n) {
         return;
      }
      if (visited[x][y]) {
         return;
      }

      if (grid[x][y] == 0) {
         return;
      }


      pq.add(new Point(x, y, grid[x][y], distance));

   }

   public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
      final int m = grid.length;
      final int n = grid[0].length;

      var visited = new boolean[m][n];
      var pq = new PriorityQueue<Point>(new PointComparator());
      pq.add(new Point(start[0], start[1], grid[start[0]][start[1]], 0));

      var ans = new ArrayList<List<Integer>>();

      while (!pq.isEmpty()) {
         var point = pq.poll();
         int x = point.x;
         int y = point.y;
         int distance = point.distance;
         int integer = point.integer;
         if (visited[x][y]) {
            continue;
         }
         visited[x][y] = true;


         if (pricing[0] <= integer && integer <= pricing[1]) {
            ans.add(new ArrayList<>(Arrays.asList(x, y)));
            if (ans.size() == k) {
               return ans;
            }
         }


         update(x - 1, y, distance + 1, m, n, grid, visited, pq);
         update(x + 1, y, distance + 1, m, n, grid, visited, pq);
         update(x, y - 1, distance + 1, m, n, grid, visited, pq);
         update(x, y + 1, distance + 1, m, n, grid, visited, pq);
      }


      return ans;
   }
}