/*     */ package Backup;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Item
/*     */ {
/*  13 */   public Escenario game = Escenario.getEscenario();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item ConvertirEnVacio() {
/*  20 */     Item nuevoVacio = new Vacio(); nuevoVacio.posicion(getX(), getY()); return nuevoVacio;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item ConvertirEnDiamante() {
/*  28 */     Item nuevoDiamante = new Diamante(); nuevoDiamante.posicion(getX(), getY()); return nuevoDiamante;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumAccion tipoDeAccion(Item objeto) {
/*  38 */     switch (objeto.tipo()) { case DIRT:
/*  39 */         return EnumAccion.CAVAR;
/*  40 */       case TITANIUM: return EnumAccion.RECHAZAR;
/*  41 */       case WALL: return EnumAccion.RECHAZAR;
/*  42 */       case ROCK: return EnumAccion.EMPUJAR;
/*  43 */       case DIAMOND: return EnumAccion.RECOMPENSAR;
/*  44 */       case EXIT: return EnumAccion.SALIDA;
/*  45 */       case EMPTY: return EnumAccion.AVANZAR;
/*  46 */       case null: return EnumAccion.RECHAZAR;
/*  47 */       case FIREFLY: return EnumAccion.EXPLOTAR;
/*  48 */       case BUTTERFLY: return EnumAccion.EXPLOTAR; }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  53 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void moverHacia(EnumDireccion direc) throws Exception {
/*  63 */     System.out.println("Moviendo");
/*  64 */     switch (direc) { case DERECHA:
/*  65 */         respuesta(this.game.getItem(getX() + 1, getY()), direc); break;
/*  66 */       case IZQUIERDA: respuesta(this.game.getItem(getX() - 1, getY()), direc); break;
/*  67 */       case ARRIBA: respuesta(this.game.getItem(getX(), getY() - 1), direc); break;
/*  68 */       case null: respuesta(this.game.getItem(getX(), getY() + 1), direc);
/*     */         break; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void salida(Item item) {
/*  77 */     if (item.isEstadoPuerta()) {
/*  78 */       this.game.setPuntosTiempo(this.game.getTiempoLimite()); resetDiamantes(); this.game.setNivel(this.game.getNivel() + 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void respuesta(Item item, EnumDireccion direc) throws Exception {
/*  90 */     switch (item.tipoDeAccion(item)) { case EXPLOTAR:
/*  91 */         this.game.explotar(this.game.getItem(getX(), getY())); break;
/*  92 */       case EMPUJAR: empujar(direc); break;
/*  93 */       case CAVAR: mover(direc); break;
/*  94 */       case null: mover(direc);
/*  95 */         System.out.println("avanzando"); break;
/*  96 */       case RECOMPENSAR: mover(direc);
/*  97 */         setDiamond(1); this.game.setPuntos();
/*  98 */         System.out.println("El jugador agarro un diamante"); break;
/*     */       case SALIDA:
/* 100 */         if (getDiamond() >= this.game.cantindadDiamantesNivel() && this.game.getNivel() <= 12) {
/* 101 */           item.abrirPuerta();
/*     */         }
/* 103 */         salida(item);
/*     */         break; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BDTile tipo() {
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void posicion(int a, int b) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getX() {
/* 128 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY() {
/* 133 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mover() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void mover(EnumDireccion direc) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDiamond(int cant) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDiamond() {
/* 152 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void desplazarDer() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void desplazarIzq() {}
/*     */ 
/*     */   
/*     */   public boolean callendo() {
/* 165 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void detener() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void caer() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void moverInsecto(EnumDireccion direc) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void empujar(EnumDireccion direc) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void abrirPuerta() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEstadoPuerta() {
/* 193 */     return false;
/*     */   }
/*     */   
/*     */   public void resetDiamantes() {}
/*     */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */