import ByteDance.NumberMatch;
import ByteDance.StoneGameVII;
import maodao.link.IsCycString;
import modao.array.LongestOnes;
import modao.array.MinSubArray;
import modao.backtrace.AssignBike;
import modao.backtrace.SplitIntoFibonacci;
import modao.backtrace.WiggleMaxLength;
import modao.db.*;
import modao.match.Kmp;
import modao.sliding.window.C395;
import modao.sliding.window.MinWindow;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Test1 {

    public static void main(String[] args)
    {

        Scanner cin = new Scanner(System.in);
        char[] s = cin.next().toCharArray();
        int size = s.length;

        int sum=0,preSum=0;
        for(int i=0;i<4;++i)
        {
            preSum = preSum*25;
            if(i<size)
            {
                preSum += s[i]-'a';
            }
            sum += preSum;
            if(i<size-1)
            {
                sum +=1;
            }
        }
        System.out.println(sum);
        cin.close();
    }

    @org.junit.Test
    public void TestNoRepeatedCharSubString()
    {
        NoRepeateCharSubString noRepeateCharSubString = new NoRepeateCharSubString();
        Assert.assertEquals("abc",noRepeateCharSubString.doMain("abccba"));
        Assert.assertEquals("b",noRepeateCharSubString.doMain("bbbb"));
        Assert.assertEquals("",noRepeateCharSubString.doMain(""));
        Assert.assertEquals(" ab",noRepeateCharSubString.doMain(" ab "));
        Assert.assertEquals("abcde",noRepeateCharSubString.doMain("abcde"));
        Assert.assertEquals("b",noRepeateCharSubString.doMain("bbbb"));
        Assert.assertEquals("deawkux",noRepeateCharSubString.doMain("bcadeawkux"));

        Assert.assertEquals("abc",noRepeateCharSubString.doMain2("abccba"));
        Assert.assertEquals("b",noRepeateCharSubString.doMain2("bbbb"));
        Assert.assertEquals("",noRepeateCharSubString.doMain2(""));
        Assert.assertEquals(" ab",noRepeateCharSubString.doMain2(" ab "));
        Assert.assertEquals("abcde",noRepeateCharSubString.doMain2("abcde"));
        Assert.assertEquals("b",noRepeateCharSubString.doMain2("bbbb"));
        Assert.assertEquals("deawkux",noRepeateCharSubString.doMain2("bcadeawkux"));

    }

    @Test
    public void TestLongestCycSubString()
    {
        LongestCycSubString longestCycSubString = new LongestCycSubString();
        Assert.assertEquals("a",longestCycSubString.doFun("a"));
        Assert.assertEquals("aa",longestCycSubString.doFun("aa"));
        Assert.assertEquals("a",longestCycSubString.doFun("ab"));
        Assert.assertEquals("abccba",longestCycSubString.doFun("abccbade"));
        Assert.assertEquals("abccba",longestCycSubString.doFun("eabccbade"));
        Assert.assertEquals("edabccbade",longestCycSubString.doFun("edabccbade"));
        Assert.assertEquals("abccba",longestCycSubString.doFun("edabccbafe"));

        Assert.assertEquals("a",longestCycSubString.doMain("a"));
        Assert.assertEquals("aa",longestCycSubString.doMain("aa"));
        Assert.assertEquals("a",longestCycSubString.doMain("ab"));
        Assert.assertEquals("abccba",longestCycSubString.doMain("abccbade"));
        Assert.assertEquals("abccba",longestCycSubString.doMain("eabccbade"));
        Assert.assertEquals("edabccbade",longestCycSubString.doMain("edabccbade"));
        Assert.assertEquals("abccba",longestCycSubString.doMain("edabccbafe"));

    }

    @Test
    public void TestDynamicSample()
    {
        DynamicSample dynamicSample = new DynamicSample();
        Assert.assertEquals(1,dynamicSample.doMain(9,10));
        Assert.assertEquals(2,dynamicSample.doMain(8,10));
        Assert.assertEquals(3,dynamicSample.doMain(7,10));
        Assert.assertEquals(5,dynamicSample.doMain(6,10));
        Assert.assertEquals(8,dynamicSample.doMain(5,10));
        Assert.assertEquals(13,dynamicSample.doMain(4,10));
        Assert.assertEquals(21,dynamicSample.doMain(3,10));

    }

    @Test
    public void testMaxProfit()
    {
        int[] prices = {7,1,5,3,6,4};
        Assert.assertEquals(7,MaxProfit.maxProfit(prices));

        int[] prices2 = {1,2,3,4,5};
        Assert.assertEquals(4,MaxProfit.maxProfit(prices2));

        int[] prices3 = {7,6,4,3,1};

        Assert.assertEquals(0,MaxProfit.maxProfit(prices3));

        int[] prices4 = {6,1,3,2,4,7};
        Assert.assertEquals(7,MaxProfit.maxProfit2(prices4));

        int[] prices5 = {14,9,10,12,4,8,1,16};
        Assert.assertEquals(19,MaxProfit.maxProfit2(prices5));

        Assert.assertEquals(0,MaxProfit.maxProfit2(prices3));

        int[] prices6= {1,2,4,2,5,7,2,4,9,0};

        Assert.assertEquals(13,MaxProfit.maxProfit2(prices6));

    }

    @Test
    public void testMerge()
    {
        int[][] data = {{1,3},{2,6},{8,10},{15,18}};

        int[][] rest = Merage.merge(data);

        int[][] data2 = {{1,1},{2,6},{8,10},{10,18}};

        int[][] rest2 = Merage.merge(data2);

        int[][] data3 = {{1,5},{2,3},{10,10},{10,18}};

        int[][] rest3 = Merage.merge(data3);

        Stack<Character> stack = new Stack<Character>();
        String s = "test";

        System.out.println("end");
    }

    @Test
    public void testIsValid()
    {
       Assert.assertEquals(true,Merage.isValid("()[]{}"));
    }

    @Test
    public void testLRUCache2()
    {
        LRUCache2 lruCache2 = new LRUCache2();
        int[][] opts={{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int[] res = lruCache2.LRU(opts,3);
        System.out.println("test");
    }

    @Test
    public void testHalfSearch()
    {
        HalfSearch halfSearch = new HalfSearch();
        int[] a={3,3,4,4,4,5,6,6,6,7,8,8,12,13,15,16,21,21,22,24,24,27,28,32,34,35,35,36,36,39,40,41,41,42,44,44,45,45,47,47,47,47,48,48,50,51,51,53,53,53,54,54,54,56,56,57,59,60,60,60,60,61,62,63,65,65,65,65,67,67,68,70,71,71,74,75,75,79,81,84,84,86,86,87,90,90,90,90,91,92,93,94,94,94,95,97,97,98,98,99};
        Assert.assertEquals(96,halfSearch.upper_bound_(100,97,a));
    }

    @Test
    public void testGrayCode()
    {
        char q = 'q';
        int t= q-'a';

        GrayCode grayCode = new GrayCode();
        String[] res = grayCode.getGray(3);
        String[] res2 = grayCode.getGray2(3);
        System.out.println("res: %s "+res.toString());
    }

    @Test
    public void testDfs()
    {
        Dfs dfs = new Dfs();
        int[] data = {1,1,2};
        dfs.permuteUnique(data);
    }

    @Test
    public void testQueen()
    {
        Queen queen = new Queen();
        List<List<String>> res = queen.solveNQueens(4);
        System.out.println(res.toString());
    }

    @Test
    public void testQuickSort()
    {
        QuerySort querySort = new QuerySort();
        int[] nums = {7,8,10,1,2,3,4,5,6};
        querySort.quickSort(nums,0,nums.length-1);
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length;++i)
        {
            list.add(nums[i]);
        }
        System.out.println(list);
    }

    @Test
    public void testQuickSelect()
    {
        QuickSelect quickSelect = new QuickSelect();
        int[] nums = {2,1};
        int res = quickSelect.quickSelect2(nums,nums.length-2,0,nums.length-1);
        System.out.println(res);
    }

    @Test
    public void testKthGrammer()
    {
        KthGramer kthGramer = new KthGramer();
        Assert.assertEquals(1,kthGramer.kthGrammar(10,15));
        Assert.assertEquals(1,kthGramer.kthGrammar2(4,3));
    }

    @Test
    public void testNextPermutation()
    {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{4,2,0,2,3,2,0};
        nextPermutation.nextPermutation(nums);

        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length;++i)
        {
            list.add(nums[i]);
        }
        System.out.println(list);
    }

    @Test
    public void testTwoSearch()
    {
        TwoSearch twoSearch = new TwoSearch();
        char[][] src = {{'d','a','b','c'},{'e','f','a','d'},{'c','c','a','f'},{'d','e','f','c'}};
        char[][] patten = {{'c','a'},{'e','f'}};
        int[] result = twoSearch.twoSearch(src,patten);
        System.out.println(String.format("i=%d,j=%d",result[0],result[1]));
    }

    @Test
    public void testTotalNQueens()
    {
        Queen queen = new Queen();
        Assert.assertEquals(2,queen.totalNQueens(8));
    }

    @Test
    public void testPathQ()
    {
        PathQ pathQ = new PathQ();
        int[][] weights={{1,3,4,2,5,7},{2,1,3,8,9,4},{1,5,7,2,3,4},{8,1,4,2,5,6},{4,5,3,1,2,7},{3,6,3,4,2,8}};
//        Assert.assertEquals(29,pathQ.minPath(weights,0,0,5,5,1));
//
//        Assert.assertEquals(16,pathQ.minPath(weights,0,0,3,3,1));
//
//        Assert.assertEquals(16,pathQ.minPath(weights,0,0,2,3,1));

        List<List<String>> result = new ArrayList<List<String>>();
        Stack<String> path = new Stack<String>();
        path.push("0_0");
        pathQ.minPath3(weights,0,0,2,2,path,result);


        Stack<String> initPath = new Stack<String>();
        initPath.push("0_0");
        List<String> minPath=new ArrayList<String>(1000);
        Assert.assertEquals(14,pathQ.minPath2(weights,0,0,2,2,100000,initPath,1,minPath));
        System.out.println(minPath.toString());

        int[][] weights2={{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};

//        Assert.assertEquals(19,pathQ.minPath(weights2,0,0,3,3,1000000,1));


        Assert.assertEquals(19,pathQ.minPath4(weights2,0,0,3,3));

        Assert.assertEquals(29,pathQ.minPath4(weights,0,0,5,5));

        Assert.assertEquals(19,pathQ.minPath5(weights2,3,3));

        Assert.assertEquals(29,pathQ.minPath5(weights,5,5));

    }

    @Test
    public void testByteLeaves()
    {
        ByteLeaves byteLeaves = new ByteLeaves();
        Assert.assertEquals(2,byteLeaves.minimumOperations("yyy"));
        Assert.assertEquals(1,byteLeaves.minimumOperations("rrr"));
        Assert.assertEquals(1,byteLeaves.minimumOperations("rrrr"));
        Assert.assertEquals(2,byteLeaves.minimumOperations("rrryyyrryyyrr"));
        Assert.assertEquals(0,byteLeaves.minimumOperations("ryr"));
        Assert.assertEquals(3,byteLeaves.minimumOperations("yry"));

    }

    @Test
    public void testWhiteBlack()
    {
        WhiteBlack whiteBlack = new WhiteBlack();
        Assert.assertEquals(4,whiteBlack.cellBrush(2,2));
        Assert.assertEquals(0,whiteBlack.cellBrush(2,1));
        Assert.assertEquals(1,whiteBlack.cellBrush(2,4));
        Assert.assertEquals(10,whiteBlack.cellBrush(6,11));
    }

    @Test
    public void testFindKthNumber()
    {
        FindKthNums findKthNums = new FindKthNums();
        Assert.assertEquals(10,findKthNums.findKthNumber(13,2));
    }

    @Test
    public void testRestoreIp()
    {
        RestoreIp restoreIp = new RestoreIp();
        List<String> result = restoreIp.restoreIpAddresses("25525511135");
        System.out.println(result.toString());
        result = restoreIp.restoreIpAddresses("0000");
        System.out.println(result.toString());
        result = restoreIp.restoreIpAddresses("1111");
        System.out.println(result.toString());
        result = restoreIp.restoreIpAddresses("010010");
        System.out.println(result.toString());
        result = restoreIp.restoreIpAddresses("101023");
        System.out.println(result.toString());

    }

    @Test
    public void testAssignBike()
    {
        AssignBike assignBike = new AssignBike();
        int[][] workers={{0,0},{2,1}};
        int[][] bikes={{1,2},{3,3}};
        int[] result =  assignBike.assignBikes(workers,bikes);

        int[][] workers2={{0,0},{1,1},{2,0}};
        int[][] bikes2 ={{1,0},{2,2},{2,1}};

        result = assignBike.assignBikes(workers2,bikes2);

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0; i<result.length;++i)
        {
            res.add(result[i]);
        }
        System.out.println(res.toString());
    }

    @Test
    public void testAssignBike2()
    {
        AssignBike assignBike = new AssignBike();
        int[][] workers={{0,0},{2,1}};
        int[][] bikes={{1,2},{3,3}};
        int[] result =  assignBike.assignBikes2(workers,bikes);

        int[][] workers2={{0,0},{1,1},{2,0}};
        int[][] bikes2 ={{1,0},{2,2},{2,1}};

        result = assignBike.assignBikes2(workers2,bikes2);

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0; i<result.length;++i)
        {
            res.add(result[i]);
        }
        System.out.println(res.toString());
    }

    @Test
    public void testAssignBike3()
    {
        AssignBike assignBike = new AssignBike();
        int[][] workers={{0,0},{2,1}};
        int[][] bikes={{1,2},{3,3}};
        int[] result =  assignBike.assignBikes3(workers,bikes);

//        int[][] workers2={{0,0},{1,1},{2,0}};
//        int[][] bikes2 ={{1,0},{2,2},{2,1}};
//
//        result = assignBike.assignBikes3(workers2,bikes2);

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0; i<result.length;++i)
        {
            res.add(result[i]);
        }
        System.out.println(res.toString());

    }

    @Test
    public void testKMP()
    {
        Kmp kmp = new Kmp();
        int[] next = kmp.genericNext("abab");

        next = kmp.genericNext("ababacd");
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0; i<next.length;++i)
        {
            temp.add(next[i]);
        }

        System.out.println(temp.toString());

        Assert.assertEquals(-1,kmp.kmp("ababaeabac","ababacd"));
    }

    @Test
    public void testBackPacks()
    {
        Backpack backpack = new Backpack();
        Assert.assertEquals(39,backpack.backPack(new int[]{1,5,10,19,20,21,22},39));
    }

    @Test
    public void testBackPack2()
    {
        BackPack2 backPack2 = new BackPack2();
        Assert.assertEquals(18,backPack2.backPack2(new int[]{2,2,4,6,3},new int[]{3,4,8,9,6},9));
    }

    @Test
    public void testYanHuiSanJiao()
    {
        YanHuiSanJiao yanHuiSanJiao = new YanHuiSanJiao();
        Assert.assertEquals(20,yanHuiSanJiao.shortPath(new int[][]{{5,-1,-1,-1,-1},{7,8,-1,-1,-1},{2,3,4,-1,-1,-1},{4,9,6,1,-1},{2,7,9,4,5}}));
    }

    @Test
    public void testChange()
    {
        Change change = new Change();
        Assert.assertEquals(3,change.change(new int[]{1,2,5,10,20,50,100},17));

        Assert.assertEquals(4,change.change(new int[]{1,2,5,10,20,50,100},18));

        Assert.assertEquals(-1,change.change(new int[]{5,10,20,50,100},18));

        Assert.assertEquals(3,change.change(new int[]{1,3,5},9));
    }

    @Test
    public void testLevenshteinDistance()
    {
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();

        Assert.assertEquals(3,levenshteinDistance.distance("mitcmu", "mtacnu"));

        Assert.assertEquals(8,levenshteinDistance.distance("mitcmu", "mtacnuxxxxx"));

        Assert.assertEquals(8,levenshteinDistance.distance("mitcmuttttt", "mtacnu"));

        Assert.assertEquals(1,levenshteinDistance.distance("hellow", "helllow"));
    }

    @Test
    public void testLongestCommonSubString()
    {
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        Assert.assertEquals(4,longestCommonSubstring.longestCommonSubstring("mitcmu","mtacnu"));
        Assert.assertEquals(6,longestCommonSubstring.longestCommonSubstring("hellow", "helllow"));
    }

    @Test
    public void testLengthOfLIS()
    {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        Assert.assertEquals(3,lengthOfLIS.lengthOfLIS(new int[]{4,10,4,3,8,9}));
        Assert.assertEquals(4,lengthOfLIS.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        Assert.assertEquals(3,lengthOfLIS.lengthOfLIS(new int[] {4,10,5,6}));
        Assert.assertEquals(6,lengthOfLIS.lengthOfLIS(new int[] {5,7,-24,12,13,2,3,12,5,6,35}));
    }

    @Test
    public void testMinSubArray()
    {
        MinSubArray minSubArray = new MinSubArray();
        Assert.assertEquals(2,minSubArray.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    @Test
    public void testLongesOnes()
    {
        LongestOnes longestOnes = new LongestOnes();
        Assert.assertEquals(6,longestOnes.longestOnes3(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }

    @Test
    public void testTreeMap()
    {
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"test1");
        treeMap.put(1,"test11");
        System.out.println(treeMap.toString());
    }

    @Test
    public void testSplitIntoFibonacci()
    {
        SplitIntoFibonacci splitIntoFibonacci = new SplitIntoFibonacci();
        List<Integer> result = splitIntoFibonacci.splitIntoFibonacci("123456579");
        System.out.println(result.toString());

        result = splitIntoFibonacci.splitIntoFibonacci("11235813");
        System.out.println(result.toString());

        result = splitIntoFibonacci.splitIntoFibonacci("112358130");
        System.out.println(result.toString());

        result = splitIntoFibonacci.splitIntoFibonacci("0123");
        System.out.println(result.toString());

        result = splitIntoFibonacci.splitIntoFibonacci("1101111");
        System.out.println(result.toString());

        result = splitIntoFibonacci.splitIntoFibonacci("5511816597");
        System.out.println(result.toString());
    }

    @Test
    public void testMinWindow()
    {
        MinWindow minWindow = new MinWindow();
        Assert.assertEquals("BANC",minWindow.minWindow("ADOBECODEBANC","ABC"));

        Assert.assertEquals("a",minWindow.minWindow("a","a"));
        Assert.assertEquals("aa",minWindow.minWindow("aa","aa"));
    }

    @Test
    public void testWiggleMaxLength()
    {
        WiggleMaxLength wiggleMaxLength = new WiggleMaxLength();
        Assert.assertEquals(6,wiggleMaxLength.wiggleMaxLength(new int[]{1,1,7,4,9,2,5}));
        Set<Integer> set = new HashSet<>();
        set.contains(1);

    }

    @Test
    public void testNumberMatch()
    {
        NumberMatch numberMatch = new NumberMatch();
        Assert.assertEquals(6,numberMatch.numberOfMatches(7));
        Assert.assertEquals(13,numberMatch.numberOfMatches(14));
        Assert.assertEquals(0,numberMatch.numberOfMatches(1));
    }

    @Test
    public void testStoneGameVII()
    {
        StoneGameVII stoneGameVII = new StoneGameVII();
        Assert.assertEquals(6,stoneGameVII.stoneGameVII(new int[]{5,3,1,4,2}));
        Assert.assertEquals(122,stoneGameVII.stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));
        String temp ="";
        temp.split(" ");

    }
    public void testC239()
    {

    }

    @Test
    public void testC395()
    {
        C395 c395 = new C395();
        Assert.assertEquals(3,c395.longestSubstring("aaabb",3));
        Assert.assertEquals(3,c395.longestSubstring2("aaabb",3));
        Assert.assertEquals(5,c395.longestSubstring2("ababbc",2));
        Assert.assertEquals(3,c395.longestSubstring3("aaabb",3));
        Assert.assertEquals(5,c395.longestSubstring3("ababbc",2));
        Assert.assertEquals(6,c395.longestSubstring3("aaabbb",3));
    }

    @Test
    public void testIsCycString()
    {
        IsCycString isCycString = new IsCycString();
        Assert.assertEquals(true,isCycString.isCycString(isCycString.buildNodes("abccba")));
        Assert.assertEquals(true,isCycString.isCycString(isCycString.buildNodes("aba")));
        Assert.assertEquals(false,isCycString.isCycString(isCycString.buildNodes("abc")));
        Assert.assertEquals(false,isCycString.isCycString(isCycString.buildNodes("a")));
        Assert.assertEquals(false,isCycString.isCycString(isCycString.buildNodes("")));
    }


}

//1,3,4,2,5,7
//2,1,3,8,9,4
//3,5,7,2,3,4
//8,1,4,2,5,6
//4,5,3,1,2,7
//3,6,3,4,2,8

//1,3,5,9
//2,1,3,4
//5,2,6,7
//6,8,4,3
