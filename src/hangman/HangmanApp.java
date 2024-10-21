package hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class HangmanApp {
    public static void main(String[] args) {
        String[] words = {"москва", "гродно", "яблоко", "апельсин", "прикол"};
        Random random = new Random();
        String word = words[random.nextInt(words.length)];
        Set<Character> guessedLetters = new HashSet<>();

        int attempts = 6;

        Scanner scanner = new Scanner(System.in);
        while (attempts > 0) {

            switch(attempts){
                case 1:
                    System.out.println("""
                             +---+
                             |   |
                             O   |
                            /|\\  |
                            /    |
                                 |
                            =========
                            """);
                    break;
                case 2:
                    System.out.println("""
                             +---+
                             |   |
                             O   |
                            /|\\  |
                                 |
                                 |
                            =========
                            """);
                    break;
                case 3:
                    System.out.println("""
                             +---+
                             |   |
                             O   |
                            /|   |
                                 |
                                 |
                            =========
                            """);
                    break;
                case 4:
                    System.out.println("""
                             +---+
                             |   |
                             O   |
                             |   |
                                 |
                                 |
                            =========
                            """);
                    break;
                case 5:
                    System.out.println("""
                             +---+
                             |   |
                             O   |
                                 |
                                 |
                                 |
                            =========
                            """);
                    break;
                default:
                    System.out.println("""
                             +---+
                             |   |
                                 |
                                 |
                                 |
                                 |
                            =========
                            """);
                    break;
            }

            System.out.println("Текущее слово: " + maskWord(word, guessedLetters));
            System.out.println("Количество оставшихся попыток: " + attempts);
            System.out.println("Введите букву: ");
            char ch = scanner.next().toLowerCase().charAt(0);

            if (guessedLetters.contains(ch)) {
                System.out.println("Уже такой символ угадан!");
                continue;
            }

            guessedLetters.add(ch);

            if (word.indexOf(ch) == -1) {
                System.out.println("Такого символа нет в слове!");
                attempts--;
            }

            if (isWordGuessed(word, guessedLetters)) {
                System.out.println("Поздравляю! Вы победили!");
                return;
            }
        }
        System.out.println("""
                 +---+
                 |   |
                 O   |
                /|\\  |
                / \\  |
                     |
                =========
                """);
        System.out.println("Гейм овер! Слово было таким: " + word);
    }

    private static String maskWord(String string, Set<Character> guessedLetters)
    {
        StringBuilder maskedWord = new StringBuilder();
        for (char c : string.toCharArray())
        {
            if(!guessedLetters.contains(c))
            {
                maskedWord.append("*");
            } else {
                maskedWord.append(c);
            }
        }
        return maskedWord.toString();
    }

    private static boolean isWordGuessed(String word, Set<Character> guessedLetters) {
        for(char c : word.toCharArray()) {
            if(!guessedLetters.contains(c))
            {
                return false;
            }
        }
        return true;
    }
}
