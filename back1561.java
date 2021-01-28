import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back1561 {
    static int n,m;
    static int[] arr;

    static boolean check(long mid){
        long child=m;
        for(int i=0;i<m;i++)child+=mid/arr[i];
        if(child>=n){
            return true;
        }
        else return false;
    }
    static long binary(long left,long right){
        long result=0;        
        while(left<=right){
            long mid=(left+right)/2;            
            if(check(mid)){
                result=mid;                
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[m];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++)arr[i]=Integer.parseInt(st.nextToken());
        if(n<=m){
            System.out.println(n);
            return; 
        }        
        long time=binary(0,2000000000L * 30L);       
        long child=m;
        for(int i=0;i<m;i++)child+=(time-1)/arr[i];
        for(int i=0;i<m;i++){
            if((time%arr[i])==0)child++;
            if(child==n){
                System.out.println(i+1);
                return;
            }
        }

    }    
}
