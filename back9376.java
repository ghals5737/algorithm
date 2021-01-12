import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back9376 {
    static class Pair{
        int x;
        int y;
        int num;
        public Pair(int x,int y,int num){
            this.x=x;
            this.y=y;
            this.num=num;
        }
    }
    static int t,n,m;
    static int[][] map;
    static int[][][] ans;
    static boolean[][] check;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static ArrayList<Pair>list;

    static void bfs(int startX,int startY,int idx){
        check=new boolean[n+2][m+2];
        Queue<Pair>q =new LinkedList<>();
        check[startY][startX]=true;
        q.add(new Pair(startX,startY,0));        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int x=p.x;
            int y=p.y;
            int num=p.num;            
            for (int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0&&nx<=m+1&&ny>=0&&ny<=n+1&&!check[ny][nx]&&map[ny][nx]!=-1){
                    check[ny][nx]=true;
                    if(map[ny][nx]==1){  
                        ans[ny][nx][idx]=ans[y][x][idx]+1;                      
                        q.add(new Pair(nx,ny,num+1));
                    }else{
                        ans[ny][nx][idx]=ans[y][x][idx];                      
                        q.add(new Pair(nx,ny,num));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        t=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();

        for(int tt=0;tt<t;tt++){
            st=new StringTokenizer(bf.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            ans=new int[n+2][m+2][3];
            map=new int[n+2][m+2];
            list=new ArrayList<>();
            list.add(new Pair(0,0,0));            
            for(int i=1;i<=n;i++){
                st=new StringTokenizer(bf.readLine());
                String s=st.nextToken();
                for(int j=1;j<=m;j++){
                    char c=s.charAt(j-1);
                    if(c=='*'){
                        map[i][j]=-1;
                    }else if(c=='#'){
                        map[i][j]=1;
                    }else if(c=='$'){
                        list.add(new Pair(j,i,0));                        
                    }
                }                
            }
            int cnt=0;
            for(Pair p:list){
                bfs(p.x,p.y,cnt++);                            
            }
            
            int result=Integer.MAX_VALUE;            
            for(int i=0;i<=n+1;i++){
                for(int j=0;j<=m+1;j++){             
                    if(map[i][j]!=-1){
                        int num=ans[i][j][0]+ans[i][j][1]+ans[i][j][2];
                        if(map[i][j]==1)result=Math.min(num-2, result);
                        else result=Math.min(num,result);
                    }
                }             
            }            
            sb.append(result+"\n");
        }
        System.out.println(sb);
    }    
}
