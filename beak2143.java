import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak2143 {
    static int n,m;
    static long t;
    static long[] a,b;
    static ArrayList<Long>sumA=new ArrayList<>();
    static ArrayList<Long>sumB=new ArrayList<>();
    static int lowerBound(long num){
        int left=0;
        int right=sumB.size();        
        while(left<right){
            int mid=(left+right)/2;
            if(num>sumB.get(mid)){                
                left=mid+1;                
            }else{
                right=mid;
            }
        }
        return left;
    }
    static int upperBound(long num){
        int left=0;
        int right=sumB.size();        
        while(left<right){
            int mid=(left+right)/2;
            if(num>=sumB.get(mid)){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        t=Long.parseLong(st.nextToken());
        st=new StringTokenizer(bf.readLine());  
        n=Integer.parseInt(st.nextToken());             
        a=new long[n];        
        st=new StringTokenizer(bf.readLine());  
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());     
        m=Integer.parseInt(st.nextToken());
        b=new long[m];
        st=new StringTokenizer(bf.readLine());  
        for(int i=0;i<m;i++){
            b[i]=Integer.parseInt(st.nextToken());
        }    
        for(int i=0;i<n;i++){
            long sum=a[i];
            sumA.add(sum);
            for(int j=i+1;j<n;j++){
                sum+=a[j];
                sumA.add(sum);
            }
        }
        for(int i=0;i<m;i++){
            long sum=b[i];
            sumB.add(sum);
            for(int j=i+1;j<m;j++){
                sum+=b[j];
                sumB.add(sum);
            }
        }
        sumA.sort((a,b)->{return a.compareTo(b);});
        sumB.sort((a,b)->{return a.compareTo(b);});
        long ans=0;
        for(int i=0;i<sumA.size();i++){
            long num=t-sumA.get(i);
            int l=lowerBound(num);
            int r=upperBound(num);
            ans+=(r-l);
        }
        System.out.println(ans);
    }    
}
