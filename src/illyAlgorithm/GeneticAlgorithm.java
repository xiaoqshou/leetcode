package illyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class GeneticAlgorithm {
	/** generate first population */
	public static void generPop(TestCases testCases) {
		for (TestCase tc : testCases.cases) {
			tc = generRanTestCase();
		}
	}

	/** generate a test case randomly */
	public static TestCase generRanTestCase() {
		return new TestCase();
	}

	/** 计算累积概率 用于遗传算法的选择操作 */
	private static void calSelectProbability(ArrayList<TestCase> testCases) {
		double sumP = 0;
		// 计算选择概率
		for (int i = 0; i < testCases.size(); i++) {
			sumP += testCases.get(i).fitValue;
			testCases.get(i).cumulativeP = sumP;
		}
		// order the test cases by fitness value
		Collections.sort(testCases, new Comparator<TestCase>() {

			@Override
			public int compare(TestCase o1, TestCase o2) {
				// TODO Auto-generated method stub
				return o1.fitValue - o2.fitValue;
			}
		});
		// 计算每个个体累计概率
		for (int i = 1; i < testCases.size(); i++) {
			testCases.get(i).cumulativeP = testCases.get(i).cumulativeP / sumP;
		}
	}

	/** 选择操作 */
	public static TestCases selectNext(ArrayList<TestCase> testCases) {
		calSelectProbability(testCases);
		TestCases nextCase = new TestCases();
		for (int j = 0; j < nextCase.cases.size(); j++) {
			double point = Math.random();
			for (int i = 0; i < testCases.size(); i++) {
				if ((point > testCases.get(i).cumulativeP)
						|| (point < testCases.get(i + 1).cumulativeP)) {
					nextCase.cases.add(testCases.get(i));
					break;
				}
			}
		}
		return nextCase;
	}

	/** operation crossover */
	private static void crossOver(TestCase iCase, TestCase jCase, int position) {
		for (int i = position; i < GAparameter.GENE_LENGTH; i++) {
			byte temp = 0;
			temp = iCase.genes[i];
			iCase.genes[i] = jCase.genes[i];
			jCase.genes[i] = temp;
		}
	}

	/** operation exchange */
	private static void exchange(TestCase a, TestCase b) {
		// TODO:
	}

	public void preparation() {
		// step one:
		TestCases iCases = new TestCases();
		// step two:
		while (!iCases.isEvolutionEnd()) {
			TestCases nextCases = selectNext(iCases.cases);
			iCases.cases = null;
			
			while (nextCases.cases.size() != 0) {
				if (Math.random() > GAparameter.MUTATIONRATE) {
					TestCase mutateCase = nextCases.selectRandom();
					mutateCase.mutate();
					iCases.cases.add(mutateCase);
				}
				if (Math.random() > GAparameter.UNIFORMRATE) {
					TestCase casei = nextCases.selectRandom();
					TestCase casej = nextCases.selectRandom();
					crossOver(casei, casej, (int) Math.random()
							* GAparameter.GENE_LENGTH);
					iCases.cases.add(casei);
					iCases.cases.add(casej);
				}
			}
		}

	}

	public void process() {
		preparation();
	}
}
