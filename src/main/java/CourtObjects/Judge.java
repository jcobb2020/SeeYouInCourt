package CourtObjects;

public class Judge implements IJudge{

    protected String name;
    protected String function;

    public String getName(){
        return this.name;
    }

    public Judge(){
        this.setFunction("");
    }
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Judge))
        {
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

    public String displayJudge(){
        StringBuilder builder = new StringBuilder();
        builder.append("name: " + this.name + "\n");
        builder.append("function: " + this.function + "\n");
        return builder.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
