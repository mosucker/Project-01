import com.sun.security.jgss.GSSUtil;

import java.util.Random;

public class Simulation
{
    private int row;
    private int col;
    private int[][] matrix;

    public Simulation(int row, int col)
    {
        this.row = row;
        this.col = col;
        matrix = new int[row][col];
    }

    public int nbrLivingCells(int xRow, int xCol)
    {
        int counter = 0;

        if (xCol + 1 < col && matrix[xRow][xCol + 1] == 1)
        {
            counter++;
        }

        if (xCol >= 1 && matrix[xRow][xCol - 1] == 1)
        {
            counter++;
        }

        if (xRow >= 1 && matrix[xRow - 1][xCol] == 1)
        {
            counter++;
        }

        if(xRow + 1 < row && matrix[xRow + 1][xCol] == 1)
        {
            counter++;
        }

        return counter;
    }


    public void advanceToNextGeneration()
    {
        int[][] nextGenerationMatrix = getNextGenerationMatrix();
        this.matrix = nextGenerationMatrix;
    }


    public int[][] getNextGenerationMatrix()
    {
        int[][] nextGenerationMatrix = new int[row][col];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                int nbrLivingCells = nbrLivingCells(i, j);
                if (matrix[i][j] == 1)
                {
                    if(nbrLivingCells < 2)
                    {
                        nextGenerationMatrix[i][j] = 0;
                    }
                    if(nbrLivingCells < 4 && nbrLivingCells > 1)
                    {
                        nextGenerationMatrix[i][j] = 1;
                    }
                    if(nbrLivingCells > 3)
                    {
                        nextGenerationMatrix[i][j] = 0;
                    }
                } else {
                    if (nbrLivingCells == 3)
                    {
                        nextGenerationMatrix[i][j] = 1;
                    }
                }
            }
        }

        return nextGenerationMatrix;
    }

    public void generateValues()
    {
        Random rand = new Random();
        for(int i = 0; i < row; i++)
        {
            for(int j= 0; j < col; j++)
            {
                matrix[i][j] = rand.nextInt(2);
            }
        }
    }


    public void displayMatrix()
    {
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
