package texastony.neural_network;

import java.util.Random;

import texastony.neural_network.HiddenNeuron;

public class TestHiddenNeuron_AND {
	public static void main(String[] args) {
		Random r = new Random();
		HiddenNeuron hidden1 = new HiddenNeuron(randomWeights(3, r), 2);
		int counter = 0;
		double error, error1, error2, error3, error4;
		while (counter<500){
			error=0.0;
			for(int count = 0;count<4;count++){
				if(count==0){
					double[] temp = {0.0, 0.0};
					hidden1.setInput(temp);
				}
				else if(count==1){
					double[] temp = {0.0, 1.0};
					hidden1.setInput(temp);
				}
				else if(count==2){
					double[] temp = {1.0, 0.0};
					hidden1.setInput(temp);
				}
				else {
					double[] temp = {1.0, 1.0};
					hidden1.setInput(temp);
				}
				if(count==0){
					error1 = 0-hidden1.getOutput();
					double[] temp = {error1};
					double[] delta = {hidden1.getOutput()*(1-hidden1.getOutput())*(0-hidden1.getOutput())};
					hidden1.updateWeight(delta, temp);
					error=error1*error1;
				}
				else if(count==1){
					error2 = 0-hidden1.getOutput();
					double[] temp = {error2};
					double[] delta = {hidden1.getOutput()*(1-hidden1.getOutput())*(0-hidden1.getOutput())};
					hidden1.updateWeight(delta, temp);
					error+=error2*error2;
				}
				else if(count==2){
					error3 = 0-hidden1.getOutput();
					double[] temp = {error3};
					double[] delta = {hidden1.getOutput()*(1-hidden1.getOutput())*(0-hidden1.getOutput())};
					hidden1.updateWeight(delta, temp);
					error+=error3*error3;
				}
				else{
					error4 = 1-hidden1.getOutput();
					double[] temp = {error4};
					double[] delta = {hidden1.getOutput()*(1-hidden1.getOutput())*(1-hidden1.getOutput())};
					hidden1.updateWeight(delta, temp);
					error+=error4*error4;
					System.out.println("Error is: "+error+" For run "+counter);
				}
			}
			counter++;
		}
		double tempOut;
		double[] temp = {0.0, 0.0};
		hidden1.setInput(temp);
		tempOut = hidden1.getOutput();
		System.out.println("0.0 & 0.0 = "+tempOut);
		double[] temp2 = {0.0, 1.0};
		hidden1.setInput(temp2);
		tempOut = hidden1.getOutput();
		System.out.println("1.0 & 0.0 = "+tempOut);
		double[] temp3 = {1.0, 0.0};
		hidden1.setInput(temp3);
		tempOut = hidden1.getOutput();
		System.out.println("0.0 & 1.0 = "+tempOut);
		double[] temp4 = {1.0, 1.0};
		hidden1.setInput(temp4);
		tempOut = hidden1.getOutput();
		System.out.println("1.0 & 1.0 = "+tempOut);
		

	}
	private static double[] randomWeights(int numInputs, Random r){
		double[] output = new double[numInputs];
		for(int i=0;i<numInputs;i++){
			output[i]=(r.nextDouble()-.5)*2*(2.4/numInputs);
		}
		return output;
	}
}
