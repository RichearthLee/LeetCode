package t11;


import java.util.Scanner;
/**
 * @author yukunlee
 * @Description TODO
 * @date 2018年10月11日
 */
public class T11_1 {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String word = sc.next();
             
            if(isAllUpCase(word) && isConEql(word) && isThrEql(word))
                System.out.println("Likes");
            else
                System.out.println("Dislikes");
        }
    }
    //����1
     public static boolean isAllUpCase(String word){
        return word.matches("[A-Z]+");
    }
    //����2
    public static boolean isConEql(String word){
        return !word.matches(".*(.)(\\1).*");
    }
    //����3
    public static boolean isThrEql(String word){
        return !word.matches(".*(.).*(.)(.*\\1)(.*\\2).*");
    }
}