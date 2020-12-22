package modao.db;

import java.util.Objects;

public class ByteLeaves {

    //动态规划
    public int minimumOperations(String leaves) {

        int[][] states = new int[leaves.length()][3];
        states[0][0] = leaves.charAt(0)=='y'?1:0;
        states[0][1] = states[0][2] = states[1][2] = Integer.MAX_VALUE;
        for(int i=1;i<leaves.length();++i)
        {
            states[i][0] = states[i-1][0] + (leaves.charAt(i)=='y'?1:0);
            states[i][1] = Math.min(states[i-1][0],states[i-1][1]) + (leaves.charAt(i)=='r'?1:0) ;
            if(i>=2)
            {
                states[i][2] = Math.min(states[i-1][1],states[i-1][2]) + (leaves.charAt(i)=='y'?1:0);
            }
        }
        return states[leaves.length()-1][2];
    }

}
