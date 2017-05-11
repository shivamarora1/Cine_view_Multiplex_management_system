
import java.awt.Button;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SHIVAM
 */
public class seat {
JButton bu;
int seat;
int day_id;
seat(JButton bu,int seat){
    this.bu=bu;
    this.seat=seat;
}
seat(JButton bu,int seat,int day_id){
this.bu=bu;
this.day_id=day_id;
this.seat=seat;
}
}
