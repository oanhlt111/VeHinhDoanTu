package view.scene;

import client.Client;
import constant.Avatar;
import constant.Constant;
import controller.ClientCtr;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import model.Player;

/**
 *
 * @author whiwf
 */
public class IngameFrm extends javax.swing.JFrame {

    private PaintToolPanel paintToolPanel;
    private GuessPane guessPane;

    private PaintPane paintPane1;
    private PaintPane paintPane2;

    private ResultTurnDialog resultTurnDialog;

    public IngameFrm() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Scribble it! " + client.Client.account.getName());

        setLayout(null);

        //paint
        paintPane1 = new PaintPane(this);
        add(paintPane1);
        paintPane1.setBounds(240, 70, 585, 290);

        paintPane2 = new PaintPane(this);
        add(paintPane2);
        paintPane2.setBounds(240, 370, 585, 290);

        displayCurrentPainterPane();

        //paint tool
        paintToolPanel = new PaintToolPanel(this);
        this.add(paintToolPanel);
        paintToolPanel.setBounds(845, 400, 205, 260);

        paintToolPanel.setVisible(false);

        //guess pane
        guessPane = new GuessPane();
        this.add(guessPane);
        guessPane.setBounds(845, 400, 205, 250);

        guessPane.setVisible(false);

        // close window event
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(IngameFrm.this,
                        "Bạn có chắc muốn thoát game?", "Thoát game?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    ClientCtr.senderClient.sendLeaveRoom();
                }
            }
        });
    }

    //================start game============================
        //show paint tool
    public void displayPaintTool() {
        paintToolPanel.setVisible(true);
        guessPane.setVisible(false);
    }

    // show guess pane
    public void displayGuessPane() {
        paintToolPanel.setVisible(false);
        guessPane.setVisible(true);
    }
    
    // show player list
    public void displayLsPlayer(ArrayList<Player> lsPlayer) {
        taLsPlayer.setText("");

        for (Player player : lsPlayer) {
            String msgPlayer = player.getAccount().getName() + "(" + player.getAccount().getUsername() + ") : " + player.getScore() + " điểm\n";
            taLsPlayer.append(msgPlayer);
            //show current player score
            if(player.getAccount().getUsername().equals(Client.account.getUsername())){
                lbScore.setText(player.getScore() + " điểm");
            }
        }
    }

    // display current painter
    public void displayCurrentPainterPane() {
        resetPaintPane();
        if (Client.room.getLsPainterUsername().get(0).equals(Client.account.getUsername())) {
            paintPane1.setBorder(new LineBorder(Color.red));
        } else if (Client.room.getLsPainterUsername().get(1).equals(Client.account.getUsername())) {
            paintPane2.setBorder(new LineBorder(Color.red));
        }
    }

    // reset paintpane
    public void resetPaintPane() {
        paintPane1.setBorder(new LineBorder(Color.black));
        paintPane2.setBorder(new LineBorder(Color.black));
    }

    // show current player inf
    public void displayCurrentPlayerInf() {
        lbCurPlayer.setText(client.Client.account.getUsername());
        if(Client.account.getAvatar() != null){
            ImageIcon avatar = new ImageIcon(Avatar.PATH + Client.account.getAvatar());
            lbCurPlayer.setIcon(avatar);
        }
    }

    // show countdown time
    public void displayCountdownTime(String msgTurn, String msgTime) {
        lbTurn.setText(msgTurn + "/3");
        lbCountdown.setText(msgTime + " s");
    }

    //show result turn dialog
    public void showResultTurnDialog(ArrayList<Player> lsPlayers) {
        resultTurnDialog = new ResultTurnDialog(this, true);
        resultTurnDialog.displayTurnResult(lsPlayers);
        resultTurnDialog.setVisible(true);
    }

    //close result turn dialog
    public void closeResultTurnDialog() {
        resultTurnDialog.setVisible(false);
    }

    // show msg player leave room
    public void showMessagePlayerLeaveRoom(String msg) {
        taNotification.append(msg + "\n");
    }

    //=============================== chat area ================================
    public void showPlayerGuessResult(String guess) {
        taChat.append("> " + guess + "\n");
    }

    // Show message in text area
    public void displayMesg(String mes) {
        taChat.append(mes + "\n");
    }

    //show word for player
    public void displayWord(String word) {
        if (Client.room.getLsPainterUsername().get(0).equals(Client.account.getUsername())
                || Client.room.getLsPainterUsername().get(1).equals(Client.account.getUsername())) {
            jLabelWord.setText(word);
        } else {
            String numOfWord = "";
            for (int i = 0; i < word.length(); i++) {
                numOfWord += "_ ";
            }
            jLabelWord.setText(numOfWord);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbCurPlayer = new javax.swing.JLabel();
        lbScore = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taLsPlayer = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taNotification = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnSendMsg = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taChat = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbTurn = new javax.swing.JLabel();
        lbCountdown = new javax.swing.JLabel();
        jLabelWord = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbCurPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/avatar/icons8_circled_user_female_skin_type_7_96px.png"))); // NOI18N
        lbCurPlayer.setText("player 1");

        lbScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbScore.setText("100 điểm");

        taLsPlayer.setEditable(false);
        taLsPlayer.setColumns(20);
        taLsPlayer.setLineWrap(true);
        taLsPlayer.setRows(5);
        jScrollPane1.setViewportView(taLsPlayer);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông báo"));

        taNotification.setEditable(false);
        taNotification.setColumns(20);
        taNotification.setLineWrap(true);
        taNotification.setRows(5);
        jScrollPane4.setViewportView(taNotification);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCurPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCurPlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbScore)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Chat"));

        jLabel3.setText("Nhập tin nhắn");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        btnSendMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/icons8_paper_plane_24px.png"))); // NOI18N
        btnSendMsg.setText("Gửi");
        btnSendMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMsgActionPerformed(evt);
            }
        });

        taChat.setEditable(false);
        taChat.setColumns(20);
        taChat.setLineWrap(true);
        taChat.setRows(5);
        jScrollPane2.setViewportView(taChat);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jTextField1)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnSendMsg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSendMsg)
                .addGap(23, 23, 23))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Vòng:");

        lbTurn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTurn.setText("2/3");

        lbCountdown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/assets/icons8-timer-30.png"))); // NOI18N
        lbCountdown.setText("120 s");

        jLabelWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWord.setText("Từ để đoán (7)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lbTurn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelWord, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCountdown, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTurn)
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jLabelWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbCountdown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  //send Messeage
    private void btnSendMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMsgActionPerformed
        String msg = "";
        msg = jTextField1.getText();
        if (jTextField1.getText().trim().length() > 0) {
            ClientCtr.senderClient.sendChatMessage(msg);
        }
        jTextField1.setText("");
    }//GEN-LAST:event_btnSendMsgActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String msg = "";
            msg = jTextField1.getText();
            //send to server
            if (jTextField1.getText().trim().length() > 0) {
                ClientCtr.senderClient.sendChatMessage(msg);
            }
            jTextField1.setText("");
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IngameFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngameFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngameFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngameFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngameFrm().setVisible(true);
            }
        });
    }

    public PaintPane getPaintPane1() {
        return paintPane1;
    }

    public PaintPane getPaintPane2() {
        return paintPane2;
    }

    public GuessPane getGuessPane() {
        return guessPane;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendMsg;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelWord;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbCountdown;
    private javax.swing.JLabel lbCurPlayer;
    private javax.swing.JLabel lbScore;
    private javax.swing.JLabel lbTurn;
    private javax.swing.JTextArea taChat;
    private javax.swing.JTextArea taLsPlayer;
    private javax.swing.JTextArea taNotification;
    // End of variables declaration//GEN-END:variables

    public void changeTurn(ArrayList<Player> listPlayer) {
        if (Client.room.getLsPainterUsername().get(0).equals(Client.account.getUsername())) {
            setTurn(Client.room.getLsPainterUsername().get(1));
            paintPane1.repaint();
        } else if (Client.room.getLsPainterUsername().get(1).equals(Client.account.getUsername())) {
            setTurn(Client.room.getLsPainterUsername().get(0));
            paintPane2.repaint();
        }
    }

    private void setTurn(String username) {
        if (Client.room.getLsPainterUsername().get(0).equals(username)) {
            paintPane1.setEnabled(false);
            guessPane.setEnabled(false);
        } else if (Client.room.getLsPainterUsername().get(1).equals(username)) {
            paintPane2.setEnabled(false);
            guessPane.setEnabled(false);
        }

    }
}
