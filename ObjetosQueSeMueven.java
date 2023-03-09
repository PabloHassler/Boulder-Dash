/*    */ package Backup;
/*    */ 
/*    */ public abstract class ObjetosQueSeMueven
/*    */   extends Posicion {
/*  5 */   public int retardo = 150;
/*  6 */   public Jugador player = Jugador.getPlayer();
/*    */   
/*    */   public void moverInsecto(EnumDireccion direc) {
/*    */     try {
/* 10 */       Thread.sleep(this.retardo);
/* 11 */     } catch (InterruptedException e1) {
/*    */       
/* 13 */       e1.printStackTrace();
/*    */     } 
/* 15 */     if (((this.x + 1 == this.player.getX() || this.x - 1 == this.player.getX()) && this.y == this.player.getY()) || ((this.y + 1 == this.player.getY() || this.y - 1 == this.player.getY()) && this.x == this.player.getX())) {
/* 16 */       this.game.explotar(this.game.getItem(this.x, this.y));
/*    */     }
/* 18 */     switch (direc) {
/*    */       case null:
/* 20 */         this.game.modificarItem(this.x, this.y + 1, this.game.getItem(getX(), getY()));
/* 21 */         this.game.modificarItem(this.x, this.y, this.game.getItem(this.x, this.y).ConvertirEnVacio());
/* 22 */         this.y++;
/*    */         break;
/*    */       case ARRIBA:
/* 25 */         this.game.modificarItem(this.x, this.y - 1, this.game.getItem(getX(), getY()));
/* 26 */         this.game.modificarItem(this.x, this.y, this.game.getItem(this.x, this.y).ConvertirEnVacio());
/* 27 */         this.y--;
/*    */         break;
/*    */       
/*    */       case IZQUIERDA:
/* 31 */         this.game.modificarItem(this.x - 1, this.y, this.game.getItem(getX(), getY()));
/* 32 */         this.game.modificarItem(this.x, this.y, this.game.getItem(this.x, this.y).ConvertirEnVacio());
/* 33 */         this.x--;
/*    */         break;
/*    */       case DERECHA:
/* 36 */         this.game.modificarItem(this.x + 1, this.y, this.game.getItem(getX(), getY()));
/* 37 */         this.game.modificarItem(this.x, this.y, this.game.getItem(this.x, this.y).ConvertirEnVacio());
/* 38 */         this.x++;
/*    */         break;
/*    */     } 
/*    */   }
/*    */   
/*    */   public abstract void mover();
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\ObjetosQueSeMueven.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */