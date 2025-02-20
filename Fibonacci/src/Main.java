public class Main {
    public static void main(String[] args) {
        int a = 0, b = 1, n = 8;

        for (int i = 0; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println(b);
    }public float castToInt(int num){
        return (float)num;
    }

}
/*
        }
                int f = fibonacci(0,1,8);
        System.out.println(f);
    }
    public static int fibonacci(int a, int b, int n) {
        if (n == 0) return b;
        else return fibonacci(b, a+b, n-1);
    }


        */