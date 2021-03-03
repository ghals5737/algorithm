import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak15918 {
    static int n,x,y,ans;
    static int[] arr=new int[101];
    static boolean[] v=new boolean[101];
    static void dfs(int now){
        if(now==2*n){
            ans++;
            return;
        }
        if(arr[now]==0){
            for(int i=1;i<=n;i++){
                if(v[i])continue;
                if(now+i+1<=2*n&&arr[now+i+1]==0){
                    arr[now]=arr[now+i+1]=i;
                    v[i]=true;
                    dfs(now+1);
                    arr[now]=arr[now+i+1]=0;
                    v[i]=false;
                }
            }
        }
        else{
            dfs(now+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        arr[x]=arr[y]=y-x-1;
        v[y-x-1]=true;
        ans=0;
        dfs(1);
        System.out.println(ans);
    }    
}
