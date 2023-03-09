/*     */ package Backup;
/*     */ 
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Escenario
/*     */   extends TimerTask
/*     */ {
/*  12 */   private static Escenario instancia = new Escenario();
/*  13 */   private int vidas = 5;
/*  14 */   private int puntos = 0;
/*  15 */   private BDLevelReader levelReader = new BDLevelReader();
/*     */   private Item[][] game;
/*     */   private boolean gameOver = false;
/*     */   private int nivel;
/*  19 */   public int retardo = 1500;
/*  20 */   private int times = 0;
/*     */   private Timer timer;
/*  22 */   private int tiempoLimite = 150;
/*     */ 
/*     */   
/*     */   public boolean tiempoTerminado;
/*     */ 
/*     */   
/*     */   private boolean JugadorBloqueado = false;
/*     */ 
/*     */   
/*     */   public static Escenario getEscenario() {
/*  32 */     return instancia;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void crearEscenario(int nivel) {
/*  39 */     this.nivel = nivel;
/*     */     try {
/*  41 */       int levels = this.levelReader.readLevels("levels.xml");
/*  42 */       this.levelReader.setCurrentLevel(nivel);
/*  43 */     } catch (Exception e) {
/*     */       
/*  45 */       e.printStackTrace();
/*     */     } 
/*  47 */     this.game = new Item[this.levelReader.getWIDTH()][this.levelReader.getHEIGHT()];
/*  48 */     for (int y = 0; y < this.levelReader.getHEIGHT(); y++) {
/*  49 */       for (int x = 0; x < this.levelReader.getWIDTH(); x++) {
/*  50 */         this.game[x][y] = null;
/*  51 */         switch (this.levelReader.getTile(x, y)) { case EMPTY:
/*  52 */             this.game[x][y] = new Vacio(); this.game[x][y].posicion(x, y); break;
/*  53 */           case DIRT: this.game[x][y] = new Suciedad(); this.game[x][y].posicion(x, y); break;
/*  54 */           case TITANIUM: this.game[x][y] = new MuroTitanio(); this.game[x][y].posicion(x, y); break;
/*  55 */           case WALL: this.game[x][y] = new MuroMagico(); this.game[x][y].posicion(x, y); break;
/*  56 */           case ROCK: this.game[x][y] = new Roca(); this.game[x][y].posicion(x, y); break;
/*  57 */           case DIAMOND: this.game[x][y] = new Diamante(); this.game[x][y].posicion(x, y); break;
/*  58 */           case PLAYER: this.game[x][y] = Jugador.getPlayer(); this.game[x][y].posicion(x, y); break;
/*  59 */           case BUTTERFLY: this.game[x][y] = new Mariposa(); this.game[x][y].posicion(x, y); break;
/*  60 */           case FIREFLY: this.game[x][y] = new Luciernaga(); this.game[x][y].posicion(x, y); break;
/*  61 */           case EXIT: this.game[x][y] = new Puerta(); this.game[x][y].posicion(x, y); break;
/*  62 */           case null: this.game[x][y] = new Ameba(); this.game[x][y].posicion(x, y);
/*     */             break; }
/*     */ 
/*     */       
/*     */       } 
/*     */     } 
/*  68 */     imprimirMapa(); setJugadorBloqueado(false); this.times = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItem(int x, int y) {
/*  77 */     return this.game[x][y];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item modificarItem(int columna, int fila, Item modificacion) {
/*  87 */     this.game[columna][fila] = modificacion; return this.game[columna][fila];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void explotar(Item item) {
/*  95 */     if (Jugador.getPlayer().getX() == item.getX() && Jugador.getPlayer().getY() == item.getY()) {
/*  96 */       setJugadorBloqueado(true);
/*     */     }
/*  98 */     for (int f = item.getX() - 1; f <= item.getX() + 1; f++) {
/*  99 */       for (int c = item.getY() - 1; c <= item.getY() + 1; c++) {
/* 100 */         if (this.game[f][c].tipo() != BDTile.TITANIUM)
/* 101 */           instancia.modificarItem(f, c, this.game[f][c].ConvertirEnVacio()); 
/*     */       } 
/*     */     } 
/*     */     try {
/* 105 */       Thread.sleep(this.retardo);
/* 106 */     } catch (InterruptedException e) {
/*     */       
/* 108 */       e.printStackTrace();
/*     */     } 
/* 110 */     if (this.JugadorBloqueado) {
/* 111 */       reset();
/*     */     }
/*     */   }
/*     */   
/*     */   public void explotarDiamantes(Item item) {
/* 116 */     for (int f = item.getX() - 1; f <= item.getX() + 1; f++) {
/* 117 */       for (int c = item.getY() - 1; c <= item.getY() + 1; c++) {
/* 118 */         if (this.game[f][c].tipo() != BDTile.TITANIUM)
/* 119 */           instancia.modificarItem(f, c, this.game[f][c].ConvertirEnDiamante()); 
/*     */       } 
/*     */     } 
/*     */     try {
/* 123 */       Thread.sleep(this.retardo);
/* 124 */     } catch (InterruptedException e) {
/*     */       
/* 126 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean GameOver() {
/* 134 */     return this.gameOver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 141 */     this.vidas--;
/* 142 */     if (this.vidas == 0) {
/* 143 */       this.gameOver = true;
/*     */     }
/* 145 */     instancia.setNivel(this.nivel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int cantindadDiamantesNivel() {
/* 153 */     return this.levelReader.getDiamondsNeeded();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNivel() {
/* 160 */     return this.nivel;
/*     */   }
/*     */   public void setNivel(int level) {
/* 163 */     this.nivel = level; instancia.crearEscenario(this.nivel);
/*     */   }
/*     */   public int getVidas() {
/* 166 */     return this.vidas;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ActualizarEscenario(EnumTurnos accion) {
/* 173 */     for (int y = 0; y < this.levelReader.getHEIGHT(); y++) {
/* 174 */       for (int x = 0; x < this.levelReader.getWIDTH(); x++) {
/* 175 */         switch (this.game[x][y].tipo()) {
/*     */           case FIREFLY:
/*     */           case BUTTERFLY:
/* 178 */             if (accion == EnumTurnos.INSECTOS)
/* 179 */               this.game[x][y].mover(); 
/*     */             break;
/*     */           case ROCK:
/*     */           case DIAMOND:
/* 183 */             if (accion == EnumTurnos.DIAMANTESYROCAS) {
/* 184 */               this.game[x][y].mover();
/*     */             }
/*     */             break;
/*     */           case null:
/* 188 */             if (accion == EnumTurnos.AMOEBA) {
/* 189 */               this.game[x][y].mover();
/*     */             }
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void imprimirMapa() {
/* 202 */     System.out.println("..............................................................");
/* 203 */     for (int y = 0; y < this.levelReader.getHEIGHT(); y++) {
/* 204 */       for (int x = 0; x < this.levelReader.getWIDTH(); x++) {
/* 205 */         System.out.print(this.game[x][y].tipo());
/* 206 */         System.out.print(" ");
/*     */       } 
/* 208 */       System.out.println();
/*     */     } 
/*     */     
/* 211 */     System.out.println("..............................................................");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPuntos() {
/* 219 */     return this.puntos;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPuntos() {
/* 225 */     this.puntos += 10;
/*     */   }
/*     */   public void setPuntosTiempo(int tiempo) {
/* 228 */     this.puntos += tiempo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 235 */     this.times++;
/* 236 */     if (this.times <= this.tiempoLimite) {
/* 237 */       System.out.println("tiempo: " + getTiempoLimite());
/*     */     } else {
/* 239 */       System.out.println("Reiniciando...");
/* 240 */       this.tiempoTerminado = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTiempo(int tiempo) {
/* 248 */     this.times = tiempo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void iniciarTimer(Timer timer) {
/* 255 */     this.timer = timer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void iniciarTiempo() {
/* 261 */     Timer timer2 = new Timer("Nuevo timer....");
/* 262 */     Escenario t = getEscenario();
/* 263 */     t.iniciarTimer(timer2);
/* 264 */     this.timer.schedule(t, 0L, 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTiempo() {
/* 271 */     return this.times;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTiempoLimite() {
/* 278 */     return this.tiempoLimite - this.times;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTiempoLimite(int tiempoLimite) {
/* 285 */     this.tiempoLimite = tiempoLimite;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getJugadorBloqueado() {
/* 292 */     return this.JugadorBloqueado;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJugadorBloqueado(boolean jugadorBloqueado) {
/* 299 */     this.JugadorBloqueado = jugadorBloqueado;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Timer getTimer() {
/* 306 */     return this.timer;
/*     */   }
/*     */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Escenario.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */