/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author supermanYC
 */
public class Chaser extends Player{
    private Entity runner;
    public Chaser(Field f, int side, String name, int number, String team, char symbol, double x, double y)
    {
        super(f, side, name, number, team, symbol, x, y);
        if(side == 1)
        {
            this.speedX = Math.random();
            runner = f.team2.get(0);
        }
        else
        {
            this.speedX = Math.random() * (-1);
            runner = runner = f.team1.get(0);
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
}
