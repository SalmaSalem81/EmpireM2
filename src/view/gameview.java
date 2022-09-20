package view;
import java.awt.BorderLayout;
import units.*; 
import buildings.*;
 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import engine.*;
import units.Status;
import javax.swing.JScrollPane;
public class gameview extends JFrame  {
	private JTextArea idleArmy;
	private JTextArea bArmy;
	private JTextArea mArmy;
	private JTextArea playerinformation;
	private JTextArea battleLog ;
	private JScrollPane Sc3;
	private JPanel worldmapview;
	private JComboBox<String> armyi;
	private JComboBox<String> armyB;
	private JComboBox<String> armyM;
	private JPanel Armyibm;
	private controller c;
	private JPanel cityview;
	private JComboBox<String> buildings;
	private JButton upgrade;
	private JButton recruit;
	private JButton Finish;
	private JButton ChooseCity;
	private JButton ok;
	private JTextArea city2;
	private JTextArea basicinfo;
	private JComboBox<String> unitsinfop;
	private JComboBox<String> unitsinfoc ;
	private JPanel battleview ;
	private JComboBox<String> def ;
	private JButton initiateA;
	private JComboBox<Unit> availableunits; 
	private JComboBox<Army> availablearmies ;
	private JButton relocateUnit ;
	private JButton laySeige ;
	private JButton setTarget ;
	private JTextArea target_city ;
	private JPanel buttons ;
	

	//private JTextArea playerunitsinfo;
	//private JTextArea enemyunitsinfo;
	//private JButton displayp;
	//private JButton displayc ;
	private JButton AutoResolve ;
	private JButton ManualMode ;
	private JButton BattleEnd ;
	//private JTextArea battleplayerunit;
	//private JTextArea battleenemyunit;
	private JTextArea battle;
	
	private JButton build;
	private JScrollPane Sc1;//bassant
	private JScrollPane Sc2;//bassant
    private JButton BattleStart ;
	private String[] iA = new String [2];
   	private String[] BA = new String [2];
   	private String[] MA = new String [2];
	 public controller getC() {
		return c;
	}
	public void setC(controller c) {
		this.c = c;
	}
	private JButton endTurn;
public gameview() {
	
	super();
	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	 setSize(2500,3000);
	  this.setVisible(true);
	  getContentPane().setLayout(new FlowLayout());
	  
	  buttons = new JPanel() ;
	  buttons.setLayout(new GridLayout(0,1));
	  this.add(buttons) ;
	  
	  availableunits = new JComboBox();
	  availablearmies = new JComboBox();
	  relocateUnit = new JButton("Relocate Unit") ;
	  
	  buttons.add(relocateUnit);
	  buttons.add(availableunits);
	  buttons.add( availablearmies);
	  
	 playerinformation = new JTextArea();
	
	 playerinformation.setPreferredSize(new Dimension(300, 200));
	
	 playerinformation.setEditable(false);
	 
	 playerinformation.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));

	add( playerinformation);
	laySeige = new JButton ("lay seige") ;
	setTarget = new JButton("set target") ;
	target_city = new JTextArea() ;
	target_city.setPreferredSize(new Dimension(50,50));
	buttons.add(laySeige);
	buttons.add(setTarget) ;
	buttons.add(target_city) ;
	//playerinformation.setText("salma");
   
    //we have to call method 
   // updateplayerinfo (c.getG());
    worldmapview = new JPanel();
    worldmapview.setLayout(new GridLayout(0,1));
  // worldmapview.add(new JButton ("dina"));
	worldmapview.setPreferredSize(new Dimension(400, 600));
    //worldmapview.setEditable(false);
	worldmapview.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
    this.add(worldmapview);
    // idleArmy = new JTextArea ();
   //  idleArmy.setPreferredSize(new Dimension(150, 150));
   //  idleArmy.setEditable(false);
 //	worldmapview.add(idleArmy);
