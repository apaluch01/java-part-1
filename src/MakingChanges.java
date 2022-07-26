import org.jetbrains.annotations.NotNull;

class Person {
    String name;
    int age;
}

public class MakingChanges {
    public static void changeIdentities(@NotNull Person p1, @NotNull Person p2) {
        String swapName = p1.name;
        p1.name = p2.name;
        p2.name = swapName;

        p1.age = p1.age ^ p2.age ^ (p2.age = p1.age);
    }

    public static void main(String args[]){
        Person p1 = new Person();
        Person p2 = new Person();

        p1.name = "Alyssa";
        p2.name = "Max";
        p1.age = 18;
        p2.age = 23;

        System.out.println(p1.name + " " + p1.age);
        System.out.println(p2.name + " " + p2.age + "\n");

        changeIdentities(p1, p2);

        System.out.println(p1.name + " " + p1.age);
        System.out.println(p2.name + " " + p2.age);
    }
}