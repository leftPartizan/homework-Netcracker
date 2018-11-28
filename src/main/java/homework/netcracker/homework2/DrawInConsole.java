package homework.netcracker.homework2;

public class DrawInConsole {

    public static void drawCube(int n) {
        int size = n;
        for (int row = 1; row <= size; ++row) {
            for (int col = 1; col <= size; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }

    }
    public static void drawFigureA(int n) {
        int size = n;
        for (int row = 1; row <= size; ++row) {
            for (int col = 1; col <= row; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }

    }

    public static void drawFigureB(int n) {
        int size = n;
        for (int row = 1; row <= size; ++row) {
            for (int col = 1; col <= size - row + 1; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }

    }

    public static void drawFigureC(int n) {
        int size = n;
        for (int row = 1; row <= size; ++row) {
            for (int col = 1, j = 1; col <= size; col++, j++) {
                if (j < row){
                    System.out.print("  ");
                }
                else {System.out.print("# ");}
            }
            System.out.println();
        }

    }

    public static void drawFigureD(int n) {
        int size = n;
        for (int row = 1; row <= size; ++row) {
            for (int col = 1, j = 1; col <= size; col++, j++) {
                if (j < size - row + 1){
                    System.out.print("  ");
                }
                else {System.out.print("# ");}
            }
            System.out.println();
        }

    }

    public static void drawFigureF(int n) {
        int size = n;
        for (int row = 1; row <= size; ++row) {
            for (int col = 1; col <= size; col++) {
                if ( row != 1 && row != size && col != 1 && col != size){
                    System.out.print("  ");
                }
                else {System.out.print("# ");}
            }
            System.out.println();
        }

    }


}
