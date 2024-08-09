class Solution {
    public char[] reverseString(char[] s) {
        char[] newArray = new char[s.length]; // create a new char array with the same length as the input array

        for(int i = 0; i < s.length; i++) {
            newArray[i] = s[s.length - 1 - i]; // copy elements in reverse order
        }

        for(int i = 0; i < s.length; i++) {
            s[i] = newArray[i]; // copy the reversed elements back to the original array
        }
        
        return s; // return the reversed array
    }
}

