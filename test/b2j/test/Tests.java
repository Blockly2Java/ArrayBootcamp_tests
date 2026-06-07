package b2j.test;

import b2j.wrappers.MainWrapper;

public class Tests {
    static MainWrapper<?> main = new MainWrapper<>(); 

    public static void testMain() {
        main.main().invoke();
    }




    static ClzHelper clzHelper;
    static Random ran = new Random();

    static void generateErrMsg(List<String> errMsgBuilder)
    {
        if (!errMsgBuilder.isEmpty())
        {
            fail(String.join("\n", errMsgBuilder));
        }
    }

    static boolean compareArraysOneToShort(int[] actual, int[] expected)
    {
        if(actual.length == expected.length)
        {
            for(int i=0; i < actual.length; i++)
            {
                if(actual[i] != expected[i])
                {
                    return false;
                }
            }
        }
        return true;
    }
    static void compareArrays(int[] actual, int[] expected, int exerciseNr)
    {
        List<String> errMsgBuilder = new ArrayList<>();
        if(actual == null)
        {
            fail("Es wird kein Array zurückgegeben. [e80a2fc0b9]" +
                    (instructions ? "\nErsetze 'null' in der Vorlage mit 'new int[] {...}'" : ""));
        }

        if(actual.length == 0 && expected.length != 0)
        {
            fail("Es wird ein leeres Array zurückgegeben. [c5bc30f6d2]" +
                    (instructions ? "\nTrage in den geschweiften Klammern die Werte mit Komma getrennt ein: '{1, 2, ...}'" : ""));
        }

        if(actual.length != expected.length)
        {
            String msg = "Die Länge des Arrays ist nicht korrekt. [e80a2fc0b9]";
            if(exerciseNr == 1)
            {
                errMsgBuilder.add(msg +
                        (instructions ? "\nIn den geschweiften Klammern müssen genau die 11 ersten Zweierpotenzen (beginnend bei 2^0) stehen. Du kannst auch ein leeres Array erzeugen und dann mit eine Schleife befüllen." : ""));
            }
            else if(exerciseNr == 2)
            {
                errMsgBuilder.add(msg +
                        (instructions ? "\nVerändere nicht die Länge des Arrays, sondern nur die einzelnen Werte." : ""));
                generateErrMsg(errMsgBuilder);
            }
        }

        if(actual.length + 1 == expected.length)
        {
            if(compareArraysOneToShort(actual, Arrays.copyOfRange(expected, 0, actual.length)))
            {
                errMsgBuilder.add("Dem zurückgegebenen Array fehlt das letzte Element. [aeb81c721a]" +
                        (instructions ? "\nErgänze als letztes Element '1024'" : ""));
            }
            if(compareArraysOneToShort(actual, Arrays.copyOfRange(expected, 1, expected.length)))
            {
                errMsgBuilder.add("Dem zurückgegebenen Array fehlt das erste Element. [3b371f51e8]" +
                        (instructions ? "\nErgänze als erstes Element '1'" : ""));
            }
            generateErrMsg(errMsgBuilder);
        }

        for(int i = 0; i < actual.length && i < expected.length; i++)
        {
            if(actual[i] != expected[i])
            {
                errMsgBuilder.add("Das " + (i+1) + ". Element des Arrays ist nicht korrekt. [e6a4ed1769]" +
                        (instructions ? "\nDas " + (i+1) + ". Element des Arrays muss im überprüften Beispiel sein: " + expected[i] + "\nIn deiner Abgabe ist es: " +actual[i] : ""));
            }
        }
        generateErrMsg(errMsgBuilder);
    }

