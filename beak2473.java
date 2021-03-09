import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class beak2473 { static long[] arr;
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
        long ans1=0;
        long ans2=0;
        long ans3=0;
        total=Long.MAX_VALUE;
        Arrays.sort(arr);        
        for(int i=0;i<n;i++){
            int left=i+1;
            int right=n-1;
            long c=arr[i];
            while(left<right){
                long a=arr[left];
                long b=arr[right];                
                long num=Math.abs(a+b+c);
                if(num<total){
                    total=num;
                    ans1=a;
                    ans2=b;
                    ans3=c;
                }
                if(a+b+c>=0){
                    right--;
                }
                else left++;
            }

        }        
        System.out.println(ans3+" "+ans1+" "+ans2);
    }    
}
