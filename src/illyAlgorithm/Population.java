package illyAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Population {
	/**
	 * 种群中个体累积概率和
	 */
	public double sumPro = 0;
	public ArrayList<Individual> individuals;
	public static int generation = 0;
	static{
		generation++;
	}
	public Set<Integer> coverBranches = new HashSet<Integer>();
	public double coverPro;
	
	public Population() {
		new ArrayList<Individual>(GAparameter.SCALE);
	}
	/**
	 * 自动生成种群中的个体.用于第一代种群 
	 * auto generate individuals
	 */
	public void autoGenIndiv()
	{
		for (int i = 0; i < individuals.size(); i++) {
			individuals.add(new Individual());
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
			Individual iCase = individuals.get(i);
			SimpleTest test = new SimpleTest();
			test.judgeArea(iCase);
			for (Integer ib : iCase.branches) {
				coverBranches.add(ib);
			}
		}
		return (coverBranches.size() / GAparameter.TOTAL_BRANCHS) == 0;
	}
	
	/**
	 * select a individual from the population and remove it from the population
	 * @return
	 */
	public Individual selectRandom(int size) {
		int rand = (int) Math.random() * size;
		Individual selected = individuals.get(rand);
		individuals.remove(rand);
		return selected;
	}
	public double calCoverRatio()
	{
		this.coverPro = coverBranches.size()/GAparameter.TOTAL_BRANCHS;
		return this.coverPro;
	}
}
