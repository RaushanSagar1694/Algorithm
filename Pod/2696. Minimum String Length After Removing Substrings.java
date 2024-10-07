

import  java.util.*;



// 2696. Minimum String Length After Removing Substrings

class Solution {
    public int minLength(String s) {
        Stack<Character> pq = new Stack<>();

        for(char ch2 : s.toCharArray()){

            if(pq.isEmpty()){
                pq.add(ch2);
                continue;
            }
            char ch1 = pq.peek();

            if((ch1 == 'A' && ch2 == 'B') || (ch1 == 'C' && ch2 == 'D')){
                pq.pop();
            }
            else{
                pq.add(ch2);
            }
        }

        return pq.size();
    }

    public static void main(String[] args) {
        
    }
}
