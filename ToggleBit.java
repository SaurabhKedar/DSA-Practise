public class ToggleBit {
    static int toggleBit(int A, int i){
        A = A ^ (1 << i);
        return A;
    }
    static void main() {
        System.out.println(toggleBit(4, 1));
    }
}
