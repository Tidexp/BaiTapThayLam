/*
 Ta sẽ sử dụng công thức Euclid
Có bộ ba pitago (a,b,c), trong đó: 
    a = m^2 - n^2
    b = 2 * m * n
    c = m^2 + n^2
 */

 package BaiTap.Bai1;

 public class pitago {
    void solve(int limit) {
        for (int m = 1; m * m <= limit; m++) {
            for (int n = 1; n < m; n++) {
                int a = (m * m) - (n * n);
                int b = 2 * m * n;
                int c = (m * m) + (n * n);
                
                if (c <= limit) {
                    System.out.println("Bo ba Pitago: (" + a + ", " + b + ", " + c + ")");
                }
            }
        }
    }
 
    public static void main(String[] args) {
        pitago p = new pitago(); 
            int limit = 500;
            p.solve(limit); 
    }
 }
 
