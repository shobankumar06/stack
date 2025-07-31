import java.util.*;
import java.util.Stack;
public class Main
{
    public static String postfixToinfix(String str){
        String res="";
        Stack<String> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char x = str.charAt(i);
            String newStr = String.valueOf(x);
            if(Character.isLetterOrDigit(x)){
                stack.push(newStr);
            }
            else{
                String xx = stack.pop();
                String yy = stack.pop();
                res = "("+yy+newStr+xx+")";
                stack.push(res);
            }
            
        }
        return stack.peek();
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.print(postfixToinfix(str));
	}
}