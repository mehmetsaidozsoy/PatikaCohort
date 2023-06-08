/***
 * Inheritance
 */

public class Inheritance {

    public static void main(String[] args) {
        Insan ali = new Insan();
        muhendis veli = new muhendis(20000,180,80);
        veli.setBoy(180); 
        System.out.println(veli.getBoy());
        veli.setKilo(90);
        veli.yemek();
        System.out.println(veli.getKilo());
        //veli.maas=10000;
        veli.zam((float)0.50);
        System.out.println(veli.maas);
        ali.setKilo(80);
        ali.yemek();
        System.out.println(ali.getKilo());
        muhendis deli= new muhendis(15000,180,90);
        System.out.println(deli.maas); 

        Bisiklet b1=new Bisiklet();
        b1.bin();


    }

}