// 	String n = "IDLE armies" +"\n";
// 	idleArmy.setText(n);
 	// bArmy = new JTextArea ();
   //  bArmy.setPreferredSize(new Dimension(150, 150));
  //   bArmy.setEditable(false);
 	//worldmapview.add(bArmy);
   
 	 mArmy = new JTextArea ();
    mArmy.setPreferredSize(new Dimension(150, 150));
    mArmy.setEditable(false);
    Sc1 = new JScrollPane(mArmy) ; //bassant
    worldmapview.add(Sc1); //bassant
 	//worldmapview.add(mArmy);
 	//Armyibm = new JPanel();
 	//Armyibm.setLayout(new GridLayout(0,1));
 	//Armyibm.setPreferredSize(new Dimension(600, 100));
 	//Armyibm.setVisible(true);
	
 	//Armyibm.add(armyi);
	//Armyibm.add(armyB);
	//Armyibm.add(armyM);
	
	
 	//worldmapview.add(Armyibm);
 	cityview = new JPanel();
 	cityview.setLayout(new FlowLayout());
 	cityview.setPreferredSize(new Dimension(400, 550));
 	cityview.setVisible(false);
 	this.add(cityview);
 	String [] Building = {"buildings", "Farm","Market","ArcheryRange", "Barracks", "Stable"};
 	buildings = new JComboBox<String>(Building);
 	def = new JComboBox<String>();
 	initiateA = new JButton ("initiate Army");
 	
 	//initiateA.setActionCommand("initiate Army");
 	cityview.add(initiateA);
 	String def1 = "defending units";
 	def.addItem(def1);
 	cityview.add(buildings);
 	cityview.add(def);
 	
 /*	darmyview = new JPanel();
 	darmyview.setLayout(new FlowLayout());
 	darmyview.setPreferredSize(new Dimension(400, 550));
 	darmyview.setVisible(false);
 	this.add(darmyview);
 	cdefendingArmy = new JTextArea();
 	cdefendingArmy.setPreferredSize(new Dimension(400, 550));
 	cdefendingArmy.setEditable(false);
 	darmyview.add(cdefendingArmy);*/
 	
 	battleview = new JPanel() ;
 	//battleview.setLayout(new GridLayout(0,3));
 	battleview.setLayout(new FlowLayout());
 	battleview.setPreferredSize(new Dimension(400, 600));
 	battleview.setVisible(false);
 	this.add(battleview);
 	//String [] playerunit = {"Player Units", "archer 1","archer 2","archer 3","archer 4","infantry 1","infantry 2","infantry 3","infantry 4","infantry 5","infantry 6","infantry 7","infantry 8","infantry 9","cavalry 1","cavalry 2","cavalry 3","cavalry 4"};
 //	unitsinfop= new JComboBox<String>(playerunit); 
 	
 	unitsinfop = new JComboBox();
 	unitsinfop.setPreferredSize(new Dimension (400,40));
 	unitsinfop.addItem("Player units");
 	// playerunitsinfo = new JTextArea ();
     //playerunitsinfo.setPreferredSize(new Dimension(300, 300));
     //playerunitsinfo.setEditable(false);
    // displayp = new JButton ("Player unit");
     
    // Sc1 = new JScrollPane(mArmy) ; //bassant
 	
 	//String [] enemyunit = {"Enemy Units", "archer 1","archer 2","archer 3","archer 4","infantry 1","infantry 2","infantry 3","infantry 4","infantry 5","infantry 6","infantry 7","infantry 8","infantry 9","cavalry 1","cavalry 2","cavalry 3","cavalry 4"};
 	//unitsinfoc= new JComboBox<String>(enemyunit); 
     unitsinfoc= new JComboBox();
     unitsinfoc.setPreferredSize(new Dimension (400,40));
     unitsinfoc.addItem("enemy units");
 	
 	// enemyunitsinfo = new JTextArea ();
     //enemyunitsinfo.setPreferredSize(new Dimension(300, 300));
   //  enemyunitsinfo.setEditable(false);
     //displayc = new JButton("City unit");
     // Sc1 = new JScrollPane(mArmy) ; //bassant
  	
  	BattleStart = new JButton("Battle Start");
  	BattleStart.setActionCommand("Battle Start");
  	battle = new JTextArea ();
  	battle.setVisible(true);
  	
  //	battleplayerunit = new JTextArea ();
  	//battleenemyunit = new JTextArea ();
  	ManualMode = new JButton("ManualMode");
  	 AutoResolve = new JButton("AutoResolve");
  	// ManualMode.setPreferredSize(new Dimension());
  	battle.setPreferredSize(new Dimension(50, 20));
  	battleview.add(unitsinfop);
  	battleview.add(unitsinfoc);
  	
  	battleLog = new JTextArea() ;
  	battleLog.setPreferredSize(new Dimension(400,500));
   battleLog.setText(" ");
  	//battleLog.append("y");
  	battleLog.setEditable(false);
  	
  	Sc3  = new JScrollPane();
  	Sc3.getViewport().setView(battleLog);
  	
  	relocateUnit = new JButton("relocate unit");
  	
  	battleview.add(ManualMode);
  	battleview.add(AutoResolve);
  	battleview.add(Sc3) ;
  this.add(BattleStart);
  this.add(battle);
  	
  	//battleview.add(battleplayerunit);
  	//battleview.add(battleenemyunit);
  	
  	
	
 	
 	
  	
  	
 
 	
 	
 	
 	
 	upgrade = new JButton ("upgrade");
    upgrade.setActionCommand("upgrade");
    recruit = new JButton ("recruit");
    recruit.setActionCommand("recruit");
    Finish = new JButton ("Finish");
    Finish.setActionCommand("Finish");
    cityview.add(upgrade);
    cityview.add(recruit);
   build  = new JButton ("build");
   build.setActionCommand("build");
   //manual_resolve = new JButton("Manual Resolve");
   //manual_resolve.setActionCommand("Manual Resolve") ;
    cityview.add(Finish);
    cityview.add(build);
    //cityview.add(manual_resolve);
     basicinfo = new JTextArea();
     basicinfo.setPreferredSize( new Dimension (400,500));//bassant
     basicinfo.setEditable(false);
     Sc2 = new JScrollPane(basicinfo);//bassant
     cityview.add(Sc2);//bassant
    
    ok = new JButton ("ok");
    ok.setActionCommand("ok");
    city2 = new JTextArea();
    //basicinfo.setEditable(false);//bassant
    city2.setPreferredSize(new Dimension(100,100));
    this.add(ok);
    this.add(city2);
    
  
 	
    endTurn = new JButton("endTurn");
    endTurn.setActionCommand("endTurn");
    this.add(endTurn);
    //button1.addActionListener(this);
    
    
    
    this.revalidate();
    this.repaint();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}


