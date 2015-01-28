package illyAlgorithm;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * @author Young 
 * step1:init第一代 
 * step2:计算种群适应度（） 
 * step3:判断是否达到条件 达到结束 未达到 step4
 * step4:计算种群累积概率 进行选择操作，生成新的种群，转入step5 
 * step5:对新的种群进行 交叉操作、变异操作。转入step2;
 */
abstract class GeneticAlgorithm {
	
	/**
	 * 设置遗传算法参数 种群规模、基因长度、交叉概率、变异概率、迭代次数、精英主义
	 * set Genetic Algorithm's parameter
	 */
	public static void setGApara(int popScale, int geneLength,
			int crossoverPro, int mutatePro, int interation, boolean elitism) {
		GAparameter.SCALE = popScale;
		GAparameter.GENE_LENGTH = geneLength;
		GAparameter.UNIFORMRATE = crossoverPro;
		GAparameter.MUTATIONRATE = mutatePro;
		GAparameter.INTERATION = interation;
		GAparameter.ELITISM = elitism;
	}

	/**
	 * 初始化第一代种群
	 * initialize the first population
	 * @return
	 */
	private Population initFirstGen() {
		Population pop = new Population();
		pop.autoGenIndiv();
		return pop;
	}

	/**
	 * 计算pop种群的累积概率.用于选择操作
	 * calculate population's accumulate probability
	 */
	private void calAccuPro(Population pop) {

		Collections.sort(pop.individuals, new Comparator<Individual>() {

			@Override
			public int compare(Individual o1, Individual o2) {
				// TODO Auto-generated method stub
				return o1.fitValue - o2.fitValue;
			}
		});
		for (int i = 0; i < pop.individuals.size(); i++) {
			pop.individuals.get(i).cumulativeRatio = pop.individuals.get(i).cumulativeRatio
					/ pop.sumPro;
		}
	}

	private boolean judgeEndPro(Population pop) {
		execute(pop);
		pop.calCoverRatio();
		/*
		 * TODO:添加种群迭代次数终止条件
		 */
		if (pop.coverPro >= GAparameter.COVER_RATIO)
			return true;
		else
			return false;
	}
	
	/**
	 * 对上一代种群进行选择操作
	 * generate the next population with select operation
	 * @return
	 */
	private Population selectNextPop(Population pop) {
		Population nextPop = new Population();
		for (@SuppressWarnings("unused")
		Individual indi : nextPop.individuals) {
			double selectivePro = genRandom(0, pop.sumPro);
			indi = select(pop, selectivePro);
		}
		return nextPop;
	}

	/**
	 * 根据个体的累积概率从群体中选择一条个体的轮盘赌选择方法
	 * operation select : select a individual for a population
	 * @param pop
	 */
	private static Individual select(Population pop, double selectivePro) {
		for (int i = 0; i < pop.individuals.size(); i++) {
			if (selectivePro < pop.individuals.get(i).cumulativeRatio) {
				return pop.individuals.get(i);
			}
		}
		return null;
	}

	/**
	 * 对群体进行交叉操作
	 * operation crossover for a population
	 * @param pop
	 */
	private void crossOver(Population pop) {
		for (int i = pop.individuals.size() - 1; i > 0; i--) {
			Individual indM = pop.selectRandom(i);
			Individual indF = pop.selectRandom(i--);
			if (genRandom(0, 1) > GAparameter.UNIFORMRATE) {
				crossOverIndividuals(indF, indM,
						(int) genRandom(0, GAparameter.GENE_LENGTH));
			}
			pop.individuals.add(indM);
			pop.individuals.add(indF);
		}
	}

	/**
	 * 对群体进行突变操作
	 * operation mutation for a population
	 * @param pop
	 */
	private void mutation(Population pop) {
		for (int i = 0; i < pop.individuals.size(); i++) {
			if (genRandom(0, 1) > GAparameter.MUTATIONRATE)
				pop.individuals.set(i, mutateIndiv(pop.individuals.get(i)));
		}
	}
	/**
	 * 随机生成数，用于各种随机操作数
	 * generate a double number randomly between [from,to]
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	private double genRandom(double from, double to) {
		Random r = new Random();
		return r.nextDouble() * (to - from) + from;
	}

	/**
	 * 对群体中两个个体进行交叉操作
	 * operation crossover for a population
	 * 
	 * @param iIndiv
	 * @param Jindiv
	 * @param position
	 */
	private void crossOverIndividuals(Individual iIndiv,
			Individual Jindiv, int position) {
		for (int i = position; i < GAparameter.GENE_LENGTH; i++) {
			byte temp = 0;
			temp = iIndiv.chromosome[i];
			iIndiv.chromosome[i] = Jindiv.chromosome[i];
			Jindiv.chromosome[i] = temp;
		}
	}

	/**
	 * 对一个个体进行变异操作
	 * operation mutation for a population
	 * @return
	 */
	private Individual mutateIndiv(Individual indi) {
		int location = (int) genRandom(0, GAparameter.GENE_LENGTH);
		indi.chromosome[location] = (byte) ((indi.chromosome[location] == 1) ? 0 : 1);
		return indi;
	}

	/** operation exchange */
	@SuppressWarnings("unused")
	private static void exchange(Individual a, Individual b) {
		// TODO:
	}

	/**
	 * 算法操作流程
	 */
	public void process() {
		Population pF = initFirstGen();
		Population pp = pF;
		if (!judgeEndPro(pp)) {
			calAccuPro(pp);
			Population nextPP = selectNextPop(pp);
			crossOver(nextPP);
			mutation(nextPP);
			pp = nextPP;
			
		}
	}
	/**
	 * 抽象执行方法.根据不同的测试用例进行不同的操作。
	 * 所进行的从测试用例需要获得如下参数：
	 * 计算群体中个体累积概率和 Population.sumRatio
	 * 计算群体中每个个体的累积概率 Individual.cumulateRatio
	 * 计算群体中每个个分支覆盖率  Population.coverRatio
	 * execute individuals
	 * @param pop
	 */
	abstract public void execute(Population pop);
}
