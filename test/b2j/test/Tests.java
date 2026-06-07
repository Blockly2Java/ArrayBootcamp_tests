package b2j.test;

import b2j.wrappers.MainWrapper;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tests {
    static MainWrapper<?> main = new MainWrapper<>();

    public static void testMain() {
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(outContent));
        try {
            main.main().invoke();
        } catch (Exception e) {
            fail(e.getMessage());
        } finally {
            System.setOut(originalOut);
        }
        String output = outContent.toString().trim();
        if (output.equals("null") || output.isEmpty()) {
            fail("Die main-Methode wurde noch nicht angepasst oder gibt null aus.");
        }
    }

    static Random ran = new Random();

    static void generateErrMsg(List<String> errMsgBuilder) {
        if (!errMsgBuilder.isEmpty()) {
            fail(String.join("\n", errMsgBuilder));
        }
    }

    static boolean compareDoubleArraysOneToShort(double[] actual, double[] expected) {
        if (actual.length == expected.length) {
            for (int i = 0; i < actual.length; i++) {
                if (actual[i] != expected[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void compareDoubleArrays(double[] actual, double[] expected, int exerciseNr) {
        List<String> errMsgBuilder = new ArrayList<>();
        if (actual == null) {
            fail("Es wird kein Array zurückgegeben. [e80a2fc0b9]");
        }

        if (actual.length == 0 && expected.length != 0) {
            fail("Es wird ein leeres Array zurückgegeben. [c5bc30f6d2]");
        }

        if (actual.length != expected.length) {
            String msg = "Die Länge des Arrays ist nicht korrekt. [e80a2fc0b9]";
            if (exerciseNr == 1) {
                errMsgBuilder.add(msg +
                        "\nEs müssen genau 3 Elemente sein (1,2,3).");
                generateErrMsg(errMsgBuilder);
            }
            if (exerciseNr == 2) {
                errMsgBuilder.add(msg +
                        "\nEs müssen genau 11 Elemente sein (2^0 bis 2^10).");
                generateErrMsg(errMsgBuilder);
            }
        }

        if (actual.length + 1 == expected.length) {
            if (compareDoubleArraysOneToShort(actual, Arrays.copyOfRange(expected, 0, actual.length))) {
                errMsgBuilder.add("Dem zurückgegebenen Array fehlt das letzte Element. [aeb81c721a]" +
                        "\nErgänze als letztes Element '1024.0'");
            }
            if (compareDoubleArraysOneToShort(actual, Arrays.copyOfRange(expected, 1, expected.length))) {
                errMsgBuilder.add("Dem zurückgegebenen Array fehlt das erste Element. [3b371f51e8]" +
                        "\nErgänze als erstes Element '1.0'");
            }
            generateErrMsg(errMsgBuilder);
        }

        for (int i = 0; i < actual.length && i < expected.length; i++) {
            if (actual[i] != expected[i]) {
                errMsgBuilder.add("Das " + (i + 1) + ". Element des Arrays ist nicht korrekt. [e6a4ed1769]" +
                        "\nDas " + (i + 1) + ". Element muss im überprüften Beispiel sein: " + expected[i] +
                        "\nIn deiner Abgabe ist es: " + actual[i]);
            }
        }
        generateErrMsg(errMsgBuilder);
    }

    static void compareArrays(int[] actual, int[] expected, int exerciseNr) {
        List<String> errMsgBuilder = new ArrayList<>();
        if (actual == null) {
            fail("Es wird kein Array zurückgegeben. [e80a2fc0b9]");
        }

        if (actual.length == 0 && expected.length != 0) {
            fail("Es wird ein leeres Array zurückgegeben. [c5bc30f6d2]");
        }

        if (actual.length != expected.length) {
            String msg = "Die Länge des Arrays ist nicht korrekt. [e80a2fc0b9]";
            if (exerciseNr == 1) {
                errMsgBuilder.add(msg +
                        "\nIn den geschweiften Klammern müssen genau die Werte {1, 2, 3} stehen.");
            } else if (exerciseNr == 6) {
                errMsgBuilder.add(msg +
                        "\nVerändere nicht die Länge des Arrays, sondern nur die einzelnen Werte.");
                generateErrMsg(errMsgBuilder);
            }
        }

        if (actual.length + 1 == expected.length) {
            if (compareArraysOneToShort(actual, Arrays.copyOfRange(expected, 0, actual.length))) {
                errMsgBuilder.add("Dem zurückgegebenen Array fehlt das letzte Element. [aeb81c721a]");
            }
            if (compareArraysOneToShort(actual, Arrays.copyOfRange(expected, 1, expected.length))) {
                errMsgBuilder.add("Dem zurückgegebenen Array fehlt das erste Element. [3b371f51e8]");
            }
            generateErrMsg(errMsgBuilder);
        }

        for (int i = 0; i < actual.length && i < expected.length; i++) {
            if (actual[i] != expected[i]) {
                errMsgBuilder.add("Das " + (i + 1) + ". Element des Arrays ist nicht korrekt. [e6a4ed1769]" +
                        "\nDas " + (i + 1) + ". Element muss im überprüften Beispiel sein: " + expected[i] +
                        "\nIn deiner Abgabe ist es: " + actual[i]);
            }
        }
        generateErrMsg(errMsgBuilder);
    }

    static boolean compareArraysOneToShort(int[] actual, int[] expected) {
        if (actual.length == expected.length) {
            for (int i = 0; i < actual.length; i++) {
                if (actual[i] != expected[i]) {
                    return false;
                }
            }
        }
        return true;
    }


    
    static void testA1() {
        if (false) {
            fail("Voraussetzungen nicht erfüllt. [a45b5f71de]");
        }

        int[] actual = (int[]) main.aufgabe1().invoke();
        int[] expected = MockMain.aufgabe1();

        if (actual == null) {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }

        compareArrays(actual, expected, 1);
    }

    static void testA2() {
        if (false) {
            fail("Voraussetzungen nicht erfüllt. [a45b5f71de]");
        }

        double[] actual = (double[]) main.aufgabe2().invoke();
        double[] expected = MockMain.aufgabe2();

        if (actual == null) {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }

        compareDoubleArrays(actual, expected, 2);
    }

    static void testA3() {
        if (false) {
            fail("Voraussetzungen nicht erfüllt. [a45b5f71de]");
        }

        String[] array = new String[50];
        for (int i = 0; i < 50; i++) {
            array[i] = "val" + i;
        }

        String actual = null;
        try {
            actual = (String) main.aufgabe3().invoke((Object) array);
        } catch (IndexOutOfBoundsException e) {
            fail("Du versuchst auf einen Index zuzugreifen, den es im Array nicht gibt. [231dec504f]" +
                    "\nDer kleinste verfügbare Index ist 0, der größte 'arr.length - 1'");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        String expected = array[0];

        if (actual == null) {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }

        if (!expected.equals(actual)) {
            fail("Das erste Element des Arrays wird nicht korrekt zurückgegeben. [82948cb81f]" +
                    "\nDas erste Element gibst du so zurück:\nreturn arr[0];");
        }
    }

    static void testA4() {
        if (false) {
            fail("Voraussetzungen nicht erfüllt. [a45b5f71de]");
        }

        int[] array = new int[50];
        for (int i = 0; i < 50; i++) {
            int x = ran.nextInt(2000) - 1000;
            while (x == -1) {
                x = ran.nextInt(2000) - 1000;
            }
            array[i] = x;
        }

        int actual = -1;
        try {
            actual = (int) main.aufgabe4().invoke(array);
        } catch (IndexOutOfBoundsException e) {
            fail("Du versuchst auf einen Index zuzugreifen, den es im Array nicht gibt. [231dec504f]" +
                    "\nDer kleinste verfügbare Index ist 0, der größte 'arr.length - 1'");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        int expected = array[array.length - 1];

        if (actual == -1) {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }

        if (expected != actual) {
            fail("Das letzte Element des Arrays wird nicht korrekt zurückgegeben. [43a12f6a23]" +
                    "\nDas letzte Element gibst du so zurück:\nreturn arr[arr.length - 1];");
        }
    }

    static void testA5() {
        if (false) {
            fail("Voraussetzungen nicht erfüllt. [a45b5f71de]");
        }

        String[] array = new String[]{"y", "a", "y"};

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(outContent));
        try {
            main.aufgabe5().invoke((Object) array);
        } catch (Exception e) {
            fail(e.getMessage());
        } finally {
            System.setOut(originalOut);
        }
        String output = outContent.toString().trim().replace("\r\n", "\n");
        if (!output.equals("y\na\ny")) {
            fail("Die Methode aufgabe5 hat nicht die erwarteten Ausgaben auf der Konsole ausgegeben. [5a2ef39d8b]" +
                    "\nErwartet:\ny\na\ny\nAusgegeben:\n" + output);
        }
    }

    static void testA6() {
        if (false) {
            fail("Voraussetzungen nicht erfüllt. [a45b5f71de]");
        }

        int[] array = new int[50];
        for (int i = 0; i < 50; i++) {
            int x = ran.nextInt(2000) - 1000;
            while (x == -1) {
                x = ran.nextInt(2000) - 1000;
            }
            array[i] = x;
        }

        int[] expected = MockMain.aufgabe6(array.clone());
        int[] actual = (int[]) main.aufgabe6().invoke((Object) array);

        if (actual == null) {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }

        compareArrays(actual, expected, 6);
    }

    static void testA6_simple() {
        if (false) {
            fail("Voraussetzungen nicht erfüllt. [a45b5f71de]");
        }
        int[] array = new int[0];

        int[] expected = MockMain.aufgabe6(array.clone());
        int[] actual = (int[]) main.aufgabe6().invoke((Object) array);

        if (actual == null) {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }

        compareArrays(actual, expected, 6);

        int[] array2 = new int[]{5};
        int[] expected2 = MockMain.aufgabe6(array2.clone());
        int[] actual2 = (int[]) main.aufgabe6().invoke((Object) array2);
        compareArrays(actual2, expected2, 6);
    }

    static void testA7() {
        if (false) {
            fail("Voraussetzungen nicht erfüllt. [a45b5f71de]");
        }

        int[] array = new int[50];
        for (int i = 0; i < 50; i++) {
            int x = ran.nextInt(2000) - 1000;
            while (x == -1) {
                x = ran.nextInt(2000) - 1000;
            }
            array[i] = x;
        }

        int actual = -1;
        try {
            actual = (int) main.aufgabe7().invoke(array);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        int expected = MockMain.aufgabe7(array);

        if (actual == -1) {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }

        if (expected != actual) {
            fail("Die Summe aller Elemente des Arrays wird nicht korrekt zurückgegeben. [43038fa243]" +
                    "\nGib die Summe aller Elemente im Array zurück. Hierfür brauchst du eine For-Schleife: \n" +
                    "int summe = 0;\nfor(int i=0; i<array.length; i++) {\n    summe = summe + array[i];\n}");
        }
    }
}