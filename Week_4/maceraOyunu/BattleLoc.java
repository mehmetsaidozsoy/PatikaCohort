import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private Award award;
    private int maxObstacle;
    private static boolean EnemyStatus;
    
   

    public static boolean isEnemyStatus() {
        return EnemyStatus;
    }

    public void setEnemyStatus(boolean EnemyStatus) {
        BattleLoc.EnemyStatus = EnemyStatus;
    }    

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public BattleLoc(Player player, String name, Obstacle obstacle, Award award,int maxObstacle,boolean EnemyStatus) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;       
        this.maxObstacle=maxObstacle;       
        
    }

    @Override
    public boolean onLocation(){
        int obsNumber=randomObstacleNumber();
        System.out.println("Şu an buradasınız : "+this.getName());
        System.out.println("Dikkatli ol! Burada "+obsNumber+" tane "+this.getObstacle().getName()+" yaşıyor !");
        System.out.print("<S>avaş veya <K>aç :");
        String selectCase=input.nextLine();
        selectCase=selectCase.toUpperCase();
        if(selectCase.equals("S")&&combat(obsNumber)){
            System.out.println(this.getName()+" daki tüm düşmanları yendiniz !");
            this.setAward(this.getAward());
            this.getPlayer().getInventory().setAward(this.getAward());
            System.out.println(this.getAward().getName()+" ödülü aldınız !");
            this.setEnemyStatus(false);
                return true;
            }

        if(this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz !");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber){
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth()>0&&this.getObstacle().getHealth()>0) {
                System.out.print("<V>ur veya <K>aç :");
                String selectCombat=input.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    System.out.println("Siz vurdunuz !");
                    this.obstacle.setHealth(this.getObstacle().getHealth()- this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getHealth()>0){
                        System.out.println("Canavar size vurdu !");
                        int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage<0){obstacleDamage=0;}
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    }

                }else{
                    return false;
                }
            }
            
            if(this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz !");
                System.out.println(this.getObstacle().getAward()+" para kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel Paranız : "+this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Canınız : "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" Canı : "+this.getObstacle().getHealth());
        System.out.println();

    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("--------------------------");
        System.out.println("Sağlık : "+this.getPlayer().getHealth());
        System.out.println("Hasar : "+this.getPlayer().getTotalDamage());
        System.out.println("Silah : "+this.getPlayer().getWeapon().getName());
        System.out.println("Zırh : "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Ödül : "+this.getPlayer().getInventory().getAward().getName());
        System.out.println("Para : "+this.getPlayer().getMoney());
        System.out.println();
        
    }
    public void obstacleStats(int i){
        System.out.println(i+". "+this.getObstacle().getName()+" Değerleri");
        System.out.println("--------------------------");
        System.out.println("Sağlık : "+this.getObstacle().getHealth());
        System.out.println("Hasar : "+this.getObstacle().getDamage());
        System.out.println("Ödül : "+this.getObstacle().getAward());       
        
    }

    public int randomObstacleNumber(){
        Random r=new Random();
        return r.nextInt(maxObstacle)+1;

    }

     public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }    

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }    
    
}
