import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back16933 {
    static class Pair{
        int x;
        int y;
        int cnt;
        int dist;
        public Pair(int x,int y,int cnt,int dist){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
            this.dist=dist;
        }
    }
    static int n,m,k;
    static int[][] map;
    static int[][][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        
        map=new int[n][m];
        visited=new int[n][m][k+1];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            String s=st.nextToken();
            for(int j=0;j<m;j++){
               map[i][j]=s.charAt(j)-'0';
            }
        }
        q.add(new Pair(0,0,0,1));
        visited[0][0][0]=1;
        boolean sun=true;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                int x=p.x;
                int y=p.y;
                int cnt=p.cnt;
                int dist=p.dist;
                boolean stop=false;
                if(x==m-1&&y==n-1){
                    System.out.println(dist);
                    return;
                }
                for(int j=0;j<4;j++){
                    int nx=x+dx[j];
                    int ny=y+dy[j];
                    if(nx>=0&&nx<m&&ny>=0&&ny<n){
                        if(map[ny][nx]==0&&visited[ny][nx][cnt]==0){
                            visited[ny][nx][cnt]=1;
                            q.add(new Pair(nx,ny,cnt,dist+1));
                        }else if(cnt<k&&visited[ny][nx][cnt+1]==0){
                            if(sun){
                                visited[ny][nx][cnt+1]=1;
                                q.add(new Pair(nx,ny,cnt+1,dist+1));
                            }else{
                                stop=true;
                            }                         
                        }
                    }
                }
                if(stop){
                    q.add(new Pair(x, y, cnt, dist+1));
                }                
            }
            sun=!sun;       
        }
        System.out.println(-1);
        return;
    }    
}
