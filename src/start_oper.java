
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PITA 28
 */
public class start_oper extends javax.swing.JFrame {
ResultSet rs;
ResultSet rs1;
Connection con;
Statement stmt;
Color ca;
String s3="2D";
String s2;
int i=90;
int x=170;
int y=90;
ArrayList<Movie> list;
    /**
     * Creates new form start
     */
    public start_oper() {
        this.setContentPane(new JLabel(new ImageIcon("stat_ad.jpg")));
        ca=new Color(0,91,158);
        initComponents();
list=new ArrayList();

        try{
            
Class.forName("com.mysql.jdbc.Driver");
con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", global.user,global.pass);
stmt=(Statement)con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
 rs=stmt.executeQuery("select * from movies");
 while(rs.next()){
     if(rs.getInt("3d")==1){
         s3="3D";
     }
     else{
         s3="2D";
     }
    list.add(new Movie(rs.getString("movie"),rs.getString("language"),s3));
     //add(new Label(rs.getString("movie")));
Label l=new Label(rs.getString("movie")); 
l.setBounds(20, i, 130, 25);
l.setFont(new java.awt.Font("Segoe UI", 1, 14));
l.setBackground(ca);
l.setForeground(Color.WHITE);
add(l);
i=i+30;
 }
 for(int i=0;i<list.size();i++){
     Movie m=list.get(i);
     s2=m.movie+" ("+m.lang+" )"+m.d3;
     rs=stmt.executeQuery("select * from schedule where movie="+"'"+s2+"'");
     while(rs.next())
     {
         //jPanel1.add(new Button(rs.getString("start_time")));
     Button b=new Button(rs.getString("start_time"));
     b.setBounds(x, y, 45, 23);
     b.setFont(new java.awt.Font("Segoe UI", 1, 14));
     b.setBackground(new java.awt.Color(255,255,255));
     b.setForeground(new java.awt.Color(0,0,0));
    // b.setBackground(color.white);

     add(b);
     b.addActionListener(new mylistener(rs.getInt("s_no"),rs.getString("start_time"), rs.getInt("show_id"),s2));
     x=x+50;
     }
     x=170;
     y=y+30;
 }
        }
        catch(Exception e){
        e.printStackTrace();
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tlab = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        tlab.setFont(new java.awt.Font("Modern No. 20", 0, 36)); // NOI18N
        getContentPane().add(tlab);
        tlab.setBounds(187, 10, 0, 0);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my cine view.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 10, 250, 50);

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setBorder(null);
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(51, 30));

        jMenu5.setBackground(new java.awt.Color(0, 0, 0));
        jMenu5.setBorder(null);
        jMenu5.setForeground(new java.awt.Color(255, 198, 38));
        jMenu5.setText("Setting");
        jMenu5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem12.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItem12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem12.setForeground(new java.awt.Color(255, 198, 38));
        jMenuItem12.setBorder(null);
        jMenuItem12.setLabel("Change Password");
        jMenuItem12.setPreferredSize(new java.awt.Dimension(145, 22));
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(416, 359));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    class mylistener implements ActionListener
    {

       int screen_no;
       String movie;
       String start;
      int id;

        public mylistener(int screen_no,String start_time, Integer id,String movie) {
            this.screen_no = screen_no;
            this.movie = movie;
            this.start=start_time;
            this.id=id;
        }
       
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            
            
            
             try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
            seats seat=new seats(screen_no,start,id,movie);
            seat.setVisible(true);
           
        }
        
    }
    
    
    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
new chg_pass_oper().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new start_oper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JLabel tlab;
    // End of variables declaration//GEN-END:variables
}
