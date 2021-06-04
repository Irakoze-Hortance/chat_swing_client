package components.Teams.edit;

import components.InputBorder;
import models.ProfileRequestData;
import models.Request;
import models.ResponseDataSuccessDecoder;
import socket.IndexSocket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class EditGroup extends JFrame {
    private int radius;

    public  EditGroup() {
        super("Class C");
        setSize(1000,650);
        initUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void initUI() {
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        JLabel edit = new JLabel("EDIT GROUP");
        edit.setFont(new Font("Verdana", Font.BOLD, 18));
        edit.setForeground(Color.decode("#0a0a52"));

        JLabel teams = new JLabel("JAVA TEAM");
        teams.setFont(new Font("Verdana", Font.BOLD, 18));
        teams.setForeground(Color.decode("#FFD700"));

        JButton newGroup = new JButton("New Group");
        newGroup.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(15,25,15,25))
        ));
        newGroup.setBackground(Color.decode("#0a0a52"));
        newGroup.setForeground(Color.white);
        newGroup.setPreferredSize(new Dimension(40,40));

        JButton upload = new JButton("UPLOAD PROFILE");
        upload.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(15,25,15,25))
        ));
        upload.setBackground(Color.decode("#0a0a52"));
        upload.setForeground(Color.white);

        JTextField name= new JTextField("name");
        name.setColumns(30);
        name.setForeground(Color.gray.brighter());
        name.setBorder(new InputBorder(15));
        name.setColumns(40);
        JTextField desc= new JTextField("Description");
        JButton save = new JButton("Save");
        save.setPreferredSize(new Dimension(100,40));

        leftPanel.setBorder(BorderFactory.createEmptyBorder(10,120, 10, 120));
        leftPanel.setLayout(new GridBagLayout());

        edit.setFont(new Font("Verdana", Font.PLAIN,15));
        save.setForeground(Color.decode("#FFFFFF"));
        save.setBackground(Color.decode("#0a0a52"));
        save.setFont(new Font("Verdana", Font.BOLD, 16));
        save.setBounds(10, 10, 120, 50);

        save.setBorder(BorderFactory.createCompoundBorder(
                new CustomBorder(),
                new EmptyBorder(new Insets(25, 20, 25, 25))
        ));
        save.addActionListener(actionEvent -> {
            try {
                editGroup();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        JPanel nameLabelPanel = new JPanel();
        nameLabelPanel.setBackground(Color.WHITE);
        nameLabelPanel.setLayout(new BorderLayout());
        nameLabelPanel.add(name, BorderLayout.SOUTH);

        JPanel descLabelPanel = new JPanel();
        descLabelPanel.setBackground(Color.WHITE);
        descLabelPanel.setLayout(new BorderLayout());
        descLabelPanel.add(desc, BorderLayout.SOUTH);
        desc.setBorder(new InputBorder(15));
        desc.setForeground(Color.lightGray);

        JPanel savePanel = new JPanel(new BorderLayout());
        savePanel.setBackground(Color.WHITE);
        savePanel.add(save, BorderLayout.WEST);

        rightPanel.add(edit);
        rightPanel.add(teams);
        rightPanel.add(upload);
        rightPanel.add(newGroup);
        rightPanel.add(nameLabelPanel);
        rightPanel.add(name);
        rightPanel.add(descLabelPanel);
        rightPanel.add(desc);
        rightPanel.add(savePanel);
        rightPanel.setLayout(new GridLayout(7,1,0,10));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 120, 30, 120));


        add(leftPanel,BorderLayout.WEST);
        add(rightPanel,BorderLayout.CENTER);

    }

    public  void editGroup() throws IOException {
        String key= "groups/profile";
        Request request = new Request(new ProfileRequestData(1),key);
        ResponseDataSuccessDecoder response = new IndexSocket().execute(request);
        System.out.print(response.getData());

//        if(response.isSuccess()){
//            Group[] groups=new GroupResponseDataDecoder().returnGroupDecoded(response.getData()));
//            if (groups.length != 0){
//
//                for (Group group : groups) {
//                    System.out.println(group.getName()+". "+group.getDescription()+" "+group.getUpdated_at());
//                    CommonUtil.addTabs(10, false);
////                    groupMembers.add(user);
//                }
//            }
//        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EditGroup();
            }
        });
    }
}
