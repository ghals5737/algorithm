import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back5676 {
    static int n,k,treeH,treeS;
    static int[] arr;
    static int[] segment;
    static int convert(int num){
        if(num>0)return 1;
        else if(num<0)return -1;
        else return 0;
    }
    static int make_seg(int node,int start,int end){
        if(start==end)return segment[node]=convert(arr[start]);
        int mid=(start+end)>>1;
        int left=make_seg(node*2, start, mid);
        int right=make_seg(node*2+1, mid+1, end);
        return segment[node]=left*right;
    }
    static int update(int node,int start,int end,int idx,int val){
        if(start>idx||end<idx)return segment[node];
        if(start==end)return segment[node]=convert(val);
        int mid=(start+end)>>1;
        int left=update(node*2, start, mid,idx,val);
        int right=update(node*2+1, mid+1, end,idx,val);
        return segment[node]=left*right;
    }
    static int query(int node,int start,int end,int left,int right){
        if(right<start||left>end)return 1;
        if(start<=left&&right<=end)return segment[node];
        int mid=(start+end)>>1;
        int l=query(node*2, start, mid,left,right);
        int r=query(node*2+1, mid+1, end,left,right);
        return l*r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[n+1];
        treeH=(int)Math.ceil(Math.log(n)/Math.log(2));
        treeS=1<<(treeH+1);
        segment=new int[treeS];
        make_seg(1,0,n-1);
        for(int i=0;i<k;i++){
            st=new StringTokenizer(bf.readLine());
            String s=st.nextToken();
            if(s.equals("C")){
                update(1,0,n-1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }else{
                
            }
        }
    }    
}
