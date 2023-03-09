/*    */ package Backup;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ 
/*    */ public class Botonmenujugar
/*    */   implements MouseListener {
/*  8 */   DatosDeJugador datosJugador = DatosDeJugador.getDatosDeJugador();
/*  9 */   Menu men = Menu.getMenu();
/*    */ 
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {
/* 13 */     this.datosJugador.iniciarDatosDeJugador();
/* 14 */     this.datosJugador.setVisible(true);
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


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Botonmenujugar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */