


class LongestCommonSubsequence {
    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D DP array to store the length of LCS for different substrings
        int[][] dp = new int[n + 1][m + 1];

        // Build the dp array in bottom-up fashion
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;  // Characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // Characters don't match
                }
            }
        }

        // The value at dp[n][m] contains the length of LCS
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "ABCBDAB";
        String s2 = "BDCAB";

        int result = lcs(s1, s2);

        System.out.println("Length of Longest Common Subsequence: " + result);
    }
}