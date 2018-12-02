import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class pizzadeliverymanagmentsystem implements ActionListener {
    FileReader records;
    Scanner scan = new Scanner(System.in);
    int totalbill=0;
    PrintWriter writer;
    final int pricesmallpizza = 300,pricemediumpizza=750,pricelargepizza=900;
    int pizza1smallprice,pizza1regularprice,pizza1largeprice,pizza2smallprice,pizza2regularprice,pizza2largeprice,
            pizza3smallprice,pizza3regularprice,pizza3largeprice,pizza4smallprice,pizza4regularprice,pizza4largeprice;
    JFrame amframe,adminframe,changeuserpassframe;
    JLabel titlelabel = new JLabel("Pizza Delivery Management System");
    JLabel developerlabel = new JLabel("Developed By Abdul Muizz");
    JLabel namelabel = new JLabel("Name");
    JLabel addresslabel = new JLabel("Address");
    JLabel phonenumberlabel = new JLabel("Phone number");
    JTextField namefield = new JTextField();
    JTextField addressfield = new JTextField();
    JTextField phonenumberfield = new JTextField();
    JCheckBox pizza1 = new JCheckBox("Chicken Tikka Pizza");
    JCheckBox pizza2 = new JCheckBox("Chicken Bonefire Pizza");
    JCheckBox pizza3 = new JCheckBox("Chicken Fajita Pizza");
    JCheckBox pizza4 = new JCheckBox("Chicken Supreme Pizza");
    JCheckBox pizza1small = new JCheckBox("Small");
    JCheckBox pizza1regular = new JCheckBox("Regular");
    JCheckBox pizza1large = new JCheckBox("Large");
    JCheckBox pizza2small = new JCheckBox("Small");
    JCheckBox pizza2regular = new JCheckBox("Regular");
    JCheckBox pizza2large = new JCheckBox("Large");
    JCheckBox pizza3small = new JCheckBox("Small");
    JCheckBox pizza3regular = new JCheckBox("Regular");
    JCheckBox pizza3large = new JCheckBox("Large");
    JCheckBox pizza4small = new JCheckBox("Small");
    JCheckBox pizza4regular = new JCheckBox("Regular");
    JCheckBox pizza4large = new JCheckBox("Large");
    JButton printbutton = new JButton("Print Bill");
    JLabel pizza1smallquantitylabel = new JLabel("Quantity");
    JLabel pizza1regularquantitylabel = new JLabel("Quantity");
    JLabel pizza1largedquantitylabel = new JLabel("Quantity");
    JLabel pizza2smallquantitylabel = new JLabel("Quantity");
    JLabel pizza2regularquantitylabel = new JLabel("Quantity");
    JLabel pizza2largedquantitylabel = new JLabel("Quantity");
    JLabel pizza3smallquantitylabel = new JLabel("Quantity");
    JLabel pizza3regularquantitylabel = new JLabel("Quantity");
    JLabel pizza3largedquantitylabel = new JLabel("Quantity");
    JLabel pizza4smallquantitylabel = new JLabel("Quantity");
    JLabel pizza4regularquantitylabel = new JLabel("Quantity");
    JLabel pizza4largedquantitylabel = new JLabel("Quantity");
    JTextField pizza1smallquantityfield = new JTextField();
    JTextField pizza2smallquantityfield = new JTextField();
    JTextField pizza3smallquantityfield = new JTextField();
    JTextField pizza4smallquantityfield = new JTextField();
    JTextField pizza1regularquantityfield = new JTextField();
    JTextField pizza2regularquantityfield = new JTextField();
    JTextField pizza3regularquantityfield = new JTextField();
    JTextField pizza4regularquantityfield = new JTextField();
    JTextField pizza1largequantityfield = new JTextField();
    JTextField pizza2largequantityfield = new JTextField();
    JTextField pizza3largequantityfield = new JTextField();
    JTextField pizza4largequantityfield = new JTextField();
    JLabel withoutspacename = new JLabel("(without space)");
    JLabel withoutspacephoneno = new JLabel("(without space)");
    JDialog totalbilldialog = new JDialog(amframe,"Total Bill",true);
    JLabel adminlogintitle = new JLabel("Admin Login");
    JLabel adminusernamelabel = new JLabel("Username");
    JLabel adminpasswordlabel = new JLabel("Password");
    JLabel defaultuserpasslabel = new JLabel("Default Username and Password is comsats");
    JTextField adminusernamefield = new JTextField();
    JPasswordField adminpasswordfield = new JPasswordField();
    JButton adminlogin = new JButton("Login");
    JButton adminexit = new JButton("Exit");
    JButton changeusernamepassbutton = new JButton("Change Username and Password");
    JButton clearallbutton = new JButton("Clear All");
    JButton logoutbutton = new JButton("Log Out");
    JButton showrecord = new JButton("Show Record On Console");


    public pizzadeliverymanagmentsystem() {
        adminloginform();
        changeusernamegui();
        setFrame();
        allcomponentsdetails();
        actionlisteneradd();

    }
    public void adminloginform(){
        adminframe = new JFrame("Admin Login");
        adminframe.setSize(300,400);
        adminframe.setResizable(false);
        adminframe.getContentPane().setBackground(Color.WHITE);
        adminframe.setLocationRelativeTo(null);
        adminframe.getContentPane().setLayout(null);
        adminframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        adminframe.getRootPane().setDefaultButton(adminlogin);
        ///login title label
        adminlogintitle.setFont(new Font("Arial",Font.BOLD,20));
        adminlogintitle.setBounds(90,10,150,50);
        adminframe.add(adminlogintitle);
        //default user pass label
        defaultuserpasslabel.setFont(new Font("Arial",Font.PLAIN,11));
        defaultuserpasslabel.setBounds(30,30,260,50);
        adminframe.add(defaultuserpasslabel);
        //login username label
        adminusernamelabel.setBounds(20,60,60,50);
        adminframe.add(adminusernamelabel);
        //username field
        adminusernamefield.setBounds(90,70,150,30);
        adminusernamefield.setFont(new Font("Arial",Font.PLAIN,15));
        adminframe.add(adminusernamefield);
        //login password label
        adminpasswordlabel.setBounds(20,100,60,50);
        adminframe.add(adminpasswordlabel);
        //password field
        adminpasswordfield.setBounds(90,110,150,30);
        adminpasswordfield.setFont(new Font("Arial",Font.PLAIN,15));
        adminframe.add(adminpasswordfield);
        //login button
        adminlogin.setBounds(100,160,80,30);
        adminlogin.setBackground(Color.WHITE);
        adminlogin.setForeground(Color.black);
        adminframe.add(adminlogin);
        //change username and password button
        changeusernamepassbutton.setBounds(20,210,250,30);
        changeusernamepassbutton.setFont(new Font("Arial",Font.BOLD,12));
        changeusernamepassbutton.setBackground(Color.WHITE);
        changeusernamepassbutton.setForeground(Color.BLACK);
        adminframe.add(changeusernamepassbutton);
        adminexit.setBounds(100,260,80,30);
        adminexit.setBackground(Color.WHITE);
        adminexit.setForeground(Color.BLACK);
        adminframe.add(adminexit);
        adminframe.setVisible(true);
        ActionListener loginlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==adminlogin){
                    String username = adminusernamefield.getText();
                    String password = String.valueOf(adminpasswordfield.getPassword());
                    File f = new File("login.txt");
                    if(!f.exists()) {
                        try {
                            writer = new PrintWriter("login.txt");
                            writer.println("comsats");
                            writer.println("comsats");
                            writer.close();
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }
                    try {
                        scan = new Scanner(new File("login.txt"));


                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    String user = scan.next().toLowerCase();
                    String pass = scan.next().toLowerCase();
                    if(username.equals(user)&&password.equals(pass)){
                        JOptionPane.showMessageDialog(amframe,"Login Successful");
                        adminframe.setVisible(false);
                        adminpasswordfield.setText("");
                        amframe.setVisible(true);

                    }
                    else{
                        adminusernamefield.setText("");
                        adminpasswordfield.setText("");
                        JOptionPane.showMessageDialog(adminframe, "Wrong username or password");
                    }
                }
                if(e.getSource()==changeusernamepassbutton){
                    adminframe.setVisible(false);
                    adminpasswordfield.setText("");
                    changeuserpassframe.setVisible(true);


                }
                if(e.getSource()==adminexit){
                    System.exit(1);
                }
            }
        };
        adminlogin.addActionListener(loginlistener);
        adminexit.addActionListener(loginlistener);
        changeusernamepassbutton.addActionListener(loginlistener);

    }
    public void changeusernamegui(){
        changeuserpassframe = new JFrame("Admin Login");
        changeuserpassframe.setSize(320,300);
        changeuserpassframe.setResizable(false);
        changeuserpassframe.getContentPane().setBackground(Color.WHITE);
        changeuserpassframe.getContentPane().setLayout(null);
        changeuserpassframe.setLocationRelativeTo(null);
        changeuserpassframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel newusername = new JLabel("Enter New Username");
        JLabel newpass = new JLabel("Enter New Password");
        JTextField newuserfield = new JTextField();
        JPasswordField newpassfield = new JPasswordField();
        JButton changeuser = new JButton("Change");
        JButton back = new JButton("Go Back");
        changeuserpassframe.getRootPane().setDefaultButton(changeuser);

        newusername.setBounds(20,60,200,50);
        changeuserpassframe.add(newusername);
        //username field
        newuserfield.setBounds(150,70,150,30);
        newuserfield.setFont(new Font("Arial",Font.PLAIN,15));
        changeuserpassframe.add(newuserfield);
        //login password label
        newpass.setBounds(20,100,200,50);
        changeuserpassframe.add(newpass);
        //password field
        newpassfield.setBounds(150,110,150,30);
        newpassfield.setFont(new Font("Arial",Font.PLAIN,15));
        changeuserpassframe.add(newpassfield);
        //login button
        changeuser.setBounds(100,160,80,30);
        changeuser.setBackground(Color.WHITE);
        changeuser.setForeground(Color.black);
        changeuserpassframe.add(changeuser);
        back.setBounds(90,200,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        changeuserpassframe.add(back);
        ActionListener newuserpass = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back){
                    changeuserpassframe.setVisible(false);
                    newuserfield.setText("");
                    newpassfield.setText("");
                    adminframe.setVisible(true);
                }
                if(e.getSource()==changeuser){
                    String newusername = newuserfield.getText();
                    String newpassword = String.valueOf(newpassfield.getPassword());
                    PrintWriter writer = null;
                    try {
                        writer = new PrintWriter("login.txt");
                        writer.println(newusername);
                        writer.println(newpassword);
                        writer.close();

                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(changeuserpassframe,"Username and Password Changed Successful");
                    changeuserpassframe.setVisible(false);
                    newuserfield.setText("");
                    newpassfield.setText("");
                    adminframe.setVisible(true);

                }

            }
        };
        changeuser.addActionListener(newuserpass);
        back.addActionListener(newuserpass);



    }

    private void actionlisteneradd() {
        printbutton.addActionListener(this);
        //checkboxes
        pizza1.addActionListener(this);
        pizza2.addActionListener(this);
        pizza3.addActionListener(this);
        pizza4.addActionListener(this);
        pizza1small.addActionListener(this);
        pizza1regular.addActionListener(this);
        pizza1large.addActionListener(this);
        pizza2small.addActionListener(this);
        pizza2regular.addActionListener(this);
        pizza2large.addActionListener(this);
        pizza3small.addActionListener(this);
        pizza3regular.addActionListener(this);
        pizza3large.addActionListener(this);
        pizza4small.addActionListener(this);
        pizza4regular.addActionListener(this);
        pizza4large.addActionListener(this);
        pizza1smallquantityfield.addActionListener(this);
        pizza1regularquantityfield.addActionListener(this);
        pizza1largequantityfield.addActionListener(this);
        pizza2smallquantityfield.addActionListener(this);
        pizza2regularquantityfield.addActionListener(this);
        pizza2largequantityfield.addActionListener(this);
        pizza3smallquantityfield.addActionListener(this);
        pizza3regularquantityfield.addActionListener(this);
        pizza3largequantityfield.addActionListener(this);
        pizza4smallquantityfield.addActionListener(this);
        pizza4regularquantityfield.addActionListener(this);
        pizza4largequantityfield.addActionListener(this);
    }

    public void setFrame() {
        amframe = new JFrame();
        amframe.setTitle("Pizza Delivery Management System");
        amframe.setSize(800, 750);
        amframe.setResizable(false);
        amframe.getContentPane().setBackground(Color.WHITE);
        amframe.setLocationRelativeTo(null);
        amframe.getContentPane().setLayout(null);
        amframe.getRootPane().setDefaultButton(printbutton);
        amframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    private void allcomponentsdetails() {
        ///title label properties
        titlelabel.setBounds(180, 20, 500, 40);
        titlelabel.setFont(new Font("Arial", Font.PLAIN, 30));
        titlelabel.setForeground(Color.BLUE);
        amframe.add(titlelabel);
        developerlabel.setBounds(350,40,150,60);
        developerlabel.setFont(new Font("Arial", Font.PLAIN, 10));
        developerlabel.setForeground(Color.BLUE);
        amframe.add(developerlabel);


        //name label properties
        namelabel.setBounds(20, 70, 40, 50);
        namelabel.setFont(new Font("Arial", Font.PLAIN, 15));
        namelabel.setForeground(Color.BLACK);
        amframe.add(namelabel);
        withoutspacename.setBounds(20,90,70,50);
        withoutspacename.setFont(new Font("Arial", Font.PLAIN, 9));
        withoutspacename.setForeground(Color.BLACK);
        amframe.add(withoutspacename);

        ///name textfield properties
        namefield.setBounds(80, 80, 700, 30);
        namefield.setFont(new Font("Arial", Font.PLAIN, 15));
        amframe.add(namefield);


        //address label properties
        addresslabel.setBounds(20, 140, 80, 50);
        addresslabel.setFont(new Font("Arial", Font.PLAIN, 15));
        addressfield.setForeground(Color.BLACK);
        amframe.add(addresslabel);
        //address textfield properties
        addressfield.setBounds(80, 150, 700, 30);
        addressfield.setFont(new Font("Arial", Font.PLAIN, 15));
        amframe.add(addressfield);


        //phonenumberlabelproperties
        phonenumberlabel.setBounds(20, 210, 100, 50);
        phonenumberlabel.setFont(new Font("Arial", Font.PLAIN, 15));
        phonenumberlabel.setForeground(Color.BLACK);
        amframe.add(phonenumberlabel);
        withoutspacephoneno.setBounds(20,230,70,50);
        withoutspacephoneno.setFont(new Font("Arial", Font.PLAIN, 9));
        withoutspacephoneno.setForeground(Color.BLACK);
        amframe.add(withoutspacephoneno);
        //phonenumber textfield properties
        phonenumberfield.setBounds(120, 220, 660, 30);
        phonenumberfield.setFont(new Font("Arial", Font.PLAIN, 15));
        amframe.add(phonenumberfield);

        //Checkbox 1 Chicken tikka pizza properties
        pizza1.setBounds(20, 280, 150, 30);
        pizza1.setBackground(Color.WHITE);
        amframe.add(pizza1);
        //small regular large properties
        pizza1small.setBounds(300,280,100,30);
        pizza1small.setBackground(Color.WHITE);
        amframe.add(pizza1small);
        pizza1regular.setBounds(450,280,100,30);
        pizza1regular.setBackground(Color.WHITE);
        amframe.add(pizza1regular);
        pizza1large.setBounds(600,280,100,30);
        pizza1large.setBackground(Color.WHITE);
        amframe.add(pizza1large);
        //quantity of small,regular and large
        pizza1smallquantitylabel.setBounds(270,320,100,30);
        pizza1smallquantityfield.setBackground(Color.WHITE);
        amframe.add(pizza1smallquantitylabel);
        pizza1smallquantityfield.setBounds(340,315,40,40);
        amframe.add(pizza1smallquantityfield);

        pizza1regularquantitylabel.setBounds(430,320,100,30);
        pizza1regularquantitylabel.setBackground(Color.WHITE);
        amframe.add(pizza1regularquantitylabel);
        pizza1regularquantityfield.setBounds(490,315,40,40);
        amframe.add(pizza1regularquantityfield);

        pizza1largedquantitylabel.setBounds(580,320,100,30);
        pizza1largedquantitylabel.setBackground(Color.WHITE);
        amframe.add(pizza1largedquantitylabel);
        pizza1largequantityfield.setBounds(640,315,40,40);
        amframe.add(pizza1largequantityfield);



        //Checkbox 2 chicken bonefire pizza properties
        pizza2.setBounds(20, 360, 170, 30);
        pizza2.setBackground(Color.WHITE);
        amframe.add(pizza2);
        //small regular large checkpoint properties
        pizza2small.setBounds(300,360,100,30);
        pizza2small.setBackground(Color.WHITE);
        amframe.add(pizza2small);
        pizza2regular.setBounds(450,360,100,30);
        pizza2regular.setBackground(Color.WHITE);
        amframe.add(pizza2regular);
        pizza2large.setBounds(600,360,100,30);
        pizza2large.setBackground(Color.WHITE);
        amframe.add(pizza2large);
        //quantity of small,regular and large
        pizza2smallquantitylabel.setBounds(270,400,100,30);
        pizza2smallquantityfield.setBackground(Color.WHITE);
        amframe.add(pizza2smallquantitylabel);
        pizza2smallquantityfield.setBounds(340,395,40,40);
        amframe.add(pizza2smallquantityfield);

        pizza2regularquantitylabel.setBounds(430,400,100,30);
        pizza2regularquantitylabel.setBackground(Color.WHITE);
        amframe.add(pizza2regularquantitylabel);
        pizza2regularquantityfield.setBounds(490,395,40,40);
        amframe.add(pizza2regularquantityfield);

        pizza2largedquantitylabel.setBounds(580,400,100,30);
        pizza2largedquantitylabel.setBackground(Color.WHITE);
        amframe.add(pizza2largedquantitylabel);
        pizza2largequantityfield.setBounds(640,395,40,40);
        amframe.add(pizza2largequantityfield);


        //Checkbox 3 chicken fajita pizza properties
        pizza3.setBounds(20, 440, 170, 30);
        pizza3.setBackground(Color.WHITE);
        amframe.add(pizza3);
        //small regular large checkpoint properties
        pizza3small.setBounds(300,440,100,30);
        pizza3small.setBackground(Color.WHITE);
        amframe.add(pizza3small);
        pizza3regular.setBounds(450,440,100,30);
        pizza3regular.setBackground(Color.WHITE);
        amframe.add(pizza3regular);
        pizza3large.setBounds(600,440,100,30);
        pizza3large.setBackground(Color.WHITE);
        amframe.add(pizza3large);
        //quantity of small,regular and large
        pizza3smallquantitylabel.setBounds(270,480,100,30);
        pizza3smallquantityfield.setBackground(Color.WHITE);
        amframe.add(pizza3smallquantitylabel);
        pizza3smallquantityfield.setBounds(340,475,40,40);
        amframe.add(pizza3smallquantityfield);

        pizza3regularquantitylabel.setBounds(430,480,100,30);
        pizza3regularquantitylabel.setBackground(Color.WHITE);
        amframe.add(pizza3regularquantitylabel);
        pizza3regularquantityfield.setBounds(490,475,40,40);
        amframe.add(pizza3regularquantityfield);

        pizza3largedquantitylabel.setBounds(580,480,100,30);
        pizza3largedquantitylabel.setBackground(Color.WHITE);
        amframe.add(pizza3largedquantitylabel);
        pizza3largequantityfield.setBounds(640,475,40,40);
        amframe.add(pizza3largequantityfield);


        //Checkbox 4 chicken supreme pizza properties
        pizza4.setBounds(20, 520, 170, 30);
        pizza4.setBackground(Color.WHITE);
        amframe.add(pizza4);
        //small regular large checkpoint properties
        pizza4small.setBounds(300,520,100,30);
        pizza4small.setBackground(Color.WHITE);
        amframe.add(pizza4small);
        pizza4regular.setBounds(450,520,100,30);
        pizza4regular.setBackground(Color.WHITE);
        amframe.add(pizza4regular);
        pizza4large.setBounds(600,520,100,30);
        pizza4large.setBackground(Color.WHITE);
        amframe.add(pizza4large);
        //quantity of small,regular and large
        pizza4smallquantitylabel.setBounds(270,560,100,30);
        pizza4smallquantityfield.setBackground(Color.WHITE);
        amframe.add(pizza4smallquantitylabel);
        pizza4smallquantityfield.setBounds(340,555,40,40);
        amframe.add(pizza4smallquantityfield);

        pizza4regularquantitylabel.setBounds(430,560,100,30);
        pizza4regularquantitylabel.setBackground(Color.WHITE);
        amframe.add(pizza4regularquantitylabel);
        pizza4regularquantityfield.setBounds(490,555,40,40);
        amframe.add(pizza4regularquantityfield);

        pizza4largedquantitylabel.setBounds(580,560,100,30);
        pizza4largedquantitylabel.setBackground(Color.WHITE);
        amframe.add(pizza4largedquantitylabel);
        pizza4largequantityfield.setBounds(640,555,40,40);
        amframe.add(pizza4largequantityfield);
        ///false due to check
        pizza1small.setEnabled(false);
        pizza1regular.setEnabled(false);
        pizza1large.setEnabled(false);
        pizza2small.setEnabled(false);
        pizza2regular.setEnabled(false);
        pizza2large.setEnabled(false);
        pizza3small.setEnabled(false);
        pizza3regular.setEnabled(false);
        pizza3large.setEnabled(false);
        pizza4small.setEnabled(false);
        pizza4regular.setEnabled(false);
        pizza4large.setEnabled(false);
        //label false due to check
        pizza1smallquantitylabel.setEnabled(false);
        pizza1regularquantitylabel.setEnabled(false);
        pizza1largedquantitylabel.setEnabled(false);
        pizza2smallquantitylabel.setEnabled(false);
        pizza2regularquantitylabel.setEnabled(false);
        pizza2largedquantitylabel.setEnabled(false);
        pizza3smallquantitylabel.setEnabled(false);
        pizza3regularquantitylabel.setEnabled(false);
        pizza3largedquantitylabel.setEnabled(false);
        pizza4smallquantitylabel.setEnabled(false);
        pizza4regularquantitylabel.setEnabled(false);
        pizza4largedquantitylabel.setEnabled(false);
        //field false due to check
        pizza1smallquantityfield.setEnabled(false);
        pizza1regularquantityfield.setEnabled(false);
        pizza1largequantityfield.setEnabled(false);
        pizza2smallquantityfield.setEnabled(false);
        pizza2regularquantityfield.setEnabled(false);
        pizza2largequantityfield.setEnabled(false);
        pizza3smallquantityfield.setEnabled(false);
        pizza3regularquantityfield.setEnabled(false);
        pizza3largequantityfield.setEnabled(false);
        pizza4smallquantityfield.setEnabled(false);
        pizza4regularquantityfield.setEnabled(false);
        pizza4largequantityfield.setEnabled(false);


        //print bill button properties
        printbutton.setBounds(600, 650, 100, 50);
        printbutton.setBackground(Color.WHITE);
        printbutton.setForeground(Color.black);
        amframe.add(printbutton);
        //clear button
        clearallbutton.setBounds(480,650,100,50);
        clearallbutton.setBackground(Color.WHITE);
        clearallbutton.setForeground(Color.black);
        amframe.add(clearallbutton);
        logoutbutton.setBounds(360,650,100,50);
        logoutbutton.setBackground(Color.WHITE);
        logoutbutton.setForeground(Color.black);
        amframe.add(logoutbutton);
        showrecord.setBounds(150,650,200,50);
        showrecord.setBackground(Color.WHITE);
        showrecord.setForeground(Color.black);
        amframe.add(showrecord);
        ActionListener clearloglistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==clearallbutton){
                    namefield.setText("");
                    addressfield.setText("");
                    phonenumberfield.setText("");
                    pizza1smallquantityfield.setText("");
                    pizza1regularquantityfield.setText("");
                    pizza1largequantityfield.setText("");
                    pizza2smallquantityfield.setText("");
                    pizza2regularquantityfield.setText("");
                    pizza2largequantityfield.setText("");
                    pizza3smallquantityfield.setText("");
                    pizza3regularquantityfield.setText("");
                    pizza3largequantityfield.setText("");
                    pizza4smallquantityfield.setText("");
                    pizza4regularquantityfield.setText("");
                    pizza4largequantityfield.setText("");
                }
                if(e.getSource()==logoutbutton){
                    amframe.setVisible(false);
                    adminframe.setVisible(true);
                    namefield.setText("");
                    addressfield.setText("");
                    phonenumberfield.setText("");
                    pizza1.setSelected(false);
                    pizza2.setSelected(false);
                    pizza3.setSelected(false);
                    pizza4.setSelected(false);


                }
                if(e.getSource()==showrecord){
                    File recordcheck = new File("record.txt");
                    if(!recordcheck.exists()){
                        try {
                            recordcheck.createNewFile();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null,"No Record Found");
                    }
                    try {
                        records = new FileReader("record.txt");
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }


                    BufferedReader recordbuffer = new BufferedReader(records);
                    String read = null;
                    try {
                        read = recordbuffer.readLine();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    while(read!=null) {
                        System.out.println(read);
                        try {
                            read = recordbuffer.readLine();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    try {
                        records.close();
                        recordbuffer.close();

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }


            }
        };
        clearallbutton.addActionListener(clearloglistener);
        logoutbutton.addActionListener(clearloglistener);
        showrecord.addActionListener(clearloglistener);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        boolean pizza1smallfieldcheck = false;
        boolean pizza1regularfieldcheck = false;
        boolean pizza1largefieldcheck = false;
        boolean pizza2smallfieldcheck = false;
        boolean pizza2regularfieldcheck = false;
        boolean pizza2largefieldcheck = false;
        boolean pizza3smallfieldcheck = false;
        boolean pizza3regularfieldcheck = false;
        boolean pizza3largefieldcheck = false;
        boolean pizza4smallfieldcheck = false;
        boolean pizza4regularfieldcheck = false;
        boolean pizza4largefieldcheck = false;
        if (pizza1.isSelected()) {
            pizza1small.setEnabled(true);
            pizza1regular.setEnabled(true);
            pizza1large.setEnabled(true);
        }
        //pizza small check
        if (pizza1small.isSelected()){
            pizza1smallquantityfield.setEnabled(true);
            pizza1smallquantitylabel.setEnabled(true);
            pizza1smallfieldcheck=true;
        }
        if (!pizza1small.isSelected()){
            pizza1smallquantityfield.setEnabled(false);
            pizza1smallquantitylabel.setEnabled(false);
            pizza1smallquantityfield.setText("");
            pizza1smallfieldcheck=false;

        }

        if (pizza1regular.isSelected()){
            pizza1regularquantityfield.setEnabled(true);
            pizza1regularquantitylabel.setEnabled(true);
            pizza1regularfieldcheck = true;

        }
        if (!pizza1regular.isSelected()){
            pizza1regularquantityfield.setEnabled(false);
            pizza1regularquantitylabel.setEnabled(false);
            pizza1regularquantityfield.setText("");
            pizza1regularfieldcheck=false;
        }
        if (pizza1large.isSelected()){
            pizza1largequantityfield.setEnabled(true);
            pizza1largedquantitylabel.setEnabled(true);
            pizza1largefieldcheck=true;

        }
        if (!pizza1large.isSelected()){
            pizza1largequantityfield.setEnabled(false);
            pizza1largedquantitylabel.setEnabled(false);
            pizza1largequantityfield.setText("");
            pizza1largefieldcheck=false;
        }
        //pizza 2 check
        if (pizza2small.isSelected()){
            pizza2smallquantityfield.setEnabled(true);
            pizza2smallquantitylabel.setEnabled(true);
            pizza2smallfieldcheck=true;

        }
        if (!pizza2small.isSelected()){
            pizza2smallquantityfield.setEnabled(false);
            pizza2smallquantitylabel.setEnabled(false);
            pizza2smallquantityfield.setText("");
            pizza2smallfieldcheck=false;

        }
        if (pizza2regular.isSelected()){
            pizza2regularquantityfield.setEnabled(true);
            pizza2regularquantitylabel.setEnabled(true);
            pizza2regularfieldcheck=true;


        }
        if (!pizza2regular.isSelected()){
            pizza2regularquantityfield.setEnabled(false);
            pizza2regularquantitylabel.setEnabled(false);
            pizza2regularquantityfield.setText("");
            pizza2regularfieldcheck=false;

        }
        if (pizza2large.isSelected()){
            pizza2largequantityfield.setEnabled(true);
            pizza2largedquantitylabel.setEnabled(true);
            pizza2largefieldcheck=true;

        }
        if (!pizza2large.isSelected()){
            pizza2largequantityfield.setEnabled(false);
            pizza2largedquantitylabel.setEnabled(false);
            pizza2largequantityfield.setText("");
            pizza2largefieldcheck=false;

        }
        //pizza 3 check
        if (pizza3small.isSelected()){
            pizza3smallquantityfield.setEnabled(true);
            pizza3smallquantitylabel.setEnabled(true);
            pizza3smallfieldcheck=true;

        }
        if (!pizza3small.isSelected()){
            pizza3smallquantityfield.setEnabled(false);
            pizza3smallquantitylabel.setEnabled(false);
            pizza3smallquantityfield.setText("");
            pizza3smallfieldcheck=false;

        }
        if (pizza3regular.isSelected()){
            pizza3regularquantityfield.setEnabled(true);
            pizza3regularquantitylabel.setEnabled(true);
            pizza3regularfieldcheck=true;

        }
        if (!pizza3regular.isSelected()){
            pizza3regularquantityfield.setEnabled(false);
            pizza3regularquantitylabel.setEnabled(false);
            pizza3regularquantityfield.setText("");
            pizza3regularfieldcheck=false;

        }
        if (pizza3large.isSelected()){
            pizza3largequantityfield.setEnabled(true);
            pizza3largedquantitylabel.setEnabled(true);
            pizza3largefieldcheck=true;

        }
        if (!pizza3large.isSelected()){
            pizza3largequantityfield.setEnabled(false);
            pizza3largedquantitylabel.setEnabled(false);
            pizza3largequantityfield.setText("");
            pizza3largefieldcheck=false;

        }
        //pizza 4 check
        if (pizza4small.isSelected()){
            pizza4smallquantityfield.setEnabled(true);
            pizza4smallquantitylabel.setEnabled(true);
            pizza4smallfieldcheck=true;

        }
        if (!pizza4small.isSelected()){
            pizza4smallquantityfield.setEnabled(false);
            pizza4smallquantitylabel.setEnabled(false);
            pizza4smallquantityfield.setText("");
            pizza4smallfieldcheck=false;

        }
        if (pizza4regular.isSelected()){
            pizza4regularquantityfield.setEnabled(true);
            pizza4regularquantitylabel.setEnabled(true);
            pizza4regularfieldcheck=true;

        }
        if (!pizza4regular.isSelected()){
            pizza4regularquantityfield.setEnabled(false);
            pizza4regularquantitylabel.setEnabled(false);
            pizza4regularquantityfield.setText("");
            pizza4regularfieldcheck=false;

        }
        if (pizza4large.isSelected()){
            pizza4largequantityfield.setEnabled(true);
            pizza4largedquantitylabel.setEnabled(true);
            pizza4largefieldcheck=true;

        }
        if (!pizza4large.isSelected()){
            pizza4largequantityfield.setEnabled(false);
            pizza4largedquantitylabel.setEnabled(false);
            pizza4largequantityfield.setText("");
            pizza4largefieldcheck=false;

        }
        if (!pizza1.isSelected()) {
            pizza1smallquantityfield.setText("");
            pizza1regularquantityfield.setText("");
            pizza2largequantityfield.setText("");
            pizza1small.setSelected(false);
            pizza1regular.setSelected(false);
            pizza1large.setSelected(false);
            pizza1small.setEnabled(false);
            pizza1regular.setEnabled(false);
            pizza1large.setEnabled(false);
            pizza1smallquantityfield.setEnabled(false);
            pizza1smallquantitylabel.setEnabled(false);
            pizza1regularquantityfield.setEnabled(false);
            pizza1regularquantitylabel.setEnabled(false);
            pizza1largequantityfield.setEnabled(false);
            pizza1largedquantitylabel.setEnabled(false);



        }
        if (pizza2.isSelected()) {
            pizza2small.setEnabled(true);
            pizza2regular.setEnabled(true);
            pizza2large.setEnabled(true);


        }
        if (!pizza2.isSelected()) {
            pizza2smallquantityfield.setText("");
            pizza2regularquantityfield.setText("");
            pizza2largequantityfield.setText("");

            pizza2small.setSelected(false);
            pizza2regular.setSelected(false);
            pizza2large.setSelected(false);
            pizza2small.setEnabled(false);
            pizza2regular.setEnabled(false);
            pizza2large.setEnabled(false);
            pizza2smallquantityfield.setEnabled(false);
            pizza2smallquantitylabel.setEnabled(false);
            pizza2regularquantityfield.setEnabled(false);
            pizza2regularquantitylabel.setEnabled(false);
            pizza2largequantityfield.setEnabled(false);
            pizza2largedquantitylabel.setEnabled(false);
            pizza2smallfieldcheck=false;
            pizza2regularfieldcheck=false;
            pizza2largefieldcheck=false;


        }
        if (pizza3.isSelected()) {
            pizza3small.setEnabled(true);
            pizza3regular.setEnabled(true);
            pizza3large.setEnabled(true);


        }
        if (!pizza3.isSelected()) {
            pizza3smallquantityfield.setText("");
            pizza3regularquantityfield.setText("");
            pizza3largequantityfield.setText("");

            pizza3small.setSelected(false);
            pizza3regular.setSelected(false);
            pizza3large.setSelected(false);
            pizza3small.setEnabled(false);
            pizza3regular.setEnabled(false);
            pizza3large.setEnabled(false);
            pizza3smallquantityfield.setEnabled(false);
            pizza3smallquantitylabel.setEnabled(false);
            pizza3regularquantityfield.setEnabled(false);
            pizza3regularquantitylabel.setEnabled(false);
            pizza3largequantityfield.setEnabled(false);
            pizza3largedquantitylabel.setEnabled(false);
            pizza3smallfieldcheck=false;
            pizza3regularfieldcheck=false;
            pizza3largefieldcheck=false;




        }
        if (pizza4.isSelected()) {
            pizza4small.setEnabled(true);
            pizza4regular.setEnabled(true);
            pizza4large.setEnabled(true);

        }
        if (!pizza4.isSelected()) {
            pizza4smallquantityfield.setText("");
            pizza4regularquantityfield.setText("");
            pizza4largequantityfield.setText("");


            pizza4small.setSelected(false);
            pizza4regular.setSelected(false);
            pizza4large.setSelected(false);

            pizza4small.setEnabled(false);
            pizza4regular.setEnabled(false);
            pizza4large.setEnabled(false);
            pizza4smallquantityfield.setEnabled(false);
            pizza4smallquantitylabel.setEnabled(false);
            pizza4regularquantityfield.setEnabled(false);
            pizza4regularquantitylabel.setEnabled(false);
            pizza4largequantityfield.setEnabled(false);
            pizza4largedquantitylabel.setEnabled(false);
            pizza4smallfieldcheck=false;
            pizza4regularfieldcheck=false;
            pizza4largefieldcheck=false;
        }
        if (source == printbutton) {
            String name = namefield.getText().toUpperCase();
            boolean namecheck = true;
            if(name.equals("")){
                JOptionPane.showMessageDialog(amframe, "Name field cannot be empty");
                namefield.setText("");
                namecheck = false;

            }
            for (int i = 0; i < name.length()-1; i++) {
                char check = name.charAt(i);
                if(check>='A'&&check<='Z'){
                }
                else{
                    JOptionPane.showMessageDialog(amframe, "Wrong name");
                    namefield.setBackground(Color.RED);
                    namefield.setText("");
                    namecheck = false;
                    break;
                }
            }
            StringBuilder address = new StringBuilder(addressfield.getText());
            String phonenumber = phonenumberfield.getText();
            boolean phonenumbercheck = true;
            if (phonenumber.equals("")){
                JOptionPane.showMessageDialog(amframe, "Phone number cannot be empty");
                phonenumberfield.setText("");
                phonenumbercheck = false;
            }
            for (int i = 0; i < phonenumber.length(); i++) {
                char check = phonenumber.charAt(i);
                if (check >= '0' && check <= '9') {
                } else {
                    JOptionPane.showMessageDialog(amframe, "Wrong phone number");
                    phonenumberfield.setText("");
                    phonenumbercheck = false;
                    phonenumberfield.setBackground(Color.RED);
                    break;
                }
            }
            boolean pizza1smallquantitycheck = true;
            boolean pizza1regularquantitycheck = true;
            boolean pizza1largequantitycheck = true;
            boolean pizza2smallquantitycheck = true;
            boolean pizza2regularquantitycheck = true;
            boolean pizza2largequantitycheck = true;
            boolean pizza3smallquantitycheck = true;
            boolean pizza3regularquantitycheck = true;
            boolean pizza3largequantitycheck = true;
            boolean pizza4smallquantitycheck = true;
            boolean pizza4regularquantitycheck = true;
            boolean pizza4largequantitycheck = true;
            ///if Correct then
            if(namecheck&&phonenumbercheck){
                if(pizza1smallfieldcheck){
                    String pizza1smallquantity = pizza1smallquantityfield.getText();
                    if(pizza1smallquantity.equals("")) {
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza1smallquantityfield.setText("");
                        pizza1smallquantitycheck = false;
                    }
                    for(int i =0;i<pizza1smallquantity.length();i++){
                        char check = pizza1smallquantity.charAt(i);
                        if(check>='0'&&check<='9'){
                        }
                        else if(check==' '){
                            JOptionPane.showMessageDialog(amframe, "Quantity number Cannot be left Blank");
                            pizza1smallquantityfield.setText("");
                            pizza1smallquantitycheck = false;
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza1smallquantityfield.setText("");
                            pizza1smallquantitycheck = false;
                            break;
                        }
                    }
                    if(pizza1smallquantitycheck){
                        Integer pizza1smalltoint = Integer.parseInt(pizza1smallquantity);
                        pizza1smallprice = pizza1smalltoint*pricesmallpizza;
                        totalbill+=pizza1smallprice;
                    }

                }
                if(pizza1regularfieldcheck){
                    String pizza1regularquantity = pizza1regularquantityfield.getText();
                    if(pizza1regularquantity.equals("")){
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza1regularquantityfield.setText("");
                        pizza1regularquantitycheck = false;
                    }
                    for(int i =0;i<pizza1regularquantity.length();i++){
                        char check = pizza1regularquantity.charAt(i);
                        if(check>='0'&&check<='9'){
                        }
                        else{
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza1regularquantityfield.setText("");
                            pizza1regularquantitycheck = false;
                            break;
                        }
                    }
                    if(pizza1regularquantitycheck){
                        Integer pizza1regulartoint = Integer.parseInt(pizza1regularquantity);
                        pizza1regularprice = pizza1regulartoint*pricemediumpizza;
                        totalbill+=pizza1regularprice;
                    }
                }
                if(pizza1largefieldcheck){
                    String pizza1largequantity = pizza1largequantityfield.getText();
                    if(pizza1largequantity.equals("")) {
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza1largequantityfield.setText("");
                        pizza1largequantitycheck = false;
                    }

                    for(int i =0;i<pizza1largequantity.length();i++){
                        char check = pizza1largequantity.charAt(i);
                        if(check>='0'&&check<='9'){
                        }
                        else{
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza1largequantityfield.setText("");
                            pizza1largequantitycheck = false;
                            break;
                        }
                    }
                    if(pizza1largequantitycheck) {
                        Integer pizza1largetoint = Integer.parseInt(pizza1largequantity);
                        pizza1largeprice = pizza1largetoint * pricelargepizza;
                        totalbill += pizza1largeprice;
                    }
                }
                if(pizza2smallfieldcheck){
                    String pizza2smallquantity = pizza2smallquantityfield.getText();
                    if(pizza2smallquantity.equals("")) {
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza2smallquantityfield.setText("");
                        pizza2smallquantitycheck = false;
                    }
                    for(int i =0;i<pizza2smallquantity.length();i++) {
                        char check = pizza2smallquantity.charAt(i);
                        if (check >= '0' && check <= '9') {
                        } else {
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza2smallquantityfield.setText("");
                            pizza2smallquantitycheck = false;
                            break;
                        }
                    }
                    if (pizza2smallquantitycheck) {
                        Integer pizza2smalltoint = Integer.parseInt(pizza2smallquantity);
                        pizza2smallprice = pizza2smalltoint * pricesmallpizza;
                        totalbill += pizza2smallprice;
                    }
                }
                if(pizza2regularfieldcheck){
                    String pizza2regularquantity = pizza2regularquantityfield.getText();
                    if(pizza2regularquantity.equals("")) {
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza2regularquantityfield.setText("");
                        pizza2regularquantitycheck = false;
                    }
                    for(int i =0;i<pizza2regularquantity.length();i++){
                        char check = pizza2regularquantity.charAt(i);
                        if(check>='0'&&check<='9'){
                        }
                        else{
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza2regularquantityfield.setText("");
                            pizza2regularquantitycheck = false;
                            break;
                        }
                    }
                    if (pizza2regularquantitycheck) {

                        Integer pizza2regulartoint = Integer.parseInt(pizza2regularquantity);
                        pizza2regularprice = pizza2regulartoint * pricemediumpizza;
                        totalbill += pizza2regularprice;
                    }
                }
                if(pizza2largefieldcheck){
                    String pizza2largequantity = pizza2largequantityfield.getText();
                    if(pizza2largequantity.equals("")) {
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza2largequantityfield.setText("");
                        pizza2largequantitycheck = false;
                    }
                    for(int i =0;i<pizza2largequantity.length();i++){
                        char check = pizza2largequantity.charAt(i);
                        if(check>='0'&&check<='9'){
                        }
                        else{
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza2largequantityfield.setText("");
                            pizza2largequantitycheck = false;
                            break;
                        }
                    }
                    if(pizza2largequantitycheck){
                        Integer pizza2largetoint = Integer.parseInt(pizza2largequantity);
                        pizza2largeprice = pizza2largetoint * pricelargepizza;
                        totalbill += pizza2largeprice;

                    }
                }
                if(pizza3smallfieldcheck){
                    String pizza3smallquantity = pizza3smallquantityfield.getText();
                    if(pizza3smallquantity.equals("")) {
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza3smallquantityfield.setText("");
                        pizza3smallquantitycheck = false;
                    }
                    for(int i =0;i<pizza3smallquantity.length();i++){
                        char check = pizza3smallquantity.charAt(i);
                        if(check>='0'&&check<='9'){
                        }
                        else{
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza3smallquantityfield.setText("");
                            pizza3smallquantitycheck = false;
                            break;
                        }
                    }
                    if(pizza3smallquantitycheck){
                        Integer pizza3smalltoint = Integer.parseInt(pizza3smallquantity);
                        pizza3smallprice = pizza3smalltoint * pricesmallpizza;
                        totalbill += pizza3smallprice;

                    }

                }
                if(pizza3regularfieldcheck){
                    String pizza3regularquantity = pizza3regularquantityfield.getText();
                    if(pizza3regularquantity.equals("")) {
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza3regularquantityfield.setText("");
                        pizza3regularquantitycheck = false;
                    }

                    for(int i =0;i<pizza3regularquantity.length();i++){
                        char check = pizza3regularquantity.charAt(i);
                        if(check>='0'&&check<='9'){
                        }
                        else{
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza3regularquantityfield.setText("");
                            pizza3regularquantitycheck = false;
                            break;
                        }
                    }
                    if(pizza3regularquantitycheck){
                        Integer pizza3regulartoint = Integer.parseInt(pizza3regularquantity);
                        pizza3regularprice = pizza3regulartoint * pricemediumpizza;
                        totalbill += pizza3regularprice;
                    }


                }
                if(pizza3largefieldcheck){
                    String pizza3largequantity = pizza3largequantityfield.getText();
                    if(pizza3largequantity.equals("")) {
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza3largequantityfield.setText("");
                        pizza3largequantitycheck = false;
                    }

                    for(int i =0;i<pizza3largequantity.length();i++){
                        char check = pizza3largequantity.charAt(i);
                        if(check>='0'&&check<='9'){
                        }
                        else{
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza3largequantityfield.setText("");
                            pizza3largequantitycheck = false;
                            break;
                        }
                    }
                    if(pizza3largequantitycheck){
                        Integer pizza3largetoint = Integer.parseInt(pizza3largequantity);
                        pizza3largeprice = pizza3largetoint * pricelargepizza;
                        totalbill += pizza3largeprice;
                    }


                }
                if(pizza4smallfieldcheck){
                    String pizza4smallquantity = pizza4smallquantityfield.getText();
                    if(pizza4smallquantity.equals("")) {
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza4smallquantityfield.setText("");
                        pizza4smallquantitycheck = false;
                    }

                    for(int i =0;i<pizza4smallquantity.length();i++){
                        char check = pizza4smallquantity.charAt(i);
                        if(check>='0'&&check<='9'){
                        }
                        else{
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza4smallquantityfield.setText("");
                            pizza4smallquantitycheck = false;
                            break;
                        }
                    }
                    if(pizza4smallquantitycheck){
                        Integer pizza4smalltoint = Integer.parseInt(pizza4smallquantity);
                        pizza4smallprice = pizza4smalltoint * pricesmallpizza;
                        totalbill += pizza4smallprice;
                    }

                }
                if(pizza4regularfieldcheck){
                    String pizza4regularquantity = pizza4regularquantityfield.getText();
                    if(pizza4regularquantity.equals("")) {
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza4regularquantityfield.setText("");
                        pizza4regularquantitycheck = false;
                    }

                    for(int i =0;i<pizza4regularquantity.length();i++){
                        char check = pizza4regularquantity.charAt(i);
                        if(check>='0'&&check<='9'){
                        }
                        else{
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza4regularquantityfield.setText("");
                            pizza4regularquantitycheck = false;
                            break;
                        }
                    }
                    if(pizza4regularquantitycheck){
                        Integer pizza4regulartoint = Integer.parseInt(pizza4regularquantity);
                        pizza4regularprice = pizza4regulartoint * pricemediumpizza;
                        totalbill += pizza4regularprice;
                    }


                }
                if(pizza4largefieldcheck){
                    String pizza4largequantity = pizza4largequantityfield.getText();
                    if(pizza4largequantity.equals("")) {
                        JOptionPane.showMessageDialog(amframe, "Quantity Field Cannot be left Blank");
                        pizza4largequantityfield.setText("");
                        pizza4largequantitycheck = false;
                    }

                    for(int i =0;i<pizza4largequantity.length();i++){
                        char check = pizza4largequantity.charAt(i);
                        if(check>='0'&&check<='9'){
                        }
                        else{
                            JOptionPane.showMessageDialog(amframe, "Wrong quantity number");
                            pizza4largequantityfield.setText("");
                            pizza4largequantitycheck = false;
                            break;
                        }
                    }
                    if(pizza4largequantitycheck){
                        Integer pizza4largetoint = Integer.parseInt(pizza4largequantity);
                        pizza4largeprice = pizza4largetoint * pricelargepizza;
                        totalbill += pizza4largeprice;
                    }
                }
                if(pizza1smallquantitycheck&&pizza1regularquantitycheck&&pizza1largequantitycheck&&
                        pizza2smallquantitycheck&&pizza2regularquantitycheck&&pizza2largequantitycheck&&
                        pizza3smallquantitycheck&&pizza3regularquantitycheck&&pizza3largequantitycheck&&
                        pizza4smallquantitycheck&&pizza4regularquantitycheck&&pizza4largequantitycheck)

                {if(pizza1smallfieldcheck||pizza1regularfieldcheck||pizza1largefieldcheck||
                        pizza2smallfieldcheck||pizza2regularfieldcheck||pizza2largefieldcheck||
                        pizza3smallfieldcheck||pizza3regularfieldcheck||pizza3largefieldcheck||
                        pizza4smallfieldcheck||pizza4regularfieldcheck||pizza4largefieldcheck) {
                    totalbilldialog.setSize(700, 300);
                    totalbilldialog.getContentPane().setLayout(null);
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    JLabel l1 = new JLabel("Name: " + name);
                    JLabel l2 = new JLabel("Address: " + address);
                    JLabel l3 = new JLabel("Phonenumber: " + phonenumber);
                    JLabel l4 = new JLabel("Total bill is " + totalbill);
                    JLabel l5 = new JLabel("Date and Time is "+dateFormat.format(date));
                    File f = new File("record.txt");
                    if (!f.exists()) {
                        try {
                            f.createNewFile();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    try {
                        writer = new PrintWriter(new FileWriter(f,true));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    writer.println();
                    writer.println("Date and Time is "+dateFormat.format(date));
                    writer.println("Name: "+name);
                    writer.println("Address: "+address);
                    writer.println("Phonenumber: "+phonenumber);
                    writer.println("Total bill is "+totalbill);
                    writer.close();
                    l5.setBounds(20,5,300,50);
                    totalbilldialog.add(l5);

                    l1.setBounds(20,30,500,50);
                    totalbilldialog.add(l1);
                    l2.setBounds(20,60,500,50);
                    totalbilldialog.add(l2);
                    l3.setBounds(20,90,500,50);
                    totalbilldialog.add(l3);
                    l4.setBounds(20,200,200,50);
                    totalbilldialog.add(l4);
                    totalbilldialog.setVisible(true);
                    totalbill = 0;
                    namefield.setBackground(Color.WHITE);
                    phonenumberfield.setBackground(Color.WHITE);
                    l1.setText("");
                    l2.setText("");
                    l3.setText("");
                    l4.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(amframe, "Something Wrong\nCannot print bill");

                }

                }


            }

            //if not correct then
            else if(!namecheck&&!phonenumbercheck){
                JOptionPane.showMessageDialog(amframe, "Something Wrong\nCannot print bill");

            }
            else{
                JOptionPane.showMessageDialog(amframe, "Wrong input");
            }
        }

    }

    public static void main(String[] args) {
        new pizzadeliverymanagmentsystem();
    }

}

