import java.util.*;

//8皇后问题
public class Queen {
    public int totalNQueens(int n) {
        Set<Integer> col = new HashSet<Integer>();
        Set<Integer> upLines = new HashSet<Integer>();
        Set<Integer> downLines = new HashSet<Integer>();
        return backTrace(0,n,col,upLines,downLines,0);
    }

    public int backTrace(int depth,int n,Set<Integer> col, Set<Integer> upLines, Set<Integer> downLines,int total)
    {
        if(depth == n)
        {
            return total+1;
        }
        for(int i=0;i<n;++i)
        {
            if(col.contains(i))
            {
                continue;
            }
            if(upLines.contains(depth+i))
            {
                continue;
            }
            if(downLines.contains(depth-i))
            {
                continue;
            }
            col.add(i);
            upLines.add(depth+i);
            downLines.add(depth-i);
            total = backTrace(depth+1,n,col,upLines,downLines,total);
            downLines.remove(depth-i);
            upLines.remove(depth+i);
            col.remove(i);
        }
        return total;
    }

    public List<List<String>> solveNQueens(int n) {

        //下标标识棋盘的行标号，内容标识该行皇后放置的列标号。
        int[] path = new int[n];
        Arrays.fill(path,-1);
        Set<Integer> col = new HashSet<Integer>(2*n);
        //棋盘左上方到右下方的斜线，同一条斜线上，行下标和列下标的差值是相等的。一共有n条这样的斜线。
        Set<Integer> downLines = new HashSet<Integer>(2*n);
        //棋盘左下方到右上方的斜线，同一条斜线上，行下标+列下标是相等的。一共有n条这样的斜线。
        Set<Integer> upLines = new HashSet<Integer>(2*n);
        //用行下标+列下标的值标识一条斜线，当Q放置棋盘上时，同时将对应的斜线key放置到对应的集合。

        List<List<String>> result = new ArrayList<List<String>>();
        backTrace(path,0,n,col,downLines,upLines,result);

        return result;
    }

    public void backTrace(int[] path,int depth,int n ,Set<Integer> col,Set<Integer> downLines,Set<Integer> upLines,List<List<String>> result)
    {
        if(depth == n)
        {
            result.add(buildOneResult(path));
            return;
        }
        for(int i=0; i<n; ++i)
        {
            if(col.contains(i))
            {
                continue;
            }

            int downLine = depth-i;
            if(downLines.contains(downLine))
            {
                continue;
            }

            int upLine = depth+i;
            if(upLines.contains(upLine))
            {
                continue;
            }

            path[depth] = i;
            col.add(i);
            downLines.add(downLine);
            upLines.add(upLine);
            backTrace(path,depth+1,n,col,downLines,upLines,result);
            path[depth] = -1;
            col.remove(i);
            upLines.remove(upLine);
            downLines.remove(downLine);
        }
    }

    public List<String> buildOneResult(int[] column)
    {
        List<String> res = new ArrayList<String>(column.length);
        for(int i=0;i<column.length;++i)
        {
            char[] temp = new char[column.length];
            Arrays.fill(temp,'.');
            temp[column[i]] = 'Q';
            res.add(new String(temp));
        }
        return res;
    }

    public void dfs(int depth,char[] pieces,Character[][] path,boolean[] used,List<List<String>> res, int n)
    {
        if(depth==pieces.length)
        {
            System.out.println("get one res "+ res.toString());
            res.add(buildRes2(path));
            return;
        }
        for(int i=0;i<pieces.length;++i)
        {
            if(used[i])
            {
                continue;
            }
            used[i]=true;
            Character temp = path[i/n][i%n];
            path[i/n][i%n] = pieces[i];
            if(isConfit(i/n,i%n,path,n))
            {
                dfs(depth+1,pieces,path,used,res,n);
            }
            used[i]=false;
            path[i/n][i%n] = temp;
        }
    }



    public List<String> buildRes(List<Character> path, int n)
    {
        List<String> res = new ArrayList<String>();
        for(int i=0; i<n;++i)
        {
            res.add(new String());
        }
        for(int i=0; i<path.size();++i)
        {
            res.get(i/n).concat(path.get(i).toString());
        }
        return res;
    }

    public List<String> buildRes2(Character[][] path)
    {
        List<String> res = new ArrayList<String>();
        for(int i=0; i<path.length;++i)
        {
            StringBuilder stringBuilder = new StringBuilder();
            for( int j=0; j<path[i].length;++j)
            {
                stringBuilder.append(path[i][j]);
            }
            res.add(stringBuilder.toString());
        }
        return res;
    }

    public boolean isValid(List<Character> path,int n)
    {
        Character[][] temp = list2Array(path,n);
        for(int i=0; i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(temp[i][j]=='Q')
                {
                    if(!isConfit(i,j,temp,n))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isConfit(int r,int j,Character[][] temp,int n)
    {
        for(int t=0; t<n;++t)
        {
            if(t==j)
            {
                continue;
            }
            if(temp[r][t]=='Q')
            {
                return false;
            }
        }

        for(int t=0; t<n;++t)
        {
            if(t==r)
            {
                continue;
            }
            if(temp[t][j]=='Q')
            {
                return false;
            }
        }

        int tempRowIndex =r+1;
        int tempColIndex =j+1;
        for(;tempRowIndex<n && tempColIndex<n;++tempRowIndex,++tempColIndex)
        {
            if(temp[tempRowIndex][tempColIndex]=='Q')
            {
                return false;
            }
        }

        tempRowIndex =r-1;
        tempColIndex =j-1;
        for(;tempRowIndex>=0 && tempColIndex>=0;--tempRowIndex,--tempColIndex)
        {
            if(temp[tempRowIndex][tempColIndex]=='Q')
            {
                return false;
            }
        }
        return true;
    }

    public Character[][] list2Array(List<Character> path,int n)
    {
        Character[][] res = new Character[n][n];
        for(int i=0; i<path.size();++i)
        {
            res[i/n][i%n] = path.get(i);
        }
        return res;
    }
}
