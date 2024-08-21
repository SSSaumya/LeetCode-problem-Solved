class Solution {
    public String sortSentence(String s) {
        String [] word = s.split(" ");
        String[] sen = new String[word.length];
        for(String words:word)
        {
            int index = words.charAt(words.length() - 1) - '0' - 1;
            sen[index] = words.substring(0, words.length() - 1);
        }
        return String.join(" ", sen);
    }
}
