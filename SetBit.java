public class SetBit {
    static int setBit(int A, int B){
        int ans = 0;
        ans = ans | (1 << A);
        ans = ans | (1 << B);
        return ans;
    }
    static void main() {
        System.out.println(setBit(3, 5));
    }
}
