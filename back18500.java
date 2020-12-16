import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class back18500 {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static int[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int n;
    static int m;
    static int maxR;
    static ArrayList<Pair> list;

    static void dfs(int x, int y) {
        visited[y][x] = 1;
        maxR=Math.max(maxR,y);
        list.add(new Pair(x, y));
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (visited[ny][nx] == 0 && map[ny][nx] == 'x') {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new char[n][m];

        for(int i=0;i<n;i++){
            String s=bf.readLine();
            for(int j=0;j<m;j++){
                char c=s.charAt(j);
                map[i][j]=c;
            }
        }
        int k=Integer.parseInt(bf.readLine());
        boolean flag=false;
        st=new StringTokenizer(bf.readLine());
        for(int ii=0;ii<k;ii++){
            int r=n-Integer.parseInt(st.nextToken());
            visited=new int[n][m];
            if(!flag){
                for(int i=0;i<m;i++){
                    if(map[r][i]=='x'){
                        map[r][i]='.';
                        break;
                    }
                }
            }
            else{
                for(int i=m-1;i>=0;i--){
                    if(map[r][i]=='x'){
                        map[r][i]='.';
                        break;
                    }
                }
            }
            int num=1;
            boolean isBreak=false;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(visited[i][j]==0&&map[i][j]=='x'){
                        list=new ArrayList<>();
                        maxR=0;
                        dfs(j, i);
                        if(maxR==n-1)continue;
                        int diff=n;
                        boolean[][] arr=new boolean[n][m];

                        for(Pair p:list){
                            int y=p.y;
                            int x=p.x;
                            visited[y][x]=0;
                            arr[y][x]=true;
                        }

                        for(Pair p:list){
                            int minR=0;                            
                            int x=p.x;
                            int y=p.y;
                            for(minR=y+1;minR<n&&map[minR][x]=='.';minR++);
                            if(minR<n&&arr[minR][x])continue;
                            //System.out.println(x+" "+y+" "+minR);
                            diff=Math.min(diff,minR-y-1);
                        }
                        for(Pair p:list){
                            int x=p.x;
                            int y=p.y;
                            map[y][x]='.';
                        }

                        if(diff==n)diff=0;
                        for(Pair p:list){
                            int y=p.y;
                            int x=p.x;                            
                            map[y+diff][x]='x';
                        }
                        isBreak=true;
                        break;
                    }
                }
                if(isBreak)break;
            }
            flag=!flag;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
