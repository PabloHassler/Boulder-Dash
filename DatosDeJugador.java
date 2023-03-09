/*    */ package Backup;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Choice;
/*    */ import java.awt.Color;
/*    */ import java.awt.TextField;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class DatosDeJugador extends JFrame {
/*    */   private static final long serialVersionUID = 1L;
/* 15 */   private static DatosDeJugador datosJugador = new DatosDeJugador(); TextField tf; Choice c;
/*    */   
/*    */   public void iniciarDatosDeJugador() {
/* 18 */     setTitle("Datos de jugador");
/* 19 */     resize(500, 140);
/* 20 */     JLabel l2 = new JLabel("Nombre: ");
/* 21 */     JLabel l3 = new JLabel("Nivel seleccionado: ");
/* 22 */     JPanel p = new JPanel();
/* 23 */     JPanel p2 = new JPanel();
/* 24 */     JPanel p4 = new JPanel();
/* 25 */     JButton b = new JButton("Jugar");
/* 26 */     b.addMouseListener(new Botonjugar());
/* 27 */     ImageIcon bug = new ImageIcon(getClass().getResource("index.jpg"));
/* 28 */     b.setIcon(bug);
/* 29 */     b.setBackground(Color.WHITE);
/* 30 */     JButton b2 = new JButton("volver");
/* 31 */     b2.setBackground(Color.WHITE);
/* 32 */     ImageIcon bug2 = new ImageIcon(getClass().getResource("volver.jpg"));
/* 33 */     b2.setIcon(bug2);
/* 34 */     b2.addMouseListener(new Botonvolverjugador());
/* 35 */     this.c = new Choice();
/*    */     
/* 37 */     for (int i = 1; i < 11; i++) {
/* 38 */       this.c.add(Integer.toString(i));
/*    */     }
/* 40 */     this.tf = new TextField("              ");
/* 41 */     p.add(l2);
/* 42 */     p.add(this.tf);
/*    */     
/* 44 */     p2.add(l3);
/* 45 */     p2.add(this.c);
/*    */     
/* 47 */     p4.add(b); p4.add(b2);
/* 48 */     setLayout(new BorderLayout());
/* 49 */     add(p, "North");
/* 50 */     add(p2, "Center");
/* 51 */     add(p4, "South");
/*    */   }
/*    */   
/*    */   public static DatosDeJugador getDatosDeJugador() {
/* 55 */     return datosJugador;
/*    */   }
/*    */   public int nivelSeleccionado() {
/* 58 */     return Integer.parseInt(datosJugador.c.getSelectedItem());
/*    */   }
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\DatosDeJugador.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */