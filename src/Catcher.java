/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author supermanYC
 */
public class Catcher extends Player{
    private Entity runner;
    private int _side;
    private int i;
    public Catcher(Field f, int side, String name, int number, String team, char symbol, double x, double y)
    {
        super(f, side, name, number, team, symbol, x, y);
        _side = side;
        if(side == 1)
        {
            this.speedX = Math.random();
            i = f.team2.size() - 1;
            runner = f.team2.get(i);
        }
        else
        {
            this.speedX = Math.random() * (-1);
            i = f.team1.size() - 1;
            runner = f.team1.get(i);
        }
        int seed = (int)(1+Math.random()*(10-1+1));
        if(seed - 5 > 0)
            this.speedY = Math.random();
        else if(seed - 5 < 0)
            this.speedY = Math.random() * (-1);
        else
            this.speedY = 0.0;
    }
    public void update(Field field){}
    public void play(Field field)
    {
        if(catchOpponent())
        {
            if(_side == 1)
            {
                if(Math.abs(runner.x - field.getJail1Position()[0]) < 1 && Math.abs(runner.y - field.getJail1Position()[1]) < 1)
                {
                    runner.setSpeedX(0.0, runner.id);
                    runner.setSpeedY(0.0, runner.id);
                    i--;
                    if(i == -1)
                    {
                        i = field.team2.size() - 1;
                        int j = 0;
                        for(j = 0; j <= i; j++)
                        {
                            runner = field.team2.get(j);
                            runner.setX(field.getBase2Position()[0], runner.id);
                            runner.setY(field.getBase2Position()[1], runner.id);
                        }
                        for(j = 0; j <= i; j++)
                        {
                            runner = field.team2.get(j);
                            runner.setSpeedX(Math.random(), runner.id);
                            int seed = (int)(1+Math.random()*(10-1+1));
                            if(seed - 5 > 0)
                               runner.setSpeedY(Math.random(), runner.id);
                            else if(seed - 5 < 0)
                                runner.setSpeedY(Math.random() * (-1), runner.id);
                            else
                                runner.setSpeedY(0.0, runner.id);
                        }
                    }
                    runner = field.team2.get(i);
                }
                runner.setSpeedX((field.getJail1Position()[0] - runner.x)/100, runner.id);
                runner.setSpeedY((field.getJail1Position()[1] - runner.y)/100, runner.id);
                this.speedX = runner.getSpeedX();
                this.speedY = runner.getSpeedY();
            }
            else
            {
                if(Math.abs(runner.x - field.getJail2Position()[0]) < 1 && Math.abs(runner.y - field.getJail2Position()[1]) < 1)
                {
                    runner.setSpeedX(0.0, runner.id);
                    runner.setSpeedY(0.0, runner.id);
                    i--;
                    if(i == -1)
                    {
                        i = field.team1.size() - 1;
                        int j = 0;
                        for(j = 0; j <= i; j++)
                        {
                            runner = field.team1.get(j);
                            runner.setX(field.getBase1Position()[0], runner.id);
                            runner.setY(field.getBase1Position()[1], runner.id);
                        }
                        for(j = 0; j <= i; j++)
                        {
                            runner = field.team1.get(j);
                            runner.setSpeedX(Math.random(), runner.id);
                            int seed = (int)(1+Math.random()*(10-1+1));
                            if(seed - 5 > 0)
                               runner.setSpeedY(Math.random(), runner.id);
                            else if(seed - 5 < 0)
                                runner.setSpeedY(Math.random() * (-1), runner.id);
                            else
                                runner.setSpeedY(0.0, runner.id);
                        }
                    }
                    runner = field.team1.get(i);
                }
                else
                {
                    runner.setSpeedX((field.getJail2Position()[0] - runner.x)/100, runner.id);
                    runner.setSpeedY((field.getJail2Position()[1] - runner.y)/100, runner.id);
                    this.speedX = runner.getSpeedX();
                    this.speedY = runner.getSpeedY();
                }
            }
        }
        if(this.x - field.minX < 1 || field.maxX-15 - this.x < 1)
        {
            this.speedX = -this.speedX;
                //this.speedY = -this.speedY;
        }
        if(this.y - field.minY < 1 || field.maxY-15 - this.y < 1)
        {
                //this.speedX = -this.speedX;
            this.speedY = -this.speedY;
        }
        if(Math.abs(this.x - runner.x) < 1)
        {
            this.speedX = runner.getSpeedX();
        }
        else
        {
            this.speedX = (runner.getX() - this.x) / 1000;
        }
        if(Math.abs(this.y - runner.y) < 1)
        {
            this.speedY = runner.getSpeedY();
        }
        else
        {
            this.speedY = (runner.getY() - this.y) / 1000;
        }
        
    }
    
    public boolean catchOpponent()
    {
        if( Math.hypot(runner.getX() - this.getX(), runner.getY() - this.getY() ) <= Field.ARMS_LENGTH )
        {
            return true;
        }
        return false;
  }
}
