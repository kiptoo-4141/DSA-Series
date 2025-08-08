class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
         String normalized = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        // Split by whitespace
        String[] words = normalized.split("\\s+");

        // Create banned set
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // Count frequencies
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word) && !word.isEmpty()) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        // Find max frequency word
        String result = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}