public JButton getLaySeige() {
	return laySeige;
}
public void setLaySeige(JButton laySeige) {
	this.laySeige = laySeige;
}
public JButton getSetTarget() {
	return setTarget;
}
public void setSetTarget(JButton setTarget) {
	this.setTarget = setTarget;
}
public JTextArea getTarget_city() {
	return target_city;
}
public void setTarget_city(JTextArea target_city) {
	this.target_city = target_city;
}
public JTextArea getBattleLog() {
	return battleLog;
}
public void setBattleLog(JTextArea battleLog) {
	this.battleLog = battleLog;
}
public JTextArea getBattle() {
	return battle;
}
public JButton getBattleStart() {
	return BattleStart;
}
public void setBattleStart(JButton battle) {
	BattleStart = battle;
}
public JButton getManualMode() {
	return ManualMode;
}
public void setManualMode(JButton playerattackcity) {
	this.ManualMode = playerattackcity;
}
public JButton getAutoResolve() {
	return AutoResolve;
}
public void setAutoResolve(JButton cityattackplayer) {
	this.AutoResolve = cityattackplayer;
}
/*public JTextArea getBattleplayerunit() {
	return battleplayerunit;
}
public void setBattleplayerunit(JTextArea battleplayerunit) {
	this.battleplayerunit = battleplayerunit;
}
public JTextArea getBattleenemyunit() {
	return battleenemyunit;
}
public void setBattleenemyunit(JTextArea battleenemyunit) {
	this.battleenemyunit = battleenemyunit;
}*/

//public JButton getManual_resolve() {
	//return manual_resolve;
//}
//public void setManual_resolve(JButton manual_resolve) {
	//this.manual_resolve = manual_resolve;
//}
public void setEndTurn(JButton endTurn) {
	this.endTurn = endTurn;
}
public JComboBox<String> getBuildings() {
	return buildings;
}
public void setBuildings(JComboBox<String> buildings) {
	this.buildings = buildings;
}
public JButton getBuild() {
	return build;
}
public JTextArea getCity2() {
	return city2;
}
public JButton getFinish() {
	return Finish;
}
public void setFinish(JButton finish) {
	Finish = finish;
}
public JButton getChooseCity() {
	return ChooseCity;
}
public void setChooseCity(JButton chooseCity) {
	ChooseCity = chooseCity;
}
//public JTextArea getCity() {
//	return city;
//}
//public void setCity(JTextArea city) {
//	this.city = city;
//}
public JButton getUpgrade() {
	return upgrade;
}
public JButton getOk() {
	return ok;
}
public JButton getRecruit() {
	return recruit;
}
public void setRecruit(JButton recruit) {
	this.recruit = recruit;
}

public JComboBox<String> getUnitsinfop() {
	return unitsinfop;
}
public void setUnitsinfop(JComboBox<String> unitsinfop) {
	this.unitsinfop = unitsinfop;
}
public JComboBox<String> getUnitsinfoc() {
	return unitsinfoc;
}
public void setUnitsinfoc(JComboBox<String> unitsinfoc) {
	this.unitsinfoc = unitsinfoc;
}



