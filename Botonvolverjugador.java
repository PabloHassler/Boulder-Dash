/*    */ package Backup;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ 
/*    */ public class Botonvolverjugador implements MouseListener {
/*  7 */   Menu men = Menu.getMenu();
/*  8 */   DatosDeJugador datosJugador = DatosDeJugador.getDatosDeJugador();
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {
/* 11 */     this.men.init();
/* 12 */     this.men.setVisible(true);
/* 13 */     this.datosJugador.dispose();
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


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Botonvolverjugador.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */