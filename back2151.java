import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back2151 {
    static class Pair{
        int x;
        int y;
        int d;
        int cost;
        public Pair(int x,int y,int d,int cost){
            this.x=x;
            this.y=y;
            this.d=d;
            this.cost=cost;
        }
    }
    static int n,sX,sY,ans;
    static char[][] map;    
    static int[][][] visited;        
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static void solve(){
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<4;i++){
            q.add(new Pair(sX,sY,i,0));           
        }
        while(!q.isEmpty()){
            Pair p=q.poll();
            int x=p.x;
            int y=p.y;
            int d=p.d;
            int cost=p.cost;
            int nx=x+dx[d];
            int ny=y+dy[d];            
            if(visited[y][x][d]<=cost)continue;
            visited[y][x][d]=cost;
            if(nx>=0&&nx<n&&ny>=0&&ny<n&&map[ny][nx]!='*'){
                if(map[ny][nx]=='!'){
                    q.add(new Pair(nx,ny,d,cost));
                    int nd=0;
                    if(d<2)nd=1-d;
                    else nd=5-d;                    
                    q.add(new Pair(nx,ny,nd,cost+1));
                    if(d==0)nd=3;
                    else if(d==1)nd=2;
                    else if(d==2)nd=1;
                    else nd=0;                 
                    q.add(new Pair(nx,ny,nd,cost+1));
                }
                else if(map[ny][nx]=='.'){
                    q.add(new Pair(nx,ny,d,cost));
                }    
                else{
                    ans=Math.min(ans,cost);
                }               
            }
        }               
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        map=new char[n][n];
        visited=new int[n][n][4];        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            String s=st.nextToken();
            for(int j=0;j<n;j++){
                char c=s.charAt(j);
                map[i][j]=c;
                if(c=='#'){
                    sX=j;
                    sY=i;
                }
            }
        }
        map[sY][sX]='*';
        ans=987654321;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<4;k++){
                    visited[i][j][k]=987654321;
                }
            }
        }                   
        solve();        
        System.out.println(ans);
    }    
}