    static boolean struct = false;
    @Test @StrictTimeout(1) @Order(1)
    void struct()
    {
        List<String> errMsgBuilder = new ArrayList<>();

        try { clzHelper = new ClzHelper("src.aufgaben.Main"); }
        catch (Exception e) { fail(e.getMessage()); }

        try { clzHelper.structMethod("aufgabe1","int[]","public static"); }
        catch (Exception e) { errMsgBuilder.add(e.getMessage()); }

        try { clzHelper.structMethod("aufgabe2","int[]","public static", int[].class); }
        catch (Exception e) { errMsgBuilder.add(e.getMessage()); }

        try { clzHelper.structMethod("aufgabe3","int","public static", int[].class); }
        catch (Exception e) { errMsgBuilder.add(e.getMessage()); }

        try { clzHelper.structMethod("aufgabe4","int","public static", int[].class); }
        catch (Exception e) { errMsgBuilder.add(e.getMessage()); }

        try { clzHelper.structMethod("aufgabe5","int","public static", int[].class); }
        catch (Exception e) { errMsgBuilder.add(e.getMessage()); }

        generateErrMsg(errMsgBuilder);
        struct = true;
    }

    @Test @StrictTimeout(1) @Order(2)
    void testA1()
    {
        if(!struct) { fail("Voraussetzungen nicht erfüllt. [a45b5f71de]"); }


        int[] actual = (int[])clzHelper.invoke("aufgabe1","int[]","public static");
        int[] expected = MockMain.aufgabe1();

        if(actual == null)
        {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }


        compareArrays(actual, expected, 1);
    }


    @Test @StrictTimeout(1) @Order(2)
    void testA2()
    {
        if(!struct) { fail("Voraussetzungen nicht erfüllt. [a45b5f71de]"); }

        int[] array = new int[50];
        for(int i=0; i < 50; i++)
        {
            int x = ran.nextInt(2000)-1000;
            while(x == -1)
            {
                x = ran.nextInt(2000)-1000;
            }
            array[i] = x;
        }

        int[] actual = (int[])clzHelper.invoke("aufgabe2","int[]","public static", array);
        int[] expected = MockMain.aufgabe2(array);

        if(actual == null)
        {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }

        compareArrays(actual, expected,2);
    }
    @Test @StrictTimeout(1) @Order(2)
    void testA2_simple()
    {
        if(!struct) { fail("Voraussetzungen nicht erfüllt. [a45b5f71de]"); }
        int[] array = new int[0];

        int[] actual = (int[])clzHelper.invoke("aufgabe2","int[]","public static", array);
        int[] expected = MockMain.aufgabe2(array);

        if(actual == null)
        {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }

        compareArrays(actual, expected,2);
    }

