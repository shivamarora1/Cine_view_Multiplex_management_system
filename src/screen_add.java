
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class screen_add extends javax.swing.JFrame {
 int mmin=0,mhrs=0,halt=0,haltm=0,halth=0,nexh=0,nexm=0,endh=0,endm=0,tmin=0,thrs=0;
    Connection con;
Statement stmt;
ResultSet rs;
boolean isSet = false;
ArrayList<Movie> list;

int id;


    public screen_add(int id) {
         this.setContentPane(new JLabel(new ImageIcon("scr_add.jpg")));
        initComponents();
      
        list = new ArrayList<>();
        haltm=30;
this.id=id;
jid.setText(""+id);
try{
Class.forName("com.mysql.jdbc.Driver");
con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", global.user,global.pass);
stmt=(Statement)con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
rs=stmt.executeQuery("select * from screen where no="+id);

if(rs.next()){
    ttime.setText(rs.getString("start_hrs")+":"+rs.getString("start_min"));//sets starting time of first show which is on databasei it will remain same for all
    
}
//m1.setSelectedIndex(-1);
//m2.setSelectedIndex(-1);
//m3.setSelectedIndex(-1);
//m4.setSelectedIndex(-1);
//m5.setSelectedIndex(-1);
String s="2D";

/////Adding movies to DropDown List////
rs=stmt.executeQuery("select * from movies");
while(rs.next()){
    
    
    
    if(rs.getInt("3d")==1){
s="3D";        
    }
    else{
        s="2D";
    }
    list.add(new Movie(rs.getInt("id"),rs.getString("movie"),rs.getString("grade"),rs.getInt("time"),rs.getString("language"),s));
    
}
for(int k=0;k<list.size();k++){
    Movie m=list.get(k);
    m1.addItem(m.movie+" ("+m.lang+" )"+m.d3);//Whenevre we additem to combo it is automatically calss action listener
    m2.addItem(m.movie+" ("+m.lang+" )"+m.d3);
    m3.addItem(m.movie+" ("+m.lang+" )"+m.d3);
    m4.addItem(m.movie+" ("+m.lang+" )"+m.d3);
    m5.addItem(m.movie+" ("+m.lang+" )"+m.d3);
}


isSet = true;


m5.addItem("None");
calc();
ms1.setText(ttime.getText());
/////Adding Complete////
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    void calc()
    {
        String tTime = ttime.getText();
        String Time[]=tTime.split(":");
        int first_starh=Integer.parseInt(Time[0]);
        int first_starm=Integer.parseInt(Time[1]);
        int i1 = m1.getSelectedIndex();
        Movie movie1 = list.get(i1);
        int st1 = movie1.time;
        int st1h=st1/60;
        int st1m=st1%60;
        if(st1m>59)
        {
        st1m=st1m-60; 
        st1h++;
        }
        int first_endh=first_starh+st1h;
        int first_endm=first_starm+st1m;
        if(first_endm>59){
            first_endm=first_endm-60;
            first_endh++;
        }
        else{
                }
        ms1.setText(first_starh+":"+first_starm);
        me1.setText(first_endh+":"+first_endm);
///2nd movie
        int second_starth=first_endh+halth; 
       int second_startm=first_endm+haltm;
       if(second_startm>59){
           second_startm=second_startm-60;
           second_starth++;
       }
       int i2=m2.getSelectedIndex();
        System.out.println(i2);
       Movie movie2=list.get(i2);
        int st2 = movie2.time;
        int st2h=st2/60;
        int st2m=st2%60;
        if(st2m>59)
        {
        st2m=st2m-60; 
        st2h++;
        }
        int second_endh=st2h+second_starth;
        int second_endm=st2m+second_startm;
        if(second_endm>59){
            second_endm=second_endm-60;
            second_endh++;
        }
        else{
        
        }
        ms2.setText(second_starth+":"+second_startm);
        me2.setText(second_endh+":"+second_endm);
        //3rd movie
        int third_starth=second_endh+halth;
        int third_startm=second_endm+haltm;
        if(third_startm>59){
            third_startm=third_startm-60;
            third_starth++;
        }
        int i3=m3.getSelectedIndex();
        Movie movie3=list.get(i3);
        int st3=movie3.time;
        int st3h=st3/60;
        int st3m=st3%60;
        if(st3m>59)
        {
        st3m=st3m-60; 
        st3h++;
        }
        int third_endh=st3h+third_starth;
        int third_endm=st3m+third_startm;
        if(third_endm>59){
            third_endm=third_endm-60;
            third_endh++;
        }
        else{
        
        }
        ms3.setText(third_starth+":"+third_startm);
        me3.setText(third_endh+":"+third_endm);
        //4th 
        int for_starth=third_endh+halth;
        int for_startm=third_endm+haltm;
        if(for_startm>59){
            for_startm=for_startm-60;
            for_starth++;
        }
        int i4=m4.getSelectedIndex();
        Movie movie4=list.get(i4);
        int st4=movie4.time;
        int st4h=st4/60;
        int st4m=st4%60;
        if(st4m>59)
        {
        st4m=st4m-60; 
        st4h++;
        }
        int for_endh=st4h+for_starth;
        int for_endm=st4m+for_startm;
        if(for_endm>59){
            for_endm=for_endm-60;
            for_endh++;
        }
        else{
        
        }
        ms4.setText(for_starth+":"+for_startm);
        me4.setText(for_endh+":"+for_endm);
        //5th
        if(m5.getSelectedItem()=="None"){
           ms5.setText("--:--");
        me5.setText("--:--"); 
        }
        else{
        int five_starth=for_endh+halth;
        int five_startm=for_endm+haltm;
if(five_startm>59){
            five_startm=five_startm-60;
            five_starth++;
        }
        int i5=m5.getSelectedIndex();
        Movie movie5=list.get(i5);
        int st5=movie5.time;
        int st5h=st5/60;
        int st5m=st5%60;
        if(st5m>59)
        {
        st5m=st5m-60; 
        st5h++;
        }
        int five_endh=st5h+five_starth;
        int five_endm=st5m+five_startm;
        if(five_endm>59){
            five_endm=five_endm-60;
            five_endh++;
            
        }
        else{
        
        }
        if(five_endh>23){
            five_endh=five_endh-24;
        }
        ms5.setText(five_starth+":"+five_startm);
        me5.setText(five_endh+":"+five_endm);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jid = new javax.swing.JLabel();
        sstart = new javax.swing.JLabel();
        m1 = new javax.swing.JComboBox();
        m2 = new javax.swing.JComboBox();
        m3 = new javax.swing.JComboBox();
        m4 = new javax.swing.JComboBox();
        m5 = new javax.swing.JComboBox();
        supdate = new javax.swing.JButton();
        ttime = new javax.swing.JLabel();
        ms1 = new javax.swing.JLabel();
        ms2 = new javax.swing.JLabel();
        me2 = new javax.swing.JLabel();
        ms3 = new javax.swing.JLabel();
        me3 = new javax.swing.JLabel();
        ms4 = new javax.swing.JLabel();
        me4 = new javax.swing.JLabel();
        ms5 = new javax.swing.JLabel();
        me5 = new javax.swing.JLabel();
        tend = new javax.swing.JLabel();
        me1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tint = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        jLabel18.setText("jLabel18");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cinema Ticket Management");
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Screen no");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 110, 80, 40);

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Starting time");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 160, 80, 40);

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Movie 1");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 210, 60, 40);

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Movie 2");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 260, 70, 40);

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Movie 3");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 310, 60, 40);

        jLabel6.setBackground(java.awt.Color.white);
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Movie 4");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 360, 60, 40);

        jLabel7.setBackground(java.awt.Color.white);
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Movie 5");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 410, 60, 50);

        jid.setBackground(java.awt.Color.white);
        jid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(jid);
        jid.setBounds(160, 120, 30, 20);
        getContentPane().add(sstart);
        sstart.setBounds(140, 70, 0, 0);

        m1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        m1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                m1ItemStateChanged(evt);
            }
        });
        m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m1ActionPerformed(evt);
            }
        });
        getContentPane().add(m1);
        m1.setBounds(160, 220, 210, 28);

        m2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        m2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                m2ItemStateChanged(evt);
            }
        });
        m2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2ActionPerformed(evt);
            }
        });
        getContentPane().add(m2);
        m2.setBounds(160, 270, 210, 28);

        m3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        m3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                m3ItemStateChanged(evt);
            }
        });
        m3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m3ActionPerformed(evt);
            }
        });
        getContentPane().add(m3);
        m3.setBounds(160, 320, 210, 28);

        m4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        m4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                m4ItemStateChanged(evt);
            }
        });
        m4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m4ActionPerformed(evt);
            }
        });
        getContentPane().add(m4);
        m4.setBounds(160, 370, 210, 28);

        m5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        m5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                m5ItemStateChanged(evt);
            }
        });
        m5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m5ActionPerformed(evt);
            }
        });
        getContentPane().add(m5);
        m5.setBounds(160, 420, 210, 28);

        supdate.setBackground(new java.awt.Color(11, 83, 146));
        supdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        supdate.setForeground(new java.awt.Color(255, 255, 255));
        supdate.setText("SAVE");
        supdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supdateActionPerformed(evt);
            }
        });
        getContentPane().add(supdate);
        supdate.setBounds(290, 480, 100, 35);

        ttime.setBackground(java.awt.Color.white);
        ttime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ttime.setText("Time");
        getContentPane().add(ttime);
        ttime.setBounds(160, 170, 40, 20);

        ms1.setBackground(java.awt.Color.white);
        ms1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ms1.setText("00:00");
        getContentPane().add(ms1);
        ms1.setBounds(380, 220, 40, 20);

        ms2.setBackground(java.awt.Color.white);
        ms2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ms2.setText("00:00");
        getContentPane().add(ms2);
        ms2.setBounds(380, 270, 40, 20);

        me2.setBackground(java.awt.Color.white);
        me2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        me2.setText("00:00");
        getContentPane().add(me2);
        me2.setBounds(430, 270, 40, 20);

        ms3.setBackground(java.awt.Color.white);
        ms3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ms3.setText("00:00");
        getContentPane().add(ms3);
        ms3.setBounds(380, 320, 40, 20);

        me3.setBackground(java.awt.Color.white);
        me3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        me3.setText("00:00");
        getContentPane().add(me3);
        me3.setBounds(430, 320, 40, 20);

        ms4.setBackground(java.awt.Color.white);
        ms4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ms4.setText("00:00");
        getContentPane().add(ms4);
        ms4.setBounds(380, 370, 40, 20);

        me4.setBackground(java.awt.Color.white);
        me4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        me4.setText("00:00");
        getContentPane().add(me4);
        me4.setBounds(430, 370, 40, 20);

        ms5.setBackground(java.awt.Color.white);
        ms5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ms5.setText("00:00");
        getContentPane().add(ms5);
        ms5.setBounds(380, 420, 40, 20);

        me5.setBackground(java.awt.Color.white);
        me5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        me5.setText("00:00");
        getContentPane().add(me5);
        me5.setBounds(430, 420, 40, 20);
        getContentPane().add(tend);
        tend.setBounds(440, 180, 0, 0);

        me1.setBackground(java.awt.Color.white);
        me1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        me1.setText("00:00");
        getContentPane().add(me1);
        me1.setBounds(430, 220, 70, 20);

        jLabel10.setBackground(java.awt.Color.white);
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("minutes");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(430, 170, 50, 20);

        tint.setColumns(2);
        tint.setText("30");
        tint.setAutoscrolls(false);
        tint.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tintFocusLost(evt);
            }
        });
        tint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tintKeyTyped(evt);
            }
        });
        getContentPane().add(tint);
        tint.setBounds(400, 170, 30, 25);

        jLabel11.setBackground(java.awt.Color.white);
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Halt");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(360, 170, 30, 20);

        jButton1.setBackground(new java.awt.Color(11, 83, 146));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOAD PREVIOUS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 480, 150, 35);

        jPanel1.setBackground(new java.awt.Color(11, 83, 146));
        jPanel1.setLayout(null);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my cine viewR.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 10, 160, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 550, 75);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel12.setBackground(new java.awt.Color(51, 0, 51));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 198, 38));
        jLabel12.setText("                                                    Update Schedule of Movie");
        jPanel2.add(jLabel12);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 75, 550, 30);

        setSize(new java.awt.Dimension(551, 563));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void m1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m1ActionPerformed

