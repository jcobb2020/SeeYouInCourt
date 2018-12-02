import java.util.List;

public class Judge {
    private String name;
    private String function;
    private List<SpecialRoles> specialRoles;

    public void displayJudge() {
        System.out.println("Name: " + name);
        System.out.println("Function: " + function);
        displaySpecialRoles();
    }

    private void displaySpecialRoles() {
        System.out.println("Special Roles:");
        for (SpecialRoles role : specialRoles) {
            System.out.println(specialRoles);
        }
        System.out.println("----");
    }
}
