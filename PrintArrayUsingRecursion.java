public class PrintArrayUsingRecursion {
    static void print(int[] A, int i){
        if (i == A.length){
            return;
        }
        System.out.print(A[i] + " ");
        print(A, i + 1);
    }

    static int bar(int x, int y){
        if (y == 0) return 0;
        return (x + bar(x, y -1));
    }

    static int foo(int x, int y){
        if (y == 0) return 1;
        return bar(x, foo(x, y - 1));
    }
    static void main() {
        int[] A = {1, 2, 3, 4, 5};
        print(A, 0);

        //System.out.println(foo(3, 5));
    }
}
