package password;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PasswordGen {
    private static final List<Character> uppercaseLetters = toCharacterList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray());
    private static final List<Character> lowercaseLetters = toCharacterList("abcdefghijklmnopqrstuvwxyz".toCharArray());
    private static final List<Character> digits = toCharacterList("0123456789".toCharArray());
    private static final List<Character> specialCharacters = toCharacterList("!@#$%^&*()-_=+[]{}|;:',.<>?/`~".toCharArray());

    public static void main(String[] args) {
        List<Character> allCharacters = new ArrayList<>();
        allCharacters.addAll(uppercaseLetters);
        allCharacters.addAll(lowercaseLetters);
        allCharacters.addAll(digits);
        allCharacters.addAll(specialCharacters);
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Введите длину пароля (8 - 12 символов): ");
            size = scanner.nextInt();
        } while (size > 12 || size < 8);

        List<Character> pass = getRandomSample(allCharacters, size);

        StringBuilder string = new StringBuilder();
        for (char ch : pass) {
            string.append(ch);
        }
        String result = string.toString();
        System.out.println(result);
    }

    public static <T> List<T> getRandomSample(List<T> list, int sampleSize) {
        List<T> copy = new ArrayList<>(list);
        Collections.shuffle(copy);
        return copy.subList(0, Math.min(sampleSize, copy.size()));
    }

    private static List<Character> toCharacterList(char[] charArray) {
        List<Character> characterList = new ArrayList<>();
        for (char c : charArray) {
            characterList.add(c);
        }
        return characterList;
    }

}
