class Solution {
    class Union{
        int n;
        int[] arr;
        Union(int n){
            this.n=n;
            this.arr=new int[n];
        }
        void Init(){
            for(int i=0;i<n;i++){
                arr[i]=i;
            }
        }
        int find(int x){
            if(arr[x]==x)return arr[x];
            else return arr[x]=find(arr[x]);
        }
        void merge(int a,int b){
            a=find(a);
            b=find(b);
            if(a!=b){
                if(a>b){
                    int tmp=a;
                    a=b;
                    b=tmp;
                }
                arr[b]=a;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        Union u=new Union(n);
        u.Init();
        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                if(map.containsKey(email)){
                    int p=map.get(email);
                    u.merge(p,i);
                }else{
                    map.put(email,i);
                }
            }
        }
        HashMap<Integer,Set<String>>map1=new HashMap<>();
        for(int i=0;i<n;i++){
            int p=u.find(i);
            map1.putIfAbsent(p,new HashSet<>());
            Set<String> set=map1.get(p);
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                set.add(email);
            }
            map1.put(p,set);
        }
        List<List<String>>res=new ArrayList<>();
        for(int key:map1.keySet()){
            List<String>list=new ArrayList<>();
            for(String email:map1.get(key)){
                list.add(email);
            }
            list.sort((a,b)->a.compareTo(b));
            list.add(0,accounts.get(key).get(0));
            res.add(list);
        }
        return res;
    }
}
