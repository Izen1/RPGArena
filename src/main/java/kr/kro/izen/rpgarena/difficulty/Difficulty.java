package kr.kro.izen.rpgarena.difficulty;

public enum Difficulty {
    EASY,
    NORMAL,
    HARD;

    public static Difficulty fromString(String s) {
        return switch (s.toLowerCase()) {
            case "easy" -> EASY;
            case "normal" -> NORMAL;
            case "hard" -> HARD;
            default -> null;
        };
    }
}
