/*    */ package Backup;
/*    */ 
/*    */ 
/*    */ public abstract class ObjetoDesplazable
/*    */   extends General
/*    */ {
/*  7 */   Escenario game = Escenario.getEscenario();
/*    */   boolean callendo = false;
/*  9 */   Item auxiliar = new Item();
/* 10 */   public int retardo = 80;
/* 11 */   public int retardo2 = 5;
/*    */   public void desplazarDer() {
/* 13 */     this.game.modificarItem(this.x + 1, this.y, this.game.getItem(this.x, this.y));
/* 14 */     this.game.modificarItem(this.x, this.y, this.game.getItem(this.x, this.y).ConvertirEnVacio());
/* 15 */     this.x++;
/*    */   }
/*    */   public void desplazarIzq() {
/* 18 */     this.game.modificarItem(this.x - 1, this.y, this.game.getItem(this.x, this.y));
/* 19 */     this.game.modificarItem(this.x, this.y, this.game.getItem(this.x, this.y).ConvertirEnVacio());
/* 20 */     this.x--;
/*    */   }
/*    */   
/*    */   public void mover() {
/* 24 */     if (this.game.getItem(this.x, this.y + 1).tipo() == BDTile.EMPTY) {
/*    */       try {
/* 26 */         Thread.sleep(this.retardo);
/* 27 */       } catch (InterruptedException e) {
/*    */         
/* 29 */         e.printStackTrace();
/*    */       } 
/* 31 */       this.game.modificarItem(this.x, this.y + 1, this.game.getItem(this.x, this.y));
/* 32 */       this.game.modificarItem(this.x, this.y, this.game.getItem(this.x, this.y).ConvertirEnVacio());
/* 33 */       this.y++; this.game.getItem(this.x, this.y).caer();
/*    */     }
/* 35 */     else if (this.game.getItem(this.x, this.y + 1).tipo() != BDTile.PLAYER && this.callendo) {
/* 36 */       detener();
/*    */     }
/* 38 */     else if (this.game.getItem(this.x, this.y + 1).tipo() == BDTile.PLAYER && this.callendo) {
/* 39 */       this.game.explotar(this.game.getItem(this.x, this.y + 1));
/*    */     }
/* 41 */     else if (this.game.getItem(this.x, this.y + 1).tipo() == BDTile.BUTTERFLY || this.game.getItem(this.x, this.y + 1).tipo() == BDTile.FIREFLY) {
/* 42 */       this.game.explotarDiamantes(this.game.getItem(this.x, this.y + 1));
/*    */     }
/* 44 */     else if (this.game.getItem(this.x - 1, this.y).tipo() == BDTile.EMPTY && this.game.getItem(this.x - 1, this.y + 1).tipo() == BDTile.EMPTY && (this.game.getItem(this.x, this.y + 1).tipo() == BDTile.ROCK || this.game.getItem(this.x, this.y + 1).tipo() == BDTile.DIAMOND || this.game.getItem(this.x, this.y + 1).tipo() == BDTile.WALL)) {
/*    */       try {
/* 46 */         Thread.sleep(this.retardo2);
/* 47 */       } catch (InterruptedException e) {
/*    */         
/* 49 */         e.printStackTrace();
/*    */       } 
/* 51 */       desplazarIzq(); mover();
/*    */     }
/* 53 */     else if (this.game.getItem(this.x + 1, this.y).tipo() == BDTile.EMPTY && this.game.getItem(this.x + 1, this.y + 1).tipo() == BDTile.EMPTY && (this.game.getItem(this.x, this.y + 1).tipo() == BDTile.ROCK || this.game.getItem(this.x, this.y + 1).tipo() == BDTile.DIAMOND || this.game.getItem(this.x, this.y + 1).tipo() == BDTile.WALL)) {
/*    */       try {
/* 55 */         Thread.sleep(this.retardo2);
/* 56 */       } catch (InterruptedException e) {
/*    */         
/* 58 */         e.printStackTrace();
/*    */       } 
/* 60 */       desplazarDer(); mover();
/*    */     } 
/*    */   }
/*    */   
/*    */   public BDTile tipo() {
/* 65 */     return null;
/*    */   }
/*    */   public void caer() {
/* 68 */     this.callendo = true;
/*    */   }
/*    */   public boolean callendo() {
/* 71 */     return this.callendo;
/*    */   }
/*    */   public void detener() {
/* 74 */     this.callendo = false;
/*    */   }
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\ObjetoDesplazable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */