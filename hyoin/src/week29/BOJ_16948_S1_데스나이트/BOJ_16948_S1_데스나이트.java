import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16948_S1_데스나이트 {
    public static int N;
    public static Node start;
    public static Node end;
    public static int[] dx = {-2, -2, 0, 0, 2, 2};
    public static int[] dy = {-1, 1, -2, 2, -1, 1};
    public static int result;

    public static class Node{
        int x;
        int y;
        int depth;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        result = -1;
        bfs();

        System.out.println(result);
    }

    public static void bfs(){
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][N];
        queue.offer(start);
        isVisited[start.x][start.y]=true;

        while (!queue.isEmpty()){
            Node cur = queue.poll();

            if(cur.x == end.x && cur.y == end.y){
                result = cur.depth;
                return;
            }

            for (int i=0; i<dx.length; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx>=0&&nx<N&&ny>=0&&ny<N){
                    if (!isVisited[nx][ny]){
                        isVisited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, cur.depth+1));
                    }
                }
            }
        }
    }

}
