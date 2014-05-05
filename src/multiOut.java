
import java.util.Random;
import neural_network.*;

public class multiOut {
	Random r = new Random(); //Create Random object for generating weights
	OutputNeuron no = new OutputNeuron(randomWeights(5, r), 4); //Create an Neurons, calling on randomWeights 
	OutputNeuron eo = new OutputNeuron(randomWeights(5, r), 4); //Create an Neurons, calling on randomWeights 
	OutputNeuron so = new OutputNeuron(randomWeights(5, r), 4); //Create an Neurons, calling on randomWeights 
	OutputNeuron wo = new OutputNeuron(randomWeights(5, r), 4); //Create an Neurons, calling on randomWeights 
	HiddenNeuron hidden1 = new HiddenNeuron(randomWeights(5, r), 4); //to generate random weights for the neurons
	HiddenNeuron hidden2 = new HiddenNeuron(randomWeights(5, r), 4);
	HiddenNeuron hidden3 = new HiddenNeuron(randomWeights(5, r), 4);
	HiddenNeuron hidden4 = new HiddenNeuron(randomWeights(5, r), 4);
	HiddenNeuron hidden21 = new HiddenNeuron(randomWeights(5, r), 4);
	HiddenNeuron hidden22 = new HiddenNeuron(randomWeights(5, r), 4);
	HiddenNeuron hidden23 = new HiddenNeuron(randomWeights(5, r), 4);
	HiddenNeuron hidden24 = new HiddenNeuron(randomWeights(5, r), 4);
	InputNeuron N = new InputNeuron();//Input neurons have no wieghts...
	InputNeuron E = new InputNeuron();
	InputNeuron S = new InputNeuron();
	InputNeuron W = new InputNeuron();
	double errorN, errorE, errorS, errorW, pastError = 2;
	double error=2; //Initialize net.error (which is actually Root Mean-Square net.error) to something greater than the acceptable net.error
	int counter =0; //are either 00, 01, 10, or 11, there are 4 net.error values.
	
	public multiOut() {
		no.setLearning(100);
		eo.setLearning(100);
		so.setLearning(100);
		wo.setLearning(100);
		hidden1.setLearning(100);
		hidden2.setLearning(100);
		hidden3.setLearning(100);
		hidden4.setLearning(100);
		hidden21.setLearning(100);
		hidden22.setLearning(100);
		hidden23.setLearning(100);
		hidden24.setLearning(100);
	}
	
	public static void main(String[] args) {
		multiOut net = new multiOut();
		while(net.error > 0.1){ //Declare the acceptable net.error here
			for(int count = 0;count < 16; count++){ //For the four input values
				if(count == 0){ //in the first case
					net.N.setInput(0.0);//the value of the first input is: 0
					net.E.setInput(0.0);//the value of the second input is: 0
					net.S.setInput(0.0);
					net.W.setInput(0.0);
				}
				else if(count == 1){//in the second case
					net.N.setInput(0.0);
					net.E.setInput(0.0);
					net.S.setInput(0.0);
					net.W.setInput(1.0);
				}
				else if(count == 2){//in the third case
					net.N.setInput(0.0);
					net.E.setInput(0.0);
					net.S.setInput(1.0);
					net.W.setInput(0.0);
				}
				else if(count == 3){//in the fourth case
					net.N.setInput(0.0);
					net.E.setInput(0.0);
					net.S.setInput(1.0);
					net.W.setInput(1.0);
				}
				else if(count == 4){//in the fourth case
					net.N.setInput(0.0);
					net.E.setInput(1.0);
					net.S.setInput(0.0);
					net.W.setInput(0.0);
				}
				else if(count == 5){//in the fourth case
					net.N.setInput(0.0);
					net.E.setInput(1.0);
					net.S.setInput(0.0);
					net.W.setInput(1.0);
				}
				else if(count == 6){//in the fourth case
					net.N.setInput(0.0);
					net.E.setInput(1.0);
					net.S.setInput(1.0);
					net.W.setInput(0.0);
				}
				else if(count == 7){//in the fourth case
					net.N.setInput(0.0);
					net.E.setInput(1.0);
					net.S.setInput(1.0);
					net.W.setInput(1.0);
				}
				else if(count == 8){//in the fourth case
					net.N.setInput(1.0);
					net.E.setInput(0.0);
					net.S.setInput(0.0);
					net.W.setInput(0.0);
				}
				else if(count == 9){//in the fourth case
					net.N.setInput(1.0);
					net.E.setInput(0.0);
					net.S.setInput(0.0);
					net.W.setInput(1.0);
				}
				else if(count == 10){//in the fourth case
					net.N.setInput(1.0);
					net.E.setInput(0.0);
					net.S.setInput(1.0);
					net.W.setInput(0.0);
				}
				else if(count == 11){//in the fourth case
					net.N.setInput(1.0);
					net.E.setInput(0.0);
					net.S.setInput(1.0);
					net.W.setInput(1.0);
				}
				else if(count == 12){//in the fourth case
					net.N.setInput(1.0);
					net.E.setInput(1.0);
					net.S.setInput(0.0);
					net.W.setInput(0.0);
				}
				else if(count == 13){//in the fourth case
					net.N.setInput(1.0);
					net.E.setInput(1.0);
					net.S.setInput(0.0);
					net.W.setInput(1.0);
				}
				else if(count == 14){//in the fourth case
					net.N.setInput(1.0);
					net.E.setInput(1.0);
					net.S.setInput(1.0);
					net.W.setInput(0.0);
				}
				else if(count == 15){//in the fourth case
					net.N.setInput(1.0);
					net.E.setInput(1.0);
					net.S.setInput(1.0);
					net.W.setInput(1.0);
				}
				runNetwork(net);
				if(count==0){//for the first case
					//THIS IS WHAT YOU CHANGE TO SWITCH BETWEEN AND, NOR, XOR, etc.
					net.errorN = 0-net.no.getOutput();
					net.errorE = 0-net.eo.getOutput();
					net.errorS = 0-net.so.getOutput();
					net.errorW = 0-net.wo.getOutput();	
				}
				else if(count==1){
					net.errorN = 0-net.no.getOutput();
					net.errorE = 0-net.eo.getOutput();
					net.errorS = 0-net.so.getOutput();
					net.errorW = 1-net.wo.getOutput();
				}
				else if(count==2 || count==3){
					net.errorN = 0-net.no.getOutput();
					net.errorE = 0-net.eo.getOutput();
					net.errorS = 1-net.so.getOutput();
					net.errorW = 0-net.wo.getOutput();					
				}
				else if (count > 3 && count < 8){
					net.errorN = 0-net.no.getOutput();
					net.errorE = 1-net.eo.getOutput();
					net.errorS = 0-net.so.getOutput();
					net.errorW = 0-net.wo.getOutput();				
				}
				else {
					net.errorN = 1-net.no.getOutput();
					net.errorE = 0-net.eo.getOutput();
					net.errorS = 0-net.so.getOutput();
					net.errorW = 0-net.wo.getOutput();
				}
				
				if (count == 0) 
					net.error = (net.errorN*net.errorN + net.errorE*net.errorE + net.errorS*net.errorS + net.errorW*net.errorW)/4;
				else if (count < 16) 
					net.error += (net.errorN*net.errorN + net.errorE*net.errorE + net.errorS*net.errorS + net.errorW*net.errorW)/4;
				if (count == 15) 
					net.error=java.lang.Math.sqrt(net.error/16);
				
				net.no.updateWeight(net.errorN); //you change the value that output1 is subtracted from 
				net.eo.updateWeight(net.errorE);
				net.wo.updateWeight(net.errorS);
				net.so.updateWeight(net.errorW);
				
				double[] deltasOut = {net.no.getDelta(), net.eo.getDelta(), net.so.getDelta(), net.wo.getDelta()}; //This is all the code for the learning.
				double[] weightsFrom21 = {net.no.getWeightValuePast()[0], net.eo.getWeightValuePast()[0], net.so.getWeightValuePast()[0], net.wo.getWeightValuePast()[0]};
				double[] weightsFrom22 = {net.no.getWeightValuePast()[1], net.eo.getWeightValuePast()[1], net.so.getWeightValuePast()[1], net.wo.getWeightValuePast()[1]};
				double[] weightsFrom23 = {net.no.getWeightValuePast()[2], net.eo.getWeightValuePast()[2], net.so.getWeightValuePast()[2], net.wo.getWeightValuePast()[2]};
				double[] weightsFrom24 = {net.no.getWeightValuePast()[3], net.eo.getWeightValuePast()[3], net.so.getWeightValuePast()[3], net.wo.getWeightValuePast()[3]};

				net.hidden21.updateWeight(deltasOut, weightsFrom21);
				net.hidden22.updateWeight(deltasOut, weightsFrom22);
				net.hidden23.updateWeight(deltasOut, weightsFrom23);
				net.hidden24.updateWeight(deltasOut, weightsFrom24);
				
				double[] deltasIn = {net.hidden21.getDelta(),net.hidden22.getDelta(), net.hidden23.getDelta(), net.hidden24.getDelta()};				
				double[] weightsFrom1 = {net.hidden21.getWeightValuePast()[0], net.hidden22.getWeightValuePast()[0], net.hidden23.getWeightValuePast()[0],net.hidden24.getWeightValuePast()[0]};
				double[] weightsFrom2 = {net.hidden21.getWeightValuePast()[1], net.hidden22.getWeightValuePast()[1], net.hidden23.getWeightValuePast()[1],net.hidden24.getWeightValuePast()[1]};
				double[] weightsFrom3 = {net.hidden21.getWeightValuePast()[2], net.hidden22.getWeightValuePast()[2], net.hidden23.getWeightValuePast()[2],net.hidden24.getWeightValuePast()[2]};
				double[] weightsFrom4 = {net.hidden21.getWeightValuePast()[3], net.hidden22.getWeightValuePast()[3], net.hidden23.getWeightValuePast()[3],net.hidden24.getWeightValuePast()[3]};
				
				net.hidden1.updateWeight(deltasIn, weightsFrom1);
				net.hidden2.updateWeight(deltasIn, weightsFrom2);
				net.hidden3.updateWeight(deltasIn, weightsFrom3);
				net.hidden4.updateWeight(deltasIn, weightsFrom4);
			}
//		if(net.counter % 10000 == 0)
//			System.out.println(net.counter);
		if (net.error < net.pastError) {
			net.pastError = net.error;
			System.out.println(net.counter + " net.error = " + net.error);
		}
//		if (net.counter % 100 == 0) {
//			System.out.println(net.counter + " net.error = " + net.error);
//			System.out.println("0 0 0 0");
//			net.N.setInput(0.0);
//			net.E.setInput(0.0);
//			net.S.setInput(0.0);
//			net.W.setInput(0.0);
//			runNetwork(net);			
//			System.out.println(net.no.getOutput() + " " + net.eo.getOutput() + " " + net.so.getOutput() + " " + net.wo.getOutput());					
//			
//			System.out.println("0 0 0 1");
//			net.N.setInput(0.0);
//			net.E.setInput(0.0);
//			net.S.setInput(0.0);
//			net.W.setInput(1.0);
//			runNetwork(net);			
//			System.out.println(net.no.getOutput() + " " + net.eo.getOutput() + " " + net.so.getOutput() + " " + net.wo.getOutput());
//			
//			System.out.println("0 0 1 0");
//			net.N.setInput(0.0);
//			net.E.setInput(0.0);
//			net.S.setInput(1.0);
//			net.W.setInput(0.0);
//			runNetwork(net);
//			System.out.println(net.no.getOutput() + " " + net.eo.getOutput() + " " + net.so.getOutput() + " " + net.wo.getOutput());
//			System.out.println("0 1 0 0");
//			net.N.setInput(0.0);
//			net.E.setInput(1.0);
//			net.S.setInput(0.0);
//			net.W.setInput(0.0);
//			runNetwork(net);
//			System.out.println(net.no.getOutput() + " " + net.eo.getOutput() + " " + net.so.getOutput() + " " + net.wo.getOutput());	
//			System.out.println("1 0 0 0");
//			net.N.setInput(1.0);
//			net.E.setInput(0.0);
//			net.S.setInput(0.0);
//			net.W.setInput(0.0);
//			runNetwork(net);
//			System.out.println(net.no.getOutput() + " " + net.eo.getOutput() + " " + net.so.getOutput() + " " + net.wo.getOutput());				
//		}
		net.counter++;
	}		
		System.out.println(net.counter);
	}
	
	private static double[] randomWeights(int numInputs, Random r){
		double[] output = new double[numInputs];
		for(int i=0;i<numInputs;i++){
			output[i]=(r.nextDouble()-.5)*2*(2.4/numInputs);
		}
		return output;	
	}
	
	private static void runNetwork(multiOut net) {
		double[] temp = {net.N.getOutput(), net.E.getOutput(), net.S.getOutput(),  net.W.getOutput()};
		net.hidden1.setInput(temp);//Pass the hidden neurons the input values
		net.hidden2.setInput(temp);
		net.hidden3.setInput(temp);
		net.hidden4.setInput(temp);
		double[] temp22 = {net.hidden1.getOutput(), net.hidden2.getOutput(), net.hidden3.getOutput(), net.hidden4.getOutput()};
		net.hidden21.setInput(temp22);//Pass the hidden neurons the input values
		net.hidden22.setInput(temp22);
		net.hidden23.setInput(temp22);
		net.hidden24.setInput(temp22);
		double[] temp2 = {net.hidden21.getOutput(), net.hidden22.getOutput(), net.hidden23.getOutput(), net.hidden24.getOutput()};
		net.no.setInput(temp2);//Pass the output neuron the hidden neuron's values
		net.eo.setInput(temp2);
		net.so.setInput(temp2);
		net.wo.setInput(temp2);
	}
}
