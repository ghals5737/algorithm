import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak15790 {
    static int n,m,k;
    static int[] arr;
    static boolean check(int mid){
       int idx=0;
       int cnt=0;     
       for(int i=0;i<m;i++){
           int now=i;
           int sum=0; 
           idx=0; 
           cnt=0;         
           while(true){
               sum+=arr[now];                
               if(mid<=sum){
                   cnt++;                  
                   if(k==cnt){                       
                       return true;
                   }
                   sum=0;
               }
               now=(now+1)%m;
               idx++;
               if(idx==m)break;
           }
       }
       return false;
    }
    static int binary(int start,int end){
        int result=0;
        while(start<=end){
            int mid=(start+end)/2;
            if(check(mid)){                
                result=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());        
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[m+1];
        st=new StringTokenizer(bf.readLine());                
        int prev=Integer.parseInt(st.nextToken());
        int f=prev;
        for(int i=0;i<m-1;i++){
            st=new StringTokenizer(bf.readLine());        
            int now=Integer.parseInt(st.nextToken());
            arr[i]=now-prev;
            prev=now;       
            if(i==m-2){                
                arr[i+1]=n-(prev-f);
            }    
        }       
        System.out.println(binary(1,n));     
    }    
}
