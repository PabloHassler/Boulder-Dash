/*    */ package Backup;
/*    */ 
/*    */ public class Mariposa extends ObjetosQueSeMueven {
/*  4 */   public EnumDireccion direcActual = EnumDireccion.DERECHA;
/*    */   
/*    */   public void mover() {
/*  7 */     switch (this.direcActual) {
/*    */       case DERECHA:
/*  9 */         if (this.game.getItem(this.x + 1, this.y).tipo() == BDTile.EMPTY) {
/* 10 */           if (this.game.getItem(this.x, this.y + 1).tipo() == BDTile.EMPTY) {
/* 11 */             System.out.println("La luciernaga se mueve hacia Arriba");
/* 12 */             this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.ABAJO);
/* 13 */             this.direcActual = EnumDireccion.ABAJO; break;
/*    */           } 
/* 15 */           this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.DERECHA); this.direcActual = EnumDireccion.DERECHA; System.out.println("La luciernaga se mueve hacia la Derecha"); break;
/* 16 */         }  this.direcActual = EnumDireccion.ARRIBA; break;
/*    */       case ARRIBA:
/* 18 */         if (this.game.getItem(this.x, this.y - 1).tipo() == BDTile.EMPTY) {
/* 19 */           if (this.game.getItem(this.x + 1, this.y).tipo() == BDTile.EMPTY) {
/* 20 */             this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.DERECHA);
/* 21 */             this.direcActual = EnumDireccion.DERECHA; break;
/*    */           } 
/* 23 */           this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.ARRIBA); this.direcActual = EnumDireccion.ARRIBA; break;
/*    */         } 
/* 25 */         this.direcActual = EnumDireccion.IZQUIERDA; break;
/*    */       case IZQUIERDA:
/* 27 */         if (this.game.getItem(this.x - 1, this.y).tipo() == BDTile.EMPTY) {
/* 28 */           if (this.game.getItem(this.x, this.y - 1).tipo() == BDTile.EMPTY) {
/* 29 */             this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.ARRIBA); System.out.println("La luciernaga se mueve hacia la Abajo");
/* 30 */             this.direcActual = EnumDireccion.ARRIBA; break;
/*    */           } 
/* 32 */           this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.IZQUIERDA); this.direcActual = EnumDireccion.IZQUIERDA; System.out.println("La luciernaga se mueve hacia la Izquierda"); break;
/* 33 */         }  this.direcActual = EnumDireccion.ABAJO; break;
/*    */       case null:
/* 35 */         if (this.game.getItem(this.x, this.y + 1).tipo() == BDTile.EMPTY) {
/* 36 */           if (this.game.getItem(this.x - 1, this.y).tipo() == BDTile.EMPTY) {
/* 37 */             this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.IZQUIERDA); System.out.println("La luciernaga se mueve hacia la Derecha");
/* 38 */             this.direcActual = EnumDireccion.IZQUIERDA; break;
/*    */           } 
/* 40 */           this.game.getItem(this.x, this.y).moverInsecto(EnumDireccion.ABAJO); this.direcActual = EnumDireccion.ABAJO; System.out.println("La luciernaga se mueve hacia Abajo"); break;
/* 41 */         }  this.direcActual = EnumDireccion.DERECHA;
/*    */         break;
/*    */     } 
/*    */   }
/*    */   public BDTile tipo() {
/* 46 */     return BDTile.BUTTERFLY;
/*    */   }
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Mariposa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */