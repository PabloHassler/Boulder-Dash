/*    */ package Backup;
/*    */ 
/*    */ public class Jugador extends Posicion {
/*  4 */   private static Jugador player = new Jugador();
/*  5 */   private int cant_diamond = 0;
/*    */   
/*    */   public void mover(EnumDireccion direc) {
/*  8 */     switch (direc) {
/*    */       case null:
/* 10 */         this.game.modificarItem(this.x, this.y + 1, this.game.getItem(getX(), getY()));
/* 11 */         this.game.modificarItem(this.x, this.y, this.game.getItem(this.x, this.y).ConvertirEnVacio());
/* 12 */         this.y++; break;
/*    */       case ARRIBA:
/* 14 */         this.game.modificarItem(this.x, this.y - 1, this.game.getItem(getX(), getY()));
/* 15 */         this.game.modificarItem(this.x, this.y, this.game.getItem(this.x, this.y).ConvertirEnVacio());
/* 16 */         this.y--; break;
/*    */       case IZQUIERDA:
/* 18 */         this.game.modificarItem(this.x - 1, this.y, this.game.getItem(getX(), getY()));
/* 19 */         this.game.modificarItem(this.x, this.y, this.game.getItem(this.x, this.y).ConvertirEnVacio());
/* 20 */         this.x--; break;
/*    */       case DERECHA:
/* 22 */         this.game.modificarItem(this.x + 1, this.y, this.game.getItem(getX(), getY()));
/* 23 */         this.game.modificarItem(this.x, this.y, this.game.getItem(this.x, this.y).ConvertirEnVacio());
/* 24 */         this.x++;
/*    */         break;
/*    */     } 
/*    */   } public BDTile tipo() {
/* 28 */     return BDTile.PLAYER;
/*    */   }
/*    */   public void setDiamond(int cant) {
/* 31 */     this.cant_diamond += cant;
/*    */   }
/*    */   public int getDiamond() {
/* 34 */     return this.cant_diamond;
/*    */   }
/*    */   public static Jugador getPlayer() {
/* 37 */     return player;
/*    */   }
/*    */   public void empujar(EnumDireccion direc) {
/* 40 */     System.out.println("Empujando");
/* 41 */     switch (direc) {
/*    */       case DERECHA:
/* 43 */         System.out.println("Empujando a la derecha");
/* 44 */         if (this.game.getItem(getX() + 2, getY()).tipo() == BDTile.EMPTY) {
/* 45 */           this.game.getItem(getX() + 1, getY()).desplazarDer();
/* 46 */           mover(direc);
/*    */         }  break;
/*    */       case IZQUIERDA:
/* 49 */         System.out.println("Empujando a la izquierda");
/* 50 */         if (this.game.getItem(getX() - 2, getY()).tipo() == BDTile.EMPTY) {
/* 51 */           this.game.getItem(getX() - 1, getY()).desplazarIzq();
/* 52 */           mover(direc);
/*    */         } 
/*    */         break;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void resetDiamantes() {
/* 59 */     this.cant_diamond = 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Jugador.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */