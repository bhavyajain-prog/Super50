import java.util.ArrayList;
import java.util.List;

/**
 * @Filename: MyString.java
 * @Description: This class provides a custom implementation of a String-like
 * object
 * that supports common string operations such as appending,
 * replacing,
 * reversing, counting words, and palindrome checking.
 * @Author: Bhavya Jain
 */

public class MyString {

    /**
     * The internal string value being managed by this class.
     */
    private String value;

    /**
     * Constructs a new MyString object initialized with the specified value.
     *
     * @param value the initial string value
     */
    MyString(String value) {
        this.value = value;
    }

    /**
     * Returns the current string value represented by this object.
     *
     * @return the internal string value
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Appends the specified string to the end of the current string value.
     *
     * @param value the string to be appended
     * @return the updated string after appending
     */
    public String append(String value) {
        this.value += value;
        return this.value;
    }

    /**
     * Replaces all non-overlapping occurrences of a specified substring within the
     * current string with another substring.
     * <p>
     * For example:
     *
     * <pre>
     * MyString str = new MyString("hello world");
     * str.replace("world", "Java");
     * // Result: "hello Java"
     * </pre>
     *
     * @param value the substring to be replaced (must not be empty)
     * @param by    the substring to replace with
     * @return the updated string after performing replacements
     */
    public String replace(String value, String by) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i <= this.value.length() - value.length()) {
            if (this.value.startsWith(value, i)) {
                sb.append(by);
                i += value.length();
            } else {
                sb.append(this.value.charAt(i));
                i++;
            }
        }
        sb.append(this.value.substring(i));
        this.value = sb.toString();
        return this.value;
    }

    /**
     * Reverses the current string value in place.
     * <p>
     * Example:
     *
     * <pre>
     * MyString str = new MyString("hello");
     * str.reverse();
     * // Value becomes "olleh"
     * </pre>
     */
    public void reverse() {
        StringBuilder sb = new StringBuilder();
        for (int i = this.value.length() - 1; i >= 0; i--) {
            sb.append(this.value.charAt(i));
        }
        this.value = sb.toString();
    }

    /**
     * Returns the length of the current string value.
     * <p>
     * Example:
     *
     * <pre>
     * MyString str = new MyString("Java");
     * str.length(); // returns 4
     * </pre>
     *
     * @return the number of characters in the current string
     */
    public int length() {
        return this.value.length();
    }

    /**
     * Counts the number of words in the current string.
     * Words are assumed to be separated by one or more spaces.
     * <p>
     * Example:
     *
     * <pre>
     * MyString str = new MyString("Hello world from Java");
     * str.countOfWords(); // returns 4
     * </pre>
     *
     * @return the number of words in the current string
     */
    public int countOfWords() {
        String s = this.value.trim();
        if (s.isEmpty())
            return 0;

        int count = 1; // Start with 1 word
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if the current string value is a palindrome.
     * A palindrome reads the same backward as forward.
     * <p>
     * Example:
     *
     * <pre>
     * MyString str = new MyString("madam");
     * str.isPalindrome(); // returns true
     * </pre>
     *
     * @return {@code true} if the string is a palindrome; {@code false} otherwise
     */
    public boolean isPalindrome() {
        int left = 0;
        int right = this.value.length() - 1;
        while (left < right) {
            char c1 = this.value.charAt(left++);
            char c2 = this.value.charAt(right--);
            if (c1 != c2)
                return false;
        }
        return true;
    }

    /**
     * Removes a substring from the current string, starting from the specified index
     * and of the specified length.
     * <p>
     * Example:
     * <pre>
     * MyString str = new MyString("Java is cool");
     * str.splice(5, 3); // Removes "is "
     * // Result: "Java cool"
     * </pre>
     * </p>
     *
     * @param start  the starting index from which to remove characters (0-based)
     * @param length the number of characters to remove
     * @return the updated string after removing the substring
     */
    public String splice(int start, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.value.length(); i++) {
            if (i < start || i >= start + length) {
                sb.append(this.value.charAt(i));
            }
        }
        this.value = sb.toString();
        return this.value;
    }

    /**
     * Splits the current string into an array of substrings using the specified pattern.
     * <p>
     * Example:
     * <pre>
     * MyString pattern = new MyString("Codeup ACE Academy");
     * String[] words = pattern.split(" ");
     * // Result: ["Codeup", "ACE", "Academy"]
     * </pre>
     * </p>
     *
     * @param pattern the string that separates the parts
     * @return an array of substrings obtained by splitting the current string
     */
    public String[] split(String pattern) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.value.length(); i++) {
            boolean flag = false;
            if (i <= this.value.length() - pattern.length()) {
                flag = true;
                for (int j = 0; j < pattern.length(); j++) {
                    if (this.value.charAt(i + j) != pattern.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                result.add(sb.toString());
                sb.setLength(0);
                i += pattern.length() - 1;
            } else {
                sb.append(this.value.charAt(i));
            }
        }
        result.add(sb.toString());
        return result.toArray(new String[0]);
    }

    /**
     * Sorts the characters of the current string in alphabetical order
     * without using built-in sorting functions.
     * <p>
     * Example:
     * <pre>
     * MyString str = new MyString("program");
     * String sortedText = str.sort();
     * // Result: "agmnoprr"
     * </pre>
     * </p>
     *
     * @return the updated string after sorting characters alphabetically
     */
    public String sort() {
        int n = this.value.length();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = this.value.charAt(i);
        }
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char a : chars) {
            sb.append(a);
        }
        this.value = sb.toString();
        return this.value;
    }
}
