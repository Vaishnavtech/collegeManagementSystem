
import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.FlowLayout;
import java.sql.*;
import java.io.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admission
{
    Admission()
    {
        //Jframe container
        JFrame jfrm = new JFrame("College Portal");
        




        





        
        //set size of the frame
       
        jfrm.setBackground(Color.green);
        jfrm.setSize(700,600);
        jfrm.setLayout(new GridLayout(11,2));
        //Terminate the program when the user closes the application
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create a text based label

        JLabel jlabs=new JLabel("Student ",SwingConstants.RIGHT);
        JLabel jlabs2=new JLabel(" Portal");
        JLabel jlab1 = new JLabel("Name:",SwingConstants.CENTER);
        JLabel jlab2 = new JLabel("Age:",SwingConstants.CENTER);
        JLabel jlab3 = new JLabel("Department:",SwingConstants.CENTER);
        JLabel jlab4 = new JLabel("Address:",SwingConstants.CENTER);
        JLabel jlab5 = new JLabel("UID:",SwingConstants.CENTER);
        JLabel jlabAGE=new JLabel("Gender",SwingConstants.CENTER);
        JLabel jlab5num=new JLabel("Phone",SwingConstants.CENTER);

        JMenuBar menuBar=new JMenuBar();
        
        jfrm.setJMenuBar(menuBar);

      JMenuItem  Student = new JMenuItem("Student");
      JMenuItem  fct = new JMenuItem("Faculty");
      JMenuItem	Courses = new JMenuItem("Courses");
      JMenuItem enrollments =new JMenuItem("Enrollments");
      JMenuItem Tables=new JMenuItem("Tables"); 
      menuBar.add(Student);
      menuBar.add(fct);
      menuBar.add(Courses);
      menuBar.add(enrollments);
      menuBar.add(Tables);
    
      fct.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Create a new JFrame for the new page
            JFrame newFrame = new JFrame("Faculties");
            newFrame.setSize(600, 400);
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close to avoid closing the main application
            newFrame.setVisible(true);
            newFrame.setLayout(new GridLayout(8,2));
             
            JLabel tjlabs=new JLabel("Faculty ",SwingConstants.RIGHT);
            JLabel tjlabs2=new JLabel(" Portal");
            

            JLabel tjlab1 = new JLabel("Name:",SwingConstants.CENTER);
            JLabel tjlab2 = new JLabel("Department Id:",SwingConstants.CENTER);
            JLabel tjlab3 = new JLabel("Department:",SwingConstants.CENTER);
            JLabel tjlab4 = new JLabel("Phone Number:",SwingConstants.CENTER);
            JLabel tjlab5 = new JLabel("Faculty ID:",SwingConstants.CENTER);
    
            JTextField tjt1=new JTextField();
            JTextField tjt2=new JTextField();
            JTextField tjt3=new JTextField();
            JTextField tjt4=new JTextField();
            JTextField tjt5=new JTextField(); 

            JButton tjbtn = new JButton("Register");
            tjbtn.setSize(500,500);

            JButton tjbtn2 = new JButton("Search");
            tjbtn2.setSize(500,500);

          newFrame.add(tjlabs);
          newFrame.add(tjlabs2); 

            newFrame.add(tjlab5);
            newFrame.add(tjt5);

            newFrame.add(tjlab1);
            newFrame.add(tjt1);

            newFrame.add(tjlab2);
            newFrame.add(tjt2);

            newFrame.add(tjlab3);
            newFrame.add(tjt3);

            newFrame.add(tjlab4);
            newFrame.add(tjt4);

            newFrame.add(tjbtn2);
            newFrame.add(tjbtn);

            tjbtn.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.CYAN));
            tjbtn2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.LIGHT_GRAY));

            tjbtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                  String uid=tjt5.getText();

                  String name=tjt1.getText();
                  
                  String branch=tjt3.getText();
                  
                  String number=tjt4.getText();

                  String DID=tjt2.getText(); 


                  int UID=1;
                     UID= Integer.valueOf(uid);
    
    
                  
                  int did= Integer.valueOf(DID);
                   System.out.println( "\n"+ UID + "\n"+name +  "\n"+branch); 
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        
                   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb", "root", "vaishnav");
                 
                   Statement stmt = conn.createStatement();    
                    
                   
                    
                    
                    String sql = "INSERT INTO `teachers`(teacher_id,teacher_name,department_id,department_name,phone_number) VALUE ('"+UID+"','"+name+"','"+did+"','"+branch+"','"+number+"');";
                     stmt.executeUpdate(sql);
        
                     conn.close();
                     
                    }
                    catch(Exception e2)
                   {
                    System.out.println(e2);
                   }
         
                    tjbtn.setText("Registed");
                }
            });





            tjbtn2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                  
    
    
                  
                
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        
                   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb", "root", "vaishnav");
                 

                    String TID=tjt5.getText();
                    
                    int tid= Integer.valueOf(TID);

                   Statement stmt = conn.createStatement();
                   ResultSet rs = stmt.executeQuery("select * from teachers where teacher_id = '"+tid+"' ");
                    
                        

                         if (rs.next()) {
                            String two = rs.getString(2);
                            tjt1.setText(two);
                            tjt3.setText(rs.getString(4));

                        } else {
                            
                            System.out.println("No teacher found with teacher_id: " + tid);
                        }

                     conn.close();
                     
                    }
                    catch(Exception e2)
                   {
                    System.out.println(e2);
                   }
         
                    tjbtn2.setText("Results");
                }
            });
        



           




        }
    });





    Tables.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JFrame newFrame = new JFrame("Tables");
            newFrame.setSize(600, 400);
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close to avoid closing the main application
            newFrame.setVisible(true); 
            newFrame.setLayout(new FlowLayout());


            try{
                Class.forName("com.mysql.jdbc.Driver");
                
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb", "root", "vaishnav");
         


           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("select * from teachers");
            
                

            
             conn.close();
             
            



        }catch(Exception er)
        {}}
    });
















       