public void updatearmystatus (Game g ) {
	String n = "IDLE armies"+"\n" ;
	//String I = "";
	//String m1 = "";
	//String b1 = "";
	for(int i=0 ; i<g.getPlayer().getControlledArmies().size() ; i++ ) {
		if(g.getPlayer().getControlledArmies().get(i).getCurrentStatus().equals(Status.IDLE)) {
			n +=  g.getPlayer().getControlledArmies().get(i).getCurrentLocation() +"\n";
			for(int j = 0 ; j<g.getPlayer().getControlledArmies().get(i).getUnits().size(); j++) {
				if (g.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Archer)
				{n += "unit's type : " +"Archer ";}
				if (g.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Cavalry)
				{n += "unit's type : " +"Cavalry ";}
				if (g.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Infantry)
				{n += "unit's type : " +"Infantry ";}
				n += "\n"+"level "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel() +"\n" + "current solider count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+"\n"+"max solider count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount() + "\n" ;
			}
		}

//	    System.out.print("x");
	}
	//idleArmy.setText(n);
	this.revalidate();
    this.repaint();
     n += "BESIEGING armies"+"\n";
	for(int i=0 ; i<g.getPlayer().getControlledArmies().size() ; i++ ) {
		if(g.getPlayer().getControlledArmies().get(i).getCurrentStatus().equals(Status.BESIEGING)) {
			n += g.getPlayer().getControlledArmies().get(i).getCurrentLocation() +"\n";
			for(int j = 0 ; j<g.getPlayer().getControlledArmies().get(i).getUnits().size(); j++) {
				if (g.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Archer)
				{n += "unit's type : " +"Archer ";}
				if (g.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Cavalry)
				{n += "unit's type : " +"Cavalry ";}
				if (g.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Infantry)
				{n += "unit's type : " +"Infantry ";}
				n += "\n"+"level "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel()+"\n" + "current solider count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+"\n"+"max solider count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount() + "\n" ;
			}
			n += "besieging city " + g.getPlayer().getControlledArmies().get(i).getCurrentLocation() +"\n"+ "Turns under seige " ;
			for(int k =0 ; k< g.getAvailableCities().size() ; k++) {if(
					g.getAvailableCities().get(k).getName().equals(g.getPlayer().getControlledArmies().get(i).getCurrentLocation())) {
				n += g.getAvailableCities().get(k).getTurnsUnderSiege();
				break;
			}}
		}

//	    System.out.print("x");
	}
	//bArmy.setText(b);
	this.revalidate();
    this.repaint();
     n += "MARCHING armies"+"\n" ;
   	for(int i=0 ; i<g.getPlayer().getControlledArmies().size() ; i++ ) {
   		if(g.getPlayer().getControlledArmies().get(i).getCurrentStatus().equals(Status.MARCHING)) {
   			n += g.getPlayer().getControlledArmies().get(i).getCurrentLocation() +"\n";
   			for(int j = 0 ; j<g.getPlayer().getControlledArmies().get(i).getUnits().size(); j++) {
				if (g.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Archer)
				{n += "unit's type : " +"Archer ";}
				if (g.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Cavalry)
				{n += "unit's type : " +"Cavalry ";}
				if (g.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Infantry)
				{n += "unit's type : " +"Infantry ";}
				n +="\n"+"level "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel() +"\n"+ "current solider count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+"\n"+"max solider count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount() + "\n" ;
				
			}
   			n += "target city "+ g.getPlayer().getControlledArmies().get(i).getTarget()+"\n" + "turns left to reach target " + g.getPlayer().getControlledArmies().get(i).getDistancetoTarget() ;
   		}

//   	    System.out.print("x");
   	}
   	mArmy.setText(n);
//  iA[0]=n;
//  iA[1]=I;
   	 //iA = {n , I };
 // BA[0]=b;
 // BA[1]=b1;
   	// BA = {b , b1 };
 // MA[0]=m;
 // MA[1]=m1;
   	// MA = { m,m1  };
 // armyi = new JComboBox<String>(iA);
//	armyB = new JComboBox<String>(BA);
//	armyM = new JComboBox<String>(MA);
	
	
   	this.revalidate();
       this.repaint();

}


