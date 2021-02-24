import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak5427 {
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int n,m,t;
    static int[][] map;
    static boolean[][][] check;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static boolean check(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        t=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int tt=0;tt<t;tt++){
            st=new StringTokenizer(bf.readLine()); 
            m=Integer.parseInt(st.nextToken());
            n=Integer.parseInt(st.nextToken());
            map=new int[n][m];
            check=new boolean[n][m][2001];
            Queue<Pair>fire=new LinkedList<>();
            int sX=0;
            int sY=0;
            for(int i=0;i<n;i++){
                st=new StringTokenizer(bf.readLine()); 
                String s=st.nextToken();
                for(int j=0;j<m;j++){
                    char c=s.charAt(j);
                    if(c=='#')map[i][j]=-1;
                    else if(c=='*'){map[i][j]=2;fire.add(new Pair(j,i));}
                    else if(c=='@'){sX=j;sY=i;}                    
                }
            }
            Queue<Pair>q=new LinkedList<>();
            q.add(new Pair(sX,sY));
            check[sY][sX][0]=true;
            int cnt=0;
            boolean flag=false;
            while(!q.isEmpty()){
                int qSize=q.size();
                int fSize=fire.size();
                if(flag)break;
                for(int i=0;i<fSize;i++){
                    Pair f=fire.poll();
                    int x=f.x;
                    int y=f.y;
                    for(int k=0;k<4;k++){
                        int nx=x+dx[k];
                        int ny=y+dy[k];
                        if(check(nx,ny)&&map[ny][nx]==0){map[ny][nx]=2;fire.add(new Pair(nx,ny));}
                    }                    
                }
                for(int i=0;i<qSize;i++){
                    Pair p=q.poll();
                    int x=p.x;
                    int y=p.y;
                    if(x==0||y==0||x==m-1||y==n-1){
                        flag=true;
                        sb.append((cnt+1)+"\n");
                        break;
                    }
                    for(int k=0;k<4;k++){
                        int nx=x+dx[k];
                        int ny=y+dy[k];
                        if(check(nx, ny)&&map[ny][nx]==0&&!check[ny][nx][cnt+1]){
                            check[ny][nx][cnt+1]=true;
                            q.add(new Pair(nx,ny));
                        }
                    }                                        
                }
                cnt++;
            } 
            if(!flag)sb.append("IMPOSSIBLE\n");                                 
        }      
        System.out.println(sb);  
    }    
}
