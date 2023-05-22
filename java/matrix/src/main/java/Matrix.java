import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Matrix {
    protected ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

    Matrix(String matrixAsString) {
        //Split string on newlines
        for (String row : matrixAsString.split("\n")) {
            //Split each row on spaces
            ArrayList<Integer> cols = Arrays.stream(row.split(" "))
                                                .map(Integer::parseInt)
                                                .collect(Collectors.toCollection(ArrayList::new));
            matrix.add(cols);
        }
    }

    int[] getRow(int rowNumber) {
        ArrayList<Integer> row = matrix.get(rowNumber - 1);

        return row.stream().mapToInt(i -> i).toArray();
    }

    int[] getColumn(int columnNumber) {
        ArrayList<Integer> column = new ArrayList<Integer>();

        for (ArrayList<Integer> row : matrix) {
            column.add(row.get(columnNumber - 1));
        }

        return column.stream().mapToInt(i -> i).toArray();
    }
}
