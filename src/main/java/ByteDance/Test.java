package ByteDance;

import java.util.*;
public class Test{
    public static void main(String []args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n;++i)
        {
            String temp = scanner.next();
            System.out.println(adjust(temp));
        }
    }
    public static String adjust(String s)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length();)
        {
            if(i>=2 && s.charAt(i) == s.charAt(i-1) && s.charAt(i)==s.charAt(i-2))
            {
                s = stringBuilder.toString().concat(s.substring(i+1));
//                stringBuilder.append(s.substring(i+1));
//                s = stringBuilder.toString();
                continue;
            }
            if(i>=3 && s.charAt(i)==s.charAt(i-1) &&  s.charAt(i-2)== s.charAt(i-3))
            {
                s = stringBuilder.toString().concat(s.substring(i+1));
//                stringBuilder.append(s.substring(i+1));
//                s = stringBuilder.toString();
                continue;
            }
            stringBuilder.append(s.charAt(i));
            ++i;
        }
        return stringBuilder.toString();
    }
}
