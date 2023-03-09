/*     */ package Backup;
/*     */ import java.io.InputStream;
/*     */ import java.util.Map;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.xpath.XPath;
/*     */ import javax.xml.xpath.XPathFactory;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class BDLevelReader {
/*  13 */   private final int COLUMN = 40;
/*  14 */   private final int ROW = 22;
/*     */   private Document doc;
/*  16 */   private BDTile[][] field = new BDTile[40][22];
/*     */ 
/*     */ 
/*     */   
/*     */   private int diamondsNeeded;
/*     */ 
/*     */ 
/*     */   
/*     */   public int readLevels(String filename) throws Exception {
/*  25 */     InputStream is = BDLevelReader.class.getResource(filename).openStream();
/*  26 */     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
/*  27 */     DocumentBuilder db = dbf.newDocumentBuilder();
/*  28 */     this.doc = db.parse(is);
/*  29 */     XPathFactory xpf = XPathFactory.newInstance();
/*  30 */     XPath path = xpf.newXPath();
/*  31 */     int numLevel = Integer.parseInt(path.evaluate("count(levelset/level)", 
/*  32 */           this.doc));
/*  33 */     return numLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void readElementsOfType(int level, String name, BDTile value, XPath path) throws Exception {
/*  39 */     int count = Integer.parseInt(path.evaluate("count(levelset/level[" + 
/*  40 */           level + "]/" + name + ")", this.doc));
/*  41 */     for (int i = 1; i <= count; i++) {
/*  42 */       int x = Integer.parseInt(path.evaluate("levelset/level[" + level + 
/*  43 */             "]/" + name + "[" + i + "]/@x", this.doc));
/*  44 */       int y = Integer.parseInt(path.evaluate("levelset/level[" + level + 
/*  45 */             "]/" + name + "[" + i + "]/@y", this.doc));
/*  46 */       this.field[x][y] = value;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentLevel(int level) throws Exception {
/*  57 */     for (int x = 0; x < 40; x++) {
/*  58 */       for (int y = 0; y < 22; y++) {
/*  59 */         this.field[x][y] = BDTile.DIRT;
/*     */       }
/*     */     } 
/*     */     
/*  63 */     Map<String, BDTile> map = new HashMap<String, BDTile>();
/*  64 */     map.put("titanium", BDTile.TITANIUM);
/*  65 */     map.put("wall", BDTile.WALL);
/*  66 */     map.put("rock", BDTile.ROCK);
/*  67 */     map.put("diamond", BDTile.DIAMOND);
/*  68 */     map.put("amoeba", BDTile.AMOEBA);
/*  69 */     map.put("dirt", BDTile.DIRT);
/*  70 */     map.put("empty", BDTile.EMPTY);
/*  71 */     map.put("firefly", BDTile.FIREFLY);
/*  72 */     map.put("butterfly", BDTile.BUTTERFLY);
/*  73 */     map.put("exit", BDTile.EXIT);
/*  74 */     map.put("player", BDTile.PLAYER);
/*     */     
/*  76 */     NodeList nlist = this.doc.getElementsByTagName("levelset");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     Node n = nlist.item(0);
/*  85 */     nlist = n.getChildNodes();
/*     */     
/*  87 */     int lvl = 0; int i;
/*  88 */     for (i = 0; lvl < level && i < nlist.getLength(); i++) {
/*  89 */       n = nlist.item(i);
/*  90 */       if (n.getNodeName().equals("level")) {
/*  91 */         lvl++;
/*     */       }
/*     */     } 
/*  94 */     this.diamondsNeeded = Integer.parseInt(n.getAttributes()
/*  95 */         .getNamedItem("diamonds").getNodeValue());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     nlist = n.getChildNodes();
/* 102 */     for (i = 0; i < nlist.getLength(); i++) {
/*     */       
/* 104 */       Node e = nlist.item(i);
/* 105 */       String tag = e.getNodeName();
/* 106 */       if (map.containsKey(tag)) {
/*     */         
/* 108 */         NamedNodeMap attr = e.getAttributes();
/* 109 */         int j = Integer.parseInt(attr.getNamedItem("x").getNodeValue());
/* 110 */         int y = Integer.parseInt(attr.getNamedItem("y").getNodeValue());
/*     */         
/* 112 */         this.field[j][y] = map.get(tag);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BDTile getTile(int x, int y) {
/* 123 */     return this.field[x][y];
/*     */   }
/*     */   
/*     */   public int getDiamondsNeeded() {
/* 127 */     return this.diamondsNeeded;
/*     */   }
/*     */   
/*     */   public int getWIDTH() {
/* 131 */     return 40;
/*     */   }
/*     */   
/*     */   public int getHEIGHT() {
/* 135 */     return 22;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 144 */     BDLevelReader levelReader = new BDLevelReader();
/*     */     try {
/* 146 */       int nivelElegido = 1;
/* 147 */       int levels = levelReader.readLevels("levels.xml");
/* 148 */       levelReader.setCurrentLevel(nivelElegido);
/*     */       
/* 150 */       StringBuilder sb = new StringBuilder();
/* 151 */       sb.append("NIVELES DISPONIBLES:");
/* 152 */       sb.append(levels);
/* 153 */       sb.append("\n");
/* 154 */       sb.append("DIAMANTES NECESARIOS DEL NIVEL ");
/* 155 */       sb.append(nivelElegido);
/* 156 */       sb.append(":");
/* 157 */       sb.append(levelReader.getDiamondsNeeded());
/*     */       
/* 159 */       System.out.println(sb);
/*     */ 
/*     */       
/* 162 */       levelReader.imprimirMapa();
/*     */     }
/* 164 */     catch (Exception e) {
/* 165 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void imprimirMapa() {
/* 173 */     System.out.println("..............................................................");
/* 174 */     System.out.println("...Y así se ve el mapa!");
/* 175 */     for (int y = 0; y < 22; y++) {
/* 176 */       for (int x = 0; x < 40; x++) {
/* 177 */         System.out.print(this.field[x][y]);
/* 178 */         System.out.print(" ");
/*     */       } 
/* 180 */       System.out.println();
/*     */     } 
/*     */     
/* 183 */     System.out.println("..............................................................");
/*     */   }
/*     */ }


/* Location:              C:\Users\hashy\Downloads\Boulder-Dash.jar!\Backup\BDLevelReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */