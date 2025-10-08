/**
 * @Filename: Main.java
 * @Description: Entry point of the application that demonstrates usage of the
 *               MyString class and its string manipulation methods such as
 *               append, replace, reverse, countOfWords, splice, split, and sort.
 * @Author: Bhavya Jain
 */

public class Main {

    /**
     * The main method — serves as the entry point of the program.
     * Demonstrates the functionality of the custom MyString class
     * using Java-related examples.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Initialize with a base string
        MyString str = new MyString("Java");

        // Append another word
        System.out.println("Original String: " + str);
        System.out.println("After append(\" Programming\"): " + str.append(" Programming"));

        // Replace substring
        System.out.println("After replace(\"Programming\", \"Language\"): " + str.replace("Programming", "Language"));

        // Reverse the string
        str.reverse();
        System.out.println("After reverse(): " + str);

        // Length of string
        System.out.println("Length of current string: " + str.length());

        // Reset the string for next operations
        str = new MyString("Java is fun and powerful");

        // Count words
        System.out.println("\nString for word count: " + str);
        System.out.println("Word count: " + str.countOfWords());

        // Check palindrome
        MyString palindromeStr = new MyString("madam");
        System.out.println("\nChecking palindrome for 'madam': " + palindromeStr.isPalindrome());

        MyString nonPalindrome = new MyString("Java");
        System.out.println("Checking palindrome for 'Java': " + nonPalindrome.isPalindrome());

        // Splice example
        MyString spliceStr = new MyString("JavaScript");
        System.out.println("\nOriginal String for splice(): " + spliceStr);
        System.out.println("After splice(4, 6): " + spliceStr.splice(4, 6)); // Removes "Script"

        // Split example
        MyString splitStr = new MyString("Java is a versatile language");
        System.out.println("\nOriginal String for split(): " + splitStr);
        String[] words = splitStr.split(" ");
        System.out.println("Split by space:");
        for (String w : words) {
            System.out.println("- " + w);
        }

        // Sort characters alphabetically
        MyString sortStr = new MyString("program");
        System.out.println("\nOriginal String for sort(): " + sortStr);
        System.out.println("After sort(): " + sortStr.sort());

        System.out.println("\n----- End of Demonstration -----");
    }
}
