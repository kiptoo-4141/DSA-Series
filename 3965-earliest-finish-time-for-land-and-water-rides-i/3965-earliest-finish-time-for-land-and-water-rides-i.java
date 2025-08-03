class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int m = landStartTime.length;
        int n = waterStartTime.length;
        int EPTime = Integer.MAX_VALUE;

        for(int i = 0; i < m; i++){
            int landStart = landStartTime[i];
            int landEnd = landStart + landDuration[i];
            for(int j = 0; j < n; j++){
                int waterStart = Math.max(waterStartTime[j], landEnd);
                int waterEnd = waterStart + waterDuration[j];

                EPTime = Math.min(EPTime, waterEnd);
            }
        }

        for (int j = 0; j < n; j++) {
            int waterStart = waterStartTime[j];
            int waterEnd = waterStart + waterDuration[j];
            for (int i = 0; i < m; i++) {
                int landStart = Math.max(landStartTime[i], waterEnd);
                int landEnd = landStart + landDuration[i];
                EPTime = Math.min(EPTime, landEnd);
            }
        }

        return EPTime;
    }
}