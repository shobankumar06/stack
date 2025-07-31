import java.util.*;
import java.util.Stack;
public class Main
{
    public static String infixToPostfix(String str){
        String res="";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char x = str.charAt(i);
            if(Character.isLetterOrDigit(x)){
                res+=x;
            }
            else if(x=='('){
                stack.push(x);
            }
            else if(x==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    res+=stack.pop();
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && priority(x)<=priority(stack.peek())){
                    res+=stack.pop();
                }
                stack.push(x);
            }
        }
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
    private static int priority(char str){
        if(str=='^'){
            return 3;
        }
        if(str=='*' || str=='/'){
            return 2;
        }
        if(str=='+' || str=='-'){
            return 1;
        }
        return -1;
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.print(infixToPostfix(str));
	}
}