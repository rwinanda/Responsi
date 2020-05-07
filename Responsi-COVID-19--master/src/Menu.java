import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame {
    JLabel lTittle;
    JButton bCreate, bRead, bUpdate, bDelete, bExit;

    public void displayMenu(){
        setTitle("DATA COVID-19");
        lTittle = new JLabel("DATA COVID-19");
        lTittle.setFont(new Font("Regular", Font.BOLD, 18));
        lTittle.setForeground(new Color(247, 252, 255));
        bCreate = new JButton("Masukkan Data ");
        bCreate.setFont(new Font("Regular",Font.PLAIN, 16));
        bCreate.setBackground(new Color(247, 252, 255));
        bRead = new JButton("Output ");
        bRead.setFont(new Font("Regular",Font.PLAIN, 16));
        bRead.setBackground(new Color(247, 252, 255));
        bUpdate = new JButton("Edit ");
        bUpdate.setFont(new Font("Regular",Font.PLAIN, 16));
        bUpdate.setBackground(new Color(247, 252, 255));
        bDelete = new JButton("Hapus ");
        bDelete.setFont(new Font("Regular",Font.PLAIN, 16));
        bDelete.setBackground(new Color(247, 252, 255));
        bExit = new JButton("Exit ");
        bExit.setFont(new Font("Regular",Font.PLAIN, 16));
        bExit.setBackground(new Color(255, 0, 0));

        getContentPane().setBackground(new Color(12, 164, 255));

        setLayout(null);
        add(lTittle);
        add(bCreate);
        add(bRead);
        add(bUpdate);
        add(bDelete);
        add(bExit);

        lTittle.setBounds(170,30,180,30);
        bCreate.setBounds(10, 80, 220, 30);
        bRead.setBounds(250, 80, 220, 30);
        bUpdate.setBounds(10, 120, 220, 30);
        bDelete.setBounds(250, 120, 220, 30);
        bExit.setBounds(130, 160, 220, 30);

        setSize(500, 280);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Buat();
            }
        });
        bRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Baca();
            }
        });
        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Hapus();
                }catch (ClassNotFoundException classError){
                    classError.printStackTrace();
                }catch (SQLException sqlError){
                    sqlError.printStackTrace();
                }
            }
        });
        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Edit();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
