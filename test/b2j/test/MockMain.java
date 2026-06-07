/**
 * Erstelle dein Programm über Blockly und
 * klicke auf 'Play', um es auszuführen!
 */

public class Main {
    /**
     * Das Hauptprogramm (main-Methode):
     * Alles, was ausgeführt werden soll,
     * muss in diese Methode eingefügt werden.
     * Objekte erstellen, Methoden aufrufen, ...
     *
     * Das Hauptprogramm wird automatisch
     * gestartet, wenn du auf 'Play' drückst.
     */
    public static void main() {
        System.out.println(aufgabe1());
    }

    public static int[] aufgabe1() {
        int[] arr1 = {1, 2, 3};
        return arr1;
    }

    public static double[] aufgabe2() {
        double[] arr2 = new double[11];
        for (int i = 0; i < 11; i++) {
            arr2[i] = Math.pow(2, i);
        }
        return arr2;
    }

    public static String aufgabe3(String[] arr) {
        return arr[0];
    }

    public static int aufgabe4(int[] arr) {
        return arr[arr.length - 1];
    }

    public static void aufgabe5(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] aufgabe6(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * arr[i];
        }
        return arr;
    }

    public static int aufgabe7(int[] arr) {
        int summe = 0;
        for (int i = 0; i < arr.length; i++) {
            summe = summe + arr[i];
        }
        return summe;
    }

}