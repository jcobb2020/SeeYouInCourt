import java.util.List;

public class Judge {
    private String name;
    private String function;
    private List<SpecialRoles> specialRoles;

    public String displayJudge() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name +"\n");
        System.out.println("Function: " + function + "\n");
        sb.append(this.displaySpecialRoles());
        return sb.toString();
    }

    private String displaySpecialRoles() {
        StringBuilder sb = new StringBuilder();
        sb.append("Special Roles: \n");
        for (SpecialRoles role : specialRoles) {
             sb.append(specialRoles + "\n");
        }
        sb.append("----");
        return sb.toString();
    }

    public boolean equals(Judge judge){
        if(this.name.equals(judge.name)){
            return true;
        }
        return false;
    }
}
