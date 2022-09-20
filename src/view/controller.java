package view;
import java.awt.event.ActionEvent; 


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import javax.swing.JButton;

import javax.swing.*;
import engine.*;
import buildings.*;
import exceptions.*;
import units.*;
public class controller  implements ActionListener {
	 private View startView ;
	 private gameview gameview ;
	  //private JButton startgame;
	 //private gameview game;
	 private String helper_city;
	 private String helper_target ;
	 private int armyindex;
	 private Game g ;
	public Game getG() {
		return g;
	}
public controller() {
	//helper_city = " ";
	startView = new View();
   // startgame = new JButton("enter to start ");
    //startView.add(startgame);
	gameview =new gameview();
	gameview.setVisible(false);
	//game.setC(this);
	startView.getStartgame().addActionListener(this);
	//startgame.addActionListener(this);
	startView.getCity().addActionListener(this);
	gameview.getOk().addActionListener(this);
	gameview.getFinish().addActionListener(this);
	gameview.getUpgrade().addActionListener(this);
	gameview.getRecruit().addActionListener(this);
    gameview.getBuild(). addActionListener(this);
    gameview.getBuildings().addActionListener(this);
    gameview.getEndTurn().addActionListener(this);
    gameview.getManualMode().addActionListener(this);
   // gameview.getDisplayp().addActionListener(this);
    //gameview.getDisplayc().addActionListener(this);
    gameview.getAutoResolve().addActionListener(this);
    gameview.getBattleStart().addActionListener(this);
    gameview.getUnitsinfop().addActionListener(this);
    gameview.getInitiateA().addActionListener(this);
    gameview.getRelocateUnit().addActionListener(this);
    gameview.getLaySeige().addActionListener(this);
    gameview.getSetTarget().addActionListener(this);
    
    //gameview.getBattle().addActionListener(this);
    startView.revalidate();
    startView.repaint();
    gameview.revalidate();
    gameview.repaint();
}
public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("enter to start") ) {
		if (startView.getP_name().getText().equals("")) {
			JOptionPane.showMessageDialog(startView, "no name entered", "Error", JOptionPane.ERROR_MESSAGE);}
			else {
				if(startView.getCity().getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(startView, "no city chosen", "Error", JOptionPane.ERROR_MESSAGE);
					 
				}else { 
					try {
					g =new Game(startView.getP_name().getText(),(String) startView.getCity().getSelectedItem());
					System.out.println(g.getPlayer().getName());
					System.out.println(g.getPlayer().getControlledCities().size());
					
					//System.out.println("cleanup");
				}
				catch(IOException z){
					System.out.println("invalid input!!");
					
				}//finally {
					//System.out.println("cleanup");
					
				//}
					startView.setVisible(false);
					startView.dispose();
					gameview.setVisible(true);
					gameview.updateplayerinfo(g);
					gameview.updateWorldMap(g);
					gameview.updatearmystatus(g);
					gameview.updatecomboboxes(g);
					//City c = new City ("cairo");
					//game.updatecityview(c);
					}
				
					
				}
		


		
		
		
		
	}
	if (e.getActionCommand().equals("ok") ) {
		//System.out.println(g.getPlayer().getControlledCities().size() );
		for(int i =0 ; i<g.getPlayer().getControlledCities().size() ; i++ ) {
		if (g.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals(gameview.getCity2().getText().toLowerCase())) {
			//System.out.println("x");
		helper_city=gameview.getCity2().getText().toLowerCase();
		gameview.getCityview().setVisible(true);
	     gameview.updatecityview(g.getPlayer().getControlledCities().get(i),g.getPlayer());
		gameview.getOk().setVisible(false);
		gameview.getCity2().setVisible(false);}}
		if(!(gameview.getCity2().getText().equals("") )&& gameview.getCityview().isVisible()==false) {JOptionPane.showMessageDialog(startView, "you do not control this city", "Error", JOptionPane.ERROR_MESSAGE);}
		if(gameview.getCity2().getText().equals("")&& gameview.getCityview().isVisible()==false) {JOptionPane.showMessageDialog(startView, "enter a city", "Error", JOptionPane.ERROR_MESSAGE);}
	}
	
	if (e.getActionCommand().equals("Finish") ) {
		gameview.getCityview().setVisible(false);
		gameview.getOk().setVisible(true);
		gameview.getCity2().setVisible(true);
	}
	if (e.getActionCommand().equals("build") ) {
		//String t ="";
		if (((String) gameview.getBuildings().getSelectedItem()).equals("buildings")) {
			JOptionPane.showMessageDialog(startView, " please choose a type", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
		try {
			 //t =(String) gameview.getBuildings().getSelectedItem();
			g.getPlayer().build((String) gameview.getBuildings().getSelectedItem(), helper_city);
		} catch (NotEnoughGoldException e1) {JOptionPane.showMessageDialog(startView, " pardon, you do not have enough money", "Error", JOptionPane.ERROR_MESSAGE);
			
		   
		      
		
		      		
		
		}}gameview.updateplayerinfo(g);
		for(int i =0 ; i<g.getPlayer().getControlledCities().size() ; i++ ) {
			if (g.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals(helper_city)) {
				//System.out.println("x");
			//helper_city=gameview.getCity2().getText().toLowerCase();
		
		     gameview.updatecityview(g.getPlayer().getControlledCities().get(i),g.getPlayer());}}}
 if (e.getActionCommand().equals("upgrade")) {
	try {
		 for(int i =0 ; i<g.getPlayer().getControlledCities().size() ; i++ ) {
				if (g.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals(helper_city)) {
					 if(((String) gameview.getBuildings().getSelectedItem()).toLowerCase().equals("farm")) {
						 for (int j = 0;j<g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {
							 if (g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j) instanceof Farm) {
								 g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).upgrade();
							 }
						 }
					 }	
					 if(((String) gameview.getBuildings().getSelectedItem()).toLowerCase().equals("market")) {
						 for (int j = 0;j<g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {
							 if (g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j) instanceof Market) {
								 g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).upgrade();
							 }
						 }
					 }
					 
					 if(((String) gameview.getBuildings().getSelectedItem()).toLowerCase().equals("archeryrange")) {
						 for (int j = 0;j<g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
							 if (g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof ArcheryRange) {
								 g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).upgrade();
							 }
						 }
					 } 
					 if(((String) gameview.getBuildings().getSelectedItem()).toLowerCase().equals("barracks")) {
						 for (int j = 0;j<g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
							 if (g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Barracks) {
								 g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).upgrade();
							 }
						 }
					 }  
					 if(((String) gameview.getBuildings().getSelectedItem()).toLowerCase().equals("stable")) {
						 for (int j = 0;j<g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
							 if (g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Stable) {
								 g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).upgrade();
							 }
						 }
					 } 
	
					 
					    gameview.updatecityview(g.getPlayer().getControlledCities().get(i),g.getPlayer());
					    gameview.updateplayerinfo(g);
					    break;
					 
					 
					 
					 
					 
					 
					 
					 
					 
				
		 
	 }
				
	}
		
		 
 }	
 catch (BuildingInCoolDownException z ){
	 JOptionPane.showMessageDialog(startView, " this building is cooling down", "Error", JOptionPane.ERROR_MESSAGE);
	 
	 
	 
 }
	catch(MaxLevelException z2) {
		 JOptionPane.showMessageDialog(startView, " max level has already been reached", "Error", JOptionPane.ERROR_MESSAGE);
	}
 }
 
 if (e.getActionCommand().equals("endTurn")) {
	 if(g.getCurrentTurnCount()==g.getMaxTurnCount()) {
		 if(g.getPlayer().getControlledCities().size()==3) {
			 //JOptionPane.showMessageDialog(startView, "YOU WON AND CONQURED ALL CITIES !!", "CONGRATULATIONS", JOptionPane.ERROR_MESSAGE);
			 JOptionPane.showMessageDialog(gameview, "YOU WON AND CONQURED ALL CITIES !!");
			 System.exit(0) ;
		 }
		 else {
			 JOptionPane.showMessageDialog(gameview, "UNFORTUNATELY, YOU LOST!!!!");
			 System.exit(0) ;
		 }
		 
	 }
	 else {
	 g.endTurn();
	 
	 gameview.updateplayerinfo(g);
	 //gameview.updatearmystatus (g)	;
	// gameview.updatecityview(c, g.getPlayer());
	 //gameview.updatecomboboxes(g);
	 for(int i =0 ; i<g.getPlayer().getControlledCities().size() ; i++ ) {
			
			if (g.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals(helper_city.toLowerCase())) {
				gameview.updatecityview(g.getPlayer().getControlledCities().get(i), g.getPlayer());
				
				
			}}
		gameview.updatebattleview(g.getPlayer(), g);
		gameview.updatearmystatus(g);
		gameview.updatecomboboxes(g);
	 
 }}
 
 
 if (e.getActionCommand().equals("recruit") ) {//bassant
		//String t ="";
		if (((String) gameview.getBuildings().getSelectedItem()).equals("buildings")) {
			JOptionPane.showMessageDialog(startView, " please choose a type", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
		try {
			 //t =(String) gameview.getBuildings().getSelectedItem();
			if(((String) gameview.getBuildings().getSelectedItem()).toLowerCase().equals("archeryrange")) {
				g.getPlayer().recruitUnit("archer", helper_city);
			}
			if(((String) gameview.getBuildings().getSelectedItem()).toLowerCase().equals("barracks")) {
				g.getPlayer().recruitUnit("infantry", helper_city);
			}
			if(((String) gameview.getBuildings().getSelectedItem()).toLowerCase().equals("stable")) {
				g.getPlayer().recruitUnit("cavalry", helper_city);
			}
			
			
		} 
		catch (MaxRecruitedException ex1) {
			JOptionPane.showMessageDialog(startView, "cannot recruit as max recruited units reached", "Error", JOptionPane.ERROR_MESSAGE);}
		catch (BuildingInCoolDownException ex2) {
			JOptionPane.showMessageDialog(startView, "cannot recruit building is cooling down", "Error", JOptionPane.ERROR_MESSAGE);}

		catch(NotEnoughGoldException ex3) {
			
			JOptionPane.showMessageDialog(startView, "cannot recruit no enough gold", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		gameview.updatecomboboxes(g);	
        gameview.updateplayerinfo(g);
        gameview.updatearmystatus(g);
		for(int i =0 ; i<g.getPlayer().getControlledCities().size() ; i++ ) {
			if (g.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals(helper_city)) {
				//System.out.println("x");
			//helper_city=gameview.getCity2().getText().toLowerCase();
		
		     gameview.updatecityview(g.getPlayer().getControlledCities().get(i),g.getPlayer());}}
		}
		}//bassant
 
 if(e.getActionCommand().equals("Battle Start")) {
	 boolean flag = false;
	 boolean armyr = false;
	for (int i =0 ; i<g.getPlayer().getControlledCities().size() ; i++ ) {
	 if (gameview.getBattle().getText().toLowerCase().equals(g.getPlayer().getControlledCities().get(i).getName().toLowerCase())){
		flag = true ;
	}}
	if(flag == false) {
		System.out.println(false);
		for (int j =0 ; j<g.getPlayer().getControlledArmies().size() ; j++ ) {
			System.out.println(2);
			 if (g.getPlayer().getControlledArmies().get(j).getDistancetoTarget()==0) {
				System.out.println(true);
				 armyr = true;
				 //gameview.getCityview().setVisible(false);
				 gameview.getBattleview().setVisible(true);
				 gameview.updatebattleview(g.getPlayer(), g);
				 armyindex = j ;
				 
				 
			}
		 }
		 if(armyr == false) { JOptionPane.showMessageDialog(startView, "you did not reach the city", "Error", JOptionPane.ERROR_MESSAGE);  }
		 }
			
	
	 }
if (e.getActionCommand().equals("AutoResolve")) {
	for(int x=0 ; x<g.getAvailableCities().size();x++) {
		if(g.getAvailableCities().get(x).getName().equals(g.getPlayer().getControlledArmies().get(armyindex).getCurrentLocation())){
			try {
			 g.autoResolve(g.getPlayer().getControlledArmies().get(armyindex),g.getAvailableCities().get(x).getDefendingArmy());}
			catch(FriendlyFireException i) {
				 JOptionPane.showMessageDialog(startView, "you are attacking friendly city", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	if(g.getPlayer().getControlledArmies().get(armyindex).getUnits().size()==0) {
		gameview.updatearmystatus ( g );
		gameview.updatecomboboxes(g); 
		JOptionPane.showMessageDialog(startView, "Sorry you LOOST!!", "Failure", JOptionPane.ERROR_MESSAGE);
		gameview.getBattleview().setVisible(false);
		//gameview.getCityview().setVisible(true);
	}
	else {
		gameview.updatearmystatus ( g );
		gameview.updatecomboboxes(g);
		JOptionPane.showMessageDialog(startView, "You WON ", "WINNER", JOptionPane.ERROR_MESSAGE);
		gameview.getBattleview().setVisible(false);
		//gameview.getCityview().setVisible(true);
	}
	
   
}
if(e.getActionCommand().equals("ManualMode")) {
	String d = "\n";
	boolean flag = true ;
	for(int y =0 ; y<g.getAvailableCities().size() ; y++ ) {
		if(g.getPlayer().getControlledArmies().get(armyindex).getCurrentLocation().toLowerCase().equals(g.getAvailableCities().get(y).getName().toLowerCase())) {
			try {
				int rand =(int) (Math.random() * g.getAvailableCities().get(y).getDefendingArmy().getUnits().size());
				int intial =g.getAvailableCities().get(y).getDefendingArmy().getUnits().get( rand).getCurrentSoldierCount();
				d+="you attacked your enemy :" + "enemie soilder count went from" + g.getAvailableCities().get(y).getDefendingArmy().getUnits().get( rand).getCurrentSoldierCount();
		   g.getPlayer().getControlledArmies().get(armyindex).getUnits().get(gameview.getUnitsinfop().getSelectedIndex()).attack(g.getAvailableCities().get(y).getDefendingArmy().getUnits().get( rand));
	       flag = false;
	       d+= "\n" + "you attacked your enemy :" + "enemie soilder count went to" + g.getAvailableCities().get(y).getDefendingArmy().getUnits().get( rand).getCurrentSoldierCount() + "\n" +"decrement : "+ (intial- g.getAvailableCities().get(y).getDefendingArmy().getUnits().get( rand).getCurrentSoldierCount()) + "\n";
	       if(g.getPlayer().getControlledArmies().get(armyindex).getUnits().size()==0) {
	    	   
	    	   gameview.getBattleLog().append(d);
	    	   gameview.updatecomboboxes(g);
	    	   gameview.updatearmystatus ( g );
	    	   gameview.updatebattleview(g.getPlayer() , g);
			   JOptionPane.showMessageDialog(startView, "Sorry you LOOST!!", "Failure", JOptionPane.ERROR_MESSAGE);
			   gameview.getBattleview().setVisible(false);
				//gameview.getCityview().setVisible(true);
		   }
		   if(g.getAvailableCities().get(y).getDefendingArmy().getUnits().size()==0) {
			   gameview.getBattleLog().append(d);
			   gameview.updatecomboboxes(g);
			   gameview.updatearmystatus ( g );
	    	   gameview.updatebattleview(g.getPlayer() , g);
			   JOptionPane.showMessageDialog(startView, "You WON ", "WINNER", JOptionPane.ERROR_MESSAGE);
			   gameview.getBattleview().setVisible(false);
				//gameview.getCityview().setVisible(true);
		   } int rand2 = (int) Math.random() *g.getPlayer().getControlledArmies().get(armyindex).getUnits().size();
		    d = d+ "your enemie attacked you , your intial solider count :" +g.getPlayer().getControlledArmies().get(armyindex).getUnits().get(rand2).getCurrentSoldierCount();
		    intial =g.getPlayer().getControlledArmies().get(armyindex).getUnits().get(rand2).getCurrentSoldierCount();
		   gameview.updatebattleview(g.getPlayer() , g);
	       g.getAvailableCities().get(y).getDefendingArmy().getUnits().get((int) (Math.random() * g.getAvailableCities().get(y).getDefendingArmy().getUnits().size())).attack(g.getPlayer().getControlledArmies().get(armyindex).getUnits().get((int) Math.random() *g.getPlayer().getControlledArmies().get(armyindex).getUnits().size()));
	       d = d + "\n"+"your unit final solider count :" +g.getPlayer().getControlledArmies().get(armyindex).getUnits().get(rand2).getCurrentSoldierCount() + " dec" +  (intial -g.getPlayer().getControlledArmies().get(armyindex).getUnits().get(rand2).getCurrentSoldierCount()); 
		   
	       if(g.getPlayer().getControlledArmies().get(armyindex).getUnits().size()==0) {
	    	   gameview.getBattleLog().append(d);
	    	   gameview.updatecomboboxes(g);
	    	   gameview.updatearmystatus ( g );
	    	   gameview.updatebattleview(g.getPlayer() , g);
			   JOptionPane.showMessageDialog(startView, "Sorry you LOOST!!", "Failure", JOptionPane.ERROR_MESSAGE);
			   gameview.getBattleview().setVisible(false);
				//gameview.getCityview().setVisible(true);
		   }
		   if(g.getAvailableCities().get(y).getDefendingArmy().getUnits().size()==0) {
			   gameview.getBattleLog().append(d);
			   gameview.updatecomboboxes(g);
			   gameview.updatearmystatus ( g );
	    	   gameview.updatebattleview(g.getPlayer() , g);
			   JOptionPane.showMessageDialog(startView, "You WON ", "WINNER", JOptionPane.ERROR_MESSAGE);
			   gameview.getBattleview().setVisible(false);
				//gameview.getCityview().setVisible(true);
		   }
		   else {
			   gameview.getBattleLog().append(d);
			   gameview.updatecomboboxes(g);
			   gameview.updatearmystatus ( g );
			   gameview.updatebattleview(g.getPlayer() , g);
			   JOptionPane.showMessageDialog(startView, "choose a unit and press ManualMode", "Manual Mode", JOptionPane.ERROR_MESSAGE);
			   
		   }
			
			}
			
		
		catch(FriendlyFireException f) {
			JOptionPane.showMessageDialog(startView, "You are attacking Friendly city ", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
			
}
	
	//getUnits().get((int) (Math.random() * attacker.getUnits().size()));
	//Unit unit2 = defender.getUnits().get((int) (Math.random() * defender.getUnits().size()));
	
		//unit1.attack(unit2);
}
}
	 
	 
 
/* if(e.getActionCommand().equals("Player unit")) {
	 if(((String)(gameview.getUnitsinfop().getSelectedItem())).equals("Player units")) {
		 JOptionPane.showMessageDialog(startView, "please choose player unit", "Error", JOptionPane.ERROR_MESSAGE);
	 }
	 if(((String)(gameview.getUnitsinfop().getSelectedItem())).equals("archer")) {
	 for(int b =0 ; b<g.getPlayer().getControlledArmies().size() ;b++ ) {
		 if(g.getPlayer().getControlledArmies().get(b).getDistancetoTarget()==0) {
			 helper_target = g.getPlayer().getControlledArmies().get(b).getTarget() ;
		 for(int l =0 ; l<g.getPlayer().getControlledArmies().get(b).getUnits().size() ;l++) {
			
			 if(g.getPlayer().getControlledArmies().get(b).getUnits().get(l) instanceof Archer)  {
				 gameview.updatebattleviewplayer(g.getPlayer().getControlledArmies().get(b).getUnits().get(l)) ;
				 
			 }
			 }
		 break;
		 }
		
		 }
		 
		 
		 
	 }
	 if(((String)(gameview.getUnitsinfop().getSelectedItem())).equals("cavalry")) {
		 for(int b =0 ; b<g.getPlayer().getControlledArmies().size() ;b++ ) {
			 if(g.getPlayer().getControlledArmies().get(b).getDistancetoTarget()==0) { 
				 helper_target = g.getPlayer().getControlledArmies().get(b).getTarget() ;
			 for(int l =0 ; l<g.getPlayer().getControlledArmies().get(b).getUnits().size() ;l++) {
				
				 if(g.getPlayer().getControlledArmies().get(b).getUnits().get(l) instanceof Cavalry)  {
					 gameview.updatebattleviewplayer(g.getPlayer().getControlledArmies().get(b).getUnits().get(l)) ;
					 
				 }
				 }
			 break;
			 }}
	 }
	 if(((String)(gameview.getUnitsinfop().getSelectedItem())).equals("infantry")) {
		 for(int b =0 ; b<g.getPlayer().getControlledArmies().size() ;b++ ) {
			 if(g.getPlayer().getControlledArmies().get(b).getDistancetoTarget()==0) {
				 helper_target = g.getPlayer().getControlledArmies().get(b).getTarget() ;
			 for(int l =0 ; l<g.getPlayer().getControlledArmies().get(b).getUnits().size() ;l++) {
				
				 if(g.getPlayer().getControlledArmies().get(b).getUnits().get(l) instanceof Infantry)  {
					 gameview.updatebattleviewplayer(g.getPlayer().getControlledArmies().get(b).getUnits().get(l)) ;
					 
				 }
				 }
			 break;
			 }}
	 }
	 
	 
	 
 }
 if(e.getActionCommand().equals("City unit")) {
	 if(((String)(gameview.getUnitsinfop().getSelectedItem())).equals("Enemy units")) {
		 JOptionPane.showMessageDialog(startView, "please choose enemy unit", "Error", JOptionPane.ERROR_MESSAGE);
	 }
	 if(((String)(gameview.getUnitsinfop().getSelectedItem())).equals("archer")) {
	 for(int b =0 ; b<g.getPlayer().getControlledArmies().size() ;b++ ) {
		 if(g.getPlayer().getControlledArmies().get(b).getDistancetoTarget()==0) {
			 helper_target = g.getPlayer().getControlledArmies().get(b).getTarget() ;
		 for(int l =0 ; l<g.getAvailableCities().size();l++) {
			
			 if(g.getAvailableCities().get(l).getName().equals(helper_target))  {
				for(int m =0 ; m< g.getAvailableCities().get(l).getDefendingArmy().getUnits().size() ; m++) { 
					if(g.getPlayer().getControlledArmies().get(b).getUnits().get(l) instanceof Archer)  {
						gameview.updatebattleviewenemy(g.getPlayer().getControlledArmies().get(b).getUnits().get(l));
					}
				 
			 }
				break;
			 }
			 }
		 }
		 
		 break;
		 }
		 
		 
		 
	 }
	 if(((String)(gameview.getUnitsinfop().getSelectedItem())).equals("cavalry")) {
		 for(int b =0 ; b<g.getPlayer().getControlledArmies().size() ;b++ ) {
			 if(g.getPlayer().getControlledArmies().get(b).getDistancetoTarget()==0) {
				 helper_target = g.getPlayer().getControlledArmies().get(b).getTarget() ;
			 for(int l =0 ; l<g.getAvailableCities().size();l++) {
				
				 if(g.getAvailableCities().get(l).getName().equals(helper_target))  {
					for(int m =0 ; m< g.getAvailableCities().get(l).getDefendingArmy().getUnits().size() ; m++) { 
						if(g.getPlayer().getControlledArmies().get(b).getUnits().get(l) instanceof Cavalry)  {
							gameview.updatebattleviewenemy(g.getPlayer().getControlledArmies().get(b).getUnits().get(l));
						}
					 
				 }
					break;
				 }
				 }
			 }
			 
			 break;
			 }
	 }
	 if(((String)(gameview.getUnitsinfop().getSelectedItem())).equals("infantry")) {
		 for(int b =0 ; b<g.getPlayer().getControlledArmies().size() ;b++ ) {
			 if(g.getPlayer().getControlledArmies().get(b).getDistancetoTarget()==0) {
				 helper_target = g.getPlayer().getControlledArmies().get(b).getTarget() ;
			 for(int l =0 ; l<g.getAvailableCities().size();l++) {
				
				 if(g.getAvailableCities().get(l).getName().equals(helper_target))  {
					for(int m =0 ; m< g.getAvailableCities().get(l).getDefendingArmy().getUnits().size() ; m++) { 
						if(g.getPlayer().getControlledArmies().get(b).getUnits().get(l) instanceof Infantry)  {
							gameview.updatebattleviewenemy(g.getPlayer().getControlledArmies().get(b).getUnits().get(l));
						}
					 
				 }
					break;
				 }
				 }
			 }
			 
			 break;
			 }
	 
	 
	 
 }
 
 }*/
 
// if(e.getActionCommand().equals("Player unit")) {
//	 if(((String)(gameview.getUnitsinfop().getSelectedItem())).equals("Player units")) {
//		 JOptionPane.showMessageDialog(startView, "please choose player unit", "Error", JOptionPane.ERROR_MESSAGE);
//	 }
//	 if(((String)(gameview.getUnitsinfop().getSelectedItem())).equals("archer 1")) {
		 
		 
//	 }
// }

 if (e.getActionCommand().equals("initiate Army") ) {

	 for(int i =0 ; i<g.getPlayer().getControlledCities().size() ; i++ ) {
		
			if (g.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals(helper_city.toLowerCase())) {
			
	 g.getPlayer().initiateArmy(g.getPlayer().getControlledCities().get(i),g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get((gameview.getDef().getSelectedIndex()-1)));
	 gameview.updatecityview(g.getPlayer().getControlledCities().get(i),g.getPlayer());
			} } gameview.updatearmystatus ( g );
			gameview.updatecomboboxes(g);
			}
 
 if(e.getActionCommand().equals("Relocate Unit")) {
	 
	 try {
		 
		((Army) gameview.getAvailablearmies().getSelectedItem()).relocateUnit((Unit)gameview.getAvailableunits().getSelectedItem());
		for(int i =0 ; i<g.getPlayer().getControlledCities().size() ; i++ ) {
			
			if (g.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals(helper_city.toLowerCase())) {
				gameview.updatecityview(g.getPlayer().getControlledCities().get(i), g.getPlayer());
				
				
			}}
		gameview.updatebattleview(g.getPlayer(), g);
		gameview.updatearmystatus(g);
		gameview.updatecomboboxes(g);
		
		
	} catch (MaxCapacityException e1) {
		
		JOptionPane.showMessageDialog(startView, "You have reached maximum capacity ", "Error", JOptionPane.ERROR_MESSAGE);
		
		
	}
 }
 if(e.getActionCommand().equals("set target")) {
	 //System.out.println("x");
	 System.out.println(gameview.getSetTarget().getText());
	 if(gameview.getTarget_city().getText().toLowerCase().equals("cairo")){
		 g.targetCity(((Army) gameview.getAvailablearmies().getSelectedItem()), "Cairo");
	 }
	 if(gameview.getTarget_city().getText().toLowerCase().equals("rome")){
		 g.targetCity(((Army) gameview.getAvailablearmies().getSelectedItem()), "Rome");
	 }
	 if(gameview.getTarget_city().getText().toLowerCase().equals("sparta")){
		 g.targetCity(((Army) gameview.getAvailablearmies().getSelectedItem()), "Sparta");
	 }
	 
	 
	 gameview.updateplayerinfo(g);
	 //gameview.updatearmystatus (g)	;
	// gameview.updatecityview(c, g.getPlayer());
	 //gameview.updatecomboboxes(g);
	 for(int i =0 ; i<g.getPlayer().getControlledCities().size() ; i++ ) {
			
			if (g.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals(helper_city.toLowerCase())) {
				gameview.updatecityview(g.getPlayer().getControlledCities().get(i), g.getPlayer());
				
				
			}}
		gameview.updatebattleview(g.getPlayer(), g);
		gameview.updatearmystatus(g);
		gameview.updatecomboboxes(g);}
 
 if(e.getActionCommand().equals("lay seige")) {
	 
 
	 if(gameview.getTarget_city().getText().toLowerCase().equals("cairo")){
		 
		 
		 
		 for(int b =0 ; b<g.getAvailableCities().size();b++) {
			 if(g.getAvailableCities().get(b).getName().equals("Cairo")) {
				 if(g.getAvailableCities().get(b).getTurnsUnderSiege()<3) {
		            
				 try {
						g.getPlayer().laySiege(((Army) gameview.getAvailablearmies().getSelectedItem()),g.getAvailableCities().get(b) );
					} catch (TargetNotReachedException | FriendlyCityException e1) {
						
						JOptionPane.showMessageDialog(startView, "You didn't reach target or the target is a friendly city ", "Error", JOptionPane.ERROR_MESSAGE);
					}}
				 else {
					 JOptionPane.showMessageDialog(startView, "You should battle ", "Error", JOptionPane.ERROR_MESSAGE);
				 }
	 }
		 }
		 }
	 if(gameview.getTarget_city().getText().toLowerCase().equals("rome")){
		 for(int b =0 ; b<g.getAvailableCities().size();b++) {
			 
			 
			 if(g.getAvailableCities().get(b).getName().equals("Rome")) {
				 if(g.getAvailableCities().get(b).getTurnsUnderSiege()<3) {
		             try {
						g.getPlayer().laySiege(((Army) gameview.getAvailablearmies().getSelectedItem()),g.getAvailableCities().get(b));
					} catch (TargetNotReachedException | FriendlyCityException e1) {
						JOptionPane.showMessageDialog(startView, "You didn't reach target or the target is a friendly city ", "Error", JOptionPane.ERROR_MESSAGE);
					}}
				 else {
					 JOptionPane.showMessageDialog(startView, "You should battle ", "Error", JOptionPane.ERROR_MESSAGE);
				 }
	 }
		 }
		 
		
	 }
	 if(gameview.getTarget_city().getText().toLowerCase().equals("sparta")){
		 for(int b =0 ; b<g.getAvailableCities().size();b++) {
			 if(g.getAvailableCities().get(b).getName().equals("Sparta")) {
				 if(g.getAvailableCities().get(b).getTurnsUnderSiege()<3) {
		             try {
						g.getPlayer().laySiege(((Army) gameview.getAvailablearmies().getSelectedItem()),g.getAvailableCities().get(b) );
					} catch (TargetNotReachedException | FriendlyCityException e1) {
						JOptionPane.showMessageDialog(startView, "You didn't reach target or the target is a friendly city ", "Error", JOptionPane.ERROR_MESSAGE);
					}}
				 else {
					 JOptionPane.showMessageDialog(startView, "You should battle ", "Error", JOptionPane.ERROR_MESSAGE);
				 }
	 }
		 }
		 
	 }
	 
	 gameview.updateplayerinfo(g);
	 //gameview.updatearmystatus (g)	;
	// gameview.updatecityview(c, g.getPlayer());
	 //gameview.updatecomboboxes(g);
	 for(int i =0 ; i<g.getPlayer().getControlledCities().size() ; i++ ) {
			
			if (g.getPlayer().getControlledCities().get(i).getName().toLowerCase().equals(helper_city.toLowerCase())) {
				gameview.updatecityview(g.getPlayer().getControlledCities().get(i), g.getPlayer());
				
				
			}}
		gameview.updatebattleview(g.getPlayer(), g);
		gameview.updatearmystatus(g);
		gameview.updatecomboboxes(g);}
 
	 
 }

 
 
 
public static void main (String [] args) {
	controller c = new controller ();
}
}

