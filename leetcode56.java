import java.util.*;
class Solution {
    class Intv{
        int start;
        int end;
        public Intv(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public int[][] merge(int[][] intervals) {
        ArrayList<Intv>list=new ArrayList<>();
        ArrayList<Intv>res=new ArrayList<>();
        
        for(int[] interval:intervals){
            list.add(new Intv(interval[0],interval[1]));
        }
        
        list.sort((Intv a,Intv b)->{
            if(a.start==b.start)return a.end-b.end;
            else return a.start-b.start;
        });
        int nowS=list.get(0).start;
        int nowE=list.get(0).end;
        list.remove(0);
        for(Intv a:list){
            int nextS=a.start;
            int nextE=a.end;
            if(nowE<nextS){
                res.add(new Intv(nowS,nowE));
                nowS=nextS;
                nowE=nextE;
            }else{
                nowE=Math.max(nowE,nextE);
            }
        }        
        res.add(new Intv(nowS,nowE));
        int[][] ans=new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            ans[i][0]=res.get(i).start;
            ans[i][1]=res.get(i).end;
        }
        return ans;
    }
}
