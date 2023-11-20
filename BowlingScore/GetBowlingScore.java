package BowlingScore;

import java.util.ArrayList;
import java.util.List;

class GetBowlingScore {
    static Integer handleStrike(int i, String[] scores) {
        if (i + 1 >= scores.length || i + 2 >= scores.length) {
            return null;
        }

        int score = 10;
        if (scores[i + 1].equals("X")) {
            score += 10;
            if (i + 2 < scores.length && scores[i + 2].equals("X")) {
                score += 10;
            } else {
                score += Integer.parseInt(scores[i + 2]);
            }
        } else {
            score += Integer.parseInt(scores[i + 1]);
            if (scores[i + 2].equals("/")) {
                score += 10 - Integer.parseInt(scores[i + 1]);
            } else {
                score += Integer.parseInt(scores[i + 2]);
            }
        }

        return score;
    }

    static Integer handleSpare(int i, String[] scores) {
        if (i + 1 >= scores.length) {
            return null;
        }

        int score = 10;
        if (scores[i + 1].equals("X")) {
            score += 10;
        } else {
            score += Integer.parseInt(scores[i + 1]);
        }

        return score;
    }

    static Integer handleOpen(int i, String[] scores) {
        if (i + 1 >= scores.length || scores[i + 1].equals("/")) {
            return null;
        }

        return Integer.parseInt(scores[i]) + Integer.parseInt(scores[i + 1]);
    }

    public static List<Integer> getBowlingScores(String[] scores) {
        List<Integer> result = new ArrayList<Integer>();
        int frame = 0;
        int i = 0;
        while (frame < 10 && i < scores.length) {
            Integer score = 0;
            if (scores[i].equals("X")) {
                score = handleStrike(i, scores);
                i++;
            } else if (scores[i].equals("/")) {
                score = handleSpare(i, scores);
                i++;
            } else {
                if (i + 1 >= scores.length) {
                    score = null;
                    i++;
                } else if (scores[i + 1].equals("/")) {
                    i++;
                    continue;
                } else {
                    score = Integer.parseInt(scores[i]) + Integer.parseInt(scores[i + 1]);
                    i += 2;
                }
            }
            result.add(score);
            frame++;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] scores1 = { "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" };
        List<Integer> bowlingScores1 = getBowlingScores(scores1);
        System.out.println(bowlingScores1);

        String[] scores2 = { "X", "7", "/", "9", "0", "X", "0", "8", "8", "/", "0", "6", "X", "X", "X", "8", "1" };
        List<Integer> bowlingScores2 = getBowlingScores(scores2);
        System.out.println(bowlingScores2);

        String[] scores3 = { "4", "5", "X", "8" };
        List<Integer> bowlingScores3 = getBowlingScores(scores3);
        System.out.println(bowlingScores3);

        String[] scores4 = { "4", "5", "X", "8", "1" };
        List<Integer> bowlingScores4 = getBowlingScores(scores4);
        System.out.println(bowlingScores4);

        String[] scores5 = { "4", "5", "X", "8", "/" };
        List<Integer> bowlingScores5 = getBowlingScores(scores5);
        System.out.println(bowlingScores5);

        String[] scores6 = { "4", "5", "X", "8", "/", "2" };
        List<Integer> bowlingScores6 = getBowlingScores(scores6);
        System.out.println(bowlingScores6);

        String[] scores7 = { "4", "5", "X", "8", "/", "X", "3" };
        List<Integer> bowlingScores7 = getBowlingScores(scores7);
        System.out.println(bowlingScores7);
    }
}