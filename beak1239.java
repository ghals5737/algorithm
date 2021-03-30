
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1239 {
    static int n,ans;
    static int[] arr,arr2;
    static boolean[] v=new boolean[100];
    static boolean[] check;
    static void solve(int idx){
        if(idx==n){
            v=new boolean[100];
            int now=0;            
            for(int i=0;i<n;i++){
                int num=arr[arr2[i]];
                v[now]=true;
                v[(now+num)%100]=true;             
                now=(now+num)%100;
            }
            int cnt=0;
            for(int i=0;i<50;i++){
                if(v[i]&&v[i+50])cnt++;
            }
            ans=Math.max(ans, cnt);
            return;
        }
        for(int i=0;i<n;i++){
            if(!check[i]){
                check[i]=true;
                arr2[idx]=i;
                solve(idx+1);
                check[i]=false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        arr=new int[n];
        arr2=new int[n];
        check=new boolean[n];
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        ans=0;
        solve(0);
        System.out.println(ans);
    }    
}
