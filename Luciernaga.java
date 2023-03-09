/*    */ package Backup;
/*    */ 
/*    */ public class Luciernaga extends ObjetosQueSeMueven {
/*  4 */   public Escenario game = Escenario.getEscenario();
/*  5 */   public EnumDireccion direcActual = EnumDireccion.DERECHA;
/*    */   public void mover() {
/*  7 */     switch (this.direcActual) {
/*    */       case DERECHA:
/*  9 */         if (this.game.getItem(this.x + 1, this.y).tipo() == BDTile.EMPTY) {
/* 10 */           if (this.game.getItem(this.x, this.y - 1).tipo() == BDTile.EMPTY) {
/* 11 */             System.out.println("La luciernaga se mueve hacia Arriba opcion 2");
/* 12 */             this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.ARRIBA);
/* 13 */             this.direcActual = EnumDireccion.ARRIBA; break;
/*    */           } 
/* 15 */           this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.DERECHA); this.direcActual = EnumDireccion.DERECHA; System.out.println("La luciernaga se mueve hacia la Derecha"); break;
/* 16 */         }  this.direcActual = EnumDireccion.ABAJO; break;
/*    */       case null:
/* 18 */         if (this.game.getItem(this.x, this.y + 1).tipo() == BDTile.EMPTY) {
/* 19 */           if (this.game.getItem(this.x + 1, this.y).tipo() == BDTile.EMPTY) {
/* 20 */             this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.DERECHA); System.out.println("La luciernaga se mueve hacia la Derecha opcion 2");
/* 21 */             this.direcActual = EnumDireccion.DERECHA; break;
/*    */           } 
/* 23 */           this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.ABAJO); this.direcActual = EnumDireccion.ABAJO; System.out.println("La luciernaga se mueve hacia Abajo"); break;
/* 24 */         }  this.direcActual = EnumDireccion.IZQUIERDA; break;
/*    */       case IZQUIERDA:
/* 26 */         if (this.game.getItem(this.x - 1, this.y).tipo() == BDTile.EMPTY) {
/* 27 */           if (this.game.getItem(this.x, this.y + 1).tipo() == BDTile.EMPTY) {
/* 28 */             this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.ABAJO); System.out.println("La luciernaga se mueve hacia la Abajo opcion 2");
/* 29 */             this.direcActual = EnumDireccion.ABAJO; break;
/*    */           } 
/* 31 */           this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.IZQUIERDA); this.direcActual = EnumDireccion.IZQUIERDA; System.out.println("La luciernaga se mueve hacia la Izquierda"); break;
/* 32 */         }  this.direcActual = EnumDireccion.ARRIBA; break;
/*    */       case ARRIBA:
/* 34 */         if (this.game.getItem(this.x, this.y - 1).tipo() == BDTile.EMPTY) {
/* 35 */           if (this.game.getItem(this.x - 1, this.y).tipo() == BDTile.EMPTY) {
/* 36 */             this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.IZQUIERDA);
/* 37 */             this.direcActual = EnumDireccion.IZQUIERDA; break;
/*    */           } 
/* 39 */           this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.ARRIBA); this.direcActual = EnumDireccion.ARRIBA; break;
/*    */         } 
/* 41 */         this.direcActual = EnumDireccion.DERECHA;
/*    */         break;
/*    */     } 
/*    */   } public BDTile tipo() {
/* 45 */     return BDTile.FIREFLY;
/*    */   }
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Luciernaga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */