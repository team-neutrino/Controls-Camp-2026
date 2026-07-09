public class DogOwner {
    // member variables
    String m_name;
    Dog m_dog;

    public DogOwner(String name) {
        m_name = name;
    }

    public DogOwner(String name, Dog dog) {
        m_name = name;
        m_dog = dog;
    }

    public String getName() {
        return m_name;
    }

    public Dog getDog() {
        return m_dog;
    }

    public String getDogName() {
        return m_dog.getName();
    }

    public void assignDog(Dog dog) {
        m_dog = dog;
    }

    public void trainDog() {
        m_dog.train();
    }

    public void playWithDog() {
        if (m_dog != null) {
            m_dog.play();
        } else {
            System.out.println("Yo you don't have a dog clown");
        }
    }
}