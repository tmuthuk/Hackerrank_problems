public class RowColumnMajor {

    public int findRMCM(int[][] matrix, int r) {
        int rmTotal = 1;
        // ROW MAJOR
        int add = 0;
        for(int i=0; i<r; i++) {
            for (int j=0; j<r; j++) {
                int a = i;
                int b = j+1;

                if (j+1 >= r) {
                    a = i+1;
                    b = 0;
                }
                System.out.println("i:" + i + " j: " + j + " a: " +a + " b:" + b);
                if (i ==r-1 && j==r-1) {
                    break;
                }
                // Write condition for [2][2] * 1
                add += ( matrix[i][j] * matrix[a][b]);
            }
        }
        return add;
    }
    public static void main(String[] args) {
        int r =3;
        int[][] matrix = new int[r][r];
        int num = 1;
        for(int i=0; i<r; i++) {
            for (int j=0; j<r; j++) {
                matrix[i][j] = num++;
            }}
        RowColumnMajor major = new RowColumnMajor();
        System.out.println(major.findRMCM(matrix, r));
    }

}
