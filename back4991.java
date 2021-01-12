import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back4991 {
    static class Pair{
        int x;
        int y;
        int state;
        public Pair(int x,int y,int state){
            this.x=x;
            this.y=y;
            this.state=state;
        }
    }
    static int n,m,ans;
    static char[][] map;
    static int[][][] visited;
    static int[] key;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static int daw;

    static boolean isAble(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }

    static int bfs(int sX,int sY){   
        Queue<Pair>q=new LinkedList<>();
        visited[sY][sX][0]=1;
        q.add(new Pair(sX,sY,0));        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int x=p.x;
            int y=p.y;
            int state=p.state;
            //System.out.println(state);
            if(daw-1==state)return visited[y][x][state]-1;
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(isAble(nx,ny)&&map[ny][nx]!='x'){
                    if(map[ny][nx]=='*'){
                        int num=key[ny*m+nx];
                        if(visited[ny][nx][state|(1<<num)]==0){
                            visited[ny][nx][state|(1<<num)]=visited[y][x][state]+1;
                            q.add(new Pair(nx,ny,state|(1<<num)));
                        }
                    }else{
                        if(visited[ny][nx][state]==0){
                            visited[ny][nx][state]=visited[y][x][state]+1;
                            q.add(new Pair(nx,ny,state));
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();         
       
        while(true){
            StringTokenizer st=new StringTokenizer(bf.readLine());
            m=Integer.parseInt(st.nextToken());
            n=Integer.parseInt(st.nextToken());
            if(m+n==0)break;
            map=new char[n][m];
            key=new int[n*m+1];            
            int cnt=0;
            int startX=0;
            int startY=0;
            
            for(int i=0;i<n;i++){
                st=new StringTokenizer(bf.readLine());
                String s=st.nextToken();
                for(int j=0;j<m;j++){
                    char c=s.charAt(j);
                    if(c=='*')key[i*m+j]=cnt++;
                    if(c=='o'){
                        startX=j;
                        startY=i;
                    }
                    map[i][j]=c;
                }
            }
            ans=987654321;
            daw=(1<<cnt);            
            visited=new int[n][m][daw];
            
            sb.append(bfs(startX,startY)+"\n");
        }
        System.out.println(sb);        
    }    
}
