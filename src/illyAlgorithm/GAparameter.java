package illyAlgorithm;

public class GAparameter {

	/** 基因编码长度 */
	public static  int GENE_LENGTH = 64;

	/** 种群规模 */
	public static  int SCALE = 80;
	
	/**迭代数*/
	public static  int INTERATION = 50;

	/** 交叉概率 */
	public static  double UNIFORMRATE = 0.5;

	/** 突变概率 */
	public static  double MUTATIONRATE = 0.015;

	/** 淘汰数组的大小 */
	public static  int TOURNAMENTSIZE = 5;

	/** 精英主义 */
	public static  boolean ELITISM = true;

	/** 总分支数 */
	public static  int TOTAL_BRANCHS = 8;

	/** 总路径数 */
	public static  int TOTAL_PATHS = 5;
	
	public static long COVER_RATIO = 1;
}
