import java.util.Stack;

public class EvaluateExpression {
    static int evalRPN(String[] A){
        Stack<Integer> st = new Stack<>();
        for (String s : A){
            if (s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")){
                int a  = st.pop();
                int b = st.pop();

                int result = 0;

                switch (s){
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case  "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }

                st.push(result);
            }
            else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
    static void main() {
        String[] A = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(A));
    }
}