    @Test @StrictTimeout(1) @Order(2)
    void testA3()
    {
        if(!struct) { fail("Voraussetzungen nicht erfüllt. [a45b5f71de]"); }
        int[] array = new int[50];
        for(int i=0; i < 50; i++)
        {
            int x = ran.nextInt(2000)-1000;
            while(x == -1)
            {
                x = ran.nextInt(2000)-1000;
            }
            array[i] = x;
        }

        int actual = -1;
        try
        {
            actual = (int) clzHelper.invoke("aufgabe3", "int", "public static", array);
        }
        catch(IndexOutOfBoundsException e)
        {
            fail("Du versuchst auf einen Index zuzugreifen, den es im Array nicht gibt. [231dec504f]" +
                    (instructions ? "\nDer kleinste verfügbare Index ist 0, der größte 'array.length - 1'" : ""));
        }
        catch(Exception e)
        {
            fail(e.getMessage());
        }
        int expected = array[0];

        if(expected == actual)
        {
            return;
        }

        if(actual == -1)
        {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }

        if(actual == array[1])
        {
            fail("Es wird das zweite Element des Arrays zurückgegeben. [370f883527]" +
                    (instructions ? "\nDas erste Element gibst du so zurück:\nreturn array[0];" : ""));
        }

        if(actual != expected)
        {
            fail("Das erste Element des Arrays wird nicht korrekt zurückgegeben. [82948cb81f]" +
                    (instructions ? "\nDas erste Element gibst du so zurück:\nreturn array[0];" : ""));
        }
    }
    @Test @StrictTimeout(1) @Order(2)
    void testA4()
    {
        if(!struct) { fail("Voraussetzungen nicht erfüllt. [a45b5f71de]"); }
        int[] array = new int[50];
        for(int i=0; i < 50; i++)
        {
            int x = ran.nextInt(2000)-1000;
            while(x == -1)
            {
                x = ran.nextInt(2000)-1000;
            }
            array[i] = x;
        }

        int actual = -1;
        try
        {
            actual = (int) clzHelper.invoke("aufgabe4", "int", "public static", array);
        }
        catch(IndexOutOfBoundsException e)
        {
            fail("Du versuchst auf einen Index zuzugreifen, den es im Array nicht gibt. [231dec504f]" +
                    (instructions ? "\nDer kleinste verfügbare Index ist 0, der größte 'array.length - 1'" : ""));
        }
        catch(Exception e)
        {
            fail(e.getMessage());
        }
        int expected = array[array.length - 1];


        if(actual == -1)
        {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }

        if(expected == actual)
        {
            return;
        }

        if(actual == array[0])
        {
            fail("Es wird das erste Element des Arrays zurückgegeben. [885aaecdef]" +
                    (instructions ? "\nDas letzte Element gibst du so zurück:\nreturn array[array.length-1];" : ""));
        }
        if(actual == array[1])
        {
            fail("Es wird das zweite Element des Arrays zurückgegeben. [4ce70433c8]" +
                    (instructions ? "\nDas letzte Element gibst du so zurück:\nreturn array[array.length-1];" : ""));
        }

        if(actual != expected)
        {
            fail("Das letzte Element des Arrays wird nicht korrekt zurückgegeben. [43a12f6a23]" +
                    (instructions ? "\nDas letzte Element gibst du so zurück:\nreturn array[array.length-1];" : ""));
        }
    }
    @Test @StrictTimeout(1) @Order(2)
    void testA5()
    {
        if(!struct) { fail("Voraussetzungen nicht erfüllt. [a45b5f71de]"); }
        int[] array = new int[50];
        for(int i=0; i < 50; i++)
        {
            int x = ran.nextInt(2000)-1000;
            while(x == -1)
            {
                x = ran.nextInt(2000)-1000;
            }
            array[i] = x;
        }

        int actual = -1;
        try
        {
            actual = (int) clzHelper.invoke("aufgabe5", "int", "public static", array);
        }
        catch(IndexOutOfBoundsException e)
        {
            fail("Du versuchst auf einen Index zuzugreifen, den es im Array nicht gibt. [231dec504f]" +
                    (instructions ? "\nDer kleinste verfügbare Index ist 0, der größte 'array.length - 1'" : ""));
        }
        catch(Exception e)
        {
            fail(e.getMessage());
        }
        int expected = MockMain.aufgabe5(array);


        if(actual == -1)
        {
            fail("Aufgabe wurde noch nicht bearbeitet.");
        }


        if(expected == actual)
        {
            return;
        }

        if(actual == array[0])
        {
            fail("Es wird das erste Element des Arrays zurückgegeben. [b24700ef46]" +
                    (instructions ? "\nGib die Summe aller Elemente im Array zurück. Hierfür brauchst du so eine For-Schleife: \n" +
                            "int summe = 0;\nfor(int i=0; i<array.length; i++) {\n    summe += array[i];\n}" : ""));
        }
        if(actual == array[array.length-1])
        {
            fail("Es wird das letzte Element des Arrays zurückgegeben. [07412a10f8]" +
                    (instructions ? "\nGib die Summe aller Elemente im Array zurück. Hierfür brauchst du eine For-Schleife: \n" +
                            "int summe = 0;\nfor(int i=0; i<array.length; i++) {\n    summe += array[i];\n}" : ""));
        }

        if(actual != expected)
        {
            fail("Die Summe aller Elemente des Arrays wird nicht korrekt zurückgegeben. Hast du vielleicht das erste oder letzte Elemente vergessen? [43038fa243]" +
                    (instructions ? "\nGib die Summe aller Elemente im Array zurück. Hierfür brauchst du eine For-Schleife: \n" +
                            "int summe = 0;\nfor(int i=0; i<array.length; i++) {\n    summe += array[i];\n}" : ""));
        }
    }
}
