public class joseArr {
    public static void main(String[] args) {
        //共有的人数
        int N = 41;
        //报数的数字
        int C = 3;
        Joseph(N, C);
    }

    public static void Joseph(int N, int C) {
        //初始化数组
        int a[] = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i + 1;

        //报数
        int i=0;
        while (N > 1) {
            int k = 0;
            //约瑟夫计算公式
            i = (i + C - 1) % N;
            k++;
            System.out.print(a[i]+" ");
            for (int j = i + 1; j < N; j++)
                a[j - 1] = a[j];
            N--;
            if (i == N)
                i = 0;
        }
        //将最后一人输出
        System.out.print(a[i]+" ");
    }
}
