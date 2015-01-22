package illyAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TestCases {
	public ArrayList<TestCase> cases = new ArrayList<TestCase>(
			GAparameter.SCALE);
	public static int generation = 0;
	static{
		generation++;
	}
	public Set<Integer> coverBranches = new HashSet<Integer>();

	public TestCases() {
		init();
	}

	private void init() {
		for (int i = 0; i < cases.size(); i++) {
			cases.add(new TestCase());
		}
	}

	public boolean isEvolutionEnd() {
		if (generation > GAparameter.INTERATION)
			return true;
		else
			return isCoverAll();
	}

	private boolean isCoverAll() {
		for (int i = 0; i < GAparameter.SCALE; i++) {
			TestCase iCase = cases.get(i);
			SimpleTest test = new SimpleTest();
			test.judgeArea(iCase);
			for (Integer ib : iCase.branches) {
				coverBranches.add(ib);
			}
		}
		return (coverBranches.size() / GAparameter.TOTAL_BRANCHS) == 0;
	}

	public TestCase selectRandom() {
		int rand = (int) Math.random() * cases.size();
		TestCase selected = cases.get(rand);
		cases.remove(rand);
		return selected;
	}
}
