package ua.opnu;

import java.util.Arrays;

public class Main {

    // ====================== Завдання 1 ======================
    // Предикат для перевірки на просте число
    public static Predicate isPrimePredicate = (n) -> {
        int x = (int) n;
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    };

    // ====================== Завдання 2 ======================
    public static class Student {
        private String name;
        private String group;
        private int[] marks;

        public Student(String name, String group, int[] marks) {
            this.name = name;
            this.group = group;
            this.marks = marks;
        }

        public String getName() { return name; }
        public String getGroup() { return group; }
        public int[] getMarks() { return marks; }

        public boolean hasDebt() {
            for (int m : marks) {
                if (m < 60) return true;
            }
            return false;
        }
    }

    public static Student[] filterStudents(Student[] arr, Predicate p) {
        Student[] temp = new Student[arr.length];
        int k = 0;

        for (Student s : arr) {
            if (p.test(s)) {
                temp[k++] = s;
            }
        }
        return Arrays.copyOf(temp, k);
    }

    // ====================== Завдання 3 ======================
    public static int[] filterTwo(int[] arr, Predicate p1, Predicate p2) {
        int[] res = new int[arr.length];
        int k = 0;

        for (int x : arr) {
            if (p1.test(x) && p2.test(x)) {
                res[k++] = x;
            }
        }
        return Arrays.copyOf(res, k);
    }

    // ====================== Завдання 4 ======================
    public static Consumer<Student> studentPrinter = (s) ->
            System.out.println(s.getName());

    public static void forEach(Student[] arr, Consumer<Student> c) {
        for (Student s : arr) c.accept(s);
    }

    // ====================== Завдання 5 ======================
    public static void actionIf(int[] arr, Predicate p, Consumer c) {
        for (int x : arr) {
            if (p.test(x)) {
                c.accept(x);
            }
        }
    }

    // ====================== Завдання 6 ======================
    public static Function powerOfTwo = (n) -> {
        int x = (int) n;
        return (int) Math.pow(2, x);
    };

    public static int[] applyFunction(int[] arr, Function f) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = (int) f.apply(arr[i]);
        }
        return res;
    }

    // ====================== Завдання 7 ======================
    public static Function numberToString = (n) -> {
        String[] names = {
                "нуль", "один", "два", "три", "чотири",
                "п’ять", "шість", "сім", "вісім", "дев’ять"
        };
        return names[(int)n];
    };

    public static String[] stringify(int[] arr, Function f) {
        String[] out = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = (String) f.apply(arr[i]);
        }
        return out;
    }

    // ====================== main ======================
    public static void main(String[] args) {
       
    }
}
