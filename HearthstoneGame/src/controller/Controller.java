package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.stage.WindowEvent;

import javax.management.timer.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.AOESpell;
import model.cards.spells.FieldSpell;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.LeechingSpell;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.Spell;
import model.heroes.*;
import view.*;
import engine.Game;
import engine.GameListener;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;

public class Controller implements ActionListener,GameListener{
	private Game game;
	private SummonConfirm summon;
	private CastConfirm cast;
	private HeroScreen1 heroscreen1;
	private HeroScreen2 heroscreen2;
	private StartScreen startscreen;
	private TrailerScreen trailerscreen;
	private GameScreen gamescreen;
	private ExceptionWindow exceptionwindow;
	private Hero p1;
	private Hero p2;
	boolean fh ;
	boolean sh ;
	boolean gf;
	boolean ew;
	boolean mageFlag;
	boolean priestFlag;
	private Clip clip; 
	private JButton selected=null;
	private Spell selectedSpell=null;
	private Minion attacking = null;
	private Victory v=null;


	public Controller(){
    mageFlag = false;
    priestFlag=false;
	ew = false;
                                                         
    playSoundLoop("sounds/MainMenuWav.wav");
    summon = new SummonConfirm();
    cast = new CastConfirm();
    startscreen = new StartScreen();
	heroscreen1 = new HeroScreen1();
	heroscreen2 = new HeroScreen2();
	exceptionwindow=new ExceptionWindow();
	
	fh = true;
	sh = true;
	gf = false;
	
	
	
	
	exceptionwindow.addConfirmListener(this);
	summon.addConfirmListener(this);
	cast.addConfirmListener(this);
	
	
	JButton sb = startscreen.getStart();
	sb.addActionListener(this);
	for(int i=0;i<heroscreen1.getHeroes().size();i++){
		JButton b = heroscreen1.getHeroes().get(i);
		b.addActionListener(this);
		}
	for(int i=0;i<heroscreen2.getHeroes().size();i++){
			JButton b = heroscreen2.getHeroes().get(i);
			b.addActionListener(this);	
	}
    try {
		TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	playSound("sounds/VO_INNKEEPER_WELCOME1_16.wav");
    
}

	@Override
	public void actionPerformed(ActionEvent a){
		
		
			
		
		JButton b = (JButton) a.getSource();
		
		if(b.getActionCommand().equals("Skip"))
		{
		playSound("sounds/AdventurePanel_down.wav");
		trailerscreen.dispose();
		startscreen.setVisible(true);
		}
		
		if(b.getActionCommand().equals("Start"))
		{
			
			playSound("sounds/AdventurePanel_down.wav");
			startscreen.dispose();
			heroscreen1.setVisible(true);
			}
		if(fh){
		
			int x = heroscreen1.getHeroes().indexOf(b);
			switch(x)
			{
			case(0): try {
					p1 = new Hunter();playSound("sounds/Hub_Click.wav");
					playSound("sounds/VO_ANNOUNCER_REXXAR_08.wav");
					 try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					fh = false;heroscreen1.dispose();heroscreen2.setVisible(true);break;
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			case(1):try {
					p1 = new Mage();playSound("sounds/Hub_Click.wav");
					playSound("sounds/VO_ANNOUNCER_JAINA_06.wav");
					 try {
							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					fh = false;heroscreen1.dispose();heroscreen2.setVisible(true);break;
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			case(2):try {
					p1 = new Paladin();playSound("sounds/Hub_Click.wav");
					playSound("sounds/VO_ANNOUNCER_UTHER_10.wav");
					 try {
							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					fh = false;heroscreen1.dispose();heroscreen2.setVisible(true);break;
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			case(3):try {
					p1 = new Priest();playSound("sounds/Hub_Click.wav");
					playSound("sounds/VO_ANNOUNCER_ANDUIN_12.wav");
					 try {
							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					fh = false;heroscreen1.dispose();heroscreen2.setVisible(true);break;
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			case(4):try {
					p1 = new Warlock();playSound("sounds/Hub_Click.wav");
					playSound("sounds/VO_ANNOUNCER_GUL'DAN_13.wav");
					 try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					fh = false;heroscreen1.dispose();heroscreen2.setVisible(true);break;
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			
			
			}
		}
		
		
			
			
			
			else
				if(sh && !fh){
			
				
				
				int y = heroscreen2.getHeroes().indexOf(b);
				switch(y)
				{
				case(0): try {
					p2 = new Hunter();playSound("sounds/Hub_Click.wav");
					playSound("sounds/VO_ANNOUNCER_REXXAR_08.wav");
					
					
					 try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					sh = false;heroscreen2.dispose();break;
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			case(1):try {
				   p2 = new Mage();playSound("sounds/Hub_Click.wav");
				   playSound("sounds/VO_ANNOUNCER_JAINA_06.wav");
				   try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   sh = false;heroscreen2.dispose();break;
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			case(2):try {
				   p2 = new Paladin();playSound("sounds/Hub_Click.wav");
				   playSound("sounds/VO_ANNOUNCER_UTHER_10.wav");
				   try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   sh = false;heroscreen2.dispose();break;
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			case(3):try {
				   p2 = new Priest();playSound("sounds/Hub_Click.wav");
				   playSound("sounds/VO_ANNOUNCER_ANDUIN_12.wav");
				   try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   sh = false;heroscreen2.dispose();break;
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			case(4):try {
				   p2 = new Warlock();playSound("sounds/Hub_Click.wav");
				   playSound("sounds/VO_ANNOUNCER_GUL'DAN_13.wav");
				   try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   sh = false;heroscreen2.dispose();break;
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
				}
			
			
			
			if(!fh && !sh)
			{
				gf = true;
				sh =true;
			    stopSoundLoop();
			    playSoundLoop("sounds/GameMusic.wav");
				try {
					
					game = new Game(p1,p2);
					game.setListener(this);
				
				} catch (FullHandException | CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
			    gamescreen.setVisible(true);
			    
			    JButton g = gamescreen.getEndTurnButton();
				g.addActionListener(this);
				
				for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
					gamescreen.getCurrHandButtons().get(i).addActionListener(this);
			
				for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
					gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
				
				for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
					gamescreen.getOppFieldButtons().get(i).addActionListener(this);
				
				JButton chp = gamescreen.getCurrHeroPower();
				chp.addActionListener(this);
				
				JButton ch = gamescreen.getCurrHero();
				JButton oh = gamescreen.getOppHero();
				ch.addActionListener(this);
				oh.addActionListener(this);
			
			}
			
			
		if(b.getActionCommand().equals("EndTurn"))
		{
			
				try {
					playSound("sounds/AdventurePanel_down.wav");
					game.endTurn();
					
				} catch (FullHandException  e) {
					exceptionwindow.setMsg(e.getMessage());
					exceptionwindow.setbr("Burned: "+((FullHandException)e).getBurned().getName()+", "
					+((FullHandException)e).getBurned().getManaCost()+", "+((FullHandException)e).getBurned().getRarity());
					ew=true;
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gamescreen.dispose();
				if(game.getOpponent().getCurrentHP()==0)
				{
					gamescreen.setVisible(false);
					stopSoundLoop();
					v=new Victory(game.getCurrentHero());
					v.addConfirmListener(this);
					v.setVisible(true);
				}
				else
				{
				gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
				 JButton g = gamescreen.getEndTurnButton();
					g.addActionListener(this);
			    }
				
				 if(ew){exceptionwindow.setVisible(true);ew=false;}
				
				
				for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
				gamescreen.getCurrHandButtons().get(i).addActionListener(this);
				
			    for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
				gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
			
			    for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
				gamescreen.getOppFieldButtons().get(i).addActionListener(this);
			    
			    JButton chp = gamescreen.getCurrHeroPower();
				chp.addActionListener(this);
				
				JButton ch = gamescreen.getCurrHero();
				JButton oh = gamescreen.getOppHero();
				ch.addActionListener(this);
				oh.addActionListener(this);
				
				
		}
				
		if(selected==null && b.getActionCommand().equals("CurrHand"))
		{	
			playSound("sounds/UI_MouseClick_01.wav");
			int r = gamescreen.getCurrHandButtons().indexOf(b);
			Card c=game.getCurrentHero().getHand().get(r);
			selected = b;
			if(c instanceof MinionTargetSpell)
				selectedSpell = ((Spell)c);
			if(c instanceof LeechingSpell)
			//{
				selectedSpell = ((Spell)c);
			//}
			if(c instanceof Minion)
				summon.setVisible(true);
			else
				cast.setVisible(true);
			
		}
		if(b.getActionCommand().equals("Cancel"))
		{
			playSound("sounds/UI_MouseClick_01.wav");
			cast.setVisible(false);
			summon.setVisible(false);
			selected = null;
			selectedSpell = null;
		}
		
		if(b.getActionCommand().equals("ok"))
		{
			playSound("sounds/UI_MouseClick_01.wav");
			exceptionwindow.setVisible(false);
		}
		
		
		
		if(selected !=null && b.getActionCommand().equals("Confirm"))
				{
					  
					playSound("sounds/UI_MouseClick_01.wav");
					int r = gamescreen.getCurrHandButtons().indexOf(selected);
					Card c=game.getCurrentHero().getHand().get(r);
					if(c instanceof Minion)
					{
						
						try {
							game.getCurrentHero().playMinion((Minion)c);
							
						} catch (NotYourTurnException | NotEnoughManaException
								| FullFieldException e) {
							ew=true;
							exceptionwindow.setMsg(e.getMessage());
							
						}
					}
					if (c instanceof FieldSpell)
						try {
							game.getCurrentHero().castSpell((FieldSpell)c);
						} catch (NotYourTurnException | NotEnoughManaException e) {
							ew=true;
							exceptionwindow.setMsg(e.getMessage());
							
						}
					
					if (c instanceof AOESpell)
						try {
							game.getCurrentHero().castSpell((AOESpell)c,game.getOpponent().getField());
							
						} catch (NotYourTurnException | NotEnoughManaException e) {
							// TODO Auto-generated catch block
							ew=true;
							exceptionwindow.setMsg(e.getMessage());
						}
					
					cast.setVisible(false);
					summon.setVisible(false);
					gamescreen.dispose();
					if(game.getOpponent().getCurrentHP()==0)
					{
						gamescreen.setVisible(false);
						v=new Victory(game.getCurrentHero());
						v.addConfirmListener(this);
						v.setVisible(true);
					}
					else
					{
					gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
					 JButton g = gamescreen.getEndTurnButton();
						g.addActionListener(this);
				    }
		
				    if(ew){exceptionwindow.setVisible(true);ew=false;}
				    
				    if(game.getCurrentHero().getCurrentManaCrystals()==0)
				    	playSound("sounds/VO_JobsDone.wav");
						
						for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
							gamescreen.getCurrHandButtons().get(i).addActionListener(this);
					
						for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
							gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
						
						for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
							gamescreen.getOppFieldButtons().get(i).addActionListener(this);
						JButton chp = gamescreen.getCurrHeroPower();
						chp.addActionListener(this);
						JButton ch = gamescreen.getCurrHero();
						JButton oh = gamescreen.getOppHero();
						ch.addActionListener(this);
						oh.addActionListener(this);
					
				
						selected = null;
				}
				
				if(b.getActionCommand().equals("CurrField") && attacking == null)
				{
					playSound("sounds/UI_MouseClick_01.wav");
					int r = gamescreen.getCurrFieldButtons().indexOf(b);
					Minion c=game.getCurrentHero().getField().get(r);
					attacking = c;
				}
				
				if(b.getActionCommand().equals("Hero") && attacking != null)
				{
					try {
						playSound("sounds/UI_MouseClick_01.wav");
						game.getCurrentHero().attackWithMinion(attacking, game.getOpponent());
					} catch (CannotAttackException | NotYourTurnException
							| TauntBypassException | NotSummonedException
							| InvalidTargetException e) {
						ew=true;
						exceptionwindow.setMsg(e.getMessage());
						
					}	
					gamescreen.dispose();
					if(game.getOpponent().getCurrentHP()==0)
					{
						gamescreen.setVisible(false);
						stopSoundLoop();
						v=new Victory(game.getCurrentHero());
						v.addConfirmListener(this);
						v.setVisible(true);
					}
					else
					{
					gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
					 JButton g = gamescreen.getEndTurnButton();
						g.addActionListener(this);
				    }
						if(ew){exceptionwindow.setVisible(true);ew=false;}
						
						for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
							gamescreen.getCurrHandButtons().get(i).addActionListener(this);
					
						for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
							gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
						
						for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
							gamescreen.getOppFieldButtons().get(i).addActionListener(this);
						JButton chp = gamescreen.getCurrHeroPower();
						chp.addActionListener(this);
						JButton ch = gamescreen.getCurrHero();
						JButton oh = gamescreen.getOppHero();
						ch.addActionListener(this);
						oh.addActionListener(this);
						attacking = null;
				}
				if(b.getActionCommand().equals("OppField") && attacking != null)
				{
					playSound("sounds/UI_MouseClick_01.wav");
					int r = gamescreen.getOppFieldButtons().indexOf(b);
					Minion c = game.getOpponent().getField().get(r);
					try {
						game.getCurrentHero().attackWithMinion(attacking, c);
					} catch (CannotAttackException | NotYourTurnException
							| TauntBypassException | InvalidTargetException
							| NotSummonedException e) {
						
						ew=true;
						exceptionwindow.setMsg(e.getMessage());
						
					}
					gamescreen.dispose();
					if(game.getOpponent().getCurrentHP()==0)
					{
						gamescreen.setVisible(false);
						stopSoundLoop();
						v=new Victory(game.getCurrentHero());
						v.addConfirmListener(this);
						v.setVisible(true);
					}
					else
					{
					gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
					 JButton g = gamescreen.getEndTurnButton();
						g.addActionListener(this);
				    }
						
						if(ew){exceptionwindow.setVisible(true);ew=false;}
						
						for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
							gamescreen.getCurrHandButtons().get(i).addActionListener(this);
					
						for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
							gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
						
						for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
							gamescreen.getOppFieldButtons().get(i).addActionListener(this);
						JButton chp = gamescreen.getCurrHeroPower();
						chp.addActionListener(this);
						JButton ch = gamescreen.getCurrHero();
						JButton oh = gamescreen.getOppHero();
						ch.addActionListener(this);
						oh.addActionListener(this);
						attacking = null;
				}
				if(selectedSpell != null && b.getActionCommand().equals("Hero"))
					if((selectedSpell.getName().equals("Kill Command")) || (selectedSpell.getName().equals("Pyroblast")))
					     if(selectedSpell instanceof HeroTargetSpell)
					     {
					    	 try {
					    		 playSound("sounds/UI_MouseClick_01.wav");
								game.getCurrentHero().castSpell(((HeroTargetSpell)selectedSpell),game.getOpponent());
							} catch (NotYourTurnException
									| NotEnoughManaException e) {
								
								ew=true;
								exceptionwindow.setMsg(e.getMessage());
							}
					    	 gamescreen.dispose();
					    	 if(game.getOpponent().getCurrentHP()==0)
								{
									gamescreen.setVisible(false);
									stopSoundLoop();
									v=new Victory(game.getCurrentHero());
									v.addConfirmListener(this);
									v.setVisible(true);
								}
								else
								{
								gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
								 JButton g = gamescreen.getEndTurnButton();
									g.addActionListener(this);
							    }
									if(ew){exceptionwindow.setVisible(true);ew=false;}
									
									for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
										gamescreen.getCurrHandButtons().get(i).addActionListener(this);
								
									for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
										gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
									
									for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
										gamescreen.getOppFieldButtons().get(i).addActionListener(this);
									JButton chp = gamescreen.getCurrHeroPower();
									chp.addActionListener(this);
									JButton ch = gamescreen.getCurrHero();
									JButton oh = gamescreen.getOppHero();
									ch.addActionListener(this);
									oh.addActionListener(this);
								
					    	
					   }
					
				if(selectedSpell != null && b.getActionCommand().equals("CurrField"))
				{
					
					playSound("sounds/UI_MouseClick_01.wav");
					int r = gamescreen.getCurrFieldButtons().indexOf(b);
					Minion c=game.getCurrentHero().getField().get(r);
					if((selectedSpell.getName().equals("Divine Spirit")) || (selectedSpell.getName().equals("Seal of Champions")))
					{
						playSound("sounds/UI_MouseClick_01.wav");
						try {
							game.getCurrentHero().castSpell((MinionTargetSpell)selectedSpell, c);
						} catch (NotYourTurnException | NotEnoughManaException
								| InvalidTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						gamescreen.dispose();
						if(game.getOpponent().getCurrentHP()==0)
						{
							gamescreen.setVisible(false);
							stopSoundLoop();
							v=new Victory(game.getCurrentHero());
							v.addConfirmListener(this);
							v.setVisible(true);
						}
						else
						{
						gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
						 JButton g = gamescreen.getEndTurnButton();
							g.addActionListener(this);
					    }
							if(ew){exceptionwindow.setVisible(true);ew=false;}
							
							for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
								gamescreen.getCurrHandButtons().get(i).addActionListener(this);
						
							for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
								gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
							
							for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
								gamescreen.getOppFieldButtons().get(i).addActionListener(this);
							JButton chp = gamescreen.getCurrHeroPower();
							chp.addActionListener(this);
							JButton ch = gamescreen.getCurrHero();
							JButton oh = gamescreen.getOppHero();
							ch.addActionListener(this);
							oh.addActionListener(this);
					}
				}
				
				if(selectedSpell != null && b.getActionCommand().equals("OppField"))
				{
					playSound("sounds/UI_MouseClick_01.wav");
					int r = gamescreen.getOppFieldButtons().indexOf(b);
					Minion c=game.getOpponent().getField().get(r);
					//System.out.println(c);
					if(selectedSpell instanceof LeechingSpell)
					{
					try {
						game.getCurrentHero().castSpell((LeechingSpell)selectedSpell, c);
					} catch (NotYourTurnException | NotEnoughManaException e) {
						
						ew=true;
						exceptionwindow.setMsg(e.getMessage());
						
					}
					}
					
					if( (selectedSpell.getName().equals("Polymorph")) ||  (selectedSpell.getName().equals("Shadow Word: Death")) 
							|| (selectedSpell.getName().equals("Kill Command")) || (selectedSpell.getName().equals("Pyroblast")))
					{
						try {
							playSound("sounds/UI_MouseClick_01.wav");
							game.getCurrentHero().castSpell(((MinionTargetSpell)selectedSpell), c);
						} catch (NotYourTurnException | NotEnoughManaException
								| InvalidTargetException e) {
							
							ew=true;
							exceptionwindow.setMsg(e.getMessage());
							
						}
					}
					
					gamescreen.dispose();
					if(game.getOpponent().getCurrentHP()==0)
					{
						gamescreen.setVisible(false);
						stopSoundLoop();
						v=new Victory(game.getCurrentHero());
						v.addConfirmListener(this);
						v.setVisible(true);
					}
					else
					{
					gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
					 JButton g = gamescreen.getEndTurnButton();
						g.addActionListener(this);
				    }
						if(ew){exceptionwindow.setVisible(true);ew=false;}		
						
					for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
							gamescreen.getCurrHandButtons().get(i).addActionListener(this);
					
						for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
							gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
						
						for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
							gamescreen.getOppFieldButtons().get(i).addActionListener(this);
						JButton chp = gamescreen.getCurrHeroPower();
						chp.addActionListener(this);
						JButton ch = gamescreen.getCurrHero();
						JButton oh = gamescreen.getOppHero();
						ch.addActionListener(this);
						oh.addActionListener(this);
						
						selectedSpell = null;
					
				}
				
			if(b.getActionCommand().equals("CurrHeroPower") && (game.getCurrentHero() instanceof Hunter || game.getCurrentHero() instanceof Warlock || game.getCurrentHero() instanceof Paladin ))
			{
				
			try {
				       playSound("sounds/UI_MouseClick_01.wav");
						game.getCurrentHero().useHeroPower();
					} catch (NotEnoughManaException
							| HeroPowerAlreadyUsedException
							| NotYourTurnException 
							| FullFieldException | CloneNotSupportedException e) {
						
						ew=true;
						exceptionwindow.setMsg(e.getMessage());
						
						
					} catch (FullHandException e) {

						ew=true;
						exceptionwindow.setMsg(e.getMessage());
						exceptionwindow.setbr("Burned: "+((FullHandException)e).getBurned().getName()+", "
								+((FullHandException)e).getBurned().getManaCost()+", "+((FullHandException)e).getBurned().getRarity());
					}
			
				gamescreen.dispose();
				if(game.getOpponent().getCurrentHP()==0)
				{
					gamescreen.setVisible(false);
					stopSoundLoop();
					v=new Victory(game.getCurrentHero());
					v.addConfirmListener(this);
					v.setVisible(true);
				}
				else
				{
					if(game.getCurrentHero().getCurrentHP()==0)
					{
						gamescreen.setVisible(false);
						stopSoundLoop();
						v=new Victory(game.getOpponent());
						v.addConfirmListener(this);
						v.setVisible(true);
					}
					else
					{
				gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
				 JButton g = gamescreen.getEndTurnButton();
					g.addActionListener(this);
				}
			    }
					if(ew){exceptionwindow.setVisible(true);ew=false;}
					 if(game.getCurrentHero().getCurrentManaCrystals()==0)
					    	playSound("sounds/VO_JobsDone.wav");
					
					for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
						gamescreen.getCurrHandButtons().get(i).addActionListener(this);
				
					for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
						gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
					
					for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
						gamescreen.getOppFieldButtons().get(i).addActionListener(this);
					JButton chp = gamescreen.getCurrHeroPower();
					chp.addActionListener(this);
					JButton ch = gamescreen.getCurrHero();
					JButton oh = gamescreen.getOppHero();
					ch.addActionListener(this);
					oh.addActionListener(this);
				
				
			}
			if(b.getActionCommand().equals("CurrHeroPower") && game.getCurrentHero() instanceof Mage)
				mageFlag = true;
			playSound("sounds/UI_MouseClick_01.wav");
			
			if(mageFlag && b.getActionCommand().equals("OppField"))
			{
				int r = gamescreen.getOppFieldButtons().indexOf(b);
				Minion c = game.getOpponent().getField().get(r);
				try {
					((Mage)game.getCurrentHero()).useHeroPower(c);
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
						| NotYourTurnException | FullHandException
						| FullFieldException | CloneNotSupportedException e) {

					ew=true;
					exceptionwindow.setMsg(e.getMessage());
					
				}
				mageFlag = false;
				gamescreen.dispose();
				if(game.getOpponent().getCurrentHP()==0)
				{
					gamescreen.setVisible(false);
					stopSoundLoop();
					v=new Victory(game.getCurrentHero());
					v.addConfirmListener(this);
					v.setVisible(true);
				}
				else
				{
				gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
				 JButton g = gamescreen.getEndTurnButton();
					g.addActionListener(this);
			    }
					if(ew){exceptionwindow.setVisible(true);ew=false;}
					 if(game.getCurrentHero().getCurrentManaCrystals()==0)
					    	playSound("sounds/VO_JobsDone.wav");
					
					for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
						gamescreen.getCurrHandButtons().get(i).addActionListener(this);
				
					for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
						gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
					
					for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
						gamescreen.getOppFieldButtons().get(i).addActionListener(this);
					JButton chp = gamescreen.getCurrHeroPower();
					chp.addActionListener(this);
					JButton ch = gamescreen.getCurrHero();
					JButton oh = gamescreen.getOppHero();
					ch.addActionListener(this);
					oh.addActionListener(this);
			}
			if(mageFlag && b.getActionCommand().equals("Hero"))
			{
				try {
					playSound("sounds/UI_MouseClick_01.wav");
					((Mage)game.getCurrentHero()).useHeroPower(game.getOpponent());
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
						| NotYourTurnException | FullHandException
						| FullFieldException | CloneNotSupportedException e) {
					
					ew=true;
					exceptionwindow.setMsg(e.getMessage());
					
				}
				mageFlag = false;
				gamescreen.dispose();
				if(game.getOpponent().getCurrentHP()==0)
				{
					gamescreen.setVisible(false);
					stopSoundLoop();
					v=new Victory(game.getCurrentHero());
					v.addConfirmListener(this);
					v.setVisible(true);
				}
				else
				{
				gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
				 JButton g = gamescreen.getEndTurnButton();
					g.addActionListener(this);
			    }
					if(ew){exceptionwindow.setVisible(true);ew=false;}
					
					for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
						gamescreen.getCurrHandButtons().get(i).addActionListener(this);
				
					for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
						gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
					
					for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
						gamescreen.getOppFieldButtons().get(i).addActionListener(this);
					JButton chp = gamescreen.getCurrHeroPower();
					chp.addActionListener(this);
					JButton ch = gamescreen.getCurrHero();
					JButton oh = gamescreen.getOppHero();
					ch.addActionListener(this);
					oh.addActionListener(this);
					
					
			}
			if((b.getActionCommand().equals("CurrHeroPower") && game.getCurrentHero() instanceof Priest))
				priestFlag = true;
			playSound("sounds/UI_MouseClick_01.wav");
			
			if((priestFlag) && b.getActionCommand().equals("Hero"))
				
			{
				try {
					((Priest)game.getCurrentHero()).useHeroPower(game.getCurrentHero());
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
						| NotYourTurnException | FullHandException
						| FullFieldException | CloneNotSupportedException e) {

					ew=true;
					exceptionwindow.setMsg(e.getMessage());
					 if(game.getCurrentHero().getCurrentManaCrystals()==0)
					    	playSound("sounds/VO_JobsDone.wav");
					
					
				}
				gamescreen.dispose();
				if(game.getOpponent().getCurrentHP()==0)
				{
					gamescreen.setVisible(false);
					stopSoundLoop();
					v=new Victory(game.getCurrentHero());
					v.addConfirmListener(this);
					v.setVisible(true);
				}
				else
				{
				gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
				 JButton g = gamescreen.getEndTurnButton();
					g.addActionListener(this);
			    }
					if(ew){exceptionwindow.setVisible(true);ew=false;}
					
					for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
						gamescreen.getCurrHandButtons().get(i).addActionListener(this);
				
					for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
						gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
					
					for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
						gamescreen.getOppFieldButtons().get(i).addActionListener(this);
					JButton chp = gamescreen.getCurrHeroPower();
					chp.addActionListener(this);
					JButton ch = gamescreen.getCurrHero();
					JButton oh = gamescreen.getOppHero();
					ch.addActionListener(this);
					oh.addActionListener(this);	
					priestFlag = false;
			}
			if(priestFlag && b.getActionCommand().equals("CurrField"))
			{
				playSound("sounds/UI_MouseClick_01.wav");
				int r = gamescreen.getCurrFieldButtons().indexOf(b);
				Minion c = game.getCurrentHero().getField().get(r);
				try {
					((Priest)game.getCurrentHero()).useHeroPower(c);
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
						| NotYourTurnException | FullHandException
						| FullFieldException | CloneNotSupportedException e) {

					ew=true;
					exceptionwindow.setMsg(e.getMessage());
					
				}
				gamescreen.dispose();
				if(game.getOpponent().getCurrentHP()==0)
				{
					gamescreen.setVisible(false);
					stopSoundLoop();
					v=new Victory(game.getCurrentHero());
					v.addConfirmListener(this);
					v.setVisible(true);
				}
				else
				{
				gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
				 JButton g = gamescreen.getEndTurnButton();
					g.addActionListener(this);
			    }
					if(ew){exceptionwindow.setVisible(true);ew=false;}
					
					for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
						gamescreen.getCurrHandButtons().get(i).addActionListener(this);
				
					for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
						gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
					
					for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
						gamescreen.getOppFieldButtons().get(i).addActionListener(this);
					JButton chp = gamescreen.getCurrHeroPower();
					chp.addActionListener(this);
					JButton ch = gamescreen.getCurrHero();
					JButton oh = gamescreen.getOppHero();
					ch.addActionListener(this);
					oh.addActionListener(this);
					priestFlag = false;
			}
			
			if(b.getActionCommand().equals("New"))
					{
				playSound("sounds/UI_MouseClick_01.wav");
				       gamescreen.dispose();
				       v.dispose();
				       new Controller();
				       
					}
			
			if(b.getActionCommand().equals("Exit"))
			{
				playSound("sounds/UI_MouseClick_01.wav");
		       System.exit(0);
		       
			}
				
			//if(ew)
			//{
			//	exceptionwindow.setVisible(true);
			//	ew = false;
			//}
			
			
				
			
	
		        
		        
		       
			
		
			
		}
	
	public void RenewGs(GameScreen gamescreen,Game game){
		gamescreen.dispose();
		gamescreen = new GameScreen(game.getCurrentHero(),game.getOpponent());
		 JButton g = gamescreen.getEndTurnButton();
			g.addActionListener(this);
			
			for(int i=0;i<gamescreen.getCurrHandButtons().size();i++)
				gamescreen.getCurrHandButtons().get(i).addActionListener(this);
		
			for(int i=0;i<gamescreen.getCurrFieldButtons().size();i++)
				gamescreen.getCurrFieldButtons().get(i).addActionListener(this);
			
			for(int i=0;i<gamescreen.getOppFieldButtons().size();i++)
				gamescreen.getOppFieldButtons().get(i).addActionListener(this);
			JButton chp = gamescreen.getCurrHeroPower();
			chp.addActionListener(this);
	}
	public void playSound(String filepath) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*public void playSoundLoop(String filepath) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
			cl = AudioSystem.getClip();
			
			

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	public void playSoundLoop(String filepath){
	    try {
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filepath));
	           
	            clip = AudioSystem.getClip( );
	            clip.open(audioInputStream);
	            clip.loop(Clip.LOOP_CONTINUOUSLY);
	            clip.start( );    
	            }

	        catch(Exception e)  {
	            e.printStackTrace( );
	        }
	}

	 
	 public void stopSoundLoop(){
	    clip.stop();
	 }
		
	
	public static void main(String[] args) {
		new Controller();
	}

	@Override
	public void onGameOver() {
		
		//gamescreen.removeAll
		/*v=new Victory(game.getCurrentHero());
		gamescreen.setVisible(false);
		gamescreen.dispose();
		v.addConfirmListener(this);
		v.setVisible(true);*/
		
	}

	
	
}
