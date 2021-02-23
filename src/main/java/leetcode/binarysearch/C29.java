package leetcode.binarysearch;

public class C29 {
    public int divide(int dividend, int divisor) {

        if(dividend == 0)
        {
            return 0;
        }

        boolean flag=false;
        if((dividend<0 && divisor>0) ||
                (dividend>0 && divisor<0))
        {
            flag = true;
        }

        long tempDividend = dividend<0 ? (long)0-dividend:dividend;
        long originDivisor = divisor<0 ? (long)0-divisor:divisor;

        long res = 0;
        while(tempDividend>=originDivisor) {
            int tempRes = 1;
            long tempDivisor = originDivisor;
            while (tempDivisor << 1 < tempDividend) {
                tempRes <<= 1;
                tempDivisor <<= 1;
            }
            tempDividend -= tempDivisor;
            res += tempRes;
        }

        if(flag)
        {
            res = 0-res;
        }

        if(res>Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        if(res<Integer.MIN_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        return (int)res;
    }
}





