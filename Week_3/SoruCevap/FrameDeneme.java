import javax.swing.JFrame;

public class FrameDeneme {
    

    public static void main(String [] args){
        JFrame frame =new JFrame();
        SoruDeneme sd=new SoruDeneme();
        sd.sorulariOlustur();
        sd.soruyuEkranaYAnsıt(1);
        frame.add(sd);
        frame.setVisible(true);
        frame.setBounds(100, 100, 200, 150);
    }
}
