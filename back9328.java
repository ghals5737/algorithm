import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back9328 {
    static class Pair{
        int x;
        int y;
        public Pair (int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int t,n,m;
    static char[][] map;
    static boolean[][]visited;
    static int[] key=new int[27];
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};   
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        t=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        for(int tt=0;tt<t;tt++){
            st=new StringTokenizer(bf.readLine());  
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            map=new char[n+2][m+2];
            visited=new boolean[n+2][m+2];
            key=new int[27];
            for(int i=0;i<n+2;i++){
                for(int j=0;j<m+2;j++){
                    map[i][j]='.';
                }
            }
            for(int i=1;i<=n;i++){
                st=new StringTokenizer(bf.readLine());  
                String s=st.nextToken();
                for(int j=1;j<=m;j++){
                    char c=s.charAt(j-1);
                    map[i][j]=c;                    
                }
            }            
            Queue<Pair>q=new LinkedList<>();
            visited[0][0]=true;
            int ans=0;
            q.add(new Pair(0,0));
            st=new StringTokenizer(bf.readLine());  
            String s=st.nextToken();
            if(!s.equals("0"))for(int i=0;i<s.length();i++)key[s.charAt(i)-'a']=1;
            while(!q.isEmpty()){
                Pair p=q.poll();
                int x=p.x;
                int y=p.y;
                for(int i=0;i<4;i++){
                    int nx=x+dx[i];
                    int ny=y+dy[i];
                    if(nx>=0&&nx<m+2&&ny>=0&&ny<n+2&&!visited[ny][nx]&&map[ny][nx]!='*'){
                        if(map[ny][nx]=='$'){
                            ans++;
                            map[ny][nx]='.';
                            visited[ny][nx]=true;
                            q.add(new Pair(nx,ny));
                        }else if(map[ny][nx]=='.'){
                            visited[ny][nx]=true;
                            q.add(new Pair(nx,ny));
                        }else if(map[ny][nx]>='A'&&map[ny][nx]<='Z'){
                            char door=map[ny][nx];
                            if(key[door-'A']==1){
                                map[ny][nx]='.';                                
                                q.add(new Pair(nx,ny));                                
                                visited[ny][nx]=true; 
                            }
                        }else if(map[ny][nx]>='a'&&map[ny][nx]<='z'){
                            char door=map[ny][nx];
                            key[door-'a']=1;
                            while(!q.isEmpty())q.poll();
                            visited=new boolean[n+2][m+2];
                            map[ny][nx]='.';
                            q.add(new Pair(nx,ny));                                
                            visited[ny][nx]=true; 
                        }
                    }
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }    
}
