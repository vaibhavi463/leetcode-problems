class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;                   
        int j = s.length() - 1;       

        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;}

            
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;}

            
            char leftChar = Character.toLowerCase(s.charAt(i));
            char rightChar = Character.toLowerCase(s.charAt(j));

    
            if (leftChar != rightChar) {
                return false;}

            i++;
            j--;}

        return true;
    }
}