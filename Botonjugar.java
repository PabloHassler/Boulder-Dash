/*    */ package Backup;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ 
/*    */ public class Botonjugar
/*    */   implements MouseListener
/*    */ {
/*  9 */   BD graf = BD.getBD();
/*    */   
/*    */   public void mouseClicked(MouseEvent arg0) {
/* 12 */     this.graf.init();
/* 13 */     this.graf.setVisible(true);
/*    */   }
/*    */   
/*    */   public void mouseEntered(MouseEvent arg0) {}
/*    */   
/*    */   public void mouseExited(MouseEvent arg0) {}
/*    */   
/*    */   public void mousePressed(MouseEvent arg0) {}
/*    */   
/*    */   public void mouseReleased(MouseEvent arg0) {}
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Botonjugar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */