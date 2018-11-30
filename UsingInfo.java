package clientmain;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;

import java.io.InputStreamReader;



import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import network.SimpleClient;

public class UsingInfo extends JFrame implements Runnable{
    private JPanel jPanel2 = new JPanel();
    private JLabel show1 = new JLabel();
    private JLabel show2 = new JLabel();
    private JLabel show3 = new JLabel();
    private JButton jButton1 = new JButton();
    private JSeparator jSeparator1 = new JSeparator();
    private JSeparator jSeparator2 = new JSeparator();
    
    private String pcNumber = null;
    private String clientId = null;
    private String oneTimePrice = null;
    private Date startDate = null;
    
    private long useSecond = 0;       // ��� ����� ���� ��������� �ʰ��� �Է��Ͽ� ���
    protected long addSecond = 0;   // <- �߰� �ð� �ʴ���
    protected long addSecondMoney = 0;  // <- 1�ð��� �ݾ� ���� �ʴ��� �ݾ��� �����ϴµ� ���
    private String useMoney = "0";
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();

    public UsingInfo( String pcNumber, String clientId, String oneTimePrice, Date startDate ) {
        this.pcNumber = pcNumber;
        this.clientId = clientId;
        this.oneTimePrice = oneTimePrice;
        this.startDate = startDate;
        // Wed Jan 07 12:41:14 KST 2009
        // 2009-01-07 12:44:06.0
        try {
            this.addSecondMoney = 100; // <- ��� ��� �⺻����
            // ��� ��� �⺻������ �ش��ϴ� 1�ð��� ������ ���/���� = 100���� �ʰ� ������
            this.addSecond = ((60*60)/ ( Integer.parseInt(this.oneTimePrice)/this.addSecondMoney ) );
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(342, 164));
        this.getContentPane().setLayout(null);
        
        //frame ��� ����
        this.setTitle("�������� 0.8.3");
        this.setUndecorated(true);

        jPanel2.setBounds(new Rectangle(5, 35, 230, 85));
        jPanel2.setLayout(null);
        jPanel2.setBackground(new Color(181, 181, 181));
        
        show1.setBounds(new Rectangle(65, 0, 130, 25));
        show1.setBackground(new Color(198, 198, 198));

        show1.setHorizontalAlignment(SwingConstants.TRAILING);
        show2.setBounds(new Rectangle(55, 30, 140, 25));
        show2.setHorizontalAlignment(SwingConstants.RIGHT);
        show2.setFont(new Font("����", 1, 15));
        
        show3.setBounds(new Rectangle(60, 60, 135, 25));
        show3.setHorizontalAlignment(SwingConstants.RIGHT);
        show3.setFont(new Font("����", 1, 15));
        jButton1.setText("��� ����");
        jButton1.setBounds(new Rectangle(240, 70, 90, 50));
        jButton1.setFont(new Font("����ü", 0, 12));
        jButton1.setBackground(new Color(198, 198, 198));
        jButton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButton1_actionPerformed(e);
                    }
                });

        //�α��� Ŭ���� �ð� ���  
        jSeparator1.setBounds(new Rectangle(5, 25, 215, 2));
        jSeparator2.setBounds(new Rectangle(5, 55, 215, 2));
        jLabel1.setText("�������� PC�� ���� 0.8.3");
        jLabel1.setBounds(new Rectangle(0, 5, 335, 25));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setForeground(new Color(49, 49, 49));
        jLabel1.setFont(new Font("����", 1, 13));
        jLabel2.setBounds(new Rectangle(15, 30, 45, 25));
        jLabel2.setToolTipText("null");
        jLabel2.setText("���");
        jLabel2.setHorizontalAlignment(SwingConstants.TRAILING);
        jLabel3.setBounds(new Rectangle(15, 60, 45, 25));
        jLabel3.setToolTipText("null");
        jLabel3.setText("�ð�");
        jLabel3.setHorizontalAlignment(SwingConstants.TRAILING);
        jLabel4.setBounds(new Rectangle(15, 0, 45, 25));
        jLabel4.setToolTipText("null");
        jLabel4.setText("�����");
        jLabel4.setHorizontalAlignment(SwingConstants.TRAILING);
        jLabel5.setText(" "+this.pcNumber+"�� PC"); //<- ��ǻ�� ��ȣ
        jLabel5.setBounds(new Rectangle(240, 40, 90, 20));
        jPanel2.add(jLabel4, null);
        jPanel2.add(jLabel3, null);
        jPanel2.add(jLabel2, null);
        jPanel2.add(jSeparator2, null);
        jPanel2.add(jSeparator1, null);
        jPanel2.add(show3, null);
        jPanel2.add(show2, null);
        jPanel2.add(show1, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jPanel2, null);
        this.setScreenCenter();
        
