package ByteDance;

public class NumberMatch {

    public int numberOfMatches(int n) {
        int sum = 0;
        do{
            sum += n/2;
            if(n%2==0)
            {
                n=n/2;
            }else
            {
                n=(n/2+1);
            }
        }while(n>1);
        return sum;
    }
}
