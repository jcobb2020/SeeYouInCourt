package CourtObjects;

public class ReferencedRegulation {
    private int year;
    private int nr;
    private int poz;
    private int art;

    public ReferencedRegulation(){
        this.year=0;
        this.nr=0;
        this.art=0;
        this.poz=0;
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass() != this.getClass()){
            return false;
        }
//        if(this.art != ((ReferencedRegulation) o).getArt()){
//            return false;
//        }
        if(this.nr != ((ReferencedRegulation) o).getNr()){
            return false;
        }
        if(this.poz!=((ReferencedRegulation) o).getPoz()){
            return false;
        }
        if(this.year!=((ReferencedRegulation) o).getYear()){
            return false;
        }
        return true;
    }

    public void display(){
        System.out.println(toString());
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("YEAR " + this.year + "\n");
        builder.append("Nr " + this.nr + "\n");
        builder.append("Pos " + this.poz + "\n");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return 13*year*100 + 7 *nr*10000 + 11*poz + 3*art;

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getPoz() {
        return poz;
    }

    public void setPoz(int poz) {
        this.poz = poz;
    }

    public int getArt() {
        return art;
    }

    public void setArt(int art) {
        this.art = art;
    }
}
