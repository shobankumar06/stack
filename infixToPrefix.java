import java.util.*;
import java.util.Stack;
public class Main
{
    public static String infixToPrefix(String str){
        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();
        char arr[] = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                arr[i]=')';
            }
            else if(arr[i]==')'){
                arr[i]='(';
            }
        }
        String res="";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            char x = arr[i];
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
                if(x=='^'){
                    while(!stack.isEmpty() && priority(x)<=priority(stack.peek())){
                        res+=stack.pop();
                    }
                    stack.push(x);
                }
                else{
                    while(!stack.isEmpty() && priority(x)<priority(stack.peek())){
                        res+=stack.pop();
                    }
                    stack.push(x);
                }
            }
        }
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        StringBuilder s = new StringBuilder(res);
        return s.reverse().toString();
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
		System.out.print(infixToPrefix(str));
	}
}