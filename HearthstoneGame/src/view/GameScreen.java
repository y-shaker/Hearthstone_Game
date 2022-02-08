package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import engine.Game;
import exceptions.FullHandException;
import model.cards.minions.Icehowl;
import model.cards.minions.Minion;
import model.cards.spells.Spell;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;


public class GameScreen extends JFrame{

	private JLabel ScreenBackground;
	
	private JPanel oppHand;
	private JPanel currHand;
	
	private JButton currHeroPower ;
	
	private JPanel oppField;
	private JPanel currField;
	
	private JButton oppHero;
	//private JLabel oppHeroImage;
	private JPanel oppHeroHPPanel;
	private JTextField oppHeroHP;
	
	private JButton currHero;
	//private JLabel currHeroImage;
	private JPanel currHeroHPPanel;
	private JTextField currHeroHP;
	
	private JPanel oppDeck;
	private JTextField oppDeckRem;
	
	private JPanel currDeck;
	private JTextField currDeckRem;
	
	private JPanel currManaPanel;
	private JLabel currMana;
	private JTextField currManaT;
	
	private JPanel oppManaPanel;
	private JLabel oppMana;
	private JTextField oppManaT;
	
	private JButton EndTurnButton;
	
	private ArrayList<JButton> currHandButtons;
	private ArrayList<JButton> currFieldButtons;
	private ArrayList<JButton> oppFieldButtons;
	
	
	
	//private JPanel MinionStats;
	//private JTextArea minStats;
	//private JLabel Stats;
	
	public GameScreen()  {
		
	}
	public GameScreen(Hero curr,Hero opp){
		
		currHandButtons=new ArrayList<JButton>();
		currFieldButtons=new ArrayList<JButton>();
		oppFieldButtons=new ArrayList<JButton>();
		
		ImageIcon cHPow = null;
		ImageIcon cHero=null;
		
		UIManager.put("ToolTip.background", new ColorUIResource(63,63,63)); 
		UIManager.put("ToolTip.foreground", Color.white);
		UIManager.put("ToolTip.font", new Font("Andalus", Font.PLAIN, 16));
		UIManager.put("ToolTip.border",BorderFactory.createLineBorder(new Color(170,170,170)));
		
		
	    if (curr instanceof Hunter){
	    	 cHPow=new ImageIcon("images/RexxarHeroPower");
	    	 cHero = new ImageIcon("images/RexxarNew.png");
	    }
	    if (curr instanceof Mage){
	    	 cHPow=new ImageIcon("images/JainaHeroPower");
	    	 cHero = new ImageIcon("images/jainasNew.png");
	    }
	    if (curr instanceof Paladin){
	    	 cHPow=new ImageIcon("images/UtherHeroPower");
	    	 cHero = new ImageIcon("images/utherNew.png");
	    }
	    if (curr instanceof Priest){
	    	 cHPow=new ImageIcon("images/AnduinHeroPower");
	    	 cHero = new ImageIcon("images/AnduinNew.png");
	    }
	    if (curr instanceof Warlock){
	    	 cHPow=new ImageIcon("images/GuldanHeroPower");
	    	 cHero = new ImageIcon("images/GuldanNew.png");
	    }
	    
	    ImageIcon oHPow = null;
		ImageIcon oHero=null;
		
		if (opp instanceof Hunter){
	    	 oHPow=new ImageIcon("images/RexxarHeroPower");
	    	 oHero = new ImageIcon("images/RexxarNew.png");
	    }
	    if (opp instanceof Mage){
	    	 oHPow=new ImageIcon("images/JainaHeroPower");
	    	 oHero = new ImageIcon("images/jainasNew.png");
	    }
	    if (opp instanceof Paladin){
	    	 oHPow=new ImageIcon("images/UtherHeroPower");
	    	 oHero = new ImageIcon("images/utherNew.png");
	    }
	    if (opp instanceof Priest){
	    	 oHPow=new ImageIcon("images/AnduinHeroPower");
	    	 oHero = new ImageIcon("images/AnduinNew.png");
	    }
	    if (opp instanceof Warlock){
	    	 oHPow=new ImageIcon("images/GuldanHeroPower");
	    	 oHero = new ImageIcon("images/GuldanNew.png");
	    }
	    
		
		setTitle("Hearthstone: Heroes Of Warcraft");
		setBounds(100, 10, 1700,950);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		ImageIcon ss=new ImageIcon("images/Gb900pUp.jpg");
		ScreenBackground=new JLabel(ss);
		ScreenBackground.setPreferredSize(new Dimension(1680, 930));
		Font f = new Font("Book Antiqua",Font.BOLD,20);
		
		oppHand = new JPanel();
		FlowLayout layout = (FlowLayout)oppHand.getLayout();
		layout.setVgap(0);
		oppHand.setOpaque(false);
		oppHand.setBounds(0,0,1700,75);
		
		for(int i=0;i<opp.getHand().size();i++)
			addOppCard();
		
		ScreenBackground.add(oppHand);
		
		
		currHand = new JPanel();
		currHand.setOpaque(false);
		currHand.setBounds(0,778,1700,160);
		FlowLayout layout3 = (FlowLayout)currHand.getLayout();
		layout3.setVgap(0);
		for(int i = 0; i<curr.getHand().size();i++)                    
		{
			String x = curr.getHand().get(i).getName();
			JButton b = new JButton();
			b.setPreferredSize(new Dimension(150,165));
			b.setPreferredSize(new Dimension(150,165));
			b.setPreferredSize(new Dimension(150,165));
			switch(x)
			{
			case("Goldshire Footman"):     b.setIcon(new ImageIcon("images/Goldshire Footman.png"));break;
			case("Stonetusk Boar"):        b.setIcon(new ImageIcon("images/Stonetusk boar.png"));break;
			case("Bloodfen Raptor"):       b.setIcon(new ImageIcon("images/bloodfen Raptor.png"));break;
			case("Frostwolf Grunt"):       b.setIcon(new ImageIcon("images/Frostwolf grunt.png"));break;
			case("Wolfrider"):             b.setIcon(new ImageIcon("images/Wolfrider.png"));break;
			case("Chilwind Yeti"):         b.setIcon(new ImageIcon("images/Chillwind Yeti.png"));break;
			case("Boulderfist Ogre"):      b.setIcon(new ImageIcon("images/Boulderfist Ogre.png"));break;
			case("Core Hound"):            b.setIcon(new ImageIcon("images/core hound.png"));break;
			case("Argent Commander"):      b.setIcon(new ImageIcon("images/argent Commander.png"));break;
			case("Sunwalker"):             b.setIcon(new ImageIcon("images/Sunwalker.png"));break;
			case("Chromaggus"):            b.setIcon(new ImageIcon("images/chromaggus.png"));break;
			case("The LichKing"):          b.setIcon(new ImageIcon("images/lichking.png"));break;
			case("Icehowl"):               b.setIcon(new ImageIcon("images/Icehowl.png"));break;
			case("Colossus of the Moon"):  b.setIcon(new ImageIcon("images/colossus of the moon.png"));break;
			case("King Krush"):            b.setIcon(new ImageIcon("images/King Krush.png"));break;
			case("Wilfred Fizzlebang"):    b.setIcon(new ImageIcon("images/Wilfred Fizzlebang.png"));break;
			case("Kalycgos"):              b.setIcon(new ImageIcon("images/Kalycgos.png"));break;
			case("Prophet Velen"):         b.setIcon(new ImageIcon("images/Prophet Velen.png"));break;
			case("Silver Hand Recruit"):   b.setIcon(new ImageIcon("images/Silver_Hand_Recruit(268).png"));break;
			case("Holy Nova"):             b.setIcon(new ImageIcon("images/HolyNova.png"));break; 
			case("Curse of Weakness"):     b.setIcon(new ImageIcon("images/Curseofweakness.png"));break;
			case("Divine Spirit"):         b.setIcon(new ImageIcon("images/Divinespirit.png"));break;
			case("Flamestrike"):           b.setIcon(new ImageIcon("images/flamestrike.png"));break;
			case("Kill Command"):          b.setIcon(new ImageIcon("images/KillCommand.png"));break;
			case("Level Up!"):             b.setIcon(new ImageIcon("images/LevelUp.png"));break;
			case("Multi-Shot"):            b.setIcon(new ImageIcon("images/MultiShot.png"));break;
			case("Polymorph"):             b.setIcon(new ImageIcon("images/Polymorph.png"));break;
			case("Pyroblast"):             b.setIcon(new ImageIcon("images/Pyroblast.png"));break;
			case("Seal of Champions"):     b.setIcon(new ImageIcon("images/Sealofchampions.png"));break;
			case("Shadow Word: Death"):    b.setIcon(new ImageIcon("images/ShadowWordDeath.png"));break;
			case("Siphon Soul"):           b.setIcon(new ImageIcon("images/siphonsoul.png"));break;
			case("Twisting Nether"):       b.setIcon(new ImageIcon("images/twistingNether.png"));break;
			case("Tirion Fordring"):       b.setIcon(new ImageIcon("images/Tirion.png"));break;
			case("Sheep"):                 b.setIcon(new ImageIcon("images/Sheep.png"));break;
			}
			b.setOpaque(false);
			b.setBorderPainted(false);
			b.setContentAreaFilled(false);
			
			
			if(curr.getHand().get(i) instanceof Minion)
				
				b.setToolTipText("<html>"+"Attack:"+"<br>"+((Minion) curr.getHand().get(i)).getAttack()+"<br>"
				                 +"Health: "+"<br>"+((Minion) curr.getHand().get(i)).getCurrentHP()+"/"+((Minion)curr.getHand().get(i)).getMaxHP()
				                 +"<br>"+((Minion)curr.getHand().get(i)).getRarity().toString()
				                 +"<br>"+"Divine Shield: "+((Minion)curr.getHand().get(i)).isDivine()+"</html>");
			
			b.setActionCommand("CurrHand");
				
		    currHandButtons.add(b);
				
			    currHand.add(b);
			    
			    if(curr.getHand().get(i) instanceof Spell)
					 b.setToolTipText("Spell Rarity: "+curr.getHand().get(i).getRarity().toString());
		}
		ScreenBackground.add(currHand);
		
		
		
		currHeroPower = new JButton(cHPow);
		currHeroPower.setActionCommand("CurrHeroPower");
		currHeroPower.setBounds(930,590,150,200);
		currHeroPower.setOpaque(false);
		currHeroPower.setOpaque(false);
		currHeroPower.setBorderPainted(false);
		currHeroPower.setContentAreaFilled(false);
		currHeroPower.setFocusPainted(false);
		currHeroPower.setToolTipText("Use Hero Power");
		ScreenBackground.add(currHeroPower);
		
		oppField = new JPanel();
		oppField.setOpaque(false);
		oppField.setBounds(240,240,1200,180);
		for(int i = 0; i<opp.getField().size();i++)                    
		{
			String x = opp.getField().get(i).getName();
			
			JButton b = new JButton();
			b.setPreferredSize(new Dimension(150,165));
			b.setPreferredSize(new Dimension(150,165));
			b.setPreferredSize(new Dimension(150,165));
			switch(x)
			{
			case("Goldshire Footman"):     b.setIcon(new ImageIcon("images/Goldshire Footman.png"));break;
			case("Stonetusk Boar"):        b.setIcon(new ImageIcon("images/Stonetusk boar.png"));break;
			case("Bloodfen Raptor"):       b.setIcon(new ImageIcon("images/bloodfen Raptor.png"));break;
			case("Frostwolf Grunt"):       b.setIcon(new ImageIcon("images/Frostwolf grunt.png"));break;
			case("Wolfrider"):             b.setIcon(new ImageIcon("images/Wolfrider.png"));break;
			case("Chilwind Yeti"):         b.setIcon(new ImageIcon("images/Chillwind Yeti.png"));break;
			case("Boulderfist Ogre"):      b.setIcon(new ImageIcon("images/Boulderfist Ogre.png"));break;
			case("Core Hound"):            b.setIcon(new ImageIcon("images/core hound.png"));break;
			case("Argent Commander"):      b.setIcon(new ImageIcon("images/argent Commander.png"));break;
			case("Sunwalker"):             b.setIcon(new ImageIcon("images/Sunwalker.png"));break;
			case("Chromaggus"):            b.setIcon(new ImageIcon("images/chromaggus.png"));break;
			case("The LichKing"):          b.setIcon(new ImageIcon("images/lichking.png"));break;
			case("Icehowl"):               b.setIcon(new ImageIcon("images/Icehowl.png"));break;
			case("Colossus of the Moon"):  b.setIcon(new ImageIcon("images/colossus of the moon.png"));break;
			case("King Krush"):            b.setIcon(new ImageIcon("images/King Krush.png"));break;
			case("Wilfred Fizzlebang"):    b.setIcon(new ImageIcon("images/Wilfred Fizzlebang.png"));break;
			case("Kalycgos"):              b.setIcon(new ImageIcon("images/Kalycgos.png"));break;
			case("Prophet Velen"):         b.setIcon(new ImageIcon("images/Prophet Velen.png"));break;
			case("Silver Hand Recruit"):   b.setIcon(new ImageIcon("images/Silver_Hand_Recruit(268).png"));break;
			case("Holy Nova"):             b.setIcon(new ImageIcon("images/HolyNova.png"));break; 
			case("Curse of Weakness"):     b.setIcon(new ImageIcon("images/Curseofweakness.png"));break;
			case("Divine Spirit"):         b.setIcon(new ImageIcon("images/Divinespirit.png"));break;
			case("Flamestrike"):           b.setIcon(new ImageIcon("images/flamestrike.png"));break;
			case("Kill Command"):          b.setIcon(new ImageIcon("images/KillCommand.png"));break;
			case("Level Up!"):             b.setIcon(new ImageIcon("images/LevelUp.png"));break;
			case("Multi-Shot"):            b.setIcon(new ImageIcon("images/MultiShot.png"));break;
			case("Polymorph"):             b.setIcon(new ImageIcon("images/Polymorph.png"));break;
			case("Pyroblast"):             b.setIcon(new ImageIcon("images/Pyroblast.png"));break;
			case("Seal of Champions"):     b.setIcon(new ImageIcon("images/Sealofchampions.png"));break;
			case("Shadow Word: Death"):    b.setIcon(new ImageIcon("images/ShadowWordDeath.png"));break;
			case("Siphon Soul"):           b.setIcon(new ImageIcon("images/siphonsoul.png"));break;
			case("Twisting Nether"):       b.setIcon(new ImageIcon("images/twistingNether.png"));break;
			case("Tirion Fordring"):       b.setIcon(new ImageIcon("images/Tirion.png"));break;
			case("Sheep"):                 b.setIcon(new ImageIcon("images/Sheep.png"));break;
			} 
			b.setOpaque(false);
			b.setBorderPainted(false);
			b.setContentAreaFilled(false);
			
			if(opp.getField().get(i) instanceof Minion)
			{
				if(((Minion) opp.getField().get(i)).isSleeping())
					b.setToolTipText("<html>"+"Attack:"+"<br>"+((Minion) opp.getField().get(i)).getAttack()
							+"<br>"+"Health: "+"<br>"+((Minion) opp.getField().get(i)).getCurrentHP()+"/"+((Minion)opp.getField().get(i)).getMaxHP()
							+"<br>"+"Sleeping..."
							+ "<br>"+"Divine Shield: "+((Minion)opp.getField().get(i)).isDivine()+"</html>");
					
				else
					b.setToolTipText("<html>"+"Attack:"+"<br>"+((Minion) opp.getField().get(i)).getAttack()
							+"<br>"+"Health: "+"<br>"+((Minion) opp.getField().get(i)).getCurrentHP()+"/"+((Minion)opp.getField().get(i)).getMaxHP()
							+ "<br>"+"Divine Shield: "+((Minion)opp.getField().get(i)).isDivine()+"</html>");
			}
			b.setActionCommand("OppField");
			
			oppFieldButtons.add(b);
			
			oppField.add(b);
		}
		ScreenBackground.add(oppField);
		
		currField = new JPanel();
		currField.setOpaque(false);
		currField.setBounds(240,400,1200,180);
		for(int i = 0; i<curr.getField().size();i++)                    
		{
			String x = curr.getField().get(i).getName();
			JButton b = new JButton();
			b.setPreferredSize(new Dimension(150,165));
			b.setPreferredSize(new Dimension(150,165));
			b.setPreferredSize(new Dimension(150,165));
			switch(x)
			{
			case("Goldshire Footman"):     b.setIcon(new ImageIcon("images/Goldshire Footman.png"));break;
			case("Stonetusk Boar"):        b.setIcon(new ImageIcon("images/Stonetusk boar.png"));break;
			case("Bloodfen Raptor"):       b.setIcon(new ImageIcon("images/bloodfen Raptor.png"));break;
			case("Frostwolf Grunt"):       b.setIcon(new ImageIcon("images/Frostwolf grunt.png"));break;
			case("Wolfrider"):             b.setIcon(new ImageIcon("images/Wolfrider.png"));break;
			case("Chilwind Yeti"):         b.setIcon(new ImageIcon("images/Chillwind Yeti.png"));break;
			case("Boulderfist Ogre"):      b.setIcon(new ImageIcon("images/Boulderfist Ogre.png"));break;
			case("Core Hound"):            b.setIcon(new ImageIcon("images/core hound.png"));break;
			case("Argent Commander"):      b.setIcon(new ImageIcon("images/argent Commander.png"));break;
			case("Sunwalker"):             b.setIcon(new ImageIcon("images/Sunwalker.png"));break;
			case("Chromaggus"):            b.setIcon(new ImageIcon("images/chromaggus.png"));break;
			case("The LichKing"):          b.setIcon(new ImageIcon("images/lichking.png"));break;
			case("Icehowl"):               b.setIcon(new ImageIcon("images/Icehowl.png"));break;
			case("Colossus of the Moon"):  b.setIcon(new ImageIcon("images/colossus of the moon.png"));break;
			case("King Krush"):            b.setIcon(new ImageIcon("images/King Krush.png"));break;
			case("Wilfred Fizzlebang"):    b.setIcon(new ImageIcon("images/Wilfred Fizzlebang.png"));break;
			case("Kalycgos"):              b.setIcon(new ImageIcon("images/Kalycgos.png"));break;
			case("Prophet Velen"):         b.setIcon(new ImageIcon("images/Prophet Velen.png"));break;
			case("Silver Hand Recruit"):   b.setIcon(new ImageIcon("images/Silver_Hand_Recruit(268).png"));break;
			case("Holy Nova"):             b.setIcon(new ImageIcon("images/HolyNova.png"));break; 
			case("Curse of Weakness"):     b.setIcon(new ImageIcon("images/Curseofweakness.png"));break;
			case("Divine Spirit"):         b.setIcon(new ImageIcon("images/Divinespirit.png"));break;
			case("Flamestrike"):           b.setIcon(new ImageIcon("images/flamestrike.png"));break;
			case("Kill Command"):          b.setIcon(new ImageIcon("images/KillCommand.png"));break;
			case("Level Up!"):             b.setIcon(new ImageIcon("images/LevelUp.png"));break;
			case("Multi-Shot"):            b.setIcon(new ImageIcon("images/MultiShot.png"));break;
			case("Polymorph"):             b.setIcon(new ImageIcon("images/Polymorph.png"));break;
			case("Pyroblast"):             b.setIcon(new ImageIcon("images/Pyroblast.png"));break;
			case("Seal of Champions"):     b.setIcon(new ImageIcon("images/Sealofchampions.png"));break;
			case("Shadow Word: Death"):    b.setIcon(new ImageIcon("images/ShadowWordDeath.png"));break;
			case("Siphon Soul"):           b.setIcon(new ImageIcon("images/siphonsoul.png"));break;
			case("Twisting Nether"):       b.setIcon(new ImageIcon("images/twistingNether.png"));break;
			case("Tirion Fordring"):       b.setIcon(new ImageIcon("images/Tirion.png"));break;
			case("Sheep"):                 b.setIcon(new ImageIcon("images/Sheep.png"));break;
			}
			b.setOpaque(false);
			b.setBorderPainted(false);
			b.setContentAreaFilled(false);
			
			if(curr.getField().get(i) instanceof Minion)
			{
				
				if(((Minion) curr.getField().get(i)).isSleeping())
					b.setToolTipText("<html>"+"Attack:"+"<br>"+((Minion) curr.getField().get(i)).getAttack()+"<br>"
			         +"Health: "+"<br>"+((Minion) curr.getField().get(i)).getCurrentHP()+"/"+((Minion)curr.getField().get(i)).getMaxHP()
			         +"<br>"+"Sleeping..."
			         + "<br>"+"Divine Shield: "+((Minion)curr.getField().get(i)).isDivine()+"</html>");
					
				else
					b.setToolTipText("<html>"+"Attack:"+"<br>"+((Minion) curr.getField().get(i)).getAttack()+"<br>"
					         +"Health: "+"<br>"+((Minion) curr.getField().get(i)).getCurrentHP()+"/"+((Minion)curr.getField().get(i)).getMaxHP()
					         + "<br>"+"Divine Shield: "+((Minion)curr.getField().get(i)).isDivine()+"</html>");
				
				
			}	
		
			b.setActionCommand("CurrField");
			
			currFieldButtons.add(b);
			
			currField.add(b);
		}
		ScreenBackground.add(currField);
		
		oppHero = new JButton(oHero);
		oppHero.setBounds(760,80,180,200);
		oppHero.setActionCommand("Hero");
		oppHero.setOpaque(false);
		oppHero.setBorderPainted(false);
		oppHero.setContentAreaFilled(false);
		oppHero.setFocusPainted(false);
		
		
		oppHeroHPPanel =new JPanel();
		oppHeroHPPanel.setOpaque(false);
		oppHeroHPPanel.setBounds(903,200,28,28);
		oppHeroHP = new JTextField(Integer.toString(opp.getCurrentHP()));
		oppHeroHP.setToolTipText("Your Opponent's Remaining Health");
		oppHeroHP.setForeground(Color.WHITE);
		oppHeroHP.setEditable(false);
		oppHeroHP.setFont(f);
		oppHeroHP.setOpaque(false);
		oppHeroHP.setBorder(null);
		oppHeroHPPanel.add(oppHeroHP);
		ScreenBackground.add(oppHeroHPPanel);
		
		
		ScreenBackground.add(oppHero);
		
		
		currHero = new JButton(cHero);
		
		currHero.setBounds(760,550,180,250);
		currHero.setActionCommand("Hero");
		currHero.setOpaque(false);
		currHero.setBorderPainted(false);
		currHero.setContentAreaFilled(false);
		currHero.setFocusPainted(false);
		
		
		
		currHeroHPPanel = new JPanel();
		currHeroHPPanel.setOpaque(false);
		currHeroHPPanel.setBounds(903,697,28,28);
		currHeroHP = new JTextField(Integer.toString(curr.getCurrentHP()));
		currHeroHP.setToolTipText("Your Remaining Health");
		currHeroHP.setForeground(Color.WHITE);
		currHeroHP.setEditable(false);
		currHeroHP.setFont(f);
		currHeroHP.setOpaque(false);
		currHeroHP.setBorder(null);
		currHeroHPPanel.add(currHeroHP);
		ScreenBackground.add(currHeroHPPanel);
		
		ScreenBackground.add(currHero);
		
		oppDeck = new JPanel();
		oppDeck.setOpaque(false);
		oppDeckRem = new JTextField(Integer.toString(opp.getDeck().size()));
		oppDeckRem.setEditable(false);
		oppDeckRem.setFont(f);
		oppDeckRem.setOpaque(false);
		oppDeckRem.setBorder(null);
		oppDeck.setBounds(1490,240,50,50);
		oppDeckRem.setToolTipText("Cards remaining in your opponent's deck");
		oppDeck.add(oppDeckRem);
		ScreenBackground.add(oppDeck);
		
		currDeck = new JPanel();
		currDeck.setOpaque(false);
		currDeckRem = new JTextField(Integer.toString(curr.getDeck().size()));
		currDeckRem.setEditable(false);
		currDeckRem.setFont(f);
		currDeckRem.setOpaque(false);
		currDeckRem.setBorder(null);
		currDeckRem.setToolTipText("Cards remaining in your deck");
		currDeck.add(currDeckRem);
		currDeck.setBounds(1495,490,50,50);
		ScreenBackground.add(currDeck);
		
		JPanel EndTurnPanel = new JPanel();
		EndTurnPanel.setBounds(1365,360,135,50);
		EndTurnPanel.setOpaque(false);
		EndTurnButton = new JButton();
		EndTurnButton.setActionCommand("EndTurn");
		EndTurnButton.setPreferredSize(new Dimension(135,50));
		EndTurnButton.setOpaque(false);
		EndTurnButton.setBorderPainted(false);
		EndTurnButton.setContentAreaFilled(false);
		EndTurnPanel.add(EndTurnButton);
		ScreenBackground.add(EndTurnPanel);
		
		currManaPanel= new  JPanel();
		currManaPanel.setBounds(605,660,120,50);
		currManaPanel.setOpaque(false);
		currMana=new JLabel();
		currMana.setIcon(new ImageIcon("images/smallmana.png"));
		currManaPanel.add(currMana);
		currManaT=new JTextField(curr.getCurrentManaCrystals() +" / " + curr.getTotalManaCrystals());
		currManaT.setToolTipText("Your Mana Crystals");
		currManaT.setForeground(Color.WHITE);
		currManaT.setEditable(false);
		currManaT.setFont(f);
		currManaT.setOpaque(false);
		currManaT.setBorder(null);
		currManaPanel.add(currManaT);
		ScreenBackground.add(currManaPanel);
		
		oppManaPanel= new  JPanel();
		oppManaPanel.setBounds(605,150,120,50);
		oppManaPanel.setOpaque(false);
		oppMana=new JLabel();
		oppMana.setIcon(new ImageIcon("images/smallmana.png"));
		oppManaPanel.add(oppMana);
		oppManaT=new JTextField(opp.getCurrentManaCrystals() +" / " + opp.getTotalManaCrystals());
		oppManaT.setToolTipText("Your Opponent's Mana Crystals");
		oppManaT.setForeground(Color.WHITE);
		oppManaT.setEditable(false);
		oppManaT.setFont(f);
		oppManaT.setOpaque(false);
		oppManaT.setBorder(null);
		oppManaPanel.add(oppManaT);
		ScreenBackground.add(oppManaPanel);
		
		add(ScreenBackground);
		
		
		
		
		
		    pack(); 
		    setResizable(false);
		    setVisible(true);
		    revalidate();
		    repaint();
	}
	
