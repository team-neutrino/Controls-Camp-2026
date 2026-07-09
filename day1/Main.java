public class Main {
    public static void main(String[] args) {
        Dog ArcherDog = new Dog("Golden Retriever", 10, "Fluffy", "golden probably", 124);
        Dog AlexDog = new Dog("Pitbull", 2.5, "cupcake", "green", 65, false, 7, true);
        DogOwner Archer = new DogOwner("Archer", ArcherDog);
        DogOwner Alex = new DogOwner("Alex");

        Alex.assignDog(AlexDog);

        Archer.playWithDog();
        waitShort();
        ArcherDog.sleep();
        waitLong();

        ArcherDog.setEnergyLevel(11);
        waitShort();
        ArcherDog.setEnergyLevel(10);
        Archer.trainDog();

        waitShort();
        AlexDog.bark();

        waitLong();
        System.out.println(Archer.getName() + "'s Dog: "  + ArcherDog.getName() + "Alex Dog: " + AlexDog.getName());
        waitShortest();
        System.out.println(
                Alex.getName() + "'s Dog: " + Alex.getDogName() + Alex.getName() + "'s Dog: " + Alex.getDogName());
    }

    private static void waitLong() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            System.out.println("The nap was cut short!");
        }
    }

    private static void waitShort() {
        try {
            Thread.sleep(1250);
        } catch (InterruptedException e) {
            System.out.println("The nap was cut short!");
        }
    }

    private static void waitShortest() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("The nap was cut short!");
        }
    }
}
