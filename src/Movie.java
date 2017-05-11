/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PITA 28
 */
public class Movie
{
    int id;
    String movie;
    String grade;
    int time;
    String lang;
    String d3;
    Movie(int i,String m,String g,int t,String l,String d){
        id=i;
        movie=m;
        grade=g;
        time=t;
        lang=l;
        d3=d;
    }
    Movie(String m,String l,String d){
        movie=m;
        lang=l;
        d3=d;
    }
    
}
