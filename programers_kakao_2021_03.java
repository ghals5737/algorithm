import java.util.*;

public class programers_kakao_2021_03 {
    static int[][][][][] arr=new int[3][2][2][2][100001];
    static HashMap<String,Integer>map=new HashMap<>();
    static int[] idx=new int[5];
    static int solve(){
        int cnt=0;
        for(int i1=0;i1<3;i1++){
            if(!(i1==idx[0]||idx[0]==-1))continue;
            for(int i2=0;i2<2;i2++){
                if(!(i2==idx[1]||idx[1]==-1))continue;
                for(int i3=0;i3<2;i3++){
                    if(!(i3==idx[2]||idx[2]==-1))continue;
                    for(int i4=0;i4<2;i4++){
                        if(!(i4==idx[3]||idx[3]==-1))continue;                      
                        cnt+=(arr[i1][i2][i3][i4][100000]-arr[i1][i2][i3][i4][idx[4]-1]);                    
                    }
                }                
            }            
        }
        return cnt;
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map.put("cpp",0);
        map.put("java",1);
        map.put("python",2);
        map.put("backend",0);
        map.put("frontend",1);
        map.put("junior",0);
        map.put("senior",1);
        map.put("chicken",0);
        map.put("pizza",1);
        map.put("-",-1);
        for(String str:info){
            StringTokenizer st=new StringTokenizer(str);
            for(int i=0;i<4;i++){
                idx[i]=map.get(st.nextToken());            
            }
            idx[4]=Integer.parseInt(st.nextToken());
            arr[idx[0]][idx[1]][idx[2]][idx[3]][idx[4]]++;            
        }
        for(int i1=0;i1<3;i1++){            
            for(int i2=0;i2<2;i2++){              
                for(int i3=0;i3<2;i3++){                  
                    for(int i4=0;i4<2;i4++){                       
                        for(int i5=1;i5<100001;i5++){
                            arr[i1][i2][i3][i4][i5]+=arr[i1][i2][i3][i4][i5-1];
                        }
                    }
                }                
            }  
        }
        int cnt=0;
        for(String str:query){
             StringTokenizer st=new StringTokenizer(str);  
             for(int i=0;i<7;i++){
                if(i%2==0)idx[i/2]=map.get(st.nextToken());            
                else st.nextToken();
             }
             idx[4]=Integer.parseInt(st.nextToken());
             answer[cnt++]=solve();
        }        
        return answer;
    }
}
