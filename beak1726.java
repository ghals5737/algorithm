import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak1726 {
    static class Pair{
        int x;
        int y;
        int d;
        Pair(int x,int y,int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    static int n,m;
    static boolean v[][][];    
    static int sX,sY,sD,eX,eY,eD;
    static int[] dx={0,1,-1,0,0};
    static int[] dy={0,0,0,1,-1};
    static int[][] map;   
    static boolean check(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    } 
    
    static void bfs(){
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(sX,sY,sD));
        v[sY][sX][sD]=true;        
        int cnt=0;
        while(!q.isEmpty()){
            int qSize=q.size();
            for(int j=0;j<qSize;j++){
                Pair p=q.poll();            
                int x=p.x;
                int y=p.y;
                int d=p.d;                    
                if(x==eX&&y==eY&&d==eD){
                    System.out.println(cnt);
                    return;
                }
                for(int k=1;k<=3;k++){
                    int nx=x+(k*dx[d]);
                    int ny=y+(k*dy[d]);
                    if(check(nx, ny)&&!v[ny][nx][d]&&map[ny][nx]==0){
                        v[ny][nx][d]=true;
                        q.add(new Pair(nx,ny,d));
                    }else if(!check(nx,ny)||map[ny][nx]==1){
                        break;
                    }
                }
                if(d<3){
                    for(int k=3;k<=4;k++){                       
                        if(!v[y][x][k]){
                            v[y][x][k]=true;
                            q.add(new Pair(x,y,k));
                        }
                    }
                }else{
                    for(int k=1;k<=2;k++){                        
                        if(!v[y][x][k]){
                            v[y][x][k]=true;
                            q.add(new Pair(x,y,k));
                        }
                    }    
                }
            }  
            cnt++;         
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        v=new boolean[n][m][5];       
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(bf.readLine()); 
        sY=Integer.parseInt(st.nextToken())-1;
        sX=Integer.parseInt(st.nextToken())-1;
        sD=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());         
        eY=Integer.parseInt(st.nextToken())-1;
        eX=Integer.parseInt(st.nextToken())-1;
        eD=Integer.parseInt(st.nextToken());
        bfs();
    }    
}
