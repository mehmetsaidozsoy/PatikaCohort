public class Insan {
    private int boy;
    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }

    private int kilo;

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }

    public Insan() {
        System.out.println("Default constructor çalıştı.");

    }

    public Insan(int boy, int kilo, int maas) {
        this();
        if (boy > 0 && kilo > 0) {
            this.boy = boy;
            this.kilo = kilo;
            
            System.out.println("Yeni bir insan oluştu.");
        }
    }

    void yemek() {
        kilo++;
    }
}
