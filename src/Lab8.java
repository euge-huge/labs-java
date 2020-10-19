public class Lab8 {
    public static void main(String[] args) {
        String[] strings = {"Experience without theory is blind, ", "but theory without experience", " is mere intellectual play."};

        int vowelCount = 0;
        for(String str : strings) {
            for(char ch : str.toCharArray()) {
                if(isVowel(ch)) vowelCount++;
            }
        }
        System.out.println("Count of vowels: " + vowelCount);
    }

    public static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'y'};
    private static boolean isVowel(char ch) {
        for(char vowel : vowels) {
            if(Character.toLowerCase(ch) == vowel) return true;
        }
        return false;
    }
}
