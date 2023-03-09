/*    */ package Backup;
/*    */ 
/*    */ public abstract class Posicion extends Item {
/*    */   public int x;
/*    */   
/*    */   public void posicion(int a, int b) {
/*  7 */     this.x = a; this.y = b;
/*    */   } public int y;
/*    */   public int getX() {
/* 10 */     return this.x;
/*    */   }
/*    */   public int getY() {
/* 13 */     return this.y;
/*    */   }
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Posicion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */