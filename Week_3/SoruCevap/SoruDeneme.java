import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SoruDeneme extends JPanel implements Action{

    JLabel soruMetni;
    JRadioButton cevapRadioA, cevapRadioB, cevapRadioC, cevapRadioD;
    JButton onayButton;  

    ButtonGroup cevaplarGrup;
    Soru[] sorular= new Soru[5];   

    int gecerliSoru=0;
    

    public SoruDeneme(){
        sorular[0]=new Soru("Hangisi programlama dili değildir ?", "Java", "C++" , "Oracle","C", Soru.Cevap.CEVAP_C);
        soruMetni=new JLabel();
        cevapRadioA =new JRadioButton();
        cevapRadioB =new JRadioButton();
        cevapRadioC =new JRadioButton();
        cevapRadioD =new JRadioButton();
        onayButton=new JButton("Son Kararım!");

        cevaplarGrup=new ButtonGroup();

        cevaplarGrup.add(cevapRadioA);
        cevaplarGrup.add(cevapRadioB);
        cevaplarGrup.add(cevapRadioC);
        cevaplarGrup.add(cevapRadioD);

        onayButton.addActionListener(this);

        add(soruMetni);
        add(cevapRadioA);
        add(cevapRadioB);
        add(cevapRadioC);
        add(cevapRadioD);
        add(onayButton);

    }   

    public void sorulariOlustur(){
       sorular[0]=new Soru("Hangisi programlama dili değildir ?", "Java", "C++" , "Oracle","C", Soru.Cevap.CEVAP_C);
       sorular[1]=new Soru("Hangisi programlama dilidir ?", "Elma", "Armut" , "Üzüm","C", Soru.Cevap.CEVAP_D);
       
    }

    public void soruyuEkranaYAnsıt(int SoruNo){
        soruMetni.setText(sorular[SoruNo].soruMetni);
        cevapRadioA.setText(sorular[SoruNo].secenekA);
        cevapRadioB.setText(sorular[SoruNo].secenekB);
        cevapRadioC.setText(sorular[SoruNo].secenekC);
        cevapRadioD.setText(sorular[SoruNo].secenekD);

    }

    public boolean cevapKontrol(Soru.Cevap verilenCevap){
        return this.sorular[gecerliSoru].cevapKontrol(verilenCevap);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    @Override
    public Object getValue(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValue'");
    }

    @Override
    public void putValue(String key, Object value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putValue'");
    }
    
}
