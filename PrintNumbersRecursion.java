public class PrintNumbersRecursion {
    static void print(int A){
        if (A == 1){
            System.out.print(1 + " ");
            return;
        }
        //decrement order
        //System.out.print(A + " ");

        print(A -1);

        //increment order
        System.out.print(A + " ");
    }

    static void main() {
        print(5);
    }
}
