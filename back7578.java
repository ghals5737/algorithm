import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back7578 {
    static int n;
    static long[] seg=new long[500000*4+1];
    static int[] B=new int[1000000+1];
    static int[] A=new int[500000+1];
    static void update(int node,int start,int end,int idx,int val){
        if(idx<start||end<idx)return;
        if(start==end){
            seg[node]=val;
            return;
        }
        int mid=(start+end)/2;
        update(node*2,start,mid, idx, val);
        update(node*2+1,mid+1,end, idx, val);
        seg[node]=seg[node*2]+seg[node*2+1];
    }
    static long query(int node,int start,int end,int left,int right){
        if(right<start||end<left)return 0;
        if(left<=start&&end<=right)return seg[node];
        int mid=(start+end)/2;
        long l=query(node*2, start, mid, left, right);
        long r=query(node*2+1, mid+1, end, left, right);
        return l+r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++){
            A[i]=Integer.parseInt(st.nextToken());            
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++){
            int num=Integer.parseInt(st.nextToken());
            B[num]=i;
        }
        long ans=0;    
        for(int i=1;i<=n;i++){
            int j=B[A[i]];
            ans+=query(1,1,n,j+1,n);
            update(1,1,n,j,1);
        }
        System.out.println(ans);
    }    
}
