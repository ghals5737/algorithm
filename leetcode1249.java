// class Solution {
//     public String minRemoveToMakeValid(String s) {
//         boolean[] check=new boolean[s.length()];
//         Stack<Integer>stack=new Stack<>();
//         StringBuilder sb=new StringBuilder();
//         for(int i=0;i<s.length();i++){
//             char c=s.charAt(i);
//             if(c=='(')stack.add(i);
//             else if(c==')'){
//                 if(stack.isEmpty())check[i]=true;
//                 else stack.pop();
//             }
//         }
//         while(!stack.isEmpty())check[stack.pop()]=true;
//         for(int i=0;i<s.length();i++){
//             if(check[i])continue;
//             char c=s.charAt(i);
//             sb.append(c);
//         }
//         return sb.toString();
//     }
// }
