// class Solution {
//     public String decodeString(String s) {
//         int num=0;        
//         String ans="";       
//         Stack<String>stack=new Stack<>();
//         for(int i=0;i<s.length();i++){
//             char c=s.charAt(i);            
//             if(c>='0'&&c<='9'){
//                 num=num*10+(c-'0');              
//             }
//             else if(c=='['){               
//                 stack.add(ans);
//                 stack.add(String.valueOf(num));
//                 num=0;
//                 ans="";
//             }else if(c==']'){                
//                 int repeat=Integer.parseInt(stack.pop());
//                 StringBuilder sb=new StringBuilder();
//                 for(int j=0;j<repeat;j++)sb.append(ans);
//                 ans=stack.pop()+sb.toString();
//             }else{
//                 ans+=c;
//             }
//         }
//         return ans;
//     }
// }
