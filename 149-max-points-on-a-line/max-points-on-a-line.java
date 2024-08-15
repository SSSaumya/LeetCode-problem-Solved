class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int maxPoints = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int samePoint = 1;
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int xDiff = points[j][0] - points[i][0];
                int yDiff = points[j][1] - points[i][1];

                if (xDiff == 0 && yDiff == 0) {
                    samePoint++;
                    continue;
                }

                int gcd = gcd(xDiff, yDiff);
                xDiff /= gcd;
                yDiff /= gcd;

                String slope = xDiff + "," + yDiff;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeMap.get(slope));
            }

            maxPoints = Math.max(maxPoints, localMax + samePoint);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}