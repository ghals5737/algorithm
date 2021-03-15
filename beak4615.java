import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class beak4615 {
    static int t,n,m;
    static int[][] map;
    static int[] dx={1,-1,0,0,1,1,-1,-1};    
    static int[] dy={0,0,1,-1,1,-1,1,-1};    
    static boolean isAble(int x,int y){
        return x>=1&&x<=n&&y>=1&&y<=n;
    }
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static Queue<Pair>q=new LinkedList<>();

    public static void main(String[] args) throws IOException {        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        t=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int tt=1;tt<=t;tt++){
            st=new StringTokenizer(bf.readLine());             
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            map=new int[n+1][n+1];
            int num=n/2;
            map[num][num]=2;
            map[num][num+1]=1;
            map[num+1][num]=1;
            map[num+1][num+1]=2;
            for(int i=0;i<m;i++){
                st=new StringTokenizer(bf.readLine());  
                int x=Integer.parseInt(st.nextToken());                           
                int y=Integer.parseInt(st.nextToken()); 
                int color=Integer.parseInt(st.nextToken()); 
                map[y][x]=color;  
                for(int k=0;k<8;k++){
                    int nx=x+dx[k];
                    int ny=y+dy[k];
                    int c=3-color;
                    q.clear();
                    while(isAble(nx,ny)&&map[ny][nx]==c){                    
                        q.add(new Pair(nx,ny));
                        nx+=dx[k];
                        ny+=dy[k];                        
                    }
                    if((isAble(nx,ny)&&map[ny][nx]==color)){
                        while(!q.isEmpty()){
                            Pair p=q.poll();
                            map[p.y][p.x]=color;
                        }
                    }
                }               
            }       
            int b=0;   
            int w=0;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(map[i][j]==1)b++;
                    else if(map[i][j]==2)w++;
                }
            }
            sb.append("#"+tt+" "+b+" "+w+"\n");
        }
        System.out.println(sb);
    }    
}
