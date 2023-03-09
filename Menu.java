/*    */ package Backup;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class Menu
/*    */   extends JFrame
/*    */ {
/* 12 */   private static Menu menu = new Menu();
/*    */ 
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   
/*    */   public void init() {
/* 19 */     setTitle("Menu de Boulder Dash");
/* 20 */     resize(500, 110);
/* 21 */     JPanel p = new JPanel();
/* 22 */     JPanel p2 = new JPanel();
/* 23 */     JButton b = new JButton();
/* 24 */     ImageIcon bug = new ImageIcon(getClass().getResource("info.gif"));
/* 25 */     b.setIcon(bug);
/* 26 */     b.addMouseListener(new Botonreglas());
/* 27 */     b.setText("Reglas");
/* 28 */     JButton b2 = new JButton("Ranking");
/* 29 */     ImageIcon bug2 = new ImageIcon(getClass().getResource("Corona.png"));
/* 30 */     b2.setIcon(bug2);
/* 31 */     b2.addMouseListener(new Botonranking());
/* 32 */     JButton b3 = new JButton();
/* 33 */     ImageIcon bug3 = new ImageIcon(getClass().getResource("index.jpg"));
/* 34 */     b3.setIcon(bug3);
/* 35 */     b3.setText("Jugar");
/* 36 */     b3.addMouseListener(new Botonmenujugar());
/* 37 */     JButton b4 = new JButton("Salir");
/* 38 */     ImageIcon bug4 = new ImageIcon(getClass().getResource("cerrar.jpg"));
/* 39 */     b4.setIcon(bug4);
/* 40 */     b4.addMouseListener(new Botonsalir());
/* 41 */     p.add(b); p.add(b2);
/* 42 */     p2.add(b3); p2.add(b4);
/* 43 */     setLayout(new BorderLayout());
/* 44 */     add(p, "North");
/* 45 */     add(p2, "Center");
/* 46 */     setVisible(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Menu getMenu() {
/* 51 */     return menu;
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 55 */     menu = getMenu();
/* 56 */     menu.init();
/* 57 */     menu.setVisible(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Menu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */