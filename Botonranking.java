/*    */ package Backup;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ 
/*    */ public class Botonranking
/*    */   implements MouseListener
/*    */ {
/*  9 */   JugadorEnRanking ran = JugadorEnRanking.getJugadorEnRanking();
/* 10 */   Menu men = Menu.getMenu();
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {
/* 13 */     this.ran.init();
/* 14 */     this.ran.setVisible(true);
/* 15 */     this.men.dispose();
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


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Botonranking.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */