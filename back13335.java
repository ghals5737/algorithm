import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back13335 {
    static int n,w,l;
    static int[] arr;
    static int[] dari;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        
        n=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        
        arr=new int[n];
        dari=new int[n];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int idx=0;
        int time=0;
        int totalW=0;

        while(true){        
           time++;
           for(int j=0;j<idx;j++){
               if(dari[j]>=w){
                   dari[j]=-1;
                   totalW-=arr[j];
               }
           }
           int num=0;
           for(int j=0;j<n;j++)num+=dari[j];
           if(num==-n){
               System.out.println(time);
               return;
           }           
           
            if(idx<n&&l>=totalW+arr[idx]){
                totalW+=arr[idx];
                idx++;                
            }
                    
           for(int j=0;j<idx;j++){
               if(dari[j]==-1)continue;
               dari[j]++;               
           }                
        }
    }    
}
