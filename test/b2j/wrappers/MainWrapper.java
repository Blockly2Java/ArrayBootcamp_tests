package b2j.wrappers;

import io.github.valentinherrmann.levenshtein.ClassWrapper;
import io.github.valentinherrmann.levenshtein.MethodWrapper;

public class MainWrapper<T> extends ClassWrapper<T>
{
    private final MethodWrapper<T, ?> main;
    private final MethodWrapper<T, int[]> aufgabe1;
    private final MethodWrapper<T, double[]> aufgabe2;
    private final MethodWrapper<T, String> aufgabe3;
    private final MethodWrapper<T, Integer> aufgabe4;
    private final MethodWrapper<T, Void> aufgabe5;
    private final MethodWrapper<T, int[]> aufgabe6;
    private final MethodWrapper<T, Integer> aufgabe7;

    public MainWrapper()
    {
        super(
            "Main",
            "", 
            "public"
        );

        main = new MethodWrapper<>(
                this,
                "main",
                void.class,
                "public",
                "static"
            );

        aufgabe1 = new MethodWrapper<>(
                this,
                "aufgabe1",
                int[].class,
                "public",
                "static"
            );

        aufgabe2 = new MethodWrapper<>(
                this,
                "aufgabe2",
                double[].class,
                "public",
                "static"
            );

        aufgabe3 = new MethodWrapper<>(
                this,
                "aufgabe3",
                String.class,
                new Class<?>[] {String[].class},
                "public",
                "static"
            );

        aufgabe4 = new MethodWrapper<>(
                this,
                "aufgabe4",
                int.class,
                new Class<?>[] {int[].class},
                "public",
                "static"
            );

        aufgabe5 = new MethodWrapper<>(
                this,
                "aufgabe5",
                void.class,
                new Class<?>[] {String[].class},
                "public",
                "static"
            );

        aufgabe6 = new MethodWrapper<>(
                this,
                "aufgabe6",
                int[].class,
                new Class<?>[] {int[].class},
                "public",
                "static"
            );

        aufgabe7 = new MethodWrapper<>(
                this,
                "aufgabe7",
                int.class,
                new Class<?>[] {int[].class},
                "public",
                "static"
            );
    }

    @Override
    public Object getObj(boolean forceNew, boolean useByteBuddy) {
        return getObj(forceNew, useByteBuddy, null);
    }

    public Object getObj() {
        return getObj(false, true);
    }

    public MethodWrapper<T, ?> main() {
        return main;
    }

    public MethodWrapper<T, int[]> aufgabe1() {
        return aufgabe1;
    }

    public MethodWrapper<T, double[]> aufgabe2() {
        return aufgabe2;
    }

    public MethodWrapper<T, String> aufgabe3() {
        return aufgabe3;
    }

    public MethodWrapper<T, Integer> aufgabe4() {
        return aufgabe4;
    }

    public MethodWrapper<T, Void> aufgabe5() {
        return aufgabe5;
    }

    public MethodWrapper<T, int[]> aufgabe6() {
        return aufgabe6;
    }

    public MethodWrapper<T, Integer> aufgabe7() {
        return aufgabe7;
    }
}
