import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak13908 {
    static int n,m,ans;
    static boolean[] v=new boolean[10];
    static void dfs(int idx,int cnt){
        if(n==idx){
            if(m==cnt)ans++;
            return;
        }
        for(int i=0;i<=9;i++){
            if(v[i]){
                v[i]=false;
                dfs(idx+1,cnt+1);
                v[i]=true;
            }else{
                dfs(idx+1,cnt);            
            }            
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<m;i++){
            int num=Integer.parseInt(st.nextToken());
            v[num]=true;
        }
        ans=0;
        dfs(0,0);
        System.out.println(ans);
    }    
}