Courses.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Create a new JFrame for the new page
            JFrame newFrame = new JFrame("Courses");
            newFrame.setSize(600, 400);
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close to avoid closing the main application
            newFrame.setVisible(true);
            newFrame.setLayout(new GridLayout(8,2));
             

            JButton cjbtn = new JButton("Create Course");
            cjbtn.setSize(500,500);

            JButton cjbtn2 = new JButton();
            cjbtn2.setSize(500,500);


            cjbtn.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.BLUE));
          cjbtn2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.LIGHT_GRAY));

            JLabel cjlabs=new JLabel("Courses ",SwingConstants.RIGHT);
            JLabel cjlabs2=new JLabel(" Portal");



            

            JLabel cjlab1 = new JLabel("Course Name:",SwingConstants.CENTER);
            JLabel cjlab2 = new JLabel("Department Id:",SwingConstants.CENTER);
            JLabel cjlab3 = new JLabel("Credits",SwingConstants.CENTER);
            JLabel cjlab4 = new JLabel("semester:",SwingConstants.CENTER);
            JLabel cjlab5 = new JLabel("Course Id:",SwingConstants.CENTER);
    
            JTextField cjt1=new JTextField();
            JTextField cjt2=new JTextField();
            JTextField cjt3=new JTextField();
            JTextField cjt4=new JTextField();
            JTextField cjt5=new JTextField(); 


          newFrame.add(cjlabs);
          newFrame.add(cjlabs2); 

            

            newFrame.add(cjlab1);
            newFrame.add(cjt1);

            newFrame.add(cjlab5);
            newFrame.add(cjt5);

            newFrame.add(cjlab2);
            newFrame.add(cjt2);

            newFrame.add(cjlab3);
            newFrame.add(cjt3);

            newFrame.add(cjlab4);
            newFrame.add(cjt4);
            

            newFrame.add(cjbtn2);
            newFrame.add(cjbtn);

            cjbtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                  String uid=cjt5.getText();

                  String name=cjt1.getText();

                  String credit=cjt2.getText();

                  String branch=cjt3.getText();
                  
                  String DID=cjt2.getText(); 

                  String SMD=cjt4.getText();

                  int UID=1;
                     UID= Integer.valueOf(uid);
    
    
                  int creDit = Integer.valueOf(credit);
                  int did= Integer.valueOf(DID);
                  int smd=Integer.valueOf(SMD);
                   System.out.println( "\n"+ UID + "\n"+name  + "\n"+branch ); 
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        
                   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb", "root", "vaishnav");
                 
                   Statement stmt = conn.createStatement();    
                    
                   
                    //String sql = "insert into student1(uid,name,age,branch,address) values(UID,name,age,branch,address)";
                    
                    String sql = "INSERT INTO `courses`(course_id,course_name,department_id ,credits,semester ) VALUE ('"+UID+"','"+name+"','"+did+"','"+creDit+"','"+smd+"');";
                     stmt.executeUpdate(sql);
        
                     conn.close();
                     
                    }
                    catch(Exception e2)
                   {
                    System.out.println(e2);
                   }
         
                    cjbtn.setText("Created");
                }
            });




















        }
    });







































    enrollments.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Create a new JFrame for the new page
            JFrame enewFrame = new JFrame("Enrollments");
            enewFrame.setSize(600, 400);
            enewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close to avoid closing the main application
            enewFrame.setVisible(true);
            enewFrame.setLayout(new GridLayout(6,2));
             

            JButton ejbtn = new JButton("Save Enrollment");
            ejbtn.setSize(500,500);

            JButton ejbtn2 = new JButton();
            ejbtn2.setSize(500,500);


            ejbtn.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.YELLOW));
        ejbtn2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.LIGHT_GRAY));

            JLabel ejlabs=new JLabel("Enrollments ",SwingConstants.RIGHT);
            JLabel ejlabs2=new JLabel(" Portal");



            

            JLabel ejlab1 = new JLabel("Student Id:",SwingConstants.CENTER);
            
            JLabel ejlab3 = new JLabel("grade",SwingConstants.CENTER);
            JLabel ejlab4 = new JLabel("enrollment id:",SwingConstants.CENTER);
            JLabel ejlab5 = new JLabel("Course Id:",SwingConstants.CENTER);
    
            JTextField ejt1=new JTextField();
            JTextField ejt2=new JTextField();
            JTextField ejt3=new JTextField();
            JTextField ejt4=new JTextField();
            JTextField ejt5=new JTextField(); 


          enewFrame.add(ejlabs);
          enewFrame.add(ejlabs2); 

            

            enewFrame.add(ejlab1);
            enewFrame.add(ejt1);

            enewFrame.add(ejlab5);
            enewFrame.add(ejt5);

           

            enewFrame.add(ejlab3);
            enewFrame.add(ejt3);

            enewFrame.add(ejlab4);
            enewFrame.add(ejt4);
            

            enewFrame.add(ejbtn2);
            enewFrame.add(ejbtn);

            ejbtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                  String uid=ejt4.getText();

                  String name=ejt1.getText();

                  String credit=ejt2.getText();

                  String grade=ejt3.getText();
                  
                  String CID=ejt5.getText(); 

                  String SMD=ejt4.getText();

                  int UID=1;
                     UID= Integer.valueOf(uid);
    
    
                  
                  int cid= Integer.valueOf(CID);
                  int SID=Integer.valueOf(name);
                   System.out.println( "\n"+ UID + "\n"+name   ); 
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        
                   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb", "root", "vaishnav");
                 
                   Statement stmt = conn.createStatement();    
                    
                   
                    //String sql = "insert into student1(uid,name,age,branch,address) values(UID,name,age,branch,address)";
                    
                    String sql = "INSERT INTO `enrollments`(enrollment_id,Student_id,course_id,grade ) VALUE ('"+UID+"','"+SID+"','"+cid+"','"+grade+"');";
                     stmt.executeUpdate(sql);
        
                     conn.close();
                     
                    }
                    catch(Exception e2)
                   {
                    System.out.println(e2);
                   }
         
                    ejbtn.setText("Saved");
                }
            });



        }
    });
    





























































        JTextField jt1=new JTextField();
        JTextField jt2=new JTextField();
        JTextField jt3=new JTextField();
        JTextField jt4=new JTextField();
        JTextField jt5=new JTextField(); 
        JTextField jt5AGE=new JTextField();
        JTextField jt5num=new JTextField();
        JTextField jtDID=new JTextField();
        
        
        JButton jfc = 
            new JButton("Search");
        //JButton jfc=new JButton("Generate .csv ");
        JButton jbtn = new JButton("Admit");
        jbtn.setSize(500,500);
       
        jbtn.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.green));
        jfc.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.LIGHT_GRAY));
         

         

       

          



         
        jbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              String uid=jt5.getText();
              String name=jt1.getText();
              String AGE=jt2.getText();
              String branch=jt3.getText();
              String address=jt4.getText();
              String gender=jt5AGE.getText();
              String number=jt5num.getText();
              String DID=jtDID.getText(); 
              int UID=1;
                 UID= Integer.valueOf(uid);


              int age = Integer.valueOf(AGE);
              int did= Integer.valueOf(DID);
               System.out.println( "\n"+ UID + "\n"+name + "\n"+age + "\n"+branch + "\n"+address); 
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    
               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb", "root", "vaishnav");
             
               Statement stmt = conn.createStatement();    
                
               
                //String sql = "insert into student1(uid,name,age,branch,address) values(UID,name,age,branch,address)";
                
                String sql = "INSERT INTO `students`(student_id,student_name,age,gender,address,phone_number,department_name,department_id) VALUE ('"+UID+"','"+name+"','"+age+"','"+gender+"','"+address+"','"+number+"','"+branch+"','"+did+"');";
                 stmt.executeUpdate(sql);
    
                 conn.close();
                 
                }
                catch(Exception e2)
               {
                System.out.println(e2);
               }
     
                jbtn.setText("Admited");
            }
        });






        jfc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    
               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegedb", "root", "vaishnav");
             

                String TID=jt5.getText();
                
                int tid= Integer.valueOf(TID);

               Statement stmt = conn.createStatement();
               ResultSet rs = stmt.executeQuery("select * from students where student_id = '"+tid+"' ");
                
                    

                     if (rs.next()) {
                        String two = rs.getString(2);
                        jt1.setText(two);
                        jt2.setText(rs.getString(3));
                        jt5AGE.setText(rs.getString(4));
                        jt4.setText(rs.getString(5));
                        jt3.setText(rs.getString(7));
                        jt5num.setText(rs.getString(6));
                        jtDID.setText(rs.getString(8));
                    } else {
                        
                        System.out.println("No student found with student_id: " + tid);
                    }

                 conn.close();
                 
                }
                catch(Exception e2)
               {
                System.out.println(e2);
               }
     
                jfc.setText("Results");
            }
        });


























        //Add the lable to the content pan
         
        JLabel jDID=new JLabel("Department Id",SwingConstants.CENTER);
         jfrm.add(jlabs);
         jfrm.add(jlabs2);


         jfrm.add(jlab5);
         jfrm.add(jt5);
         jfrm.add(jlab1);
         jfrm.add(jt1);
         jfrm.add(jlab2);
         jfrm.add(jt2);
         jfrm.add(jlab3);
         jfrm.add(jt3);

         jfrm.add(jlab4);
         jfrm.add(jt4);

         jfrm.add(jDID);
         jfrm.add(jtDID);
        

         jfrm.add(jlabAGE);
         jfrm.add(jt5AGE);

         jfrm.add(jlab5num);
         jfrm.add(jt5num);
         
         jfrm.add(jfc); 
        jfrm.add(jbtn);

        JTable jt =new JTable();
        jfrm.add(jt);
        
        jfrm.setVisible(true);
        
    }








    
    public static void main(String[] args) {
      
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                new Admission();
               

            }
        });
    
}}