public void updateplayerinfo (Game g ) {
	String result = " ";
	result = result+" player name :"+ g.getPlayer().getName() + "\n";
	result = result +" current turn count:"+ g.getCurrentTurnCount()+ "\n";
	result=result +"player food:" + g.getPlayer().getFood()+ "\n";
	result = result +"player gold:" + g.getPlayer().getTreasury();
	playerinformation.setText(result);
	//System.out.print(g.getPlayer().getName());
	
}
public void updateWorldMap(Game g) {
	for (int i =0; i<g.getAvailableCities().size(); i++) {
		JButton city = new JButton (g.getAvailableCities().get(i).getName());
	
		this.add(city);
	}
}
public void updatecityview(City c, Player p) {
	
	
	
	
	
	
	
	String basic= " ";
	basic = basic + "name"+ " "+(c.getName()) + "\n" ;// is under siege always false?
	basic = basic + "under siege " + c.isUnderSiege() + "\n" ;
	basic = basic + "turns under siege: " + c.getTurnsUnderSiege() + "\n";
	basic = basic + "Economical buildings: " + "\n";
	for (int i = 0 ; i< c.getEconomicalBuildings().size();i++) {
		 if (c.getEconomicalBuildings().get(i) instanceof Farm) {
			 basic = basic + "Type:farm" + " " + "level: " + c.getEconomicalBuildings().get(i).getLevel() +"\n" ;
			 basic = basic + "upgrade cost:" + " "+ c.getEconomicalBuildings().get(i).getUpgradeCost() + "\n";
			  }
			 else {
				 basic = basic + "Type:market" + " " + "level: " + c.getEconomicalBuildings().get(i).getLevel() +"\n" ;
				 basic = basic + "upgrade cost:" + " "+ c.getEconomicalBuildings().get(i).getUpgradeCost() + "\n";
			 }}
	basic = basic + "Military buildings" + "\n";
	for (int j=0; j<c.getMilitaryBuildings().size();j++) {
		 if (c.getMilitaryBuildings().get(j) instanceof ArcheryRange) {
			 basic = basic + "Type:Archery Range" + " " + "level: " + c.getMilitaryBuildings().get(j).getLevel() +"\n" ;
	
	      basic = basic + "upgrade cost:" + " "+ c.getMilitaryBuildings().get(j).getUpgradeCost() + " " + "Recruitment cost: "+ c.getMilitaryBuildings().get(j).getRecruitmentCost()  + "\n";}
	
		 if (c.getMilitaryBuildings().get(j) instanceof Barracks) {
			 basic = basic + "Type:barracks" + " " + "level: " + c.getMilitaryBuildings().get(j).getLevel() +"\n" ;
			 basic = basic + "upgrade cost:" + " "+ c.getMilitaryBuildings().get(j).getUpgradeCost() + " " + "Recruitment cost: "+ c.getMilitaryBuildings().get(j).getRecruitmentCost()  + "\n";}
	
		 if (c.getMilitaryBuildings().get(j) instanceof Stable) {
			 basic = basic + "Type:Stable" + " " + "level: " + c.getMilitaryBuildings().get(j).getLevel() +"\n" ;
			 basic = basic + "upgrade cost:" + " "+ c.getMilitaryBuildings().get(j).getUpgradeCost() + " " + "Recruitment cost: "+ c.getMilitaryBuildings().get(j).getRecruitmentCost()  + "\n";}
	  
	
	
	}
	basic = basic + "defending army:" + "\n";
	
	basic = basic +"current location: "+c.getDefendingArmy().getCurrentLocation()+"\n" ;//bassant
	basic = basic +"current status: " + c.getDefendingArmy().getCurrentStatus()+"\n" ;
	basic = basic +	"Distance to target: "+c.getDefendingArmy().getDistancetoTarget() +"\n";
	basic = basic +"Target: " +c.getDefendingArmy().getTarget()+ "\n";
	basic = basic + "max to hold: "+c.getDefendingArmy().getMaxToHold()+"\n" ;
	for(int a =0 ; a<c.getDefendingArmy().getUnits().size();a++) {
		if (c.getDefendingArmy().getUnits().get(a) instanceof Archer)
		{basic += "unit's type : " +"Archer ";}
		if (c.getDefendingArmy().getUnits().get(a) instanceof Cavalry)
		{basic += "unit's type : " +"Cavalry ";}
		if (c.getDefendingArmy().getUnits().get(a) instanceof Infantry)
		{basic += "unit's type : " +"Infantry ";}
		basic +="\n"+"level "+c.getDefendingArmy().getUnits().get(a).getLevel() +"\n"+ "current solider count "+c.getDefendingArmy().getUnits().get(a).getCurrentSoldierCount()+"\n"+"max solider count "+c.getDefendingArmy().getUnits().get(a).getMaxSoldierCount() + "\n";
		
	}
	
	
	//bassant
	int itemCount = def.getItemCount();

	//for(int i = 0; i < itemCount; i++){
	//  def.removeItemAt(0);
	//}
	
	String datac = "";
	for(int h=0; h<c.getDefendingArmy().getUnits().size() ; h++) {
		if (c.getDefendingArmy().getUnits().get(h) instanceof Archer) {
			datac =  " type : Archer "+ " level " + c.getDefendingArmy().getUnits().get(h).getLevel()+"\n"+" CS Count: " +c.getDefendingArmy().getUnits().get(h).getCurrentSoldierCount()+ " MxS_count: "+  c.getDefendingArmy().getUnits().get(h).getMaxSoldierCount() + " Idle_uk " + c.getDefendingArmy().getUnits().get(h).getIdleUpkeep()+ " marching_uk "+ c.getDefendingArmy().getUnits().get(h).getMarchingUpkeep()+ " siege_uk "+c.getDefendingArmy().getUnits().get(h).getSiegeUpkeep();
            def.addItem(datac);
		}
		if (c.getDefendingArmy().getUnits().get(h) instanceof Cavalry) {
			datac =  " type : Cavalry "+ " level " + c.getDefendingArmy().getUnits().get(h).getLevel()+"\n"+" CS Count: " +c.getDefendingArmy().getUnits().get(h).getCurrentSoldierCount()+ " MxS_count: "+  c.getDefendingArmy().getUnits().get(h).getMaxSoldierCount() + " Idle_uk " + c.getDefendingArmy().getUnits().get(h).getIdleUpkeep()+ " marching_uk "+ c.getDefendingArmy().getUnits().get(h).getMarchingUpkeep()+ " siege_uk "+c.getDefendingArmy().getUnits().get(h).getSiegeUpkeep();                    def.addItem(datac);
			 def.addItem(datac);}
		if (c.getDefendingArmy().getUnits().get(h) instanceof Infantry) {
			datac =  " type : Infantry "+ " level " + c.getDefendingArmy().getUnits().get(h).getLevel()+"\n"+" CS Count: " +c.getDefendingArmy().getUnits().get(h).getCurrentSoldierCount()+ " MxS_count: "+  c.getDefendingArmy().getUnits().get(h).getMaxSoldierCount() + " Idle_uk " + c.getDefendingArmy().getUnits().get(h).getIdleUpkeep()+ " marching_uk "+ c.getDefendingArmy().getUnits().get(h).getMarchingUpkeep()+ " siege_uk "+c.getDefendingArmy().getUnits().get(h).getSiegeUpkeep();                    def.addItem(datac);
			 def.addItem(datac);}
		
	}
	 basic = basic + "Armies located in city" + "\n";
	for(int o = 0 ; o< p.getControlledArmies().size(); o++) {
		if(p.getControlledArmies().get(o).getCurrentLocation().toLowerCase().equals(c.getName().toLowerCase())) {
    basic = basic + "Army" + "\n";
	
	//basic = basic +"current location: "+c.getDefendingArmy().getCurrentLocation()+"\n" ;//bassant
	basic = basic +"current status: " + p.getControlledArmies().get(o).getCurrentStatus()+"\n" ;
	basic = basic +	"Distance to target: "+p.getControlledArmies().get(o).getDistancetoTarget() +"\n";
	basic = basic +"Target: " +p.getControlledArmies().get(o).getTarget()+ "\n";
	basic = basic + "max to hold: "+p.getControlledArmies().get(o).getMaxToHold()+"\n" ;
	for(int a =0 ; a<p.getControlledArmies().get(o).getUnits().size();a++) {
		if (p.getControlledArmies().get(o).getUnits().get(a) instanceof Archer)
		{basic += "unit's type : " +"Archer ";}
		if (p.getControlledArmies().get(o).getUnits().get(a) instanceof Cavalry)
		{basic += "unit's type : " +"Cavalry ";}
		if (p.getControlledArmies().get(o).getUnits().get(a) instanceof Infantry)
		{basic += "unit's type : " +"Infantry ";}
		basic +="\n"+"level "+p.getControlledArmies().get(o).getUnits().get(a).getLevel() +"\n"+ "current solider count "+p.getControlledArmies().get(o).getUnits().get(a).getCurrentSoldierCount()+"\n"+"max solider count "+p.getControlledArmies().get(o).getUnits().get(a).getMaxSoldierCount() + "\n";
		
	}}}
	
	
	basicinfo.setText(basic);
	
	this.revalidate();
	this.repaint();
	
			 
			 
			 
		 
	 
	
		
}


