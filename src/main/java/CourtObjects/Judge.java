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

    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o){
        if(this.getClass()!= o.getClass()){
            return false;
        }
        Judge judge = (Judge) o;
        if(this.name.equals(judge.getName())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = hash*31 + name.charAt(i);
        }
        return hash;
    }
}
