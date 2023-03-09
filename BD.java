/*     */ package Backup;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class BD
/*     */   extends JFrame {
/*     */   static Integer i;
/*     */   static String jugador;
/*  17 */   DatosDeJugador dj = DatosDeJugador.getDatosDeJugador();
/*  18 */   Jugador player = Jugador.getPlayer();
/*  19 */   Font fuente = new Font("Arial Black", 4, 16);
/*  20 */   private static BD tablero = new BD();
/*  21 */   private Escenario game = Escenario.getEscenario();
/*  22 */   private Toolkit tool = Toolkit.getDefaultToolkit();
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public void init() {
/*  26 */     setTitle("Boulder Dash");
/*  27 */     jugador = this.dj.tf.getSelectedText();
/*  28 */     setSize(644, 405);
/*  29 */     addKeyListener(new Teclado());
/*  30 */     setFocusable(true);
/*  31 */     this.game.crearEscenario(this.dj.nivelSeleccionado());
/*  32 */     this.game.iniciarTiempo();
/*  33 */     Turnos turno = Turnos.getTurno();
/*  34 */     turno.iniciarTiempo();
/*  35 */     setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void paint(Graphics g) {
/*  41 */     HashMap<BDTile, BufferedImage> img = new HashMap<BDTile, BufferedImage>();
/*     */     try {
/*  43 */       img.put(BDTile.DIRT, ImageIO.read(getClass().getResource("dirt.gif")));
/*  44 */     } catch (IOException e) {
/*     */       
/*  46 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/*  49 */       img.put(BDTile.EMPTY, ImageIO.read(getClass().getResource("empty.jpg")));
/*  50 */     } catch (IOException e) {
/*     */       
/*  52 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/*  55 */       img.put(BDTile.ROCK, ImageIO.read(getClass().getResource("boulder.gif")));
/*  56 */     } catch (IOException e) {
/*     */       
/*  58 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/*  61 */       img.put(BDTile.TITANIUM, ImageIO.read(getClass().getResource("steel.gif")));
/*  62 */     } catch (IOException e) {
/*     */       
/*  64 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/*  67 */       img.put(BDTile.WALL, ImageIO.read(getClass().getResource("wall.gif")));
/*  68 */     } catch (IOException e) {
/*     */       
/*  70 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  73 */     g.setFont(this.fuente);
/*  74 */     g.clearRect(0, 0, 650, 45);
/*  75 */     g.drawString(Integer.toString(this.game.cantindadDiamantesNivel()), 24, 45);
/*  76 */     g.drawImage(this.tool.getImage(getClass().getResource("diamond.gif")), 75, 30, this);
/*  77 */     g.drawString(Integer.toString(this.game.getVidas()), 120, 45);
/*  78 */     g.drawString(Integer.toString(this.player.getDiamond()), 235, 45);
/*  79 */     g.drawString(Integer.toString(this.game.getPuntos()), 570, 45);
/*  80 */     g.drawString(Integer.toString(this.game.getTiempoLimite()), 470, 45);
/*  81 */     for (int x = 0; x < 40; x++) {
/*  82 */       for (int y = 0; y < 22; y++) {
/*  83 */         Image img2 = null;
/*  84 */         switch (this.game.getItem(x, y).tipo()) { case EMPTY:
/*  85 */             g.drawImage(img.get(BDTile.EMPTY), x * 16, y * 16 + 50, null); break;
/*  86 */           case DIRT: g.drawImage(img.get(BDTile.DIRT), x * 16, y * 16 + 50, null); break;
/*  87 */           case TITANIUM: g.drawImage(img.get(BDTile.TITANIUM), x * 16, y * 16 + 50, null); break;
/*  88 */           case WALL: g.drawImage(img.get(BDTile.WALL), x * 16, y * 16 + 50, null); break;
/*  89 */           case ROCK: g.drawImage(img.get(BDTile.ROCK), x * 16, y * 16 + 50, null); break;
/*  90 */           case DIAMOND: img2 = this.tool.getImage(getClass().getResource("diamond.gif")); break;
/*  91 */           case PLAYER: img2 = this.tool.getImage(getClass().getResource("rockford.gif")); break;
/*  92 */           case BUTTERFLY: img2 = this.tool.getImage(getClass().getResource("butterfly.gif")); break;
/*  93 */           case FIREFLY: img2 = this.tool.getImage(getClass().getResource("firefly.gif")); break;
/*  94 */           case EXIT: img2 = this.tool.getImage(getClass().getResource("exit.gif")); break;
/*  95 */           case null: img2 = this.tool.getImage(getClass().getResource("amoeba.gif"));
/*     */             break; }
/*     */ 
/*     */         
/*  99 */         g.drawImage(img2, x * 16, y * 16 + 50, this);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BD getBD() {
/* 110 */     return tablero;
/*     */   }
/*     */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\BD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */