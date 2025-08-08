class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int possibleDups = 0;
        int last = n - 1;

        // Count the number of zeros that can be duplicated
        for (int i = 0; i <= last - possibleDups; i++) {
            if (arr[i] == 0) {
                // Edge case: zero at the boundary
                if (i == last - possibleDups) {
                    arr[last] = 0; // Duplicate it once
                    last--;
                    break;
                }
                possibleDups++;
            }
        }

        // Start from the last element to be copied
        int newLast = last - possibleDups;
        for (int i = newLast; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}