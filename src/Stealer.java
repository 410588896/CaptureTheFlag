/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author supermanYC
 */
public class Stealer extends Player{
    private int pos[];
    private int _side;
    private Entity _flag;
    @Override
    public void play(Field field){
        if(Math.abs(this.x - pos[0]) < 1 && Math.abs(this.y - pos[1]) < 1)
        {
            if(_side == 1)
            {
                if(Math.abs(_flag.x - field.getBase1Position()[0]) < 1 && Math.abs(_flag.y - field.getBase1Position()[1]) < 1)
                {
                    this.speedX = 0.0;
                    this.speedY = 0.0;
                    _flag.setSpeedX(0.0, _flag.id);
                    _flag.setSpeedY(0.0, _flag.id);
                }
                else
                {
                    this.speedX = (field.getBase1Position()[0] - this.x) / 100;
                    this.speedY = (field.getBase1Position()[1] - this.y) / 100;
                    _flag.setSpeedX((field.getBase1Position()[0] - _flag.x)/100, _flag.id);
                    _flag.setSpeedY((field.getBase1Position()[1] - _flag.y)/100, _flag.id);
                }
            }
            else
            {
                if(Math.abs(_flag.x - field.getBase2Position()[0]) < 1 && Math.abs(_flag.y - field.getBase2Position()[1]) < 1)
                {
                    this.speedX = 0.0;
                    this.speedY = 0.0;
                    _flag.setSpeedX(0.0, _flag.id);
                    _flag.setSpeedY(0.0, _flag.id);
                }
                else
                {
                    this.speedX = (field.getBase2Position()[0] - this.x) / 100;
                    this.speedY = (field.getBase2Position()[1] - this.y) / 100;
                    _flag.setSpeedX((field.getBase2Position()[0] - _flag.x)/100, _flag.id);
                    _flag.setSpeedY((field.getBase2Position()[1] - _flag.y)/100, _flag.id);
                }
            }   
        }
    }
  @Override
  public void update(Field field){}

  public Stealer(Field f, int side, String name, int number, String team,char symbol, double x, double y){
    super(f, side, name, number, team, symbol, x, y);
    pos = new int[2];
    _side = side;
    if(side == 1)
    {
        pos = f.getFlag2Position();
        _flag = f.flag2;
    }
    else
    {
        pos = f.getFlag1Position();
        _flag = f.flag1;
    }
    double tmp = (int)(1+Math.random()*(10-1+1)) * 1000;
    this.speedX = (pos[0] - this.x) / tmp ;
    this.speedY = (pos[1] - this.y) / tmp;     
  }
  
}
