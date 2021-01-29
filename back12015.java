import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back12015 {
    static int n;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  

        n=Integer.parseInt(st.nextToken());
        arr=new long[n+1];
        st=new StringTokenizer(bf.readLine());  
        for(int i=1;i<=n;i++){
            arr[i]=Long.parseLong(st.nextToken());            
        }
        ArrayList<Long>list=new ArrayList<>();
        list.add(-1000000000L);
        for(int i=1;i<=n;i++){
            long num=list.get(list.size()-1);
            if(arr[i]>num)list.add(arr[i]);
            else{
                int left=0;
                int right=list.size()-1;
                int result=0;
                while(left<=right){
                    int mid=(left+right)>>1;
                    if(list.get(mid)>=arr[i]){
                        result=mid; 
                        right=mid-1;                                               
                    }else{
                        left=mid+1;
                    }
                }
                list.set(result,arr[i]);
            }
        }   
        System.out.println(list.size()-1);   
    }
}
