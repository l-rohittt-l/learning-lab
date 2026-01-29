package rohit_sawant.day11.useCase1;

class Patient5 {

    int id;
    String name;
    int age;
    String disease;

    Patient5(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Age: " + age +
               ", Disease: " + disease;
    }
}
