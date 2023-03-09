/*    */ package Backup;
/*    */ 
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class Teclado implements KeyListener {
/*  7 */   Escenario game = Escenario.getEscenario();
/*  8 */   Jugador player = Jugador.getPlayer();
/*    */ 
/*    */   
/*    */   BD bd;
/*    */ 
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ 
/*    */   
/*    */   public void keyPressed(KeyEvent e) {
/* 18 */     if (!this.game.getJugadorBloqueado()) {
/* 19 */       int c = e.getKeyCode();
/* 20 */       System.out.println(e);
/*    */       
/* 22 */       if (c == 38) {
/*    */         try {
/* 24 */           this.player.moverHacia(EnumDireccion.ARRIBA);
/* 25 */         } catch (Exception e1) {
/*    */           
/* 27 */           e1.printStackTrace();
/*    */         } 
/* 29 */         System.out.println("arriba");
/*    */       } 
/* 31 */       if (c == 40) {
/*    */         try {
/* 33 */           this.player.moverHacia(EnumDireccion.ABAJO);
/* 34 */         } catch (Exception e1) {
/*    */           
/* 36 */           e1.printStackTrace();
/*    */         } 
/* 38 */         System.out.println("abajo");
/*    */       } 
/* 40 */       if (c == 39) {
/*    */         try {
/* 42 */           this.player.moverHacia(EnumDireccion.DERECHA);
/* 43 */         } catch (Exception e1) {
/*    */           
/* 45 */           e1.printStackTrace();
/*    */         } 
/* 47 */         System.out.println("derecha");
/*    */       } 
/* 49 */       if (c == 37) {
/*    */         try {
/* 51 */           this.player.moverHacia(EnumDireccion.IZQUIERDA);
/* 52 */         } catch (Exception e1) {
/*    */           
/* 54 */           e1.printStackTrace();
/*    */         } 
/* 56 */         System.out.println("izquierda");
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e) {}
/*    */   
/*    */   public void createAndShowGUI() {}
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Teclado.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */