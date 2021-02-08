import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak17267 {
    static class Pair{
        int x;
        int y;
        int left;
        int right;
        public Pair(int x,int y,int left,int right){
            this.x=x;
            this.y=y;
            this.left=left;
            this.right=right;
        }
    }
    static int n,m;
    static int l,r;
    static int x,y;
    static int[][] map;
    static boolean[][] v;
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    static void bfs(int sX,int sY){
           v[sY][sX]=true;
           Queue<Pair>q=new LinkedList<>();
           q.add(new Pair(sX,sY,l,r));
           int cnt=1;
           while(!q.isEmpty()){
               Pair p=q.poll();
               int x=p.x;
               int y=p.y;
               int left=p.left;
               int right=p.right;
               for(int i=0;i<2;i++){
                   int nx=x;
                   int ny=y;
                   while(ny>=0&&ny<n){
                       if(map[ny][nx]==1)break;
                       if(ny>=0&&ny<n&&nx>=0&&nx<m&&!v[ny][nx]&&map[ny][nx]!=1){
                           q.add(new Pair(nx,ny,left,right));
                           v[ny][nx]=true;
                           cnt++;
                       }
                       nx+=dx[i];
                       ny+=dy[i];
                   }
               }
               for(int i=2;i<4;i++){
                   int nx=x+dx[i];
                   int ny=y+dy[i];
                   if(i==2&&left==0)continue;
                   if(i==3&&right==0)continue;
                   if(nx>=0&&nx<m&&ny>=0&&ny<n&&!v[ny][nx]&&map[ny][nx]!=1){
                       v[ny][nx]=true;
                       if(i==2)q.add(new Pair(nx,ny,left-1,right));
                       else q.add(new Pair(nx,ny,left,right-1));
                       cnt++;
                   }
               }
           }
           System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        l=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        v=new boolean[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            String s=st.nextToken();
            for(int j=0;j<m;j++){
                char c=s.charAt(j);
                map[i][j]=c-'0'; 
                if(map[i][j]==2){
                    x=j;
                    y=i;
                }               
            }
        }        
        bfs(x,y);
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(v[i][j])System.out.print(1+" ");
        //         else System.out.print(0+" ");
        //     }
        //     System.out.println();
        // }
    }
}
