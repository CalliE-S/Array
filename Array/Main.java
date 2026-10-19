//Week 5 Activities - Array

//Name: Otibar, John Carlo Q. 
//Section: DIT 2-7

//Activity 1:Favorite Things Array

public class Main {
    public static void main(String[] args) {
        String[] favorites = {
            "Badminton",
            "Reading",
            "Series",
            "Travel",
            "Content Creation"
        };

        for (int i = 0; i < favorites.length; i++) {
            System.out.println((i + 1) + ". " + favorites[i]);
        }

        System.out.println("Total number of favorites: " + favorites.length);
    }
}

//Results: 
/*
1. Badminton
2. Reading
3. Series
4. Travel
5. Content Creation
Total number of favorites: 5
*/


//Activity 2: Classic Statistics Calculator


public class ClassStatisticsCalculator {
    public static void main(String[] args) {
        int[] scores = {85, 90, 78, 92, 88, 76, 95, 80};

        int sum = 0;
        int highest = scores[0];
        int lowest = scores[0];

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];

            if (scores[i] > highest) {
                highest = scores[i];
            }

            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }

        double average = (double) sum / scores.length;

        System.out.println("Total Sum: " + sum);
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
    }
}

//Results: 
/*
Total Sum: 684
Average Score: 85.5
Highest Score: 95
Lowest Score: 76
*/


//Activity 3: Search and Sort Mini-Tool

import java.util.Arrays;

public class SearchSortMiniTool {
    public static void main(String[] args) {
        int[] scores = {85, 90, 78, 92, 88, 76, 95, 80};
        int target = 92;
        int index = -1;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println(target + " was found at index " + index);
        } else {
            System.out.println(target + " was not found.");
        }

        // Sorting a copy preserves the original array's order for other operations
        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);

        System.out.println("Original array: " + Arrays.toString(scores));
        System.out.println("Sorted array: " + Arrays.toString(sortedScores));
    }
}

//Results:
/* 
92 was found at index 3
Original array: [85, 90, 78, 92, 88, 76, 95, 80]
Sorted array: [76, 78, 80, 85, 88, 90, 92, 95]
*/


//Activity 4: Class Ranking System

public class ClassRankingSystem {

    static class Student {
        String name;
        int[] quizzes;
        double average;

        Student(String name, int[] quizzes) {
            this.name = name;
            this.quizzes = quizzes;

            int sum = 0;
            for (int score : quizzes) {
                sum += score;
            }

            average = (double) sum / quizzes.length;
        }
    }

    public static void main(String[] args) {
        String[] names = {
            "Kevin", "Geralyn", "Carlo", "John Ful", "Jelian"
        };

        int[][] quizData = {
            {90, 85, 95, 90},
            {80, 85, 90, 85},
            {95, 90, 90, 85},
            {80, 85, 90, 85},
            {75, 80, 85, 90}
        };

        Student[] students = new Student[names.length];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(names[i], quizData[i]);
        }

        sortStudents(students);

        System.out.println("========== Class Leaderboard  ==========");
        System.out.printf("%-8s %-12s %-10s%n", "Rank", "Name", "Average");

        int rank = 1;

        for (int i = 0; i < students.length; i++) {
            if (i > 0 &&
                students[i].average != students[i - 1].average) {
                rank = i + 1;
            }

            System.out.printf(
                "%-8d %-12s %-10.2f%n",
                rank,
                students[i].name,
                students[i].average
            );
        }

        String searchName = "Diana";
        int studentRank = findRank(students, searchName);

        System.out.println("\n========== STUDENT SEARCH ==========");

        if (studentRank != -1) {
            System.out.println(searchName + "'s rank: " + studentRank);
        } else {
            System.out.println(searchName + " was not found.");
        }
    }

    public static void sortStudents(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].average < students[j + 1].average) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public static int findRank(Student[] students, String name) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].name.equalsIgnoreCase(name)) {
                for (int j = 0; j < students.length; j++) {
                    if (students[j].average > students[i].average) {
                        continue;
                    }
                }

                int rank = 1;

                for (int j = 0; j < students.length; j++) {
                    if (students[j].average > students[i].average) {
                        rank++;
                    }
                }

                return rank;
            }
        }

        return -1;
    }
}

//Results: 
/* 
========== Class Leaderboard ==========
Rank     Name         Average
1        Kevin        90.00
1        Carlo        90.00
3        Geralyn      85.00
3        John Ful     85.00
5        Jelian       82.50

========== STUDENT SEARCH ==========
Diana was not found.
*/





