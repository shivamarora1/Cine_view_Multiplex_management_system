/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PITA 28
 */
public class movie_data {
    String name;
    int thour;
    int tmin;
    movie_data(String movie,int t)
    {
        name=movie;
        thour=t/60;
        tmin=t%60;
        if(tmin>59)
        {
        tmin=tmin-60;
        thour++;
        }
    }
}
