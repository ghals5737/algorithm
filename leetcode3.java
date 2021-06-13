// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashMap<Character,Integer>map=new HashMap<>();
//         int res=0;
//         int l=0;
//         int r=0;
//         int len=s.length();
//         while(l<=r&&r<len&&l<len){
//             char c=s.charAt(r);
//             if(map.containsKey(c)&&map.get(c)>=l)l=map.get(c)+1;
//             map.put(c,r);
//             res=Math.max(res,r-l+1);
//             r++;
//         }
//         return res;
//     }
// }
