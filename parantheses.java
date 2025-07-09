import java.util.*;
class Main{
    private static boolean parantheses(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char x = str.charAt(i);
            if(x=='(' || x=='{' || x=='['){
                s.push(x);
                continue;
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                else{
                    char l = s.pop();
                    switch(x){
                        case ')':
                            if(l!='('){
                                return false;
                            }
                            break;
                        case ']':
                            if(l!='['){
                                return false;
                            }
                            break;
                        case '}':
                            if(l!='{'){
                                return false;
                            }
                            break;
                        default:
                            return false;
                    }
                }
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.next();
        if(parantheses(str)){
            System.out.print("yes");
        }
        else{
            System.out.print("no");
        }
    }
}