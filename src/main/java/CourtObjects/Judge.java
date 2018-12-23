public class Judge {

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
