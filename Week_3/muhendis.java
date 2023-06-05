public class muhendis extends Insan {
    int maas;

    public muhendis() {
        this(7000);
    }

    public muhendis(int maas) {
        if(maas>0){
        this.maas = maas;
    }else{
        this.maas=7000;
    }
   
    }

    public muhendis(int maas, int boy, int kilo) {
     super(boy, kilo,maas)  ; 
    }

    int zam() {
        maas++;
        return maas;
    }

    // overloading
    int zam(int zamMiktarı) {
        maas += zamMiktarı;
        return maas;
    }

    int zam(float zamOrani) {
        float artis = zamOrani * maas;
        this.zam((int) artis);
        return (int) maas;
    }

    void yemek() {
        setKilo(getKilo() + 2);

    }

    void yemek(int kilo) {
        setKilo(kilo) ;
    }

}
