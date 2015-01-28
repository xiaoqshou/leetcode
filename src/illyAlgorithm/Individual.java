package illyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoqshou
 */
public class Individual {

	/** individual's fitness value 个体适应值 */
	public int fitValue;

	/** individual's true value个体真实值 */
	public int value;
	
	public int selectTimes = 0;
	
	/** individual's code style */
	public byte[] chromosome = new byte[GAparameter.GENE_LENGTH];

	/** cumulative probability */
	public double cumulativeRatio;

	/** path info */
	public List<Integer> execPath = new ArrayList<Integer>();

	public ArrayList<Integer> branches = new ArrayList<Integer>();

	public Individual() {
		initTestCase();
	}

	private void initTestCase() {
		generateRandom();
		StringBuffer stBuf = new StringBuffer();
		for (int i = 0; i < chromosome.length; i++) {
			stBuf.append(chromosome[i]);
		}
		String binaryCode = stBuf.toString();
		this.value = Integer.valueOf(binaryCode, 2);
	}

	/** generate binaryCodesArray randomly */
	private void generateRandom() {
	for (int i = 0; i < GAparameter.GENE_LENGTH; i++) {
			byte gene = (byte) Math.round(Math.random());
			chromosome[i] = gene;
		}
	}
	/** calculate testCase's value */
	public void calculate() {
		this.fitValue = this.execPath.size() / GAparameter.TOTAL_BRANCHS;
	}
}

