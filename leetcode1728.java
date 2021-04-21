public class leetcode1728 {
    static boolean[] v;
    public boolean dfs(int[] res,int now,int n){
        if(now==res.length)return true;
        if(res[now]!=0)return dfs(res,now+1,n);
        for(int i=n;i>=1;i--){
            if(!v[i]){
                if(i!=1&&now+i>=res.length)continue;
                if(i!=1&&res[now+i]!=0)continue;
                v[i]=true;
                res[now]=i;
                if(i!=1)res[now+i]=i;
                if(dfs(res,now+1,n))return true;
                v[i]=false;
                res[now]=0;
                if(i!=1)res[now+i]=0;
            }
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        v=new boolean[n+1];
        int[] res=new int[2*n-1];
        dfs(res,0,n);
        return res;
    }
}
