import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back2632 {
    static int n,m;
    static int size;
    static int[] a,b,cntA,cntB;
    static int[][] sumA,sumB;
    
    static void makeSubSum(int len,int[] arr,int[][] sumArr){
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(i==j)sumArr[i][j]=arr[j];
                else sumArr[i][j]=sumArr[i][j-1]+arr[j];
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<i-1;j++){
                if(j+1<=i-1)sumArr[i][j]=sumArr[0][len-1]-sumArr[j+1][i-1];                
            }
        }
    }
    static void makeCnt(int len,int[][] sumArr,int[] cntArr){
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(sumArr[i][j]<=size)cntArr[sumArr[i][j]]++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        size=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        a=new int[n];
        b=new int[m];
        sumA=new int[n][n];
        sumB=new int[m][m];
        cntA=new int[size+1];
        cntB=new int[size+1];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            a[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            b[i]=Integer.parseInt(st.nextToken());
        }
        makeSubSum(n, a, sumA);
        makeSubSum(m, b, sumB);
        makeCnt(n, sumA, cntA);
        makeCnt(m, sumB, cntB);
        int ans=0;
        for(int i=0;i<=size;i++){
            int bSize=size-i;
            if(i==0){
                ans+=cntB[bSize];
            }
            else if(bSize==0){
                ans+=cntA[i];
            }
            else{
                ans+=cntA[i]*cntB[bSize];
            }            
        }
        System.out.println(ans);
    }
}
