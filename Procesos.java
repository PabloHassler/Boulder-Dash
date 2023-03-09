/*    */ package Backup;
/*    */ 
/*    */ public class Procesos extends Thread {
/*  4 */   public Escenario game = Escenario.getEscenario();
/*    */   private EnumTurnos accion;
/*  6 */   private BD graf = BD.getBD();
/*    */   public Procesos(String hilo) {
/*  8 */     super(hilo);
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 13 */     while (!this.game.GameOver()) {
/* 14 */       this.game.ActualizarEscenario(this.accion);
/* 15 */       this.graf.repaint();
/*    */     } 
/* 17 */     stop();
/*    */   }
/*    */   
/*    */   public void setAccion(EnumTurnos accion) {
/* 21 */     this.accion = accion;
/*    */   }
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Procesos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */