/*    */ package Backup;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Container;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.DefaultTableModel;
/*    */ 
/*    */ public class JugadorEnRanking
/*    */   extends JFrame {
/*    */   private static final long serialVersionUID = 1L;
/* 16 */   private static JugadorEnRanking ran = new JugadorEnRanking();
/* 17 */   private JFrame f = new JFrame("Ranking de jugadores");
/* 18 */   private JTable t = new JTable();
/* 19 */   private JLabel l = new JLabel("Ranking de jugadores");
/* 20 */   private Object[][] datos = new Object[][] { { "Giacomo Guilizzoni", Integer.valueOf(33), Integer.valueOf(2) }, { "Guido Jack Guilizzoni,", Integer.valueOf(20), Integer.valueOf(1) }, { "Mariah Maclachlan", Integer.valueOf(10), Integer.valueOf(1) } };
/* 21 */   public int cant_f = 3;
/* 22 */   private String[] titulos = new String[] { "Jugador", "Diamantes", "Nivel" };
/* 23 */   private DefaultTableModel tm = new DefaultTableModel((Object[])this.titulos, 0);
/*    */   
/*    */   public void init() {
/* 26 */     setTitle("Ranking de Boulder Dash");
/* 27 */     resize(600, 200);
/* 28 */     JButton b = new JButton("volver");
/* 29 */     ImageIcon bug = new ImageIcon(getClass().getResource("volver.jpg"));
/* 30 */     b.setIcon(bug);
/* 31 */     b.addMouseListener(new BotonvolverRanking());
/* 32 */     Container c = this.f.getContentPane();
/* 33 */     c.setLayout(new BorderLayout());
/* 34 */     Container c2 = this.f.getContentPane();
/* 35 */     c2.setLayout(new BorderLayout());
/* 36 */     this.t.setModel(this.tm);
/* 37 */     for (int i = 0; i < 3; i++) {
/* 38 */       this.tm.addRow(this.datos[i]);
/*    */     }
/* 40 */     c.add(this.l, "North");
/* 41 */     c2.add(new JScrollPane(this.t), "Center");
/* 42 */     add(c, "North");
/* 43 */     add(c2, "Center");
/* 44 */     add(b, "South");
/* 45 */     setVisible(true);
/*    */   }
/*    */   
/*    */   public static JugadorEnRanking getJugadorEnRanking() {
/* 49 */     return ran;
/*    */   }
/*    */   
/*    */   public int getfilas() {
/* 53 */     return this.cant_f;
/*    */   }
/*    */   
/*    */   public void agregar(String nom, int diam, int nivel) {
/* 57 */     Object[] arr = new Object[3];
/* 58 */     arr[0] = nom;
/* 59 */     arr[1] = Integer.valueOf(diam);
/* 60 */     arr[2] = Integer.valueOf(nivel);
/* 61 */     agregarenranking(arr);
/*    */   }
/*    */   
/*    */   public void agregarenranking(Object[] datos) {
/* 65 */     this.tm.addRow(datos);
/*    */   }
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\JugadorEnRanking.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */