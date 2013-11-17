	package texastony.neural_network;

//import java.lang.Math;
//import java.util.Arrays;
import java.util.Random;

import texastony.neural_network.OutputNeuron;
//import texastony.neural_network.HiddenNeuron;
import texastony.neural_network.InputNeuron;


public class neural_network{	
	public static void main(String[] args) {
		Random r = new Random();
		OutputNeuron output1 = new OutputNeuron(randomWeights(2, r), 2);
		InputNeuron input1 = new InputNeuron();
		InputNeuron input2 = new InputNeuron();
		double error = 0.11;
		double error0 = 1000.0;
		double error1 = 1000.0;
		double error2 = 1000.0;
		double error3 = 1000.0;
		int counter =0;
		while(error>0.4){
			for(int count = 0;count<4;count++){
				if(count==0){
					error=0.0;
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
				double[] temp = {input1.getOutput(), input2.getOutput()};;
				output1.setInput(temp);
				if(count==0){
					error0 = 1-output1.getOutput();
					output1.updateWeight(error0);
					error+=error0*error0;
				}
				else if(count==1){
					error1 = 1-output1.getOutput();
					output1.updateWeight(error1);
					error+=error1*error1;
				}
				else if(count==2){
					error2 = 1-output1.getOutput();
					output1.updateWeight(error2);
					error+=error2*error2;
				}
				else{
					error3 = 0-output1.getOutput();
					output1.updateWeight(error3);
					error+=error3*error3;
//					System.out.println("error =" + error);
				}
			}
		counter++;
		}
		System.out.println("0 0");
		input1.setInput(0.0);
		input2.setInput(0.0);
		double[] temp = {input1.getOutput(), input2.getOutput()};
		output1.setInput(temp);
		System.out.println(output1.getOutput());
		System.out.println("0 1");
		input1.setInput(0.0);
		input2.setInput(1.0);
		double[] temp1 = {input1.getOutput(), input2.getOutput()};
		output1.setInput(temp1);
		System.out.println(output1.getOutput());
		System.out.println("1 0");
		input1.setInput(1.0);
		input2.setInput(0.0);
		double[] temp2 = {input1.getOutput(), input2.getOutput()};
		output1.setInput(temp2);
		System.out.println(output1.getOutput());
		System.out.println("1 1");
		input1.setInput(1.0);
		input2.setInput(1.0);
		double[] temp3 = {input1.getOutput(), input2.getOutput()};
		output1.setInput(temp3);
		System.out.println(output1.getOutput());
		System.out.println(counter);
	}
	private static double[] randomWeights(int numInputs, Random r){
		double[] output = new double[numInputs];
		for(int i=0;i<numInputs;i++){
			output[i]=(r.nextDouble()-.5)*2*(2.4/numInputs);
		}
		return output;
		
	}
}
