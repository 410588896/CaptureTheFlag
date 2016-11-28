/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author supermanYC
 */
public class Seeker extends Player{
    private int[] pos;
    public Seeker(Field f, int side, String name, int number, String team, char symbol, double x, double y)
    {
        super(f, side, name, number, team, symbol, x, y);
        pos = new int[2];
        if(side == 1)
        {
            pos = f.getFlag2Position();
        }
        else
            pos = f.getFlag1Position();
        double tmp = (int)(1+Math.random()*(10-1+1)) * 1000;
        this.speedX = (pos[0] - this.x) / tmp ;
        this.speedY = (pos[1] - this.y) / tmp;
    }
    public void update(Field field){}
    public void play(Field field)
    {
        if(Math.abs(this.x - pos[0]) < 1 && Math.abs(this.y - pos[1]) < 1)
        {
            this.speedX = 0.0;
            this.speedY = 0.0;
        }
    }
}
