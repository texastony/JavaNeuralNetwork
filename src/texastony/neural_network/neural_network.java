package texastony.neural_network;

import java.lang.Math;
import java.util.Random;
import texastony.neural_network.OutputNeuron;
import texastony.neural_network.HiddenNeuron;
import texastony.neural_network.InputNeuron;


public class neural_network{	
	public static void main(String[] args) {
		Random r = new Random();
		OutputNeuron output1 = new OutputNeuron(randomWeights(3, r), 3);
		HiddenNeuron hidden1 = new HiddenNeuron(randomWeights(2, r), 2);
		HiddenNeuron hidden2 = new HiddenNeuron(randomWeights(2, r), 2);
		HiddenNeuron hidden3 = new HiddenNeuron(randomWeights(2, r), 2);
		InputNeuron input1 = new InputNeuron();
		InputNeuron input2 = new InputNeuron();
		double error0 = 1000.0;
		double error1 = 1000.0;
		double error2 = 1000.0;
		double error3 = 1000.0;
		int count = 0;
		int counter =0;
		boolean first = true;
		while(Math.abs(error0)>=0.1 || Math.abs(error1)>=0.1 || Math.abs(error2)>=0.1 || Math.abs(error3)>=0.1){
			if(first==true){
				first=false;
			}
			else{
				if(count==0){
					output1.updateWeight(error0);
				}
				else if(count==1){
					output1.updateWeight(error1);
				}
				else if(count==2){
					output1.updateWeight(error2);
				}
				else{
					output1.updateWeight(error3);
				}
				double[] deltaTemp = {output1.getDelta()};
				double[] outputWeights = output1.getWeightValuePast();
				double[] outputTemp1 = {outputWeights[0]};
				double[] outputTemp2 = {outputWeights[1]};
				double[] outputTemp3 = {outputWeights[2]};
				hidden1.updateWeight(deltaTemp, outputTemp1);
				hidden2.updateWeight(deltaTemp, outputTemp2);
				hidden3.updateWeight(deltaTemp, outputTemp3);
			}
			if(count==0){
				input1.setInput(0.0);
				input2.setInput(1.0);
			}
			else if(count==1){
				input1.setInput(1.0);
				input2.setInput(0.0);
			}
			else if(count==2){
				input1.setInput(1.0);
				input2.setInput(1.0);
			}
			else{
				input1.setInput(0.0);
				input2.setInput(0.0);
			}
			double[] temp = {input1.getOutput(), input2.getOutput()};
			hidden1.setInput(temp);
			hidden2.setInput(temp);
			hidden3.setInput(temp);
			double[] tempHidden = {hidden1.getOutput(), hidden2.getOutput(), hidden3.getOutput()};
			output1.setInput(tempHidden);
			if(count==0){
				error0 = 1-output1.getOutput();
				System.out.println("error0 =" + error0);
			}
			else if(count==1){
				error1 = 1-output1.getOutput();
				System.out.println("error1 =" + error1);
			}
			else if(count==2){
				error2 = 1-output1.getOutput();
				System.out.println("error2 =" + error2);
			}
			else{
				error3 = 0-output1.getOutput();
				System.out.println("error3 =" + error3);
			}
			count = (count+1)%4;
			counter++;
		}
		System.out.println("0 0");
		input1.setInput(0.0);
		input2.setInput(0.0);
		double[] temp = {input1.getOutput(), input2.getOutput()};
		hidden1.setInput(temp);
		hidden2.setInput(temp);
		hidden3.setInput(temp);
		double[] tempHidden = {hidden1.getOutput(), hidden2.getOutput(), hidden3.getOutput()};
		output1.setInput(tempHidden);
		System.out.println(output1.getOutput());
		System.out.println(counter);
	}
	private static double[] randomWeights(int numInputs, Random r){
		double[] output = new double[numInputs];
		for(int i=0;i<numInputs-1;i++){
			output[i]=r.nextDouble()-1*2*(2.4/numInputs);
		}
		return output;
	}
}
