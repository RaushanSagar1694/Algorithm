




// 1813. Sentence Similarity III



class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() < sentence2.length()){
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }

        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int i = 0;
        int k = 0;
        int j = s1.length -1;
        int l = s2.length -1;

        while(i < s1.length && k < s2.length && s1[i].compareTo(s2[k]) == 0){
            i++;
            k++;
        }

        while(j >= 0 && l >= 0 && s1[j].compareTo(s2[l]) == 0){
            j--;
            l--;
        }


        return l < k;
    }
}