class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
         int[] count = new int[26];
        for (char letter : letters) {
            count[letter - 'a'] += 1;
        }
        
        int n = words.length;
        int mask = 1 << n, ans = 0;
        for (int i = 1; i < mask; i++) {
            int[] tempCount = new int[26];
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 0) continue;
                for (char c : words[j].toCharArray()) {
                    tempCount[c - 'a'] += 1;
                }
            }
            
            int sum = 0;
            for (int j = 0; j < count.length; j++) {
                if (tempCount[j] > count[j]) {
                    sum = 0;
                    break;
                }
                sum += score[j] * tempCount[j];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
        
    }
}