//calc();
     
    }//GEN-LAST:event_m1ActionPerformed

    private void m2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m2ActionPerformed
      
    }//GEN-LAST:event_m2ActionPerformed

    private void tintFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tintFocusLost
        halt=Integer.parseInt(tint.getText());///Get the Intervel beetween ezch show
        ///Convert Interval to minutes and Hours
    haltm=halt%60;
    halth=halt/60;
   
    System.out.println(""+halth+":"+haltm);
    calc();
    }//GEN-LAST:event_tintFocusLost

    private void m3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m3ActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_m3ActionPerformed

    private void m1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_m1ItemStateChanged
if(isSet)
{
        calc();
}// TODO add your handling code here:
    }//GEN-LAST:event_m1ItemStateChanged

    private void m4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m4ActionPerformed
      
    }//GEN-LAST:event_m4ActionPerformed

    private void m5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m5ActionPerformed
 
    }//GEN-LAST:event_m5ActionPerformed

    private void supdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supdateActionPerformed
 try
 {int i=1;
     int status=JOptionPane.showConfirmDialog(this, "Are You Sure","",JOptionPane.YES_NO_OPTION);
     if(status==JOptionPane.YES_OPTION){
     rs=stmt.executeQuery("select * from schedule where show_id="+i+" and s_no="+id);
     if(rs.next()){
         rs.updateString("movie",""+m1.getSelectedItem());
         rs.updateString("start_time",ms1.getText());
         rs.updateString("end_time",me1.getText());
         rs.updateRow();
     }
     rs=stmt.executeQuery("select * from schedule where show_id="+2+" and s_no="+id);
     if(rs.next()){
         rs.updateString("movie",""+m2.getSelectedItem());
         rs.updateString("start_time",ms2.getText());
         rs.updateString("end_time",me2.getText());
         rs.updateRow();
     }
     rs=stmt.executeQuery("select * from schedule where show_id="+3+" and s_no="+id);
     if(rs.next()){
         rs.updateString("movie",""+m3.getSelectedItem());
         rs.updateString("start_time",ms3.getText());
         rs.updateString("end_time",me3.getText());
         rs.updateRow();
     }
     rs=stmt.executeQuery("select * from schedule where show_id="+4+" and s_no="+id);
     if(rs.next()){
         rs.updateString("movie",""+m4.getSelectedItem());
         rs.updateString("start_time",ms4.getText());
         rs.updateString("end_time",me4.getText());
         rs.updateRow();
     }
     rs=stmt.executeQuery("select * from schedule where show_id="+5+" and s_no="+id);
     if(rs.next()){
         if(m5.getSelectedItem().toString()=="None"){
         rs.updateString("movie","None");
         rs.updateString("start_time","-1");
         rs.updateString("end_time","-1");
         rs.updateRow();
     
            
         }else{
         rs.updateString("movie",""+m5.getSelectedItem());
         rs.updateString("start_time",ms5.getText());
         rs.updateString("end_time",me5.getText());
         rs.updateRow();
         }
         }
     }
     JOptionPane.showMessageDialog(this, "Saved Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
 
 }
 catch(Exception e)
 {
     JOptionPane.showMessageDialog(this, "UnExpected Error");
 e.printStackTrace();
 }



// TODO add your handling code here:
    }//GEN-LAST:event_supdateActionPerformed

    private void tintKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tintKeyTyped

     
        char ch=evt.getKeyChar();
if(ch>='0'&&ch<='9'){

}else
{
evt.consume();
}

// TODO add your handling code here:
    }//GEN-LAST:event_tintKeyTyped

    private void m2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_m2ItemStateChanged
 if(isSet)
{
        calc();
}       // TODO add your handling code here:
    }//GEN-LAST:event_m2ItemStateChanged

    private void m3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_m3ItemStateChanged
 if(isSet)
{
        calc();
}       // TODO add your handling code here:
    }//GEN-LAST:event_m3ItemStateChanged

    private void m4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_m4ItemStateChanged
  if(isSet)
{
        calc();
}      // TODO add your handling code here:
    }//GEN-LAST:event_m4ItemStateChanged

    private void m5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_m5ItemStateChanged
    if(isSet)
{
        calc();
}    // TODO add your handling code here:
    }//GEN-LAST:event_m5ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try{
int stat=JOptionPane.showConfirmDialog(this, "Are You Sure", "Load Previous", JOptionPane.YES_NO_OPTION);
if(stat==JOptionPane.YES_OPTION){        
tint.setText("");
         rs=stmt.executeQuery("select * from schedule where show_id="+1+" and s_no="+id);
         if(rs.next()){
         m1.setSelectedItem(rs.getString("movie"));
         
         ms1.setText(rs.getString("start_time"));
         me1.setText(rs.getString("end_time"));
         }
         rs=stmt.executeQuery("select * from schedule where show_id="+2+" and s_no="+id);
         if(rs.next()){
         m2.setSelectedItem(rs.getString("movie"));
         
         ms2.setText(rs.getString("start_time"));
         me2.setText(rs.getString("end_time"));
         }
         rs=stmt.executeQuery("select * from schedule where show_id="+3+" and s_no="+id);
         if(rs.next()){
         m3.setSelectedItem(rs.getString("movie"));
         
         ms3.setText(rs.getString("start_time"));
         me3.setText(rs.getString("end_time"));
         }
         
         rs=stmt.executeQuery("select * from schedule where show_id="+4+" and s_no="+id);
         if(rs.next()){
         m4.setSelectedItem(rs.getString("movie"));
         
         ms4.setText(rs.getString("start_time"));
         me4.setText(rs.getString("end_time"));
         }
         rs=stmt.executeQuery("select * from schedule where show_id="+5+" and s_no="+id);
         if(rs.next()){
             String s9=rs.getString("movie");
             System.out.println(s9);
         if(s9.equals("None")){
         m5.setSelectedItem("None");
         ms5.setText("--:--");
         me5.setText("--:--");
             }
         else{
         m5.setSelectedItem(rs.getString("movie"));
         ms5.setText(rs.getString("start_time"));
         me5.setText(rs.getString("end_time"));
         }
         }
         
             
         JOptionPane.showMessageDialog(this,"Loading Complete");
}
}
catch(Exception e){
    e.printStackTrace();
}
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
   
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
            java.util.logging.Logger.getLogger(screen_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(screen_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(screen_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(screen_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new screen_add().setVisible(true);
            }
        });
    }

    ///Function For the Calculation of Starting And Ending time of Shows/////
 
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jid;
    private javax.swing.JComboBox m1;
    private javax.swing.JComboBox m2;
    private javax.swing.JComboBox m3;
    private javax.swing.JComboBox m4;
    private javax.swing.JComboBox m5;
    private javax.swing.JLabel me1;
    private javax.swing.JLabel me2;
    private javax.swing.JLabel me3;
    private javax.swing.JLabel me4;
    private javax.swing.JLabel me5;
    private javax.swing.JLabel ms1;
    private javax.swing.JLabel ms2;
    private javax.swing.JLabel ms3;
    private javax.swing.JLabel ms4;
    private javax.swing.JLabel ms5;
    private javax.swing.JLabel sstart;
    private javax.swing.JButton supdate;
    private javax.swing.JLabel tend;
    private javax.swing.JTextField tint;
    private javax.swing.JLabel ttime;
    // End of variables declaration//GEN-END:variables

}
