class Solution {
public int[] decode(int[] encoded) {
    int n = encoded.length + 1;
    int totalXor = 0;
    for (int i = 1; i <= n; i++) {
        totalXor ^= i;
    }

    int xorWithoutFirst = 0;
    for (int i = 1; i < n - 1; i += 2) {
        xorWithoutFirst ^= encoded[i];
    }

    int firstElement = totalXor ^ xorWithoutFirst;

    int[] perm = new int[n];
    perm[0] = firstElement;
    for (int i = 0; i < n - 1; i++) {
        perm[i + 1] = perm[i] ^ encoded[i];
    }

    return perm;
}
}