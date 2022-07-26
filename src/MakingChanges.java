import org.jetbrains.annotations.NotNull;

class Person {
    private String name;
    private int age;

    public Person (String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class MakingChanges {
    public static void changeIdentities(@NotNull Person p1, @NotNull Person p2) {
        String swapName = p1.getName();
        p1.setName(p2.getName());
        p2.setName(swapName);

        p1.setAge(p1.getAge() ^ p2.getAge());
        p2.setAge(p1.getAge() ^ p2.getAge());
        p1.setAge(p1.getAge() ^ p2.getAge());
    }

    public static void main(String args[]) {
        Person p1 = new Person("Alyssa", 18);
        Person p2 = new Person("Max", 23);

        System.out.println(p1.getName() + " " + p1.getAge());
        System.out.println(p2.getName() + " " + p2.getAge() + "\n");

        changeIdentities(p1, p2);

        System.out.println(p1.getName() + " " + p1.getAge());
        System.out.println(p2.getName() + " " + p2.getAge());
    }
}