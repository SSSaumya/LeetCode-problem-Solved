class Solution {
    public String reorganizeString(String s) {
    if (s == null || s.length() == 0) {
        return "";
    }

    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    queue.addAll(map.entrySet());

    StringBuilder sb = new StringBuilder();
    while (queue.size() > 1) {
        Map.Entry<Character, Integer> entry1 = queue.poll();
        Map.Entry<Character, Integer> entry2 = queue.poll();

        sb.append(entry1.getKey());
        sb.append(entry2.getKey());

        if (entry1.getValue() > 1) {
            entry1.setValue(entry1.getValue() - 1);
            queue.add(entry1);
        }
        if (entry2.getValue() > 1) {
            entry2.setValue(entry2.getValue() - 1);
            queue.add(entry2);
        }
    }

    if (!queue.isEmpty()) {
        Map.Entry<Character, Integer> entry = queue.poll();
        if (entry.getValue() > 1) {
            return "";
        } else {
            sb.append(entry.getKey());
        }
    }

    return sb.toString();
}
        
    }
