import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak16938 {
    static int n,x;
    static long l,r;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());    
        l=Long.parseLong(st.nextToken());
        r=Long.parseLong(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        arr=new int[n];
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());                        
        }
        int ans=0;       
        for(int i=0;i<(1<<n);i++){
            int cnt=0;
            int min=Integer.MAX_VALUE;
            int max=0; 
            long sum=0;
            for(int j=0;j<n;j++){
                if((i&(1<<j))>0){
                    cnt++;
                    sum+=arr[j];
                    min=Math.min(min,arr[j]);                    
                    max=Math.max(max,arr[j]);
                }
            }
            if(cnt>=2){
                if(sum>=l&&sum<=r&&max-min>=x)ans++;
            }
        }
        System.out.println(ans);
    }    
}
