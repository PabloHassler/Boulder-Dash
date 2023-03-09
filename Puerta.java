/*    */ package Backup;
/*    */ 
/*    */ public class Puerta
/*    */   extends Posicion {
/*    */   public BDTile tipo() {
/*  6 */     return BDTile.EXIT;
/*    */   }
/*    */   private boolean estadoPuerta = false;
/*    */   public void abrirPuerta() {
/* 10 */     setEstadoPuerta(true);
/*    */   }
/*    */   public void cerrarPuerta() {
/* 13 */     setEstadoPuerta(false);
/*    */   }
/*    */   public void Mover() {}
/*    */   
/*    */   public boolean isEstadoPuerta() {
/* 18 */     return this.estadoPuerta;
/*    */   }
/*    */   
/*    */   public void setEstadoPuerta(boolean estadoPuerta) {
/* 22 */     this.estadoPuerta = estadoPuerta;
/*    */   }
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Puerta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */