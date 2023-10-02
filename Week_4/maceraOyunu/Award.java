public class Award {
    int id;
    String name;
    public Award(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Award[] awards(){
        Award[] awardList=new Award[3];
        awardList[0]=new Award(1,"Food");
        awardList[1]=new Award(2,"Firewood");
        awardList[2]=new Award(3,"Water");
        return awardList;
    }

    public static Award getAwardObjByID(int id ){
        for(Award a: Award.awards()){
            if (a.getId()==id){
                return a;
            }
        }
        return null;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
