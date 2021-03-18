import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class beak1091 {
    static int n,ans;
    static int[] arr,arr1,arr2,arr3,copy;
    static boolean flag;    
    static void solve(int shuffle){
        if(flag)return;
        if(Arrays.equals(arr,arr3)){
            ans=Math.min(ans,shuffle);
            flag=true;                
            return;
        }
        if(Arrays.equals(arr,arr2)&&shuffle>0){            
            ans=-1;
            flag=true;          
            return;
        }        
        for(int i=0;i<n;i++){
            copy[arr1[i]]=arr[i];        
        }
        for(int i=0;i<n;i++){
            arr[i]=copy[i];
        }                
        solve(shuffle+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        arr=new int[n];
        arr1=new int[n];
        arr2=new int[n];
        arr3=new int[n];
        copy=new int[n];
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            arr2[i]=arr[i];
            arr3[i]=i%3;
        }
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++){
            arr1[i]=Integer.parseInt(st.nextToken());
        }
        ans=987654321;
        solve(0);
        System.out.println(ans);
    }    
}
