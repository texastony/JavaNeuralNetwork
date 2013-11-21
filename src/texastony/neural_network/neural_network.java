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
		OutputNeuron output2 = new OutputNeuron(randomWeights(2, r), 2);
		InputNeuron input1 = new InputNeuron();
		InputNeuron input2 = new InputNeuron();
		double error = 0.5344466456471899;
		double error0_1 = 1000.0;
		double error0_2 = 1000.0;
		double error1_1 = 1000.0;
		double error1_2 = 1000.0;
		double error2_1 = 1000.0;
		double error2_2 = 1000.0;
		double error3_1 = 1000.0;
		double error3_2 = 1000.0;
		int counter =0;
		while(counter< 1000){
			for(int count = 0;count<4;count++){
				if(count==0){
					error=0.0;
					input1.setInput(-1.0);
					input2.setInput(-1.0);
				}
				else if(count==1){
					input1.setInput(1.0);
					input2.setInput(-1.0);
				}
				else if(count==2){
					input1.setInput(1.0);
					input2.setInput(1.0);
				}
				else{
					input1.setInput(-1.0);
					input2.setInput(1.0);
				}
				double[] temp = {input1.getOutput(), input2.getOutput()};
				output1.setInput(temp);
				output2.setInput(temp);
				if(count==0){
					error0_1 = -1-output1.getOutput();
					error0_2 = 1-output2.getOutput();					
					output1.updateWeight(error0_1);
					output2.updateWeight(error0_2);
					error+=error0_1*error0_1+error0_2+error0_2;
				}
				else if(count==1){
					error1_1 = -1-output1.getOutput();
					error1_2 = 1-output2.getOutput();
					output1.updateWeight(error1_1);
					output2.updateWeight(error1_2);
					error+=error1_1*error1_1+error1_2*error1_2;
				}
				else if(count==2){
					error2_1 = 1-output1.getOutput();
					error2_2 = -1-output2.getOutput();
					output1.updateWeight(error2_1);
					output2.updateWeight(error2_2);
					error+=error2_2*error2_2;
				}
				else{
					error3_1 = -1-output1.getOutput();
					error3_2 = 1-output2.getOutput();
					output1.updateWeight(error3_1);
					output2.updateWeight(error3_2);
					error+=error3_1*error3_1+error3_2*error3_2;
					error=error/8;
					error=java.lang.Math.sqrt(error);
					System.out.println("error =" + error);
				}
			}
		counter++;
		}
		System.out.println("0 0");
		input1.setInput(0.0);
		input2.setInput(0.0);
		double[] temp = {input1.getOutput(), input2.getOutput()};
		output1.setInput(temp);
		output2.setInput(temp);
		System.out.println(output1.getOutput()+" "+ output1.getOutput());
		System.out.println("0 1");
		input1.setInput(0.0);
		input2.setInput(1.0);
		double[] temp1 = {input1.getOutput(), input2.getOutput()};
		output1.setInput(temp1);
		output2.setInput(temp1);
		System.out.println(output1.getOutput()+" "+output1.getOutput());
		System.out.println("1 0");
		input1.setInput(1.0);
		input2.setInput(0.0);
		double[] temp2 = {input1.getOutput(), input2.getOutput()};
		output1.setInput(temp2);
		output2.setInput(temp2);
		System.out.println(output1.getOutput()+" "+output1.getOutput());
		System.out.println("1 1");
		input1.setInput(1.0);
		input2.setInput(1.0);
		double[] temp3 = {input1.getOutput(), input2.getOutput()};
		output1.setInput(temp3);
		output2.setInput(temp3);
		System.out.println(output1.getOutput()+" "+output1.getOutput());
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