	public void addOppCard(){
		oppHand.add(new JLabel(new ImageIcon("images/CardBack2HalfUp.png")));
	}
	
	
	
	public JLabel getScreenBackground() {
		return ScreenBackground;
	}
	
	public ArrayList<JButton> getCurrHandButtons() {
		return currHandButtons;
	}
	public ArrayList<JButton> getCurrFieldButtons() {
		return currFieldButtons;
	}
	public ArrayList<JButton> getOppFieldButtons() {
		return oppFieldButtons;
	}

	public void setScreenBackground(JLabel ScreenBackground) {
		this.ScreenBackground = ScreenBackground;
	}

	public JPanel getOppHand() {
		return oppHand;
	}

	public void setOppHand(JPanel oppHand) {
		this.oppHand = oppHand;
	}

	public JPanel getCurrHand() {
		return currHand;
	}

	public void setCurrHand(JPanel currHand) {
		this.currHand = currHand;
	}

	public JButton getCurrHeroPower() {
		return currHeroPower;
	}

	public void setCurrHeroPower(JButton currHeroPower) {
		this.currHeroPower = currHeroPower;
	}

	public JPanel getOppField() {
		return oppField;
	}

	public void setOppField(JPanel oppField) {
		this.oppField = oppField;
	}

	public JPanel getCurrField() {
		return currField;
	}

