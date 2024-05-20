package isec.pt.pa.aula2.ex7;

import java.util.Arrays;

public class Matrix {

    private float [][]values;

    //private Matrix() {}

    public Matrix(int nlins, int nCols) {
        values = new float[nlins][nCols];
    }

    public Matrix(Matrix other) {
        copy(other);
    }

    private void copy(Matrix other) {
        /*values = new float[other.values.length][other.values[0].length];
        for (int i =0; i<other.values.length;i++){
            for ( int j = 0; j<other.values[i].length;j++)
                values[i][j] = other.values[i][j];
        }*/
        // OU!!!
        values = new float[other.values.length][other.values[0].length];
        for (int i = 0; i<values.length;i++){
            System.arraycopy(other.values[i],0,values[i],0,other.values[i].length);
        }
        // OU AINDA!!!
        values = new float[other.values.length][];
        for (int line = 0; line <values.length;line++){
            values[line] =
        }

    }

    public float get(int l,int c) {
        return values[l][c];
    }

    public void set(int l, int c, float v) {
        values[l][c] = v;
    }

    public void show() {
        for (int i = 0; i< values.length; i++){
            for (int j = 0; j<values[i].length;j++)
                System.out.printf("%8.2f",values[i][j]);
        }
       System.out.println();
    }

    public boolean isSizeEqual(Matrix m2) {
        if (values.length != m2.values.length){return false;}
        for (int line =0; line<values.length;line++){
            if (values[line].length != m2.values[line].length){
                return false;
            }
        }
        return true;
    }

    // a) ... altera a própria matriz
    public boolean add(Matrix m2) {
        if (!isSizeEqual(m2))
            return false;

        for (int line =0; line<values.length;line++){ // ESTA INCOMPLETO!!! NECESSITA DE CICLO FOR PARA COLUNAS E ADICIONAR UM A 1
            if (values[line].length != m2.values[line].length){
                return false;
            }
        }

        return true;
    }

    // b) ... devolve o resultado numa nova matriz
    public static Matrix add(Matrix m1, Matrix m2) {
        Matrix newMatrix;

        /*...*/

        return newMatrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for(int i = 0; i < values.length; i++) {

            sb.append( (i>0) ? ",[" : "[");

            for(int j = 0; j< values[i].length; j++){
                if (j>0)
                    sb.append(",");
                sb.append(values[i][j]);
            }

            sb.append("]");
        }

        sb.append("]");
        return sb.toString();
    }

}
