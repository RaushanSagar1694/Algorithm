

package Pod;



// 2491. Divide Players Into Teams of Equal Skill
    

    class Solution {
        public long dividePlayers(int[] skill) {
            int n = skill.length;
            if(n%2 != 0) return -1;
    
            int noOfPair = n/2;
            int[] temp = new int[1001];
            long sum = 0;
    
            for(int val : skill){
                temp[val]++;
                sum += val;
            }
    
            if(sum%noOfPair != 0){
                return -1;
            }
    
            long chemistry = sum/noOfPair;
            long result = 0;
    
            for(int i = 0; i < n; i++){
                int val1 = skill[i];
                int val2 = (int)chemistry - val1;
    
                if(val2 < 0 || temp[val2] == 0){
                    return -1;
                }
    
                result += val1 * val2;
                temp[val2]--;
            }
    
            return result/2;
        }
    }