	public void setCurrField(JPanel currField) {
		this.currField = currField;
	}

	public JButton getOppHero() {
		return oppHero;
	}

	public void setOppHero(JButton oppHero) {
		this.oppHero = oppHero;
	}


	public JPanel getOppHeroHPPanel() {
		return oppHeroHPPanel;
	}

	public void setOppHeroHPPanel(JPanel oppHeroHPPanel) {
		this.oppHeroHPPanel = oppHeroHPPanel;
	}

	public JTextField getOppHeroHP() {
		return oppHeroHP;
	}

	public void setOppHeroHP(JTextField oppHeroHP) {
		this.oppHeroHP = oppHeroHP;
	}

	public JButton getCurrHero() {
		return currHero;
	}

	public void setCurrHero(JButton currHero) {
		this.currHero = currHero;
	}


	public JPanel getCurrHeroHPPanel() {
		return currHeroHPPanel;
	}

	public void setCurrHeroHPPanel(JPanel currHeroHPPanel) {
		this.currHeroHPPanel = currHeroHPPanel;
	}

	public JTextField getCurrHeroHP() {
		return currHeroHP;
	}

	public void setCurrHeroHP(JTextField currHeroHP) {
		this.currHeroHP = currHeroHP;
	}

	public JPanel getOppDeck() {
		return oppDeck;
	}

