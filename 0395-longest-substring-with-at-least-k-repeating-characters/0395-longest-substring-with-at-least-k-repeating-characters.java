class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] freq = new int[26];
            int left = 0, right = 0, uniqueCount = 0, countAtLeastK = 0;

            while (right < n) {
                // Expand window
                if (uniqueCount <= targetUnique) {
                    int idx = s.charAt(right) - 'a';
                    if (freq[idx] == 0) uniqueCount++;
                    freq[idx]++;
                    if (freq[idx] == k) countAtLeastK++;
                    right++;
                }
                // Shrink window
                else {
                    int idx = s.charAt(left) - 'a';
                    if (freq[idx] == k) countAtLeastK--;
                    freq[idx]--;
                    if (freq[idx] == 0) uniqueCount--;
                    left++;
                }

                // Check if valid substring
                if (uniqueCount == targetUnique && uniqueCount == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }

        return maxLen;
    }
}