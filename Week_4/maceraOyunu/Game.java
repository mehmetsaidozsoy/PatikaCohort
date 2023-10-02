import java.util.Scanner;
public class Game {
    private Scanner input= new Scanner(System.in);
    
    
    public void start(){
        System.out.println("Macera Oyununa Hoş Geldiniz.");
        System.out.println("Lütfen bir isim giriniz  :");
        String playerName=input.nextLine();
        Player player=new Player(playerName);
        System.out.println("Sayın "+player.getName()+" bu karanlık ve sisli adaya Hoşgeldiniz   !!");
        System.out.println("Lütfen bir karakter seçiniz !");
        player.selectChar();
        Location location=null;

        while(true){            
                player.printInfo();
                System.out.println("");
                System.out.println("--------------- Bölgeler ---------------");
                System.out.println("");
                System.out.println("1 - Güvenli Ev --> Burası sizin için güvenli ev, düşman yok !");
                System.out.println("2 - Eşya Dükkanı --> Silah veya zırh alabilirsin !");
                System.out.println("3 - Mağara --> Ödül <Yemek> Mağaraya gir, dikkatli ol Zombi çıkabilir !");
                System.out.println("4 - Orman --> \u00D6d\u00FCl <Odun>Ormana git, dikkatli ol Vampir çıkabilir !");
                System.out.println("5 - Nehir --> \u00D6d\u00FCl <Su>Nehre gir, dikkatli ol Ayı çıkabilir !");
                System.out.println("0 - Çıkış Yap--> Oyunu sonlandır !");
                System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
                int selectLoc=input.nextInt();
                switch (selectLoc) {
                    case 0:
                        location=null;
                        break;
                    case 1:                        
                            location=new SafeHouse(player);
                            break;      
                    case 2:                        
                            location=new ToolStore(player);
                            break;
                    case 3:
                    if(Cave.isEnemyStatus()){
                            location=new Cave(player);
                            break;
                        }else{
                            System.out.println("Tüm düşmanları öldürüp ödülü aldığınızdan Mağaraya tekrar giriş yapamazsınız !");
                            continue;                            
                        }
                    case 4:
                    if(Forest.isEnemyStatus()){
                            location=new Forest(player);
                            break;
                        }else{
                            System.out.println("Tüm düşmanları öldürüp ödülü aldığı nızdan Ormana tekrar giriş yapamazsınız !");
                            System.out.println(Forest.isEnemyStatus());
                            continue;
                        }
                    
                    case 5:
                    if(River.isEnemyStatus()){
                            location=new River(player);
                            break;
                        }else{
                            System.out.println("Tüm düşmanları öldürüp ödülü aldığınızdan Nehre tekrar giriş yapamazsınız !");
                            continue;                            
                        }
                        
                    default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !");
                        location=new SafeHouse(player);
                        break;
                }
                if(location==null){
                    System.out.println("Oyun bitti yine bekleriz.");
                    break;
                }                
                if(!location.onLocation()){
                    System.out.println("Game Over!");
                    break;
                }
               
            }
         }    
}

