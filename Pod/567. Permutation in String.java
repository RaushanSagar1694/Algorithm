package Pod;

import java.util.*;


///567. Permutation in String


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] temp = s1.toCharArray();
        Arrays.sort(temp);
        String s3 = new String(temp);

        int n = s2.length();
        int size = s3.length();
        int i = 0;
        int j = 0;

        while(i < n){
            int currSize = i - j+1;

            if(currSize < size){
                i++;
                continue;
            }
            
            while(j < i && currSize > size){
                j++;
                currSize = i - j+1;
            }

            if(s3.compareTo(s2.substring(j, i+1)) == 0){
                return true;
            }

            char[] temp2 = s2.substring(j, i+1).toCharArray();
            Arrays.sort(temp2);
            String curr = new String(temp2);

            if(s3.compareTo(curr) == 0){
                return true;
            }

            i++;
        }

        return false;
    }
}