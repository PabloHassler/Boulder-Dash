/*    */ package Backup;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ 
/*    */ public class BotonvolverReglas
/*    */   implements MouseListener {
/*  8 */   Menu men = Menu.getMenu();
/*  9 */   Reglas r = Reglas.getReglas();
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {
/* 12 */     this.men.init();
/* 13 */     this.men.resize(500, 200);
/* 14 */     this.men.setVisible(true);
/* 15 */     this.r.dispose();
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


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\BotonvolverReglas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */