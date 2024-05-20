package isec.pt.pa.aula2.ex7;

public class App {

    public static void main(String[] args) throws Exception {

        Matrix m1 = new Matrix(4,3);

        for(int i=0;i<4;i++)
            for(int j=0;j<3;j++)
                m1.set(i, j, (float) Math.random()*100);

        Matrix m2 = new Matrix(m1);

        m1.set(1, 1, 1000);
        m2.set(1, 1, 2000);

        System.out.println("M1:");
        m1.show();

        System.out.println("\nM2:");
        m2.show();

        Matrix m4 = Matrix.add(m1, m2);
        System.out.println("\nM4 (M1+M2):");
        m4.show();

        m4.add(m2);
        System.out.println("\nM4 += M2:");
        m4.show();

        System.out.println("\nM1 = "+m1);
    }
}