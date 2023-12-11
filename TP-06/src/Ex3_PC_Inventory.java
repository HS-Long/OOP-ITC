public class Ex3_PC_Inventory {
    private String ID;
    private boolean isDamaged;

    public Ex3_PC_Inventory(String ID, boolean isDamaged){
        this.ID = ID;
        this.isDamaged = isDamaged;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public void setCondition(boolean condition){
        this.isDamaged = condition;
    }

    public String getID() {
        return ID;
    }

    public boolean getCondition(){
        return isDamaged;
    }
}
