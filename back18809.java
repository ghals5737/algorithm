import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back18809 {
    static class Info{
        int x;
        int y;
        public Info(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int n,m,r,g;
    static int[][] map;
    static int[][] copyMap;    
    static ArrayList<Info>list=new ArrayList<>();
    static int[] arr;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static int flower=0;
    static int ans=0;

    static void bfs(){
        Queue<Info>q=new LinkedList<>();
        Queue<Info>qq=new LinkedList<>();
        boolean[][] check=new boolean[n][m];
        for(int i=0;i<n;i++)for(int j=0;j<m;j++)if(copyMap[i][j]>2)q.add(new Info(j,i));        
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                Info el=q.poll();
                int x=el.x;
                int y=el.y;
                for(int i=0;i<4;i++){
                    int nx=x+dx[i];
                    int ny=y+dy[i];
                    if(nx>=0&&nx<m&&ny>=0&&ny<n){
                        if(copyMap[y][x]==3||copyMap[y][x]==5){
                            if(copyMap[ny][nx]==6&&!check[ny][nx]){
                                copyMap[ny][nx]=11;
                                flower++;
                            }else if(copyMap[ny][nx]==2||copyMap[ny][nx]==1){
                                copyMap[ny][nx]=5;
                                q.add(new Info(nx,ny));
                                qq.add(new Info(nx,ny));
                            }
                        }else if(copyMap[y][x]==4||copyMap[y][x]==6){
                            if(copyMap[ny][nx]==5&&!check[ny][nx]){
                                copyMap[ny][nx]=11;
                                flower++;
                            }else if(copyMap[ny][nx]==2||copyMap[ny][nx]==1){
                                copyMap[ny][nx]=6;
                                q.add(new Info(nx,ny));
                                qq.add(new Info(nx,ny));
                            }
                        }
                    }
                }                                     
            }
            while(!qq.isEmpty()){
                Info e=qq.poll();
                check[e.y][e.x]=true;
            }                      
        }        
    }
    static void dfs(int idx,int rr,int gg){
        if(rr+gg==0){
            flower=0;
            for(int i=0;i<n;i++)for(int j=0;j<m;j++)copyMap[i][j]=map[i][j];
            bfs();            
            ans=Math.max(flower,ans);            
            return;
        }
        if(idx>=list.size())return;
        //r 시약
        if(rr>0){
            Info el=list.get(idx);
            map[el.y][el.x]=3;
            dfs(idx+1,rr-1,gg);
            map[el.y][el.x]=2;
        }
        //g 시약
        if(gg>0){
            Info el=list.get(idx);
            map[el.y][el.x]=4;
            dfs(idx+1,rr,gg-1);
            map[el.y][el.x]=2;
        }
        //no
        dfs(idx+1,rr,gg);        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        g=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        copyMap=new int[n][m];
        arr=new int[g+r];
        for(int i=0;i<g;i++)arr[i]=1;
        for(int i=g;i<g+r;i++)arr[i]=2;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2)list.add(new Info(j,i));
            }
        }
        ans=0;
        dfs(0,r,g);
        System.out.println(ans);
    }    
}
