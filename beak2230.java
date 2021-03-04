import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class beak2230 {
    static int n;
    static long m;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());   
        n=Integer.parseInt(st.nextToken());
        m=Long.parseLong(st.nextToken());
        arr=new long[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());   
            arr[i]=Long.parseLong(st.nextToken());
        }        
        Arrays.sort(arr);        
        int s=0;
        int e=0;
        long ans=Long.MAX_VALUE;
        long diff=0;
        while((s<=e&&e<n)){
            if(diff>=m){                
                ans=Math.min(ans,diff);
                if(s==e){
                    e++;
                    if(e==n)break;                    
                    diff=arr[e]-arr[s];
                }else{
                    s++;
                    diff=arr[e]-arr[s];
                }
            }else{
                e++;              
                if(e==n)break;  
                diff=arr[e]-arr[s];                
            }           
        }   
        System.out.println(ans);
    }    
}
