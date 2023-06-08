public class Bisiklet extends Insan{

    Insan binmisInsan;

    public Bisiklet() {
        
    }
    public Insan getBinmisInsan() {
        return binmisInsan;
    }
    public void setBinmisInsan(Insan binmisInsan) {
        this.binmisInsan = binmisInsan;
    }
    public Bisiklet(Insan gelenInsan) {
        binmisInsan=gelenInsan;
    }
    
    public void bin(Insan gelenInsan) {

        if(binmisInsan==null){
            binmisInsan=gelenInsan;

        }
        else{
            System.out.println("Zaten"+binmisInsan.getKilo());
        }
        
    }

    public void in() {

        if(binmisInsan==null){
            System.out.println("Zaten inilmiş.");
            
        }
        else{
            int kilo=binmisInsan.getKilo();
            binmisInsan=null;
            System.out.println("Zaten"+binmisInsan.getBoy()+
            kilo);
            
        }        
    }
}
    

