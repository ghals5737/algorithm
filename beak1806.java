import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1806 {
    static int n;
    static long s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        s=Long.parseLong(st.nextToken());
        arr=new int[n];
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int s=0;
        int e=0;
        long sum=0;
        int ans=Integer.MAX_VALUE;
        while(true){
            if(sum>=s){
                ans=Math.min(ans,e-s);
                sum-=arr[s++];                
            }
            else if(s==e){
                break;
            }
            else sum+=arr[e++];            
        }
        if(ans==Integer.MAX_VALUE)ans=0;
		System.out.println(ans);
    }    
}
