/*     */ package Backup;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ 
/*     */ public class Reglas
/*     */   extends JFrame
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  15 */   private static Reglas r = new Reglas();
/*     */   
/*     */   public void iniciarReglas() {
/*  18 */     setTitle("Reglas de Boulder Dash");
/*  19 */     resize(650, 690);
/*  20 */     JTextArea l = new JTextArea(40, 55);
/*  21 */     JButton b = new JButton("Volver");
/*  22 */     ImageIcon bug = new ImageIcon(getClass().getResource("volver.jpg"));
/*  23 */     b.setIcon(bug);
/*  24 */     b.addMouseListener(new BotonvolverReglas());
/*  25 */     JScrollPane sp = new JScrollPane(l);
/*  26 */     l.setText("1. Del Juego en sí \r\n■ Cada nivel es completado con éxito cuando el personaje principal, Rockford, logra alcanzar la \r\npuerta de salida. La puerta de salida sólo será habilitada si Rockford encuentra una cantidad \r\ndeterminada de diamantes que varía según el nivel.\r\n■ Cada nivel puede jugarse empleando un máximo de 4 vidas.\r\n2. El escenario\r\nLos personajes se desenvuelven en un tablero\r\nde juego de 40 x 22 casilleros, de acuerdo a la\r\ndisposición que se vé en el gráfico.\r\nEl tablero es un conjunto de casilleros donde\r\nRockford puede moverse. Un casillero del tablero puede estar ocupado por los siguientes personajes\r\ncuyo comportamiento se encuentra detallado en el punto 3:\r\n■ Rockford\r\n■ Una roca\r\n■ Un diamante\r\n■ Una mariposa\r\n■ Una luciérnaga\r\n■ Una ameba\r\n■ Suciedad\r\n■ Un muro común, de titanio o mágico\r\n■ Una puerta de salida\r\n■ o simplemente estar vacío\r\nLos casilleros con rocas o muros no son accesibles para Rockford.\r\nLos casilleros con suciedad o vacíos SI son accesibles para Rockford, y de hecho el mismo hará su\r\ncamino a través de estos.\r\n3. Los Personajes \r\n  Rockford: es el personaje principal, debe recorrer el laberinto tratando de juntar una cantidad \r\nmínima de diamantes que le habiliten la puerta de salida al próximo nivel. Rockford puede \r\nescarbar en la basura así como empujar las rocas, las cuales se desplazarán sólo si el casillero \r\ncontiguo está vacío. \r\n  Rocas (Rocks o Boulder): Cada roca puede estar en uno de dos estados: “estacionario” o \r\ncayendo”. Si la roca está en estado “estacionario” y el casillero (x,y+1) justo abajo está... \r\n1. vacío: la roca se convierte en una roca “cayendo”. (Tener en cuenta que aún no se mueve) \r\n2. muro, roca o diamante: si los casilleros (x-1,y) y (x-1,y+1) inmediatamente a la izquierda y  \r\nabajo-izquierda están ambos vacíos, la roca “se desliza” al casillero (x-1, y) a la izquierda y se  \r\nconvierte en una roca “cayendo” (La regla también aplica si consideramos el lado derecho). \r\n3. cualquier otra cosa: la roca permanece “estacionaria”. \r\nSi la roca está actualmente “cayendo” y el casillero justo debajo es.... \r\n1. vacío: la roca se mueve al casillero que se encontraba abajo de la misma. \r\n2. jugador (Rockford): el jugador explota y muere \r\n3. luciérnaga: la luciérnaga explota y cualquier cosa que se encuentre en un área de 3*3 que no  \r\nsea un muro, se transforma en un espacio vacío. Las explosiones NO continúan  \r\nrecursivamente aún si hay otra luciérnaga o mariposa en el área de la explosión. \r\n4. mariposa: la mariposa explota y cualquier cosa que se encuentre en un área de 3*3 que no  \r\nsea un muro se convierte en diamante. (Las explosiones NO continúan recursivamente.) \r\n5. cualquier otra cosa: la roca se vuelve “estacionaria”. \r\n  Diamantes (Diamond): Los diamantes se comportan de la misma manera que las rocas, de  \r\nmodo que cada diamante se encuentra “estacionario” o “cayendo”, excepto que el diamante  \r\ncaiga en el jugador (Rockford), luciérnaga o mariposa  es inofensivo y simplemente termina en  \r\nun estado “estacionario”. \r\n Luciérnaga (Firefly): Si el jugador se encuentra en uno de los cuatro casilleros vecinos  \r\nadyacentes a la luciérnaga (arriba abajo, izquierda o derecha), la luciérnaga explota convirtiendo  \r\nun área de 3*3 en espacio vacío, y el jugador muere. De otro modo, la luciérnaga trata de  \r\nmoverse. Cada luciérnaga tiene una “dirección actual” (arriba abajo, izquierda o derecha). Si el  \r\nsiguiente casillero en su direcciòn està vacìo, la lucièrnaga se mueve allí. Si el siguiente casillero  \r\nno está vacío, la luciérnaga cambia su dirección de acuerdo a las agujas del reloj, por ejemplo: si  \r\nla dirección actual es “arriba”, la nueva dirección será a la “derecha”. (La luciérnaga no trata de  \r\nmoverse en la nueva dirección hasta que le toca nuevamente el turno.) \r\n  Mariposa (Butterfly): Las mariposas se comportan de la misma manera que las luciérnagas,  \r\nexcepto que se mueven en sentido contrario a las agujas del reloj cuando su intento de  \r\nmovimiento se encuentra bloqueado por algo. \r\n  Ameba (Amoeba): La ameba no se mueve y su toque es inofensivo para cualquiera, pero esta  \r\nlentamente se va expandiendo por los casilleros vacíos, haciendo eventualmente imposible  \r\nmoverse al jugador. En cada turno, la ameba tiene “pocas probabilidades” de expandirse. La  \r\nexpansión busca un casillero vecino en una dirección elegida de manera random, y si ese  \r\ncasillero está vacío o sucio, se convierte en una ameba. \r\n  Muro de Titanio (Titanium Wall): Un muro indestructible. \r\n  Muro Mágico (Magic wall): Es un tipo especial de muro que permite convertir rocas en  \r\ndiamantes y viceversa sólo durante un tiempo determinado.  \r\n  Basura (Dirt): Rockford escarba a través de la basura para dejar espacios vacíos. \r\n  Puerta de Salida (EXIT): Ésta se habilita cuando Rockford pudo recolectar una determinada  \r\ncantidad de diamantes. \r\n");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     l.setBackground(Color.LIGHT_GRAY);
/*     */     
/* 100 */     setBackground(Color.BLACK);
/* 101 */     l.setForeground(Color.WHITE);
/* 102 */     l.setCaretColor(Color.CYAN);
/* 103 */     l.setEditable(false);
/* 104 */     add(sp, "North");
/* 105 */     add(b, "Center");
/* 106 */     setVisible(true);
/*     */   }
/*     */   
/*     */   public static Reglas getReglas() {
/* 110 */     return r;
/*     */   }
/*     */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\Reglas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */