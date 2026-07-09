public class Dog {
    // member variables
    private String m_breed;
    private double m_age; // years
    private String m_name;
    private String m_color;
    private double m_weight; // lbs
    private boolean m_isTrained;
    private int m_energyLevel; // 0-10
    private boolean m_isReadyToPlay;

    // constructors
    public Dog(String breed, double age, String name, String color, double weight) {
        m_breed = breed;
        m_age = age;
        m_name = name;
        m_color = color;
        m_weight = weight;
    }

    public Dog(String breed, double age, String name, String color, double weight, boolean isTrained,
            int energyLevel, boolean isReadyToPlay) {
        m_breed = breed;
        m_age = age;
        m_name = name;
        m_color = color;
        m_weight = weight;
        m_isTrained = isTrained;
        if (energyLevel <= 10 && energyLevel >= 0) {
            m_energyLevel = energyLevel;
        } else {
            System.out.println("ENERGY LEVEL NOT WITHIN BOUNDS (0-10)");
        }
        m_isReadyToPlay = isReadyToPlay;
    }

    // getter methods (comes with every instance)

    public String getBreed() {
        return m_breed;
    }

    public double getAge() {
        return m_age;
    }

    public String getName() {
        return m_name;
    }

    public String getColor() {
        return m_color;
    }

    public double getWeight() {
        return m_weight;
    }

    public boolean isTrained() {
        return m_isTrained;
    }

    public int getEnergyLevel() {
        return m_energyLevel;
    }

    public boolean isReadyToPlay() {
        if (m_energyLevel >= 7) {
            m_isReadyToPlay = true;
        } else {
            m_isReadyToPlay = false;
        }
        return m_energyLevel >= 7;
    }

    // setters
    public void setAge(double age) {
        m_age = age;
    }

    public void setWeight(double weight) {
        m_weight = weight;
    }

    public void setTrained(boolean isTrained) {
        m_isTrained = isTrained;
    }

    // other methods that do stuff too
    public void bark() {
        System.out.println("Bark I'm a dog");
    }

    public void play() {
        if (isReadyToPlay()) {
            m_energyLevel -= 5;
            System.out.println("played at the park or somewhere for a while");
        } else {
            System.out.println("too tired");
        }
    }

    public void sleep() {
        if (m_energyLevel < 4) {
            m_energyLevel += 6;
        } else {
            m_energyLevel = 10;
        }
        System.out.println(getName() + " slept beautifully");
    }

    public void sleepButConcise() {
        m_energyLevel = Math.min(10, m_energyLevel + 6);
    }

    public void train() {
        setTrained(true);

        if (getEnergyLevel() < 9) {
            System.out.println("Can't train I need sleep");
        } else {
            setEnergyLevel(getEnergyLevel() - 9);
            setTrained(true);
            System.out.println("Successfully trained, can now do 0 tricks");
        }
    }

    public void setEnergyLevel(int energyLevel) {
        if (energyLevel <= 10 && energyLevel >= 0) {
            m_energyLevel = energyLevel;
        } else {
            System.out.println("ENERGY LEVEL NOT WITHIN BOUNDS (0-10)");
        }
    }

    public void printDogName() {
        System.out.println(m_name);
    }
}