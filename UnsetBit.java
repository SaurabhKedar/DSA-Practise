public class UnsetBit {
    static boolean isBitSet(int A, int i){
        if (((A >> i) & 1) == 1){
            return true;
        }
        return false;
    }
    static int unsetBit(int A, int i){
        if (isBitSet(A, i)){
            A = A ^ (1 << i);
        }
        return A;
    }
    static void main() {
        System.out.println(unsetBit(5, 2));
    }
}
