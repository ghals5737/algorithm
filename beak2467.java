import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak2467 {
    static long[] arr;
    static long total;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        arr=new long[n];
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }                      
        int left=0;
        int right=n-1;
        total=Long.MAX_VALUE;
        long ans1=0;
        long ans2=0;
        while(left<right){
            long a=arr[left];
            long b=arr[right];
            long num=Math.abs(a+b);
            if(num<total){
                total=num;
                ans1=a;
                ans2=b;
            }
            if(a+b>0){
                right--;
            }
            else left++;
        }
        System.out.println(ans1+" "+ans2);
    }    
}
