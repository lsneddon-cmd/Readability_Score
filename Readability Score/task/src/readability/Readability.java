package readability;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Readability {
    private final int wordCount;
    private final int sentenceCount;
    private final int charCount;
    private final double score;
    private final String targetAudience;

    public Readability(String input) {
        this.wordCount = calculateWordCount(input);
        this.sentenceCount = calculateSentenceCount(input);
        this.charCount = calculateCharCount(input);
        this.score = calculateScore(charCount, wordCount, sentenceCount);
        this.targetAudience = evaluateTargetAudience(score);
    }

    public void printDetails() {
        System.out.println("Words: " + this.wordCount);
        System.out.println("Sentences: " + this.sentenceCount);
        System.out.println("Characters: " + this.charCount);
        System.out.printf("The score is: %.2f\n", this.score);
        System.out.println("This text should be understood by "
                + this.targetAudience
                + "-year-olds.");
    }

    private static int calculateWordCount(String input) {
        return (int)Arrays.stream(input.split(" ")).count();
    }

    private static int calculateSentenceCount(String input) {
        return (int)Arrays.stream(input.split("[!.?]")).count();
    }

    private static int calculateCharCount(String input) {
        Pattern characters = Pattern.compile("[a-zA-Z0-9,.?!\"\';:()]");
        return (int)Arrays.stream(input.split(""))
                .filter(characters.asPredicate())
                .count();
    }

    private static double calculateScore(int chars, int words, int sentences) {
        return 4.71 * (double)chars/(double)words + 0.5 * (double)words/(double)sentences - 21.43;
    }

    private static String evaluateTargetAudience(double score) {
        switch ((int) Math.ceil(score)) {
            case 1:
                return "5-6";
            case 2:
                return "6-7";
            case 3:
                return "7-9";
            case 4:
                return "9-10";
            case 5:
                return "10-11";
            case 6:
                return "11-12";
            case 7:
                return "12-13";
            case 8:
                return "13-14";
            case 9:
                return "14-15";
            case 10:
                return "15-16";
            case 11:
                return "16-17";
            case 12:
                return "17-18";
            case 13:
                return "18-24";
            default:
                return "24+";
        }
    }
}