	public void setOppDeck(JPanel oppDeck) {
		this.oppDeck = oppDeck;
	}

	public JTextField getOppDeckRem() {
		return oppDeckRem;
	}

	public void setOppDeckRem(JTextField oppDeckRem) {
		this.oppDeckRem = oppDeckRem;
	}

	public JPanel getCurrDeck() {
		return currDeck;
	}

	public void setCurrDeck(JPanel currDeck) {
		this.currDeck = currDeck;
	}

	public JTextField getCurrDeckRem() {
		return currDeckRem;
	}

	public void setCurrDeckRem(JTextField currDeckRem) {
		this.currDeckRem = currDeckRem;
	}

	public JPanel getCurrManaPanel() {
		return currManaPanel;
	}

	public void setCurrManaPanel(JPanel currManaPanel) {
		this.currManaPanel = currManaPanel;
	}

	public JLabel getCurrMana() {
		return currMana;
	}

	public void setCurrMana(JLabel currMana) {
		this.currMana = currMana;
	}

	public JTextField getCurrManaT() {
		return currManaT;
	}

	public void setCurrManaT(JTextField currManaT) {
		this.currManaT = currManaT;
	}

	public JPanel getOppManaPanel() {
		return oppManaPanel;
	}

	public void setOppManaPanel(JPanel oppManaPanel) {
		this.oppManaPanel = oppManaPanel;
	}

	public JLabel getOppMana() {
		return oppMana;
	}

	public void setOppMana(JLabel oppMana) {
		this.oppMana = oppMana;
	}

	public JTextField getOppManaT() {
		return oppManaT;
	}

	public void setOppManaT(JTextField oppManaT) {
		this.oppManaT = oppManaT;
	}
	public JButton getEndTurnButton() {
		return EndTurnButton;
	}
	public void setEndTurnButton(JButton endTurnButton) {
		EndTurnButton = endTurnButton;
	}

	public static void main(String[] args) throws IOException, CloneNotSupportedException, FullHandException {
		
		Hero rex=new Hunter();
		Hero uth=new Paladin();
		Minion m= new Icehowl();
		rex.getField().add(m);
		uth.getField().add(m);
		Game game=new Game(rex,uth);
		GameScreen sc=new GameScreen(game.getCurrentHero(),game.getOpponent());
		
		
	}
	
	
	
}
