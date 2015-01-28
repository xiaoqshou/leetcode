package illyAlgorithm;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * @author Young 
 * step1:init��һ�� 
 * step2:������Ⱥ��Ӧ�ȣ��� 
 * step3:�ж��Ƿ�ﵽ���� �ﵽ���� δ�ﵽ step4
 * step4:������Ⱥ�ۻ����� ����ѡ������������µ���Ⱥ��ת��step5 
 * step5:���µ���Ⱥ���� ������������������ת��step2;
 */
abstract class GeneticAlgorithm {
	
	/**
	 * �����Ŵ��㷨���� ��Ⱥ��ģ�����򳤶ȡ�������ʡ�������ʡ�������������Ӣ����
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
	 * ��ʼ����һ����Ⱥ
	 * initialize the first population
	 * @return
	 */
	private Population initFirstGen() {
		Population pop = new Population();
		pop.autoGenIndiv();
		return pop;
	}

	/**
	 * ����pop��Ⱥ���ۻ�����.����ѡ�����
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
		 * TODO:�����Ⱥ����������ֹ����
		 */
		if (pop.coverPro >= GAparameter.COVER_RATIO)
			return true;
		else
			return false;
	}
	
	/**
	 * ����һ����Ⱥ����ѡ�����
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
	 * ���ݸ�����ۻ����ʴ�Ⱥ����ѡ��һ����������̶�ѡ�񷽷�
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
	 * ��Ⱥ����н������
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
	 * ��Ⱥ�����ͻ�����
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
	 * ��������������ڸ������������
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
	 * ��Ⱥ��������������н������
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
	 * ��һ��������б������
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
	 * �㷨��������
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
	 * ����ִ�з���.���ݲ�ͬ�Ĳ����������в�ͬ�Ĳ�����
	 * �����еĴӲ���������Ҫ������²�����
	 * ����Ⱥ���и����ۻ����ʺ� Population.sumRatio
	 * ����Ⱥ����ÿ��������ۻ����� Individual.cumulateRatio
	 * ����Ⱥ����ÿ������֧������  Population.coverRatio
	 * execute individuals
	 * @param pop
	 */
	abstract public void execute(Population pop);
}
