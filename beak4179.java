import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak4179 {
    static int n,m,sX,sY;
    static int[][] map;
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static Queue<Pair>fire=new LinkedList<>();
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static boolean[][] v;
    static boolean check(int x,int y){
        return x>=0&&x<=m+1&&y>=0&&y<=n+1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder();  
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n+2][m+2];
        v=new boolean[n+2][m+2];
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(bf.readLine()); 
            String s=st.nextToken();
            for(int j=1;j<=m;j++){
                char c=s.charAt(j-1);
                if(c=='#'){
                    map[i][j]=1;
                }else if(c=='F'){
                    fire.add(new Pair(j,i));
                    map[i][j]=2;
                }else if(c=='J'){
                    sX=j;
                    sY=i;
                    v[i][j]=true;
                }
            }
        }
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(sX,sY));
        int cnt=0;
        while(!q.isEmpty()){
            int fSize=fire.size();
            for(int i=0;i<fSize;i++){
                Pair p=fire.poll();                
                int x=p.x;
                int y=p.y;
                for(int k=0;k<4;k++){
                    int nx=x+dx[k];
                    int ny=y+dy[k];                    
                    if(nx>=1&&nx<=m&&ny>=1&&ny<=n&&map[ny][nx]==0){
                        map[ny][nx]=2;
                        fire.add(new Pair(nx,ny));
                    }
                }
            }   
            int qSize=q.size();            
            for(int i=0;i<qSize;i++){
                Pair p=q.poll();
                int x=p.x;
                int y=p.y;                          
                if(x==0||x==m+1||y==0||y==n+1){
                    System.out.println(cnt);
                    return;
                }
                for(int k=0;k<4;k++){
                    int nx=x+dx[k];
                    int ny=y+dy[k];
                    if(check(nx, ny)&&!v[ny][nx]&&map[ny][nx]==0){
                        v[ny][nx]=true;
                        q.add(new Pair(nx,ny));
                    }
                }
            }
            
            // for(int i=0;i<=n+1;i++){
            //     for(int j=0;j<=m+1;j++){
            //         System.out.print(map[i][j]);
            //     }
            //     System.out.println();
            // } 
            // System.out.println();   
            cnt++;
        }
        System.out.println("IMPOSSIBLE");
    }
}
