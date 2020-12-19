import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back18428 {
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int n,m;
    static int[][] map;
    static ArrayList<Pair>list=new ArrayList<>();
    static ArrayList<Pair>t=new ArrayList<>();
    static int[] arr;
    static boolean check(){
        for(Pair p:t){
            int x=p.x;
            int y=p.y;
            for(int j=x+1;j<n;j++){
                if(map[y][j]==-1||map[y][j]==1)break;
                if(map[y][j]==2)return false;
            }
            for(int j=x-1;j>=0;j--){
                if(map[y][j]==-1||map[y][j]==1)break;
                if(map[y][j]==2)return false;
            }
            for(int j=y+1;j<n;j++){
                if(map[j][x]==-1||map[j][x]==1)break;
                if(map[j][x]==2)return false;
            }
            for(int j=y-1;j>=0;j--){
                if(map[j][x]==-1||map[j][x]==1)break;
                if(map[j][x]==2)return false;
            }
        }
        return true;
    }
    static boolean flag=false;
    static void dfs(int now,int idx){
        if(flag)return;
        if(now==3){
            for(int el:arr){               
                Pair p=list.get(el);
                map[p.y][p.x]=-1;
            }
         
            if(check()){
                flag=true;
                return;
            }
            for(int el:arr){
                Pair p=list.get(el);
                map[p.y][p.x]=0;
            }
            return;
        }
        if(idx>=m)return;
        arr[now]=idx;
        dfs(now+1,idx+1);
        dfs(now,idx+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        map=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                String s=st.nextToken();
                if(s.equals("X")){
                    map[i][j]=0;
                    list.add(new Pair(j,i));
                }else if(s.equals("T")){
                    map[i][j]=1;
                    t.add(new Pair(j,i));
                }else{
                    map[i][j]=2;
                }
            }
        } 
        m=list.size();
        arr=new int[3];
        dfs(0,0);
        if(flag)System.out.println("YES");
        else System.out.println("NO");       
    }    
}
