import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class Buat extends JFrame {
    JLabel lTitle, lNegara, lPositif, lSembuh, lMeninggal,lTanggal,lId;
    JTextField fNegara, fPositif, fSembuh, fMeninggal,fTanggal,fId;
    JButton bSave, bBack;
    Statement statement;
    String negara,tanggal ;
    int positif, meninggal,sembuh,id;

    public Buat(){
        setTitle("INPUT DATA");
        lTitle = new JLabel("Input Data");
        lTitle.setFont(new Font("Regular", Font.BOLD, 18));
        lTitle.setForeground(new Color(247, 252, 255));
        
        lId = new JLabel("ID ");
        lId.setFont(new Font("Regular", Font.PLAIN, 18));
        lId.setForeground(new Color(247, 252, 255));
        fId = new JTextField();
        fId.setFont(new Font("Regular", Font.PLAIN, 16));
        fId.setForeground(new Color(0, 0, 0));
        fId.setBackground(new Color(247, 252, 255));
        
        lNegara = new JLabel("Negara ");
        lNegara.setFont(new Font("Regular", Font.PLAIN, 18));
        lNegara.setForeground(new Color(247, 252, 255));
        fNegara = new JTextField();
        fNegara.setFont(new Font("Regular", Font.PLAIN, 16));
        fNegara.setForeground(new Color(0, 0, 0));
        fNegara.setBackground(new Color(247, 252, 255));
        
        lPositif = new JLabel("Positif ");
        lPositif.setFont(new Font("Regular", Font.PLAIN, 18));
        lPositif.setForeground(new Color(247, 252, 255));
        fPositif = new JTextField();
        fPositif.setFont(new Font("Regular", Font.PLAIN, 16));
        fPositif.setForeground(new Color(0, 0, 0));
        fPositif.setBackground(new Color(247, 252, 255));
        
        lSembuh = new JLabel("Sembuh ");
        lSembuh.setFont(new Font("Regular", Font.PLAIN, 18));
        lSembuh.setForeground(new Color(247, 252, 255));
        fSembuh = new JTextField();
        fSembuh.setFont(new Font("Regular", Font.PLAIN, 16));
        fSembuh.setForeground(new Color(0, 0, 0));
        fSembuh.setBackground(new Color(247, 252, 255));
        
        lMeninggal = new JLabel("Meninggal ");
        lMeninggal.setFont(new Font("Regular", Font.PLAIN, 18));
        lMeninggal.setForeground(new Color(247, 252, 255));
        fMeninggal = new JTextField();
        fMeninggal.setFont(new Font("Regular", Font.PLAIN, 16));
        fMeninggal.setForeground(new Color(0, 0, 0));
        fMeninggal.setBackground(new Color(247, 252, 255));
        
        lTanggal = new JLabel("Tanggal ");
        lTanggal.setFont(new Font("Regular", Font.PLAIN, 18));
        lTanggal.setForeground(new Color(247, 252, 255));
        fTanggal = new JTextField();
        fTanggal.setFont(new Font("Regular", Font.PLAIN, 16));
        fTanggal.setForeground(new Color(0, 0, 0));
        fTanggal.setBackground(new Color(247, 252, 255));

        bSave = new JButton("Input");
        bSave.setFont(new Font("Regular",Font.PLAIN, 14));
        bSave.setBackground(new Color(247, 252, 255));
        bBack = new JButton("Kembali");
        bBack.setFont(new Font("Regular",Font.PLAIN, 14));
        bBack.setBackground(new Color(247, 252, 255));

        getContentPane().setBackground(new Color(12, 164, 255));

        setLayout(null);
        add(lTitle);
        add(lId);
        add(fId);
        add(lNegara);
        add(fNegara);
        add(lPositif);
        add(fPositif);
        add(lSembuh);
        add(fSembuh);
        add(lMeninggal);
        add(fMeninggal);
        add(lTanggal);
        add(fTanggal);
        add(bSave);
        add(bBack);

        lTitle.setBounds(30, 20, 250, 30);
        lId.setBounds(30, 70, 120, 30);
        fId.setBounds(130, 73,270,25);
        lNegara.setBounds(30, 110, 120, 30);
        fNegara.setBounds(130, 110, 270, 30);
        lPositif.setBounds(30, 150, 120, 30);
        fPositif.setBounds(130, 153, 270, 25);
        lSembuh.setBounds(30, 190, 120, 30);
        fSembuh.setBounds(130, 193, 270, 25);
        lMeninggal.setBounds(30, 230, 120, 30);
        fMeninggal.setBounds(130, 233, 270, 25);
        lTanggal.setBounds(30, 270, 120, 30);
        fTanggal.setBounds(130, 273, 270, 25);
        bSave.setBounds(130, 300, 90, 30);
        bBack.setBounds(230, 300, 90,30);

        setSize(440, 450);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    id = Integer.parseInt(fId.getText());
                    negara = fNegara.getText();
                    positif = Integer.parseInt(fPositif.getText());
                    sembuh = Integer.parseInt(fSembuh.getText());
                    meninggal = Integer.parseInt(fMeninggal.getText());
                    tanggal=fTanggal.getText();

                    Data data = new Data(id,negara,  positif,sembuh, meninggal,tanggal);

                    Koneksi connec = new Koneksi();
                    try {
                        statement = connec.getConnection().createStatement();
                        statement.executeUpdate("INSERT INTO tabel_covid VALUES('" + data.getId() + "','" + data.getTanggal() + "','" + data.getNegara() + "','" + data.getPositif() + "','" + data.getSembuh() + "','" + data.getMeninggal() + "')");
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan");
                    } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(Buat.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(Buat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
                }catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
                }

                setVisible(false);
            }
        });

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });
    }
}
