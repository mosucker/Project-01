public class RunSimulation
{
    public static void main(String[] args)
    {
        Simulation myMatrix = new Simulation(3 ,3);
        myMatrix.generateValues();
        System.out.println("=====First generation Matrix=====");
        myMatrix.displayMatrix();
        myMatrix.advanceToNextGeneration();
        System.out.println();
        System.out.println();
        System.out.println("=====Second generation Matrix=====");
        myMatrix.displayMatrix();

    }
}
