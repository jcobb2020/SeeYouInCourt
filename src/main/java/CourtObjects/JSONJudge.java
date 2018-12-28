package CourtObjects;

import CourtObjects.Enums.SpecialRoles;

import java.util.List;

public class JSONJudge extends Judge implements IJudge{
    private List<SpecialRoles> specialRoles;

    @Override
    public String displayJudge() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name +"\n");
        sb.append("Function: " + this.function + "\n");
        sb.append(this.displaySpecialRoles());
        return sb.toString();
    }

    private String displaySpecialRoles() {
        StringBuilder sb = new StringBuilder();
        sb.append("Special Roles: \n");
        for (SpecialRoles role : specialRoles) {
             sb.append(role + "\n");
        }
        sb.append("----");
        return sb.toString();
    }

    public String getName(){
        return this.name;
    }



//    @Override
//    public int hashCode() {
//        int hash = 7;
//        for (int i = 0; i < name.length(); i++) {
//            hash = hash*31 + name.charAt(i);
//        }
//        return hash;
//    }
}
