package illyAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiaoqshou
 * 测试用例相当于GA中的individual
 */
public class TestCase {

	/** 个体适应值 */
	public int fitValue;

	/** individual real value */
	public int value;

	public int selectTimes = 0;
	public byte[] genes = new byte[GAparameter.GENE_LENGTH];

	/** selective probability */
	public double selectiveP;

	/** cumulative probability */
	public double cumulativeP;

	/** path info */
	public List<Integer> execPath = new ArrayList<Integer>();

	public ArrayList<Integer> branches = new ArrayList<Integer>();

	public TestCase() {

	}

	private void initTestCase() {
		generateRandom();
		StringBuffer stBuf = new StringBuffer();
		for (int i = 0; i < genes.length; i++) {
			stBuf.append(genes[i]);
		}
		String binaryCode = stBuf.toString();
		this.value = Integer.valueOf(binaryCode, 2);
	}

	/** generate binaryCodesArray randomly */
	private void generateRandom() {
		for (int i = 0; i < GAparameter.GENE_LENGTH; i++) {
			byte gene = (byte) Math.round(Math.random());
			genes[i] = gene;
		}
	}

	/** mutate */
	public TestCase mutate() {
		int i = (int) Math.random() * (this.genes.length);
		changeGene(i);
		return this;
	}

	/** calculate testCase's value */
	public void calculate() {
		this.fitValue = this.execPath.size() / GAparameter.TOTAL_BRANCHS;
		this.selectiveP = fitValue;

	}

	private void changeGene(int i) {
		if (this.genes[i] == 0)
			this.genes[i] = 1;
		else
			this.genes[i] = 0;
	}
}
