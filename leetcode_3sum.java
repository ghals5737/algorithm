import java.util.*;
public class leetcode_3sum {  
    static List<List<Integer>>list=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {        
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int start=i+1;
            int end=n-1;
            while(start<end&&start<n&&end>=0){
                int sum=nums[i]+nums[start]+nums[end];
                if(sum==0){
                    list.add(Arrays.asList(nums[i],nums[start],nums[end])); 
                    while(start<n-1&&nums[start]==nums[start+1])start++;
                    while(end>0&&nums[end]==nums[end-1])end--;
                    end--;
                    start++;
                }
                if(sum<0)start++;
                else end--;                
            }
        }               
        return list;
    }    
}
