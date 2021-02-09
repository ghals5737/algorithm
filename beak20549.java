import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak20549 {
    static class Pair{
        int x;
        int y;
        int state;
        int cost;
        public Pair(int x,int y,int state,int cost){
            this.x=x;
            this.y=y;
            this.state=state;
            this.cost=cost;
        }
    }
    static int n,a,b,c,m;
    static int sX,sY;
    static int[][] map;
    static int[][][] v;
    static int[] dx1={1,2,2,1,-1,-2,-2,-1};
    static int[] dy1={-2,-1,1,2,2,1,-1,-2};
    static int[] dx2={1,1,-1,-1};
    static int[] dy2={-1,1,1,-1};
    static int[] dx3={0,1,0,-1};
    static int[] dy3={-1,0,1,0};
    static int ans;
    static boolean check(int x,int y){
        return x>=0&&x<n&&y>=0&&y<n;
    }
    static void solve(int sX,int sY){
        v[sX][sY][1]=0; 
        PriorityQueue<Pair>pq=new PriorityQueue<>((Pair a,Pair b)->{return a.cost-b.cost;});
        pq.add(new Pair(sX, sY, 1, 0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int x=p.x;
            int y=p.y;
            int state=p.state;
            int cost=p.cost;
            if(state==(1<<m+1)-1){
                ans=Math.min(ans,cost);
                continue;
            }
            if(v[y][x][state]<cost)continue;
            for(int i=0;i<8;i++){
                int nx=x+dx1[i];
                int ny=y+dy1[i];
                if(check(nx,ny)){
                    int nextState=state|(1<<map[ny][nx]);
                    if(v[ny][nx][nextState]>cost+a){
                        v[ny][nx][nextState]=cost+a;
                        pq.add(new Pair(nx,ny,nextState,cost+a));
                    }
                }
            }
            for(int i=0;i<4;i++){
                int nx=x+dx2[i];
                int ny=y+dy2[i];
                while(check(nx,ny)){
                    int nextState=state|(1<<map[ny][nx]);
                    if(v[ny][nx][nextState]>cost+b){
                        v[ny][nx][nextState]=cost+b;
                        pq.add(new Pair(nx,ny,nextState,cost+b));
                    }
                    nx+=dx2[i];
                    ny+=dy2[i];
                }
            }
            for(int i=0;i<4;i++){
                int nx=x+dx3[i];
                int ny=y+dy3[i];
                while(check(nx,ny)){
                    int nextState=state|(1<<map[ny][nx]);
                    if(v[ny][nx][nextState]>cost+c){
                        v[ny][nx][nextState]=cost+c;
                        pq.add(new Pair(nx,ny,nextState,cost+c));
                    }
                    nx+=dx3[i];
                    ny+=dy3[i];
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        sY=Integer.parseInt(st.nextToken());
        sX=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][n];
        v=new int[n][n][32];
        ans=0;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            map[y][x]=i+1;
        }
        
        for(int i=0;i<n;i++)for(int j=0;j<n;j++)for(int k=0;k<32;k++)v[i][j][k]=987654321;
        ans=987654321;         
        solve(sX, sY);
        System.out.println(ans);
    }    
}