//        clientShow();
    }
   
    public void setScreenCenter( ){
        int sx =0,sy=0,fx=0,fy=0,x=0,y=0;   //��ũ��x,������x����
                     
        //ȭ���� ��ü ������ ���
        //sx = 1028/2;sy=1024/2;        ȭ���� ����� �˶�
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        sx = (int)dim.getWidth();
//        sy = (int)dim.getHeight()/2;
        
        //�������� ��ü ũ�� ��� ���߾� ��ǥ ���
        //fx = 500/2; fy= 500/2;        �������� ����� �˶�
        fx = getWidth();
//        fy = getHeight()/2;
        
        //�������� ȭ���� Ư�� ��ġ(���߾�)�� ��ġ
       // x=sx-fx;y=sy-fy;
        x=sx-fx;
        this.setLocation(x,0);
    }

    // ������ ���� 
    public void run(){
        show1.setText(this.clientId+" �� �ȳ��ϼ���.");
        while( true ){
            addMoney();
            show2.setText(this.useMoney+"��");
            show3.setText( useTime( this.startDate ) );
    //        System.out.println( this.startDate );
            try{
                Thread.sleep(1000); // <- �и������常ŭ ����.
            }catch(Exception e){ e.printStackTrace(); }
        }
    }
    
    // �ʱ� ȭ�� ����
    private void clientShow(){
        show1.setText(this.clientId+" �� �Դϴ�.");
        show2.setText(this.useMoney+" ��");
        show3.setText( useTime( this.startDate ) );
    }
    
    // 
    private String useTime(Date udate){ // <- 
        Calendar c2 = Calendar.getInstance();       // 
        c2.setTime(new Date());  // 

        long intervalMilli = (c2.getTimeInMillis() - udate.getTime())/1000;    // 
        long minute = 60;                   // 
        long hour = minute * 60;    //
        
        int useHour = (int)(intervalMilli/hour);
        int useMinute = (int)((intervalMilli%hour)/minute);
        int useSecond = (int)((intervalMilli%hour)%minute);
        this.useSecond = intervalMilli; // 
        
        String tmp = (useHour < 10 ) ? "0"+useHour : useHour+"";
        tmp += ":";
        tmp += (useMinute < 10 ) ? "0"+useMinute : useMinute+"";
        tmp += ":";
        tmp += (useSecond < 10 ) ? "0"+useSecond : useSecond+"";
        return tmp;
    }
    
    
    // pc�� ����ϰ� �ð��� ������ ������ �ð���ŭ ����� ������Ű�� �޼ҵ�
    public void addMoney(){
        int useMoney = (int)((this.useSecond / this.addSecond) * this.addSecondMoney);
        this.useMoney = addComma(useMoney+"",3);    //<- ������ �޸�����
    }
    
    // ����Ÿ���� ������ ","�� ���̴� �޼ҵ�
    public String addComma(String val,int check){
        String tmp = "";
        StringBuffer sBuff = new StringBuffer( val );
        char[] charArr;
        sBuff.reverse();
        val = sBuff.toString();
        charArr = val.toCharArray();
        for( int i=0; i<charArr.length; i++ ){
            if( check == i ) tmp += ",";
            tmp += charArr[i];
        }
        sBuff = new StringBuffer(tmp);
        sBuff.reverse();
        val = sBuff.toString();
        return val;
    }


    private void pcStop(){
        String query = "stop";
        SimpleClient sc = new SimpleClient();
        sc.outNet(query);   // <- ������
        try{
            String result = sc.inNet();
            sc.netClose();
            if( result.equals("okstop") ){
                new LogIn().setVisible(true);
                this.dispose();
            }else if( result.equals("failstop") ){
                JOptionPane.showMessageDialog(null,"��� ���� ó���� ���� �Ͽ����ϴ�.!","���� ����",1);
            }else if( result.equals("error") ){
                JOptionPane.showMessageDialog(null,"�� ��ǻ�Ϳ� ������ �ֽ��ϴ�!!!","���� ����",0);
            }
        }catch(Exception ex){ JOptionPane.showMessageDialog(null,"������ ��ſ� ������ �ֽ��ϴ�.","��ſ���",0); }
    }

    //��� ���� ��ư Ŭ����
    private void jButton1_actionPerformed(ActionEvent e) {
        int val = JOptionPane.showConfirmDialog(null,"ㅇ",2);
//        System.out.println(val);  // ��Ұ��� 2�ݾ�..�̤�  Ȯ���� 0 �̱�..
        if ( val == 2 ){ 
            return;
        }else{
            pcStop();
        }
    }
   
}