/*    */ package Backup;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ 
/*    */ public class Botonreglas
/*    */   implements MouseListener
/*    */ {
/*  9 */   Reglas r = Reglas.getReglas();
/* 10 */   Menu men = Menu.getMenu();
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {
/* 13 */     this.r.resize(650, 690);
/* 14 */     this.r.iniciarReglas();
/* 15 */     this.r.setVisible(true);
/* 16 */     this.men.dispose();
/*    */   }
/*    */   
/*    */   public void mousePressed(MouseEvent e) {}
/*    */   
/*    */   public void mouseReleased(MouseEvent e) {}
/*    */   
/*    */   public void mouseEntered(MouseEvent e) {}
/*    */   
/*    */   public void mouseExited(MouseEvent e) {}
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Botonreglas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */