package illyAlgorithm;

public class MainTest {
	public static GeneticAlgorithm gally = new GeneticAlgorithm() {
		
		@Override
		public void execute(Population pop) {
			// TODO Auto-generated method stub
			SimpleTest test = new SimpleTest();
			pop.sumPro = 0;
			for (Individual i : pop.individuals) {
				test.judgeArea(i);
				pop.sumPro += i.fitValue;
				i.cumulativeRatio = pop.sumPro;
				for(Integer in :i.branches)
					pop.coverBranches.add(in);
			}
		}
	};
	public static void main(String[] args) {
		gally.process();
	}
}
