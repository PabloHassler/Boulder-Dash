/*    */ package Backup;
/*    */ 
/*    */ import java.util.Timer;
/*    */ import java.util.TimerTask;
/*    */ 
/*    */ public class Turnos
/*    */   extends TimerTask {
/*  8 */   private JugadorEnRanking ran = JugadorEnRanking.getJugadorEnRanking();
/*  9 */   private DatosDeJugador dj = DatosDeJugador.getDatosDeJugador();
/* 10 */   private BD graf = BD.getBD();
/* 11 */   private static Turnos instancia = new Turnos();
/* 12 */   private int times = 0;
/*    */   private Timer timer;
/* 14 */   private Escenario game = Escenario.getEscenario();
/* 15 */   private Jugador player = Jugador.getPlayer();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 22 */     this.times++;
/* 23 */     if (!this.game.GameOver()) {
/* 24 */       if (this.game.getTiempoLimite() != 0)
/* 25 */       { if (this.times <= 1) {
/* 26 */           this.game.ActualizarEscenario(EnumTurnos.DIAMANTESYROCAS);
/*    */         } else {
/* 28 */           this.game.ActualizarEscenario(EnumTurnos.INSECTOS); this.times = 0;
/*    */         }  }
/* 30 */       else { this.game.explotar(this.player); }
/*    */     
/*    */     } else {
/* 33 */       this.graf.setVisible(false);
/*    */       
/* 35 */       cancel();
/* 36 */       this.ran.init();
/* 37 */       this.ran.agregar(BD.jugador, this.game.getPuntos() / 10, this.game.getNivel());
/* 38 */       this.graf.dispose();
/* 39 */       this.dj.dispose();
/* 40 */       this.ran.setVisible(true);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTiempo(int tiempo) {
/* 48 */     this.times = tiempo;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void iniciarTimer(Timer timer) {
/* 55 */     this.timer = timer;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void iniciarTiempo() {
/* 61 */     Timer timer2 = new Timer("Nuevo timer....");
/* 62 */     Turnos t = getTurno();
/* 63 */     t.iniciarTimer(timer2);
/* 64 */     this.timer.schedule(t, 0L, 1L);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getTiempo() {
/* 71 */     return this.times;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Turnos getTurno() {
/* 78 */     return instancia;
/*    */   }
/*    */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Turnos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */