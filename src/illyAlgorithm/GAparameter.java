package illyAlgorithm;

public class GAparameter {

	/** 基因编码长度 */
	public static final int GENE_LENGTH = 64;

	/** 种群规模 */
	public static final int SCALE = 80;
	
	/**迭代数*/
	public static final int INTERATION = 50;

	/** 交叉概率 */
	public static final double UNIFORMRATE = 0.5;

	/** 突变概率 */
	public static final double MUTATIONRATE = 0.015;

	/** 淘汰数组的大小 */
	public static final int TOURNAMENTSIZE = 5;

	/** 精英主义 */
	public static final boolean ELITISM = true;

	/** 总分支数 */
	public static final int TOTAL_BRANCHS = 8;

	/** 总路径数 */
	public static final int TOTAL_PATHS = 5;
}