public void updatebattleview(Player p ,Game g) {
	
	int itemCount = unitsinfop.getItemCount();

	for(int i = 0; i < itemCount; i++){
	  unitsinfop.removeItemAt(0);
	}
	int itemCount2 = unitsinfoc.getItemCount();

	for(int i = 0; i < itemCount2; i++){
	 unitsinfoc.removeItemAt(0);
	}
	
	String datap = " ";
	String datac =" " ;
	for (int i =0; i<p.getControlledArmies().size();i++) {
		if (p.getControlledArmies().get(i).getDistancetoTarget()==0) {
			
			for (int j = 0; j<p.getControlledArmies().get(i).getUnits().size();j++) {
				if (p.getControlledArmies().get(i).getUnits().get(j) instanceof Archer) {
					datap =  " type : Archer "+ " level " + p.getControlledArmies().get(i).getUnits().get(j).getLevel()+"\n"+" CS Count: " + p.getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+ " MxS_count: "+  p.getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount() + " Idle_uk " + p.getControlledArmies().get(i).getUnits().get(j).getIdleUpkeep()+ " marching_uk "+ p.getControlledArmies().get(i).getUnits().get(j).getMarchingUpkeep()+ " siege_uk "+ p.getControlledArmies().get(i).getUnits().get(j).getSiegeUpkeep();
                    unitsinfop.addItem(datap);
				}
				if (p.getControlledArmies().get(i).getUnits().get(j) instanceof Cavalry) {
					datap =  " type : cavalry "+ " level " + p.getControlledArmies().get(i).getUnits().get(j).getLevel()+"\n"+" CS Count: " + p.getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+ " MxS_count: "+  p.getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount() + " Idle_uk " + p.getControlledArmies().get(i).getUnits().get(j).getIdleUpkeep()+ " marching_uk "+ p.getControlledArmies().get(i).getUnits().get(j).getMarchingUpkeep()+ " siege_uk "+ p.getControlledArmies().get(i).getUnits().get(j).getSiegeUpkeep();
                    unitsinfop.addItem(datap);
				}
				if (p.getControlledArmies().get(i).getUnits().get(j) instanceof Infantry) {
					datap = " type : infantry "+ " level " + p.getControlledArmies().get(i).getUnits().get(j).getLevel()+"\n"+" CS Count: " + p.getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+ " MxS_count: "+  p.getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount() + " Idle_uk " + p.getControlledArmies().get(i).getUnits().get(j).getIdleUpkeep()+ " marching_uk "+ p.getControlledArmies().get(i).getUnits().get(j).getMarchingUpkeep()+ " siege_uk "+ p.getControlledArmies().get(i).getUnits().get(j).getSiegeUpkeep();
                    unitsinfop.addItem(datap);
				}
			}
			
			String current_city =  p.getControlledArmies().get(i).getCurrentLocation();
			for (int k =0 ; k< g.getAvailableCities().size();k++) {
				if (g.getAvailableCities().get(k).getName().equals(current_city)) {
					for(int h=0; h<g.getAvailableCities().get(i).getDefendingArmy().getUnits().size() ; h++) {
						if (p.getControlledArmies().get(k).getUnits().get(h) instanceof Archer) {
							datac =  " type : Archer "+ " level " + p.getControlledArmies().get(k).getUnits().get(h).getLevel()+"\n"+" CS Count: " + p.getControlledArmies().get(k).getUnits().get(h).getCurrentSoldierCount()+ " MxS_count: "+  p.getControlledArmies().get(k).getUnits().get(h).getMaxSoldierCount() + " Idle_uk " + p.getControlledArmies().get(k).getUnits().get(h).getIdleUpkeep()+ " marching_uk "+ p.getControlledArmies().get(k).getUnits().get(h).getMarchingUpkeep()+ " siege_uk "+ p.getControlledArmies().get(k).getUnits().get(h).getSiegeUpkeep();
		                    unitsinfoc.addItem(datac);
						}
						if (p.getControlledArmies().get(k).getUnits().get(h) instanceof Cavalry) {
							datac =  " type : cavalry "+ " level " + p.getControlledArmies().get(k).getUnits().get(h).getLevel()+"\n"+" CS Count: " + p.getControlledArmies().get(k).getUnits().get(h).getCurrentSoldierCount()+ " MxS_count: "+  p.getControlledArmies().get(k).getUnits().get(h).getMaxSoldierCount() + " Idle_uk " + p.getControlledArmies().get(k).getUnits().get(h).getIdleUpkeep()+ " marching_uk "+ p.getControlledArmies().get(k).getUnits().get(h).getMarchingUpkeep()+ " siege_uk "+ p.getControlledArmies().get(k).getUnits().get(h).getSiegeUpkeep();
		                    unitsinfoc.addItem(datac);
						}
						if (p.getControlledArmies().get(k).getUnits().get(h) instanceof Infantry) {
							datac =  " type : infantry "+ " level " + p.getControlledArmies().get(k).getUnits().get(h).getLevel()+"\n"+" CS Count: " + p.getControlledArmies().get(k).getUnits().get(h).getCurrentSoldierCount()+ " MxS_count: "+  p.getControlledArmies().get(k).getUnits().get(h).getMaxSoldierCount() + " Idle_uk " + p.getControlledArmies().get(k).getUnits().get(h).getIdleUpkeep()+ " marching_uk "+ p.getControlledArmies().get(k).getUnits().get(h).getMarchingUpkeep()+ " siege_uk "+ p.getControlledArmies().get(k).getUnits().get(h).getSiegeUpkeep();
		                    unitsinfoc.addItem(datac);
						}
						
					}
				}
				
			}
			
		}
	}
	
	
  
	
	this.revalidate();
	this.repaint();
	
	
}

		

	

public void updateplayerunit(Unit u) {
	String ptext = "" ;
	if( u instanceof Archer ) {
		ptext = ptext+ "Type: "+ "Archer"+ "\n" ;
	}
	if( u instanceof Cavalry ) {
		ptext = ptext+ "Type: "+ "Cavalry"+ "\n" ;
	}
	if( u instanceof Infantry ) {
		ptext = ptext+ "Type: "+ "Infantry"+ "\n" ;
	}
	ptext = ptext+"level: "+ u.getLevel()+"\n" ;
	ptext = ptext+"Current soldier Count: "+ u.getCurrentSoldierCount()+"\n" ;
	ptext = ptext+"Max soldier count: "+ u.getMaxSoldierCount()+"\n" ;
	ptext = ptext+"Idle up keep: "+ u.getIdleUpkeep()+"\n" ;
	ptext = ptext+"Marching up keep: "+ u.getMarchingUpkeep()+"\n" ;
	ptext = ptext+"Seige up keep: "+ u.getSiegeUpkeep()+"\n" ;
	ptext = ptext+"Parent army: "+ u.getParentArmy()+"\n" ;
	
	
    //playerunitsinfo.setText(ptext);//bassant
  //  battleplayerunit.setText(ptext);
   // battleenemyunit.setText(ptext);
	
	this.revalidate();
	this.repaint();
	
	
}
public void updateenemyunit(Unit u) {
	String ptext = "" ;
	if( u instanceof Archer ) {
		ptext = ptext+ "Type: "+ "Archer"+ "\n" ;
	}
	if( u instanceof Cavalry ) {
		ptext = ptext+ "Type: "+ "Cavalry"+ "\n" ;
	}
	if( u instanceof Infantry ) {
		ptext = ptext+ "Type: "+ "Infantry"+ "\n" ;
	}
	ptext = ptext+"level: "+ u.getLevel()+"\n" ;
	ptext = ptext+"Current soldier Count: "+ u.getCurrentSoldierCount()+"\n" ;
	ptext = ptext+"Max soldier count: "+ u.getMaxSoldierCount()+"\n" ;
	ptext = ptext+"Idle up keep: "+ u.getIdleUpkeep()+"\n" ;
	ptext = ptext+"Marching up keep: "+ u.getMarchingUpkeep()+"\n" ;
	ptext = ptext+"Seige up keep: "+ u.getSiegeUpkeep()+"\n" ;
	ptext = ptext+"Parent army: "+ u.getParentArmy()+"\n" ;
	
	
    //playerunitsinfo.setText(ptext);//bassant
   // battleenemyunit.setText(ptext);
   // battleenemyunit.setText(ptext);
	
	this.revalidate();
	this.repaint();
	
	
}

public void updatecomboboxes (Game g) {
	int itemCount3 = availableunits.getItemCount();

	for(int i = 0; i < itemCount3; i++){
	  availableunits.removeItemAt(0);
	}
	int itemCount4 = availablearmies.getItemCount();

	for(int i = 0; i < itemCount4; i++){
	  availablearmies.removeItemAt(0);
	}
	for(int p=0 ; p<g.getPlayer().getControlledArmies().size() ; p++) {
		availablearmies.addItem(g.getPlayer().getControlledArmies().get(p));
		for(int q=0 ; q<g.getPlayer().getControlledArmies().get(p).getUnits().size();q++) {
			availableunits.addItem(g.getPlayer().getControlledArmies().get(p).getUnits().get(q));
		}
	}
	/*for(int s=0 ; s<g.getPlayer().getControlledCities().size();s++) {
		availablearmies.addItem(g.getPlayer().getControlledCities().get(s).getDefendingArmy());
		for(int d=0; d<g.getPlayer().getControlledCities().get(s).getDefendingArmy().getUnits().size(); d++) {
			availableunits.addItem(g.getPlayer().getControlledCities().get(s).getDefendingArmy().getUnits().get(d));
		}
	}*/
	this.revalidate();
	this.repaint();
	
}







public JPanel getCityview() {
	return cityview;
}
public void setCityview(JPanel cityview) {
	this.cityview = cityview;
}
public JTextArea getIdleArmy() {
	return idleArmy;
}
public JTextArea getbArmy() {
	return bArmy;
}
public JTextArea getmArmy() {
	return mArmy;
}
public JTextArea getPlayerinformation() {
	return playerinformation;
}
public JPanel getWorldmapview() {
	return worldmapview;
}
public JComboBox<String> getArmyi() {
	return armyi;
}
public JComboBox<String> getArmyB() {
	return armyB;
}
public JComboBox<String> getArmyM() {
	return armyM;
}
public JPanel getArmyibm() {
	return Armyibm;
}
public JButton getEndTurn() {
	return endTurn;
}

public JPanel getBattleview() {
	return battleview;
}
public void setBattleview(JPanel battleview) {
	this.battleview = battleview;
}	public JButton getRelocateUnit() {
	return relocateUnit;
}
public void setRelocateUnit(JButton relocateUnit) {
	this.relocateUnit = relocateUnit;
}
public JComboBox<Unit> getAvailableunits() {
	return availableunits;
}
public void setAvailableunits(JComboBox<Unit> availableunits) {
	this.availableunits = availableunits;
}
public JComboBox<Army> getAvailablearmies() {
	return availablearmies;
}
public void setAvailablearmies(JComboBox<Army> availablearmies) {
	this.availablearmies = availablearmies;
}
public JComboBox<String> getDef() {
	return def;
}
public void setDef(JComboBox<String> def) {
	this.def = def;
}
public JButton getInitiateA() {
	return initiateA;
}
public static void main (String [] args) {
	gameview test = new gameview();
	//Game g = new Game ("salma","cairo");
	
}
}
