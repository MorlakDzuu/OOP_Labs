import java.io.*;
import java.util.Scanner;

public class Invert {

    public static float[][] copyMatrixToArray(String rootPath) {
        File matrixFile = new File(System.getProperty("user.dir"), rootPath);
        if (!matrixFile.exists()) {
            System.out.println("Input file does not exists");
            return null;
        }
        try (FileReader reader = new FileReader(matrixFile)) {
            int order = 3;
            BufferedReader bufferedReader = new BufferedReader(reader);
            float[][] matrix = new float[order][order];
            for (int i = 0; i < order; i++) {
                Scanner scanner;
                if (bufferedReader.ready()) {
                    scanner = new Scanner(bufferedReader.readLine());
                } else {
                    System.out.println("Your matrix should have order 3");
                    return null;
                }
                for (int j = 0; j < order; j++) {
                    if (scanner.hasNextFloat()) {
                        matrix[i][j] = scanner.nextFloat();
                    } else {
                        System.out.println("Your matrix has mistakes");
                        return null;
                    }
                }
                if (scanner.hasNextFloat()) {
                    System.out.println("Your matrix should have order 3");
                    return null;
                }
            }
            return matrix;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
            return null;
        }
    }

    public static float getDeterminant(float[][] matrix) {
        float determinant = 0;
        for (int i = 0; i < 3; i++) {
            determinant = -(matrix[0][i]*getMinor(matrix, 0, i) + determinant);
        }
        return -determinant;
    }

    public static float getMinor(float[][] matrix, int a, int b) {
        float minor;
        int counter = 0;
        float[] minorMatrix = new float[4];
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++) {
                if (k != a && j != b) {
                    minorMatrix[counter] = matrix[k][j];
                    counter++;
                }
            }
        }
        minor = minorMatrix[0]*minorMatrix[3] - minorMatrix[1]*minorMatrix[2];
        return minor;
    }

    public static float[][] getConjugateMatrix(float[][] matrix) {
        float[][] extraMatrix = new float[3][3];
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                extraMatrix[j][i] = getMinor(matrix, i, j)*k;
                k = -k;
            }
        }
        return extraMatrix;
    }

    public static float[][] invertMatrix(float[][] matrix) {
        float[][] invertMatrix = new float[3][3];
        float[][] extraMatrix = getConjugateMatrix(matrix);
        float det = getDeterminant(matrix);
        if (det == 0) {
            System.out.println("Determinant equals 0, invert matrix does not exist");
            return null;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                invertMatrix[i][j] = extraMatrix[i][j]/det;
            }
        }
        return invertMatrix;
    }

    public static void printMatrix(float[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: Invert <matrix file>");
            System.exit(1);
        }
        float[][] matrix = copyMatrixToArray(args[0]);
        if (matrix == null) {
            System.exit(1);
        }
        float[][] invertMatrix = invertMatrix(matrix);
        if (invertMatrix == null) {
            System.exit(0);
        }
        printMatrix(invertMatrix);
        System.exit(0);
    }
}