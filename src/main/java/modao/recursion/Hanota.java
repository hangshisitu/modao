package modao.recursion;

import java.util.List;

public class Hanota {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        recursion(A,0,B,0,C,0);
    }

    public void recursion(List<Integer> A, int aStart,List<Integer> B, int bStart,List<Integer> C, int cStart)
    {
        if(A.size()-aStart<=0)
        {
            return;
        }
        if(A.size()-aStart==1)
        {
            C.add(A.get(0));
            return;
        }
        if(A.size()-aStart==2)
        {
            B.add(A.get(aStart+1));
            C.add(A.get(aStart));
            A.remove(aStart);
            A.remove(aStart);
            C.add(B.get(bStart));
            B.remove(bStart);
            return;
        }
        recursion(A,aStart+1,C,cStart,B,bStart);
        C.add(A.get(aStart));
        ++cStart;
        A.remove(aStart);
        recursion(B,bStart,A,aStart,C,cStart);
    }

}
