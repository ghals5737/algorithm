import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class beak16639 {
    static long[][] max;
    static long[][] min;
    static long cal(long a,long b,char c){
        if(c=='+')return a+b;
        else if(c=='-')return a-b;
        else return a*b;
    }    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        int n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        String s=st.nextToken();
        max=new long[n][n];
        min=new long[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(max[i],Long.MIN_VALUE);
            Arrays.fill(min[i],Long.MAX_VALUE);
        }
        for(int i=0;i<n;i+=2){
            int num=s.charAt(i)-'0';
            max[i][i]=num;
            min[i][i]=num;
        }
        for(int j=0;j<n;j+=2){
            for(int i=0;i<n-j;i+=2){
                for(int k=2;k<=j;k+=2){
                    long tmp[]=new long[4];
                    tmp[0]=cal(max[i][i+k-2],max[i+k][i+j],s.charAt(i+k-1));
                    tmp[1]=cal(max[i][i+k-2],min[i+k][i+j],s.charAt(i+k-1));
                    tmp[2]=cal(min[i][i+k-2],min[i+k][i+j],s.charAt(i+k-1));
                    tmp[3]=cal(min[i][i+k-2],max[i+k][i+j],s.charAt(i+k-1));
                    Arrays.sort(tmp);
                    max[i][i+j]=Math.max(max[i][i+j],tmp[3]);
                    min[i][i+j]=Math.min(min[i][i+j],tmp[0]);
                }
            }
        }
        System.out.println(max[0][n-1]);
    }    
}
