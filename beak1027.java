import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class beak1027 {
    static int n;
    static int[] arr,cnt;
        
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        arr=new int[n+1];
        cnt=new int[n+1];
        st=new StringTokenizer(bf.readLine()); 
        for(int i=1;i<=n;i++)arr[i]=Integer.parseInt(st.nextToken());
        for(int i=1;i<=n;i++){
            double max=Double.MIN_VALUE;
            for(int j=i+1;j<=n;j++){
                double now=(double)(arr[j]-arr[i])/(j-i);               
                if(now>max){
                    max=now;
                    cnt[i]++;
                    cnt[j]++;
                }                
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++)ans=Math.max(ans,cnt[i]);
        System.out.println(ans);
    }    
}
