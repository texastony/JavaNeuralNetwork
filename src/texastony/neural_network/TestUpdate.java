package texastony.neural_network;

import java.util.Arrays;
import java.util.Random;

import texastony.neural_network.OutputNeuron;

import java.lang.Math;

public class TestUpdate {
	public static void main(String[] args) {
		Random r = new Random();
		OutputNeuron output1 = new OutputNeuron(randomWeights(3, r), 2);
		int counter = 0;
		double error, error1, error2, error3, error4;
		while (counter<500){
			error=0.0;
			for(int count = 0;count<3;count++){
				if(count==0){
					double[] temp = {0.0, 0.0};
					output1.setInput(temp);
				}
				else if(count==1){
					double[] temp = {0.0, 1.0};
					output1.setInput(temp);
				}
				else {
					double[] temp = {1.0, 1.0};
					output1.setInput(temp);
				}
				if(count==0){
					error1 = 0-output1.getOutput();
					output1.updateWeight(error1);
					error=error1*error1;
				}
				else if(count==1){
					error2 = 1-output1.getOutput();
					output1.updateWeight(error2);
					error+=error2*error2;
				}
				else{
					error3 = 1-output1.getOutput();
					output1.updateWeight(error3);
					error+=error3*error3;
					System.out.println("Error is: "+error+" For run "+counter);
				}
			}
			counter++;
		}
		double tempOut;
		double[] temp = {0.0, 0.0};
		output1.setInput(temp);
		tempOut = output1.getOutput();
		System.out.println("0.0 & 0.0 = "+tempOut);
		double[] temp2 = {0.0, 1.0};
		output1.setInput(temp2);
		tempOut = output1.getOutput();
		System.out.println("0.0 & 1.0 = "+tempOut);
		double[] temp3 = {1.0, 1.0};
		output1.setInput(temp3);
		tempOut = output1.getOutput();
